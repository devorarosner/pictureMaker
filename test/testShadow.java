//Hanna Weissberg 318796398
//Devora Rosner 206672545 
package test;
import java.awt.Color;
import org.junit.Test;
import elements.*;
import geometries.*;
import primitives.*;
import renderer.*;
import scene.Scene;

public class testShadow {


	@Test
	public void testShadow1() //spot light, circle and triangle
	{
		Scene scene = new Scene();
		scene.setScreenDistance(200);
		Circle c= new Circle(new Color(0, 0, 100),700, new Point3D(0.0, 0.0, -1200));
		Material m=new Material();
		m.set_n(20);
		c.setM(m);
		scene.addGeometry(c);

		Triangle triangle = new Triangle(new Color (0, 0, 100),new Point3D(100, 150, -300),
				new Point3D(-50, -50, -350),
				new Point3D(100, -50, -350));		
		scene.addGeometry(triangle);

		scene.addLight(new SpotLight(new Color(0,105,0), new Point3D(200, 200, -100), 
			   new Vector(-2, -2, -3), 0.1, 0.00001, 0.000005));

		ImageWriter imageWriter = new ImageWriter("test Shadow 1", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.writeToimage();
	}
	@Test
	public void testShadow2() //spot light, two circles triangle
	{
		Scene scene = new Scene();
		scene.setScreenDistance(200);
		Circle c= new Circle(new Color(0, 0, 100),500, new Point3D(0.0, 0.0, -1000));
		Circle c2= new Circle(new Color(100, 0, 0),50, new Point3D(-50.0, -50.0, -150));
		Material m=new Material();
		m.set_n(20);
		c.setM(m);
		scene.addGeometry(c);
		Material m2=new Material();
		m2.set_n(20);
		c2.setM(m2);
		scene.addGeometry(c2);		

		Triangle triangle = new Triangle(new Color (0, 0, 100),new Point3D(125, 225, -360),
				new Point3D(225, 125, -360),
				new Point3D(225, 225, -370));

		Material m1=new Material();
		m1.set_n(4);
		triangle.setM(m1);
		scene.addGeometry(triangle);

		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-300, -300, 500), 
				new Vector(1, 1, -3), 0.1, 0.00001, 0.000005));
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(400, 400, -100), 
				new Vector(-2, -2, -3), 0.1, 0.00001, 0.000005));
		ImageWriter imageWriter = new ImageWriter("test Shadow 2", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.writeToimage();
	}

	@Test
	public void testShadow3(){//circle on triangles surface

		Scene scene = new Scene();
		scene.setScreenDistance(100);
		Circle c = new Circle(new Color(0, 0, 100),700, new Point3D(0.0, 0.0, -1000));
		Material m=new Material();
		m.set_n(20);
		c.setM(m);
		scene.addGeometry(c);
		Triangle triangle = new Triangle(new Color(0,0,0),new Point3D(  3500,  3500, -1200),
				new Point3D( -3000, -3000, -1000),
				new Point3D(  3000, -3000, -1000))
				;
		Material m1=new Material();
		m1.set_n(4);
		triangle.setM(m1);
		Triangle triangle2 = new Triangle(new Color(0,0,0),new Point3D(  3000,  3000, -1200),
				new Point3D( -3000,  3000, -1000),
				new Point3D( -3000, -3000, -1000)
				);
		
		triangle2.setM(m1);
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);

		scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(200, 200, 0), 
				0, 0.000001, 0.0000005));


		ImageWriter imageWriter = new ImageWriter("test Shadow 3", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.writeToimage();
	}
}
