package com.zhangyihao.twoyou.util.image;

import com.zhangyihao.twoyou.util.FileUtil;

public class HeadImgUtil implements Runnable {

	private final String[] type = new String[]{"image/bmp", "image/png", "image/jpeg", "image/jpg"};
	private final String[] extend = new String[]{"bmp", "png", "jpg", "jpg"};
	
	private String srcImageFile;
	private String fileContentType;
	
	public HeadImgUtil(String srcImageFile, String fileContentType) {
		super();
		this.srcImageFile = srcImageFile;
		this.fileContentType = fileContentType;
		for(int i=0; i<type.length; i++) {
			if(this.fileContentType.equalsIgnoreCase(type[i])) {
				this.fileContentType = extend[i];
				break;
			}
		}
	}

	@Override
	public void run() {
		ImageUtil util = new ImageUtil();
		util.resize(srcImageFile, FileUtil.getHeadImagePath(srcImageFile, "large"), 192, 144, fileContentType);
		util.resize(srcImageFile, FileUtil.getHeadImagePath(srcImageFile, "medium"), 120, 120, fileContentType);
		util.resize(srcImageFile, FileUtil.getHeadImagePath(srcImageFile, "small"), 75, 75, fileContentType);
	}

}
