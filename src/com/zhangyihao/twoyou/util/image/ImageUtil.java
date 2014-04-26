package com.zhangyihao.twoyou.util.image;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtil {
	private String fontName = "宋体";
	private int fontStyle = Font.PLAIN;
	private int fontSize = 14;
	private Color color = Color.WHITE;
	
	public ImageUtil() {
	}
	
	public ImageUtil(String fontName, int fontStyle, int fontSize, Color color) {
		if(fontName!=null && !"".equals(fontName)) {
			this.fontName = fontName;
		}
		this.fontStyle = fontStyle;
		this.fontSize = fontSize;
		if(color!=null) {
			this.color = color;
		}
	}

	public String getFontName() {
		return fontName;
	}

	public void setFontName(String fontName) {
		this.fontName = fontName;
	}

	public int getFontStyle() {
		return fontStyle;
	}

	public void setFontStyle(int fontStyle) {
		this.fontStyle = fontStyle;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * 缩放图像（按宽度缩放）
	 * @param srcImageFile 源图像文件地址
	 * @param result 缩放后的图像地址
	 * @param width 缩放后的宽度
	 */
	public final void resizeByWidth(String srcImageFile, String result, int width, String contentType) {
		try {
			File src = new File(srcImageFile);
			BufferedImage bi = ImageIO.read(src);
			int srcWidth = bi.getWidth();
			int srcHeight = bi.getHeight();
			
			if(srcWidth<width) {
				//如果图片的实际宽度小于要缩放的宽度，把缩放的宽度设置为图片宽度值加上图片宽度的10%
				//相当与把图片放大10%
				width = srcWidth+(int)(srcWidth*0.1);
			}
			
			int height = (width*srcHeight)/srcWidth;
			
			double sx = (double)width/srcWidth;
			double sy = (double)height/srcHeight;
			
			AffineTransform transform = new AffineTransform();
			transform.setToScale(sx, sy); //设置缩放变幻
			
			AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
			BufferedImage bid = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
			
			op.filter(bi, bid);
			ImageIO.write(bid, contentType, new File(result));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
     * 缩放图像（按高度和宽度缩放）
     * @param srcImageFile 源图像文件地址
     * @param result 缩放后的图像地址
     * @param height 缩放后的高度
     * @param width 缩放后的宽度
     * @param bb 比例不对时是否需要补白：true为补白; false为不补白;
     */
	public final void resize(String srcImageFile, String result, int width, int height, boolean bb, String contentType) {
        try {
            double ratio = 0.0; // 缩放比例
            File f = new File(srcImageFile);
            BufferedImage bi = ImageIO.read(f);
            
            Image itemp = bi.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            // 计算比例
            if ((bi.getHeight() > height) || (bi.getWidth() > width)) {
                if (bi.getHeight() > bi.getWidth()) {
                    ratio = (new Integer(height)).doubleValue() / bi.getHeight();
                } else {
                    ratio = (new Integer(width)).doubleValue() / bi.getWidth();
                }
                AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);
                itemp = op.filter(bi, null);
            }
            if (bb) {//补白
                BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                Graphics2D g = image.createGraphics();
                g.setColor(Color.white);
                g.fillRect(0, 0, width, height);
                if (width == itemp.getWidth(null))
                    g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2,
                            itemp.getWidth(null), itemp.getHeight(null),
                            Color.white, null);
                else
                    g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0,
                            itemp.getWidth(null), itemp.getHeight(null),
                            Color.white, null);
                g.dispose();
                itemp = image;
            }
            ImageIO.write((BufferedImage) itemp, contentType, new File(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	/**
     * 缩放图像（按高度和宽度缩放，不考虑缩放时宽高比例和原图是否一致）
     * @param srcImageFile 源图像文件地址
     * @param result 缩放后的图像地址
     * @param height 缩放后的高度
     * @param width 缩放后的宽度
     */
	public final void resize(String srcImageFile, String result, int width, int height, String contentType) {
        try {
            File f = new File(srcImageFile);
            BufferedImage bi = ImageIO.read(f);
            
            // 计算比例
            double xratio = (double)width/bi.getWidth();
            double yratio = (double)height/bi.getHeight();
			
			AffineTransform transform = new AffineTransform();
			transform.setToScale(xratio, yratio); //设置缩放变幻
			
			AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
			BufferedImage bid = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
			
			op.filter(bi, bid);
			ImageIO.write(bid, contentType, new File(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 添加文字水印
     * @param targetImg 目标图片路径，如：C://myPictrue//1.jpg
     * @param pressText 水印文字， 如：中国证券网
     * @param alpha 透明度(0.0 -- 1.0, 0.0为完全透明，1.0为完全不透明)
     */
	public final void pressText(String targetImg, String pressText,float alpha, String contentType) {
        try {
        	Font font = new Font(fontName, fontStyle, fontSize);
        	pressText = pressText+"  ";
        	
            File file = new File(targetImg);
            Image image = ImageIO.read(file);
            int width = image.getWidth(null);
            int height = image.getHeight(null);
            
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufferedImage.createGraphics();
            g.drawImage(image, 0, 0, width, height, null);
            g.setFont(font);
            g.setColor(color);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.0f));
            
            FontMetrics fontMetrics = g.getFontMetrics();
            
            int strWidth = fontMetrics.stringWidth(pressText);
            int strHeight = (int)fontMetrics.getLineMetrics(pressText, g).getHeight();
            
            int row = (height - strHeight)/(strHeight+10); //水印文字的行数
            int col = (width - strWidth)/strWidth; //一行能包含的文字（包含空格）个数
            StringBuffer sb = new StringBuffer(); //一行中要添加到图片的最终文字
            for(int i=0; i<col; i++) {
            	sb.append(pressText);
            }
            
            for(int i=0; i<row; i++) {
            	g.drawString(sb.toString(), 0, i*(strHeight+10));
            }
            
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
            g.drawString(pressText, width-strWidth, height-strHeight+5);
            
            g.dispose();
            ImageIO.write(bufferedImage, contentType, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
