package com.base.action;

import com.base.ConstantsCode;
import com.base.CoreConstants;
import com.base.dao.model.BFile;
import com.base.dao.model.BFileExample;
import com.base.dao.model.LayImage;
import com.base.dao.model.Ret;
import com.base.des.Md5;
import com.base.oss.MyOssClient;
import com.base.service.BFileService;
import com.base.support.FileExportUtils;
import com.base.util.*;
import com.base.util.file.FileUpRetn;
import com.util.PaidangConst;
import com.util.video.FFMpegUtil;
import com.util.video.VideoConRun;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.*;
import java.util.List;

@Controller
public class FileController extends CoreController{
	private static String os = System.getProperties().getProperty("os.name");
	
	@Autowired
	private BFileService fileService;
	
	@RequestMapping("/fileUpload")
	public void fileUpload(HttpServletRequest request, HttpServletResponse response,HttpSession session,String dir)
			throws Exception {
		// 文件保存目录路径
		String savePath = CoreConstants.FILE_PATH;
		if (!ServletFileUpload.isMultipartContent(request)) {
			ResponseUtils.renderJson(response, getError("请选择文件"));
			return;
		}

		// 检查目录
		File uploadDir = new File(savePath);
		if (!uploadDir.isDirectory()) {
			uploadDir.mkdirs();
		}
		
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		List<?> items = upload.parseRequest(request);
		Iterator<?> itr = items.iterator();
		String callback = request.getParameter("callback");
		String cutImg = "";
		while (itr.hasNext()) {
			FileItem item = (FileItem) itr.next();
			String fileName = item.getName();
			if (!item.isFormField()) {
				String md5 = Md5.md5(item.getInputStream());
				BFileExample example = new BFileExample();
				example.createCriteria().andFileMd5EqualTo(md5);
				List<BFile> lf = fileService.selectByExample(example);
				if (lf.size() > 0) {
					if(!StringUtil.isBlank(callback)){
						ResponseUtils.render(response, "<script>parent."+callback+"('"+lf.get(0).getFileId()+"')</script>","text/html;charset=UTF-8");
						return;
					}
					if ("image".equals(dir)) {
						ResponseUtils.renderJson(response, new FileUpRetn(0, "download?id=" +lf.get(0).getFileId(), fileName, lf.get(0).getFileSize().longValue()));
						return;
					}else if(FileExportUtils.isVideo(lf.get(0).getFileMinitype())){
						ResponseUtils.renderJson(response, new FileUpRetn(0, lf.get(0).getFileId(), lf.get(0).getFileCreater(), lf.get(0).getFileSize().longValue()));
						return;
					}
					ResponseUtils.renderJson(response, new FileUpRetn(0, lf.get(0).getFileId(), fileName, lf.get(0).getFileSize().longValue()));
					return;
				}
				long itemsize=item.getSize();
				// 检查文件大小
				if (itemsize >Long.parseLong(CoreConstants.FILE_MAXSIZE)) {
					if(!StringUtil.isBlank(callback)){
						ResponseUtils.renderText(response, "<script>parent."+callback+"(1)</script>");
						return;
					}
					ResponseUtils.renderJson(response, getError("上传文件大小超过限制。"));
					return;
				}
				// 检查扩展名
				String fileExt = fileName.substring(
						fileName.lastIndexOf(".") + 1).toLowerCase();
				String newFileName = UUID.randomUUID().toString()
						.replace("-", "");
				String minetype = FileExportUtils.getMine(item.get());
				
				if(fileName.endsWith(".apk")){
					minetype = "application/vnd.android.package-archive";
				}else if(fileName.endsWith(".ipa")){
					minetype = "application/iphone-package-archive";
				}
				
				BFile ac = new BFile();
				try {
					Calendar cal=Calendar.getInstance();
//					String realdir = cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+(cal.get(Calendar.DAY_OF_MONTH))+"/"+minetype;
					String realdir = minetype + "/" +cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+(cal.get(Calendar.DAY_OF_MONTH));
					File f = new File(savePath, realdir);
					if (!f.isDirectory()) {
						f.mkdirs();
					}
					File uploadedFile = new File(f.getPath(), newFileName + "." + fileExt);
					item.write(uploadedFile);
					minetype = FileExportUtils.getMineType(uploadedFile.getPath());
					ac.setFileId(newFileName);
					ac.setFileMinitype(minetype);
					ac.setFilePath(realdir + "/" + newFileName + "." + fileExt);
					ac.setFileState(1);
					ac.setFileSize(BigDecimal.valueOf(itemsize));
					ac.setFileMd5(md5);
					ac.setFileCreatetime(new Date());
					ac.setFileName(fileName);
					
					if(FileExportUtils.isImage(fileName)){
						BufferedImage bufferedImage = ImageIO.read(uploadedFile);
						int width = bufferedImage.getWidth();   
						int height = bufferedImage.getHeight();  
						ac.setFileCreater(width+"x"+height);
					}else if (FileExportUtils.isVideo(minetype)) {

						//上传截图
						if (StringUtil.isNotBlank(ConstantsCode.FFMPEG_PATH)){
							FFMpegUtil ffMpegUtil = new FFMpegUtil(uploadedFile);
							//视频截图
							String cutImgName = newFileName+ PaidangConst.VIDEO_CUR_IMG+".jpg";
							File cutImgFile = new File(f.getPath(),cutImgName);
							ffMpegUtil.makeScreenCut(cutImgFile);
							BFile image = new BFile();
							image.setFileId(newFileName+PaidangConst.VIDEO_CUR_IMG);
							image.setFileMinitype("image/jpeg");
							image.setFilePath(realdir + "/" + cutImgName);
							image.setFileState(1);
							image.setFileCreatetime(new Date());
							image.setFileName(cutImgName);
							image.setFileCreater("640x360");
							image.setFileBelong(BFileService.LOCAL);
							fileService.insert(image);
							ac.setFileCreater(cutImgName);
							int time = ffMpegUtil.getRuntime();
							if (itemsize / time > 100000){
								//视频
								ThreadUtil.execute(new VideoConRun(ffMpegUtil,f.getPath(),realdir,newFileName, fileService));
							}

						}

					}
					
					if(BFileService.OSS.equals(CoreConstants.FILE_MODE)){
						boolean b = MyOssClient.putObject(ac.getFilePath(), minetype, new FileInputStream(uploadedFile), null, fileName);
						if(b){
							ac.setFileBelong(BFileService.OSS);
							fileService.insert(ac);
							if (uploadedFile.exists()){
								uploadedFile.delete();
							}
						}else{
							ResponseUtils.renderJson(response, getError("上传文件失败。1"));
							return;
						}
					}else{
						ac.setFileBelong(BFileService.LOCAL);
						fileService.insert(ac);
					}
				} catch (Exception e) {
					e.printStackTrace();
					if(!StringUtil.isBlank(callback)){
						ResponseUtils.render(response, "<script>parent."+callback+"(2)</script>","text/html;charset=UTF-8");
						return;
					}
					ResponseUtils.renderJson(response, getError("上传文件失败。2"));
					return;
				}
				if(!StringUtil.isBlank(callback)){
					ResponseUtils.render(response, "<script>parent."+callback+"('"+newFileName+"')</script>","text/html;charset=UTF-8");
					return;
					
				}
				if ("image".equals(dir)) {
					if (BFileService.OSS.equals(ac.getFileBelong())){
						newFileName = "https://"+URLEncoder.encode(ac.getFilePath(),"utf-8");
					}else {
						newFileName = "download?id="+newFileName;
					}
				}else if (FileExportUtils.isVideo(minetype)){
					if (BFileService.OSS.equals(ac.getFileBelong())){
						newFileName = "https://"+URLEncoder.encode(ac.getFilePath(),"utf-8");
					}
					fileName = cutImg;
				}
				ResponseUtils.renderJson(response, new FileUpRetn(0, newFileName, fileName, itemsize));
				return;
			}
		}
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("error", 1);
		msg.put("message", "没有发现文件域");
		if(!StringUtil.isBlank(callback)){
			ResponseUtils.render(response, "<script>parent."+callback+"(3)</script>","text/html;charset=UTF-8");
			return;
		}
		ResponseUtils.renderJson(response, msg);
		return;
	}
	
