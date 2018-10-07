package com.base.util;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.im4java.core.ConvertCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;
import org.im4java.core.IdentifyCmd;
import org.im4java.process.ArrayListOutputConsumer;

import com.base.CoreConstants;

/**
 * <p>
 * GraphicsMagick + im4java 实现高质量大图的处理
 * </p>
 * 
 * @author hubin
 * @Date 2016-04-19
 */
public class GraphicsMagickHelper {
	private static Boolean OS_LINUX = null;
	private static ConvertCmd convert = null;


	/**
	 * 获得 ConvertCmd
	 * <p>
	 * windows 环境设置 convert.setSearchPath
	 * </p>
	 */
	protected static ConvertCmd localConvertCmd() {
		if ( convert == null ) {
			convert = new ConvertCmd(true);
			if (isLinux()) {
				convert.setSearchPath(CoreConstants.GRAPHICS_MAGICK_PATH);
			} else {
				convert.setSearchPath(CoreConstants.GRAPHICS_MAGICK_PATH);
			}
		}
		return convert;
	}


	/**
	 * 
	 * 图片信息
	 * 
	 * @param imagePath
	 * @return
	 */
	public static String getImageInfo( String imagePath ) {
		String line = null;
		try {
			IMOperation op = new IMOperation();
			op.format("width:%w,height:%h,path:%d%f,size:%b%[EXIF:DateTimeOriginal]");
			op.addImage(1);
			IdentifyCmd identifyCmd = new IdentifyCmd(true);
			ArrayListOutputConsumer output = new ArrayListOutputConsumer();
			identifyCmd.setOutputConsumer(output);
			identifyCmd.run(op, imagePath);
			ArrayList<String> cmdOutput = output.getOutput();
			assert cmdOutput.size() == 1;
			line = cmdOutput.get(0);
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return line;
	}


	/**
	 * 图片旋转
	 * 
	 * @param imagePath
	 *            源图片路径
	 * @param newPath
	 *            处理后图片路径
	 * @param degree
	 *            旋转角度
	 */
	public boolean rotate( String imagePath, String newPath, double degree ) {
		boolean flag = false;
		try {
			/* 将角度转换到0-360度之间 */
			degree = degree % 360;
			if ( degree <= 0 ) {
				degree = 360 + degree;
			}
			IMOperation op = new IMOperation();
			op.addImage(imagePath);
			op.rotate(degree);
			op.addImage(newPath);
			localConvertCmd().run(op);
			flag = true;
		} catch ( Exception e ) {
			flag = false;
			System.out.println("图片旋转失败!");
		}
		return flag;
	}


	/**
	 * 裁剪图片
	 * 
	 * @param imagePath
	 *            源图片路径
	 * @param newPath
	 *            处理后图片路径
	 * @param x
	 *            起始X坐标
	 * @param y
	 *            起始Y坐标
	 * @param width
	 *            裁剪宽度
	 * @param height
	 *            裁剪高度
	 * @return 返回true说明裁剪成功,否则失败
	 */
	public boolean cropImage( String imagePath, String newPath, int x, int y, int width, int height ) {
		boolean flag = false;
		try {
			IMOperation op = new IMOperation();
			op.addImage(imagePath);
			/** width：裁剪的宽度 * height：裁剪的高度 * x：裁剪的横坐标 * y：裁剪纵坐标 */
			op.crop(width, height, x, y);
			op.addImage(newPath);
			localConvertCmd().run(op);
			flag = true;
		} catch ( IOException e ) {
			System.out.println("文件读取错误!");
			flag = false;
		} catch ( InterruptedException e ) {
			flag = false;
		} catch ( IM4JavaException e ) {
			flag = false;
		} finally {

		}
		return flag;
	}


	/**
	 * 根据尺寸缩放图片
	 * 
	 * @param width 缩放后的图片宽度
	 * @param height 缩放后的图片高度
	 * @param srcPath 源图片路径
	 * @param newPath 缩放后图片的路径
	 * @param type 1为比例处理，2为大小处理，如（比例：1024x1024,大小：50%x50%）
	 * @param quality 图片的质量，0~25：差，50~75：中等，75~100高
	 */
	public static String cropImageQuality( int width, int height, String srcPath, String newPath, int type, String quality) throws Exception {
		IMOperation op = new IMOperation();
		op.addImage();
		String raw = "";
		if ( type == 1 ) {
			//按像素
			raw = width + "x" + height + "^";
		} else {
			//按像素百分比
			raw = width + "%x" + height + "%";
		}
		op.addRawArgs("-sample", raw);
		if ( (quality != null && quality.equals("")) ) {
			op.addRawArgs("-quality", quality);
		}
		op.addImage();
		localConvertCmd().run(op, srcPath, newPath);
		return newPath;
	}


	/**
	 * 按照规定的尺寸对图片进行缩放
	 *
	 * @param srcPath         需要缩放的源文件路径
	 * @param destinationPath 生成图片的目标路径
	 * @param needWidth       需要缩放的宽度
	 * @param needHeight      需要缩放的高度
	 * @param quality         图片的质量，0~25：差，50~75：中等，75~100高
	 * @return
	 */
	public static void zoom( String srcPath, String destinationPath, int needWidth, int needHeight, int quality)
		throws Exception {
		/* 创建图片转换命令 */
		IMOperation op = new IMOperation();
		op.addImage(srcPath);
		op.resize(needWidth, needHeight);

		/* 设置图片质量参数 */
		if ( quality > 0 ) {
			op.addRawArgs("-quality", String.valueOf(quality));
		}
		op.addImage(destinationPath);
		localConvertCmd().run(op);
	}
	
	/**
	 * 按照规定的尺寸对图片进行缩放
	 *
	 * @param srcPath         需要缩放的源文件路径
	 * @param destinationPath 生成图片的目标路径
	 * @param size 			      缩放比例
	 * @param quality         

	 * @return
	 */
	public static void zoom( String srcPath, String destinationPath,int size, int quality) throws Exception {
		/* 创建图片转换命令 */
		IMOperation op = new IMOperation();
		op.addImage(srcPath);
		
		//压缩
		op.addRawArgs("-thumbnail", size+"%x"+size+"%");

		/* 设置图片质量参数 */
		if ( quality > 0 ) {
			op.addRawArgs("-quality", String.valueOf(quality));
		}
		op.addImage(destinationPath);
		localConvertCmd().run(op);
	}
	

	public static void main(String[] args) throws Exception {
		zoom("D:/1.jpg","D:/2.jpg",10,0);
	}

	/**
	 * 功能描述：水印的操作接口,水印图片将会被印在右下角,透明度为80,位偏移量x轴10像素,y轴5像素的位置
	 * @param filePath 源图片路径，这里生成的目标图片路径将覆盖掉源图片
	 * @param waterPath 水印图片路径
	 * @param gravity 水印图片位置，默认右下
	 * @return IMOperation，im4java处理图片操作的接口
	 */
	public IMOperation getOpWaterMark(String filePath,String waterPath,String gravity) {
		IMOperation op = new IMOperation();
		op.gravity(StringUtils.isBlank(gravity)?"SouthEast":gravity);
		op.dissolve(80);
		op.geometry(null, null, 10, 5);
		op.addImage(waterPath);
		op.addImage(filePath);
		op.addImage(filePath);
		return op;
	}


	/**
	 * 先缩放，后居中切割图片
	 * 
	 * @param srcPath 源图路径
	 * @param desPath 目标图保存路径
	 * @param rectw 待切割在宽度
	 * @param recth 待切割在高度
	 * @param quality 图片的质量，0~25：差，50~75：中等，75~100高
	 * @param gravity 切割位置，默认中间
	 * @throws IM4JavaException 
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public static void cropImage(String srcPath, String desPath, int rectw, int recth,int quality,String gravity)
		throws IOException, InterruptedException, IM4JavaException {
		IMOperation op = new IMOperation();
		op.addImage();
		op.resize(rectw, recth, '^').gravity(StringUtils.isNotBlank(gravity)?gravity:"center").extent(rectw, recth);
		/* 设置图片质量参数 */
		if ( quality > 0 ) {
			op.addRawArgs("-quality", String.valueOf(quality));
		}
		op.addImage();
		localConvertCmd().run(op, srcPath, desPath);
	}
	
	/**
	 * 判断当前系统是否为 linux
	 * @return true linux, false windows
	 */
	public static boolean isLinux() {
		if (OS_LINUX == null) {
			String OS = System.getProperty("os.name").toLowerCase();
			if (OS != null && OS.contains("windows")) {
				OS_LINUX = false;
			} else {
				OS_LINUX = true;
			}
		}
		return OS_LINUX;
	}
}
