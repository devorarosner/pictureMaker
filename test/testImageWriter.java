package test;


import java.awt.Color;

import org.junit.Test;

import renderer.ImageWriter;

public class testImageWriter {

	@Test
	public void testImage1() {
		ImageWriter i=new ImageWriter("test Image 1", 900, 900, 900, 900);
		for (int j = 0; j < 899; j++) 
			if(j%3==0)
				i.writePixel(j,j, Color.CYAN);
			else
				for (int j2 = 0; j2 < j; j2++) 								
					i.writePixel(j,j2, Color.ORANGE);		
		i.writeToimage();
	}
	@Test
	public void testImage2() {
		ImageWriter i=new ImageWriter("test Image 2", 160, 320, 320, 160);
		for (int h = 0; h < 320; h++)			
			for (int j = 0; j < 160; j++) 
				if(j%5==0||h%5==0)
					i.writePixel(j,h, 115,225,0);
				else
					i.writePixel(j,h, 0,216,255);
		i.writeToimage();
	}
	@Test
	public void testImage3() {
		ImageWriter i=new ImageWriter("test Image 3", 300, 300, 300, 300);
		for (int h = 0; h < 300; h++) 
			for (int j = 0; j < 300; j++) 
				if(j%2==0)
					i.writePixel(j,h, 200,100,155);
				else
					i.writePixel(j,h, Color.BLACK);
		i.writeToimage();
	}
}