	@RequestMapping("/download/{id}")
	public void downloadFile(HttpServletResponse resp,
			HttpServletResponse response, @PathVariable("id") String id,
			@RequestParam(value = "w", required = false) String width,
			@RequestParam(value = "h", required = false) String height,
			@RequestParam(value = "q", required = false) String quality,
			HttpServletRequest request)
			throws Exception {
		downloadFile(id, response, width,height,quality, null,request);
	}
	
	@RequestMapping("/download")
	public void downloadFile(String id,HttpServletResponse resp,
			@RequestParam(value = "w", required = false) String w,
			@RequestParam(value = "h", required = false) String h,
			@RequestParam(value = "q", required = false) String q
			,String type,HttpServletRequest request) throws Exception{
		fileService.getFile(id, w, h, q, resp, type,request);
	}
	
	@RequestMapping("/layerPhoto")
	@ResponseBody
	public List<LayImage> layerPhoto(String id){
		if (StringUtil.isBlank(id)) return null;
		String[] ids = id.split(",");
		List<LayImage> data = new ArrayList<LayImage>(ids.length);
		for (int i = 0; i < ids.length; i++){
			BFile item = fileService.selectByPrimaryKey(ids[i]);
			if (item == null) continue;
			LayImage image = new LayImage(item.getFileName(), item.getFileId());
			image.setPid(i);
			data.add(image);
		}
		return data;
	}

