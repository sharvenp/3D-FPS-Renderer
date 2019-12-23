package main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import utils.GeneralException;

/**
 * 
 * Loads the map from an image and holds reference to the data.
 * 
 * @author sharvenp
 */
public class Map {

	private static int[][] map;
	private static int width;
	private static int height;
	
	public static boolean checkInBound(int x, int y) {
		return (0 <= x && x < width) && (0 <= y && y < height);
	}
	
	public static int getValue(int x, int y) {
		return map[y][x];
	}
	
	public static int getWidth() {
		return width;
	}
	
	public static int getHeight() {
		return height;
	}
	
	public static void readMap(String name) {
	
		BufferedImage mapImg = null;
		int[][] m = {};
		int w = 0;
		int h = 0;
		
		try {
		    
			mapImg = ImageIO.read(Map.class.getClassLoader().getResourceAsStream(name));
			w = mapImg.getWidth();
			h = mapImg.getHeight();
			m = new int[h][w];
			
			for (int row = 0; row < h; row++) {
				for (int col = 0; col < w; col++) {
					
					int pixel = mapImg.getRGB(col, row);
					int r = (pixel>>16) & 0xff;
					int g = (pixel>>8) & 0xff;
					int b = pixel & 0xff;
					
					if (r != g || g != b) {
						throw new GeneralException("RGB values need to be equal");
					}
					
					m[row][col] = (r > 0 ? 1 : 0);
				}
			}
			
		} catch (IOException e) {
			System.out.println("IO Exception");
		} catch (GeneralException ge) {
			System.out.println("Map should only have white or black for colors.");
		}
		
		width = w;
		height = h;
		map = m;
	}
	
}
