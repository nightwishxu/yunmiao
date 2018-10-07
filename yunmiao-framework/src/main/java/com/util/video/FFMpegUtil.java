package com.util.video;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Title: FFMpeg工具类
 * @version 1.0
 */
public class FFMpegUtil implements IStringGetter {

	private int runtime = 0;
	private String ffmpegUri;// ffmpeg地址
	private String originFileUri; // 视频源文件地址
	private FFMpegUtilStatus status = FFMpegUtilStatus.Empty;
	private boolean isSupported;
	private List<String> cmd = new ArrayList<String>();
	
	private enum FFMpegUtilStatus {
		Empty, CheckingFile, GettingRuntime
	};

	public FFMpegUtil(String originFileUri) {
		this.ffmpegUri = getFfmpegUri();
		this.originFileUri = originFileUri;
	}

	public FFMpegUtil(File source){
		this.ffmpegUri = getFfmpegUri();
		this.originFileUri = source.getAbsolutePath();
	}

	private String getFfmpegUri(){
		return new MyFFMPEGLocator().getFFMPEGExecutablePath();
	}

	/**
	 * 获取视频时长
	 */
	public int getRuntime() {
		runtime = 0;
		status = FFMpegUtilStatus.GettingRuntime;
		cmd.clear();
		cmd.add(ffmpegUri);
		cmd.add("-i");
		cmd.add(originFileUri);
		CmdExecuter.exec(cmd, this);
		return runtime;
	}

	/**
	 * 检测文件是否是支持的格式 将检测视频文件本身，而不是扩展名
	 */
	public boolean isSupported() {
		isSupported = true;
		status = FFMpegUtilStatus.CheckingFile;
		cmd.clear();
		cmd.add(ffmpegUri);
		cmd.add("-i");
		cmd.add(originFileUri);
		CmdExecuter.exec(cmd, this);
		return isSupported;
	}

	/**
	 * 生成视频截图
	 * 
	 * @param imageSavePath
	 *            截图文件保存全路径
	 * @param screenSize
	 *            截图大小 如640x480
	 */
	public void makeScreenCut(String imageSavePath, String screenSize) {
	    this.cmd.clear();
	    this.cmd.add(ffmpegUri);
	    this.cmd.add("-i");
	    this.cmd.add(this.originFileUri);
	    this.cmd.add("-y");
	    this.cmd.add("-f");
	    this.cmd.add("image2");
	    this.cmd.add("-ss");
	    this.cmd.add("1");
	    this.cmd.add("-t");
	    this.cmd.add("0.001");
	    if (screenSize != null){
			this.cmd.add("-s");
			this.cmd.add(screenSize);
		}
	    this.cmd.add(imageSavePath);
		CmdExecuter.exec(this.cmd, this);
	}

	/**
	 * 生成视频截图
	 *
	 * @param imageSavePath
	 *            截图文件保存全路径
	 * @param screenSize
	 *            截图大小 如640x480
	 */
	public void makeScreenCut(String imageSavePath) {
		makeScreenCut(imageSavePath,null);
	}

	public void makeScreenCut(File imageSavePath) {
		makeScreenCut(imageSavePath.getAbsolutePath());
	}

	public void test(){
	}
	
//	/**
//	 * 生成视频截图(Linux)
//	 * 
//	 * @param imageSavePath
//	 *            截图文件保存全路径
//	 * @param screenSize
//	 *            截图大小 如640x480
//	 */
//	public boolean makeScreenCutLinux(String imageSavePath, String screenSize) {
//		String command = "ffmpeg -i " + this.originFileUri + " -y -f image2 -ss 1 -t 0.001 -s " + screenSize + " " + imageSavePath;
//		try {
//			Runtime rt = Runtime.getRuntime();
//			Process proc = rt.exec(command);
//			InputStream stderr = proc.getErrorStream();
//			InputStreamReader isr = new InputStreamReader(stderr);
//			BufferedReader br = new BufferedReader(isr);
//			String line = null;
//			while ((line = br.readLine()) != null)
//				System.out.println(line);
//		} catch (Throwable t) {
//			t.printStackTrace();
//			return false;
//		}
//		return true;
//	}

