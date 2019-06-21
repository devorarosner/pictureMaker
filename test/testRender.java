package test;

import java.awt.Color;

import org.junit.Test;

import elements.AmbientLight;
import elements.Camera;
import scene.Scene;
import geometries.*;
import primitives.*;
import renderer.*;

public class testRender {
	
	@Test
	public void testRenderer1()//the image from the slides
	{
		
		Scene scene =new Scene("test scene1", Color.BLACK, new Camera(), 149,new AmbientLight());		
		scene.addGeometry(new Circle(Color.pink,50, new Point3D(0.0, 0.0, -150)));			
		Triangle triangle = new Triangle(Color.gray,new Point3D( 100, 0, -149),
				 						 new Point3D( 0, 100, -149),
				 						 new Point3D( 100, 100, -149));
		
		Triangle triangle2 = new Triangle(Color.blue,new Point3D( 100, 0, -149),
				 			 			  new Point3D( 0, -100, -149),
				 			 			  new Point3D( 100,-100, -149));
		
		Triangle triangle3 = new Triangle(Color.green,new Point3D(-100, 0, -149),
				 						  new Point3D( 0, 100, -149),
				 						  new Point3D(-100, 100, -149));
		
		Triangle triangle4 = new Triangle(Color.red,new Point3D(-100, 0, -149),
				 			 			  new Point3D( 0,  -100, -149),
				 			 			  new Point3D(-100, -100, -149));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);
		
		
		ImageWriter imageWriter = new ImageWriter("Render test1", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.printGrid(50);
		render.writeToimage();
		
	}
	@Test
	public void testRenderer2()//a house with circle on top
	{
		Scene scene =new Scene("test scene2", Color.lightGray, new Camera(), 50,new AmbientLight());	
		scene.addGeometry(new Plain(new Color(0,191,255), new Point3D(0.0, 450, 0),new Vector(0, 450, 1500)));			
		scene.addGeometry(new Plain(new Color(34,139,34), new Point3D(0.0, -450, 0),new Vector(0, -450, 1000)));			
		scene.addGeometry(new Circle(new Color(139,0,139),10, new Point3D(0, 120, -50)));
		Triangle triangle = new Triangle(new Color(255,255,224),new Point3D( -100, 0, -50),
				 						 new Point3D( 100, 0, -50),
				 						 new Point3D( 100, -150, -50));
		
		Triangle triangle2 = new Triangle(new Color(255,255,224),new Point3D( -100, 0, -50),
				 			 			  new Point3D( 100, -150, -50),
				 			 			  new Point3D( -100,-150, -50));
		
		Triangle triangle3 = new Triangle(Color.red,new Point3D(0, 100, -50),
				 						  new Point3D( -150, 0, -50),
				 						  new Point3D(150, 0, -50));
					
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);		
				
		ImageWriter imageWriter = new ImageWriter("Render test2", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();	
		render.writeToimage();
	}
	

}
