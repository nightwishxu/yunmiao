package com.base.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.base.ConstantsCode;
import com.base.util.ThreadUtil;
import com.util.PaidangConst;
import com.util.video.FFMpegUtil;
import com.util.video.VideoConRun;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.CoreConstants;
import com.base.cache.CacheSupport;
import com.base.dao.BFileMapper;
import com.base.dao.model.BFile;
import com.base.dao.model.BFileExample;
import com.base.des.Md5;
import com.base.io.FileTypeUtil;
import com.base.oss.MyOssClient;
import com.base.support.FileExportUtils;
import com.base.util.ImageUtil;
import com.base.util.StringUtil;
import com.base.util.URLUtil;

@Service
public class BFileService {
	@Autowired
	private BFileMapper bFileMapper;

	public static final String LOCAL = "local";
	public static final String OSS = "oss";
	public static final String COS = "cos";

	private static final Logger logger = Logger.getLogger(BFileService.class);

	public int countByExample(BFileExample example) {
		return this.bFileMapper.countByExample(example);
	}

	public BFile selectByPrimaryKey(String fileId) {
		return this.bFileMapper.selectByPrimaryKey(fileId);
	}

	public List<BFile> selectByExample(BFileExample example) {
		return this.bFileMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(String fileId) {
		return this.bFileMapper.deleteByPrimaryKey(fileId);
	}

	public int updateByPrimaryKeySelective(BFile record) {
		return this.bFileMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(BFile record) {
		return this.bFileMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(BFileExample example) {
		return this.bFileMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(BFile record, BFileExample example) {
		return this.bFileMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(BFile record, BFileExample example) {
		return this.bFileMapper.updateByExample(record, example);
	}

	public int insert(BFile record) {
		return this.bFileMapper.insert(record);
	}

	public int insertSelective(BFile record) {
		return this.bFileMapper.insertSelective(record);
	}

	public String uploadHeadImg(String url) {
		try {
			String savePath = UUID.randomUUID().toString();
			byte[] bytes = URLUtil.download(url);

			String type = FileTypeUtil.getType(bytes);
			if (type != null)
				savePath += "." + type.toLowerCase();
			return uploadFile(bytes, savePath, null);
		} catch (Exception e) {
			return null;
		}
	}

	public String getVideoImg(String id, String cut) throws Exception {
		if (StringUtil.isBlank(id))
			return null;
		BFile item = bFileMapper.selectByPrimaryKey(id);
		if (item == null) {
			logger.error("文件不存在;id=" + id);
			return null;
		} else {
			if (StringUtil.isNotBlank(cut)) {
				if (!cut.equals(item.getFileCreater())) {
					item.setFileCreater(cut);
					bFileMapper.updateByPrimaryKey(item);
				}
				return cut;
			} else {
				// 生成
				String cutImg = UUID.randomUUID().toString().replace("-", "");
				Calendar cal = Calendar.getInstance();
				String realdir = cal.get(Calendar.YEAR) + "-"
						+ (cal.get(Calendar.MONTH) + 1) + "-"
						+ (cal.get(Calendar.DAY_OF_MONTH)) + "/"
						+ "png";
				File f = new File(CoreConstants.FILE_PATH, realdir);
				if (!f.isDirectory()) {
					f.mkdirs();
				}
				File filepath = new File(CoreConstants.FILE_PATH + "/"
						+ item.getFilePath());
				File uploadedImgFile = new File(f.getPath(), cutImg + ".png");
				if (filepath.exists() && uploadedImgFile.exists()) {
					BFile image = new BFile();
					image.setFileId(cutImg);
					image.setFileMinitype("image/png");
					image.setFilePath(realdir + "/" + cutImg + ".png");
					image.setFileState(1);
					image.setFileCreatetime(new Date());
					image.setFileName("videocut.png");
					image.setFileCreater("320x240");
					image.setFileBelong(BFileService.LOCAL);
					int i = bFileMapper.insert(image);
					if (i > 0) {
						item.setFileCreater(cutImg);
						bFileMapper.updateByPrimaryKey(item);
					}

				}
				return cutImg;
			}
		}
	}

	/**
	 * 获取文件
	 * 
	 * @param id
	 * @param w
	 * @param h
	 * @param q
	 * @param resp
	 * @param type
	 * @throws Exception
	 */
	public void getFile(String id, String w, String h, String q,
			HttpServletResponse resp, String type, HttpServletRequest request)
			throws Exception {
		if (id != null) {
			int dot = id.indexOf(".");
			if (dot != -1) {
				id = id.substring(0, dot);
			}

			BFile item = bFileMapper.selectByPrimaryKey(id);
			if (item == null) {
				if (id.endsWith(PaidangConst.VIDEO_NORMAL)){
					getFile(id.substring(0,id.indexOf(PaidangConst.VIDEO_NORMAL)),w,h,q,resp,type,request);
					return;
				}else{
					logger.error("文件不存在;id=" + id);
					return;
				}
			} else {
				int width = 0, height = 0, quality = 0;
				if (w != null && w.length() > 0) {
					width = Integer.valueOf(w);
				}
				if (h != null && h.length() > 0) {
					height = Integer.valueOf(h);
				}
				if (q != null && q.length() > 0) {
					quality = Integer.valueOf(q);
				}
				File filepath = new File(CoreConstants.FILE_PATH + "/"
						+ item.getFilePath());
				if (OSS.equals(item.getFileBelong())) {
					String url = "https://"
							+ URLEncoder.encode(item.getFilePath(), "utf-8");
					if (width + height != 0
							&& item.getFileMinitype().startsWith("image")) {
						if (height == 0) {
							url += "?x-oss-process=image/resize,w_" + width;
						} else if (height != 0 && width != 0) {
							url += "?x-oss-process=image/resize,w_" + width
									+ ",h_" + height;
						}
						resp.sendRedirect(url);
					} else {
						resp.sendRedirect(url);
					}
					return;
				}
				if (width + height != 0
						&& item.getFileMinitype().startsWith("image")) {
					// 检查目录
					File tempDirectory = new File(CoreConstants.FILE_PATH
							+ "/temp/");
					if (!tempDirectory.isDirectory()) {
						tempDirectory.mkdirs();
					}

					String tf = CoreConstants.FILE_PATH + "/temp/"
							+ item.getFileMd5() + "_" + width + "x" + height
							+ "x" + quality + ".jpg";
					File tempfile = new File(tf);
					if (tempfile.exists()) {
						filepath = tempfile;
					} else {
						ImageUtil.scale(filepath, tempfile, width, height, null);
						filepath = tempfile;
					}

				}

				if (item.getFileMinitype().startsWith("image")) {
					type = "inline";
				} else if (item.getFileMinitype().startsWith("video")) {
					resp.sendRedirect(CoreConstants.getProperty("video.path") +item.getFilePath());
					return;
				}

				resp.setContentType(item.getFileMinitype() + "; charset=utf-8");
				if (!filepath.exists()) {
					logger.error("文件没找到;id=" + id);
					return;
				}
				FileExportUtils.download(request,resp, item.getFileName(),
						item.getFileMinitype(), filepath, type);
			}
		}
	}

	/**
	 * 文件上传
	 * 
	 * @param bytes
	 *            文件
	 * @param fileName
	 *            文件名:xxx.jpg
	 * @param belong
	 *            归属
	 * @return
	 */
	public String uploadFile(byte[] bytes, String fileName, String belong) {
		// 文件保存目录路径
		String savePath = CoreConstants.FILE_PATH;
		String md5 = "";
		try {
			md5 = Md5.md5(bytes);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		BFileExample example = new BFileExample();
		example.createCriteria().andFileMd5EqualTo(md5);
		List<BFile> lf = this.selectByExample(example);
		if (lf.size() > 0) {
			return lf.get(0).getFileId();
		}
		long itemsize = bytes.length;
		// 检查文件大小
		if (itemsize > Long.parseLong(CoreConstants.FILE_MAXSIZE)) {
			return null;
		}
		// 检查扩展名
		String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1)
				.toLowerCase();
		String newFileName = UUID.randomUUID().toString().replace("-", "");
		try {
			String minetype = FileExportUtils.getMine(bytes);
			Calendar cal = Calendar.getInstance();
			String realdir = minetype + "/" +cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+(cal.get(Calendar.DAY_OF_MONTH));
			File f = new File(savePath, realdir);
			if (!f.isDirectory()) {
				f.mkdirs();
			}
			File uploadedFile = new File(f.getPath(), newFileName + "."
					+ fileExt);
			FileOutputStream fos = new FileOutputStream(uploadedFile);
			fos.write(bytes);
			fos.close();
			minetype = FileExportUtils.getMineType(uploadedFile.getPath());
			BFile ac = new BFile();
			ac.setFileId(newFileName);
			ac.setFileMinitype(minetype);
			ac.setFilePath(realdir + "/" + newFileName + "." + fileExt);
			ac.setFileState(1);
			ac.setFileSize(BigDecimal.valueOf(itemsize));
			ac.setFileMd5(md5);
			ac.setFileCreatetime(new Date());
			ac.setFileName(fileName);
			ac.setFileBelong(belong);

			if (FileExportUtils.isImage(fileName)) {
				BufferedImage bufferedImage = ImageIO.read(uploadedFile);
				int width = bufferedImage.getWidth();
				int height = bufferedImage.getHeight();
				ac.setFileCreater(width + "x" + height);
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
					insert(image);
//					ac.setFileCreater(cutImgName);
					int time = ffMpegUtil.getRuntime();
					if (itemsize / time > 100000){
						//视频
						ThreadUtil.execute(new VideoConRun(ffMpegUtil,f.getAbsolutePath(),realdir,newFileName, this));
					}

				}
			}

			if (CoreConstants.FILE_MODE.equals(OSS)) {
				boolean b = MyOssClient.putObject(ac.getFilePath(), minetype,
						bytes, null, ac.getFileName());
				if (b) {
					ac.setFileBelong(MyOssClient.OSS_BUCKET + "."
							+ MyOssClient.OSS_ENDPOINT);
					insert(ac);
					if (uploadedFile.exists()) {
						uploadedFile.delete();
					}
				} else {
					return null;
				}
			} else {
				ac.setFileBelong(LOCAL);
				this.insert(ac);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			return null;
		}
		return newFileName;
	}

	/**
	 * 获取图片长宽
	 * 
	 * @param fileId
	 * @return
	 */
	public String getSize(String fileId) {
		String size = CacheSupport.get("imageSizeCache",
				"BFileService.getSize." + fileId, String.class);
		if (StringUtil.isBlank(size)) {
			BFile file = this.bFileMapper.selectByPrimaryKey(fileId);
			if (file != null && StringUtil.isNotBlank(file.getFileCreater())) {
				CacheSupport.put("imageSizeCache", "BFileService.getSize."
						+ fileId, file.getFileCreater());
				return file.getFileCreater();
			}
			return "";
		}
		return size;
	}

	/**
	 * 格式化图片ids:id|w|h,id|w|h
	 * 
	 * @param ids
	 * @return
	 */
	public String format(String ids) {
		if (StringUtil.isBlank(ids))
			return "";
		String[] idArray = ids.split(",");
		String size = "";
		List<String> strs = new ArrayList<String>();
		for (String id : idArray) {
			size = getSize(id);
			if (StringUtil.isNotBlank(size)) {
				id = id + "|" + size.replace("x", "|");
			} else {
				id = id + "||";
			}
			strs.add(id);
		}
		return StringUtil.listToString(strs);
	}

	public static String getTomcatWebappsPath(HttpServletRequest request){
		String tomcatRoot = request.getSession().getServletContext().getRealPath("/");
		String[] foo = tomcatRoot.split("/");
		StringBuilder tomcatWebAppsBuilder = new StringBuilder();
		int i = 0;
		for(String paths : foo){
			++i;
			if(i != foo.length){
				tomcatWebAppsBuilder.append(paths);
				tomcatWebAppsBuilder.append("/");
			}
		}
		String tomcatWebApps = tomcatWebAppsBuilder.toString();
		return tomcatWebApps;
	}
}