	/**
	 * 视频转换
	 * 
	 * @param fileSavePath
	 *            文件保存全路径（包括扩展名）如 e:/abc/test.flv
	 * @param screenSize
	 *            视频分辨率 如640x480
	 * @param audioByte
	 *            音频比特率
	 * @param audioCollection
	 *            音频采样率
	 * @param quality
	 *            视频质量(0.01-255)越低质量越好
	 * @param fps
	 *            每秒帧数（15或29.97）
	 */
	public void videoTransfer(String fileSavePath, String screenSize, int audioByte, int audioCollection, double quality, double fps) {
		cmd.clear();
		cmd.add(ffmpegUri);
		cmd.add("-i");
		cmd.add(originFileUri);
		cmd.add("-y");
		cmd.add("-c:v");
		cmd.add("libx264");
		cmd.add("-ab");
		cmd.add(Integer.toString(audioByte));
		cmd.add("-ar");
		cmd.add(Integer.toString(audioCollection));
		cmd.add("-qscale");
		cmd.add(Double.toString(quality));
		cmd.add("-r");
		cmd.add(Double.toString(fps));
		if (screenSize != null){
			cmd.add("-s");
			cmd.add(screenSize);
		}

		cmd.add(fileSavePath);
		CmdExecuter.exec(cmd, this);
	}

	/**
	 * 压缩h264编码
	 * @param fileSavePath
	 */
	public void videoTransfer(String fileSavePath) {
		videoTransfer(fileSavePath,"640x360",56,22050,8,15);
	}

	/**
	 * 压缩h264编码
	 * @param fileSavePath
	 */
	public void videoTransfer(File dest) {
		videoTransfer(dest.getAbsolutePath());
	}

	public void dealString(String str) {
		switch (status) {
		case Empty:
			break;
		case CheckingFile: {
			if (-1 == str.indexOf("Metadata:"))
				break;
			this.isSupported = true;
			break;
		}
		case GettingRuntime:
			if (str.contains("Duration")) {
				String time = str.substring(str.indexOf(":") + 1, str.indexOf(","));
				//System.out.println("Duration:" + time);
				String[] strs = time.trim().replaceAll("00", "0").split(":");
				runtime = Integer.parseInt(strs[0])*3600 + Integer.parseInt(strs[1])*60 + (int)Float.parseFloat(strs[2]);
			}
		}
	}

//	public void getVideoInfo(){
//		IContainer container = IContainer.make();
//
//		int result = container.open(originFileUri, IContainer.Type.READ, null);
//		if (result<0){
//			System.out.println("==========");
//			return ;
//		}
//		int numStreams = container.getNumStreams();
//		long duration = container.getDuration();
//		long fileSize = container.getFileSize();
//		long secondDuration = duration/1000000;
//		System.out.println("时长："+secondDuration+"秒");
//		System.out.println("文件大小:"+fileSize+"M");
//		for (int i = 0; i < numStreams; i++){
//			IStream stream = container.getStream(i);
//			IStreamCoder coder = stream.getStreamCoder();
//			if (coder.getCodecType() == ICodec.Type.CODEC_TYPE_VIDEO) {
//				System.out.println("视频宽度："+coder.getWidth());
//				System.out.println("视频高度："+coder.getHeight());
//			}
//		}
//	}

	public static void main(String[] args) {
		FFMpegUtil ffMpegUtil = new FFMpegUtil("\\\\192.168.2.30\\share\\paidang\\objectStream\\2017-11-6\\020ac972aec442d0976c7f38a7377d78.mp4");
		ffMpegUtil.makeScreenCut("\\\\192.168.2.30\\share\\paidang\\objectStream\\2017-11-6\\test.jpg");
	}
}
