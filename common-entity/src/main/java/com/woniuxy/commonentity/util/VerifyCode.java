package com.woniuxy.commonentity.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * 生成验证码
 *
 */
public class VerifyCode {
	//宽度
	private int w = 70;
	//高度
	private int h = 35;
 	private Random r = new Random();
 	//备选字体
	private String[] fontNames  = {"宋体", "华文楷体", "黑体", "微软雅黑", "楷体_GB2312"};
	//备选字符
	private String codes  = "23456789abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ";
	private Color bgColor  = new Color(255, 255, 255);
	//生产的验证码
	private String text ;
	
	//产生随机颜色
	private Color randomColor () {
		int red = r.nextInt(150);
		int green = r.nextInt(150);
		int blue = r.nextInt(150);
		return new Color(red, green, blue);
	}
	
	//随机产生字体
	private Font randomFont () {
		int index = r.nextInt(fontNames.length);
		String fontName = fontNames[index];
		int style = r.nextInt(4);
		int size = r.nextInt(5) + 24; 
		return new Font(fontName, style, size);
	}
	
	//画线
	private void drawLine (BufferedImage image) {
		int num  = 3;
		//2D图形类
		Graphics2D g2 = (Graphics2D)image.getGraphics();
		for(int i = 0; i < num; i++) {
			int x1 = r.nextInt(w);
			int y1 = r.nextInt(h);
			int x2 = r.nextInt(w);
			int y2 = r.nextInt(h); 
			g2.setStroke(new BasicStroke(1.5F)); 
			g2.setColor(Color.BLUE); 
			g2.drawLine(x1, y1, x2, y2);
		}
	}
	//生产随机字符
	private char randomChar () {
		int index = r.nextInt(codes.length());
		return codes.charAt(index);
	}
	//创建BufferedImage对象
	private BufferedImage createImage () {
		BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB); 
		Graphics2D g2 = (Graphics2D)image.getGraphics(); 
		//设置背景颜色
		g2.setColor(this.bgColor);
		//填充矩形rectangle
		g2.fillRect(0, 0, w, h);
 		return image;
	}
	
	/**
	 * 生成验证码图片
	 * @return
	 */
	public BufferedImage getImage () {
		//获取图片
		BufferedImage image = createImage(); 
		//画图类
		Graphics2D g2 = (Graphics2D)image.getGraphics();
		//存储验证码
		StringBuilder sb = new StringBuilder();
		// 向图片中画4个字符
		for(int i = 0; i < 4; i++)  {
			String s = randomChar() + ""; 
			sb.append(s); 
			float x = i * 1.0F * w / 4; 
			g2.setFont(randomFont()); 
			g2.setColor(randomColor()); 
			g2.drawString(s, x, h-5); 
		}
		this.text = sb.toString(); 
		drawLine(image); 
		return image;		
	}
	
	/**
	 * 获取验证码文本
	 */
	public String getText () {
		return text;
	}
	
	/**
	 * 输出验证码
	 * @param image
	 * @param out
	 * @throws IOException
	 */
	public static void output (BufferedImage image, OutputStream out) 
				throws IOException {
		ImageIO.write(image, "JPEG", out);
	}
}