	@RequestMapping("/replaceImg")
	@ResponseBody
	public String cutImg(String imgId,Integer startX,Integer startY,Integer width,Integer height,Integer currentW,Integer currentH,HttpServletRequest request) throws Exception{
		BFile bfile = fileService.selectByPrimaryKey(imgId);
		String src="";
		String id ="";
		if(bfile==null)
			src=request.getContextPath()+"/"+imgId;
		else
			src=CoreConstants.FILE_PATH + "/"+bfile.getFilePath();
		int n =bfile.getFilePath().lastIndexOf(".");
		String ext =bfile.getFilePath().substring(n+1);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			File srcFile = new File(src);  
			
			//图片裁剪
			ImageUtil.cut(srcFile, baos, startX, startY, width, height);
			byte[] newImg = baos.toByteArray();
			id = fileService.uploadFile(newImg, bfile.getFileName(), bfile.getFileBelong());
		}catch(Exception e){
			e.printStackTrace();
			return JSONUtils.serialize(new Ret(0));
		}finally{
			if(baos!=null){
				baos.close();
			}
		}
		return JSONUtils.serialize(new Ret(1, id));
	}
	
    /* 
     * 图片缩放 
     */  
    public static void zoomImage(String src,int w,int h,String ext,ByteArrayOutputStream baos) throws Exception {  
        double wr=0,hr=0;  
        File srcFile = new File(src);  
        BufferedImage bufImg = ImageIO.read(srcFile);  
        Image itemp = bufImg.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        wr=w*1.0 / bufImg.getWidth();  
        hr=h*1.0 / bufImg.getHeight();  
        AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(wr, hr), null);  
        itemp = ato.filter(bufImg, null);  
        try {  
            ImageIO.write((BufferedImage) itemp,ext, baos);  
        } catch (Exception ex) {  
            ex.printStackTrace();  
        }  
          
    }  
	
	private FileUpRetn getError(String message) {
		return new FileUpRetn(1, message);
	}
}
