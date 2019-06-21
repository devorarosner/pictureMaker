package test;
import java.awt.Color;
import org.junit.Test;
import elements.*;
import primitives.*;
import renderer.ImageWriter;
import renderer.Render;
import geometries.*;
import scene.Scene;
public class testLight {

	@Test
	public void spotLightTest(){
		
		Scene scene = new Scene();
		scene.setScreenDistance(150);
		Circle sphere = new Circle(new Color(0, 0, 100),800, new Point3D(0.0, 0.0, -1000));
		Material m=new Material();
		m.set_n(30);
		sphere.setM(m);
		scene.addGeometry(sphere);
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -100), 
					   new Vector(2, 2, -3), 0, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Spot test", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.writeToimage();
	}
	@Test
	public void pointLightTest(){
		
		Scene scene = new Scene();
		scene.setScreenDistance(150);
		Circle sphere = new Circle (new Color(0, 0, 100),800, new Point3D(0.0, 0.0, -1000));
		Material m=new Material();
		m.set_n(20);
		sphere.setM(m);
		scene.addGeometry(sphere);
		scene.addLight(new PointLight(new Color(255,100,100), new Point3D(-200, -200, -50), 
					   0, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Point test", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.writeToimage();
		
	}
	@Test
	public void testPhong1() //spot light, circle and triangle
	{
		Scene scene = new Scene();
		scene.setScreenDistance(200);
		 Circle c= new Circle(new Color(0, 0, 100),500, new Point3D(0.0, 0.0, -1000));
		Material m=new Material();
		m.set_n(20);
		c.setM(m);
		scene.addGeometry(c);
		
		Triangle triangle = new Triangle(new Color (0, 0, 100),new Point3D(-125, -225, -260),
										 new Point3D(-225, -125, -260),
										 new Point3D(-225, -225, -270));
		
		Material m1=new Material();
		m1.set_n(4);
		triangle.setM(m1);
		scene.addGeometry(triangle);
		
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -300, -150), 
					   new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("test Phong 1", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.writeToimage();
	}
	@Test
	public void testPhong2() //spot light, plain
	{
		Scene scene = new Scene();
		scene.setScreenDistance(50);
		 Plain pl= new Plain(new Color(0, 0, 100), new Point3D(0.0, 0.0, -100),new Vector(0,0,-1));	
		scene.addGeometry(pl);	
		scene.addLight(new SpotLight(new Color(100, 100, 100), new Point3D(0, 0, -450), 
					   new Vector(0, 0, 1), 0.1, 0.00001, 0.000005));		
		ImageWriter imageWriter = new ImageWriter("test Phong 2", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.writeToimage();
	}
	@Test
	public void testPhong3(){//circle, two spot lights
		
		Scene scene = new Scene();
		scene.setScreenDistance(150);
		Circle circle = new Circle(new Color(100, 0, 0),700, new Point3D(0.0, 10.0, -1000));
		Material m=new Material();
		m.set_n(20);
		circle.setM(m);
		scene.addGeometry(circle);
		scene.addLight(new SpotLight(new Color(100, 100, 255), new Point3D(-200, -100, -200), 
					   new Vector(1, 1, -3), 0, 0.00001, 0.000005));
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, -100, -200), 
				   new Vector(-1, 1, -3), 0, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("test phong 3", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.writeToimage();
	}
	
}
