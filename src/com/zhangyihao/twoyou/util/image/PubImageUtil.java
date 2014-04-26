package com.zhangyihao.twoyou.util.image;

import com.zhangyihao.twoyou.util.FileUtil;

public class PubImageUtil  implements Runnable {
	private final String[] type = new String[]{"image/bmp", "image/png", "image/jpeg", "image/jpg"};
	private final String[] extend = new String[]{"bmp", "png", "jpg", "jpg"};
	
	private String imagePath;
	private Integer userId;
	private String imgContentType; //图片类型
	private int mediumWidth;
	private int smallWidth;
	private int smallHeight;
	private int largeWidth;
	
 	public PubImageUtil(Integer userId, String imagePath, String imgContentType,
			int smallWidth, int smallHeight, int mediumWidth, int largeWidth) {
		this.userId = userId;
		this.imagePath = imagePath;
		this.imgContentType = imgContentType;
		this.smallWidth = smallWidth;
		this.smallHeight = smallHeight;
		this.mediumWidth = mediumWidth;
		this.largeWidth = largeWidth;
		for(int i=0; i<type.length; i++) {
			if(this.imgContentType.equalsIgnoreCase(type[i])) {
				this.imgContentType = extend[i];
				break;
			}
		}
	}
	
	@Override
	public void run() {
		String filePath = FileUtil.getRoot()+imagePath;
		
		String smallPath = getPath(smallWidth, smallHeight);
		String mediumPath = getPath(mediumWidth, -1);
		String largePath = getPath(largeWidth, -1);
		ImageUtil util = new ImageUtil();
		//对图片进行medium级别缩放
		util.resizeByWidth(filePath, mediumPath, mediumWidth, imgContentType);
		//对图片进行按宽高缩放(small级别)，不需要补白
		util.resize(filePath,smallPath, smallWidth,smallHeight, imgContentType);
		//对图片进行large级别缩放,并进行加水印
		util.resizeByWidth(filePath, largePath, largeWidth, imgContentType);
		util.pressText(largePath, "http://localhost:8080/TwoYou", 0.9f, imgContentType);
	}
	
	private String getPath(int width, int height) {
		String imgName = imagePath.substring(imagePath.lastIndexOf("/")+1);
		int dotPosition = imgName.lastIndexOf(".");
		
		StringBuffer sb = new StringBuffer();
		sb.append(FileUtil.getRoot()).append("/pin/").append(userId).append("/");
		sb.append(width).append("x");
		if(height>0) {
			sb.append(height);
		}
		sb.append("/").append(imgName.substring(0, dotPosition)).append(width);
		if(height>0) {
			sb.append(height);
		}
		sb.append(imgName.substring(dotPosition));
		return sb.toString();
	}
}
