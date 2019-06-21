package test;


import java.awt.Color;

import org.junit.Test;

import elements.AmbientLight;
import elements.SpotLight;
import geometries.Circle;
import geometries.Triangle;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class testReflectionRefraction {


	@Test
	public void testRefraction() //spot light, two circles
	{
		Scene scene = new Scene();
		scene.setScreenDistance(200);
		Circle c= new Circle(new Color(0, 0, 100),500, new Point3D(0.0, 0.0, -1000));
		Circle c2= new Circle(new Color(100, 0, 0),250, new Point3D(0.0, 0.0, -1000));
		Material m=new Material();
		m.set_n(20);
		m.set_Kt(0.5);
		c.setM(m);
		scene.addGeometry(c);
		Material m2=new Material();
		m2.set_n(20);
		c2.setM(m2);
		scene.addGeometry(c2);		

		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
				new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));
		ImageWriter imageWriter = new ImageWriter("test Refraction ", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.writeToimage();
	}
	@Test
	public void testReflection1() //spot light, two circles
	{
		Scene scene = new Scene();
		scene.setScreenDistance(200);
		Circle c= new Circle(new Color(0, 0, 100),500, new Point3D(0.0, 0.0, -1000));
		Circle c2= new Circle(new Color(100, 0, 0),50, new Point3D(-100.0, -50.0, -250));
		Material m=new Material();
		m.set_n(20);
		m.set_Kr(0.8);
		c.setM(m);
		scene.addGeometry(c);
		Material m2=new Material();
		m2.set_n(20);
		c2.setM(m2);
		scene.addGeometry(c2);		

		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, 100), 
				new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));
		ImageWriter imageWriter = new ImageWriter("test Reflection 1", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.writeToimage();
	}
	@Test
	public void testReflectionRefraction2() //spot light, circle, mirrors triangles
	{
		Scene scene = new Scene();
		scene.setAml(new AmbientLight(Color.white,0.1));
		scene.setRecursionLevel(4);
		scene.setScreenDistance(300);
		Circle c= new Circle(new Color(0, 0, 100),300, new Point3D(-550.0, -500.0, -1000));		
		Material m=new Material();
		m.set_n(20);
		m.set_Kt(0.5);
		c.setM(m);
		scene.addGeometry(c);
		Circle c2= new Circle(new Color(100, 20, 20),150, new Point3D(-550.0, -500.0, -1000));		
		Material m2=new Material();
		m2.set_n(20);
		c2.setM(m2);
		scene.addGeometry(c2);

		Triangle triangle1 = new Triangle(new Color (20, 20, 20),new Point3D(1500, -1500, -1500),
				new Point3D(-1500, 1500, -1500),
				new Point3D(-1500, -1500, -1500));	
		Material m3=new Material();
		m3.set_Kr(0.5);
		m3.set_n(20);
		triangle1.setM(m3);
		scene.addGeometry(triangle1);
		Triangle triangle2 = new Triangle(new Color (20, 20, 20),new Point3D(1500, -1500, -1500),
				new Point3D(-1500, 1500, -1500),
				new Point3D( 200,  200, -375));	
		Material m4=new Material();	
		m4.set_Kr(1);
		m4.set_n(20);
		triangle2.setM(m4);
		scene.addGeometry(triangle2);
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -150), 
				new Vector(-2, -2, -3), 0, 0.00001, 0.000005));
		ImageWriter imageWriter = new ImageWriter("test Reflection Refraction 2", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.writeToimage();
	}

}