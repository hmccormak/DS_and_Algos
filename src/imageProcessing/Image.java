package imageProcessing;

import java.awt.image.BufferedImage;

public class Image {
	private int height, width;
	private BufferedImage imageData;
	
	public Image() {
		
	}
	
	public void setImageData(BufferedImage imageData) {
		this.imageData = imageData;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public BufferedImage getImageData() {
		return imageData;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
}
