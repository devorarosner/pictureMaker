package test;



import java.awt.Color;

import org.junit.Test;

import elements.SpotLight;
import geometries.*;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class FinalTest {

	/*@Test
	public void testSnowFlake() //spot light, circle and triangle
	{
		Scene scene = new Scene();
		scene.setScreenDistance(200);
		SnowFlake s=new SnowFlake(new Point3D(220,10,-1000), 20, 5, 100, 20, 10);
		scene.addGeometries(s.CreateSnowFlake());
		scene.addLight(new SpotLight(new Color(0,105,0), new Point3D(200, 200, -100), 
			   new Vector(-2, -2, -3), 0.1, 0.00001, 0.000005));
		ImageWriter imageWriter = new ImageWriter("test snow flake", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.writeToimage();
	}*/
	/*@Test
	public void testTree() //spot light, circle and triangle
	{
		Scene scene = new Scene();
		scene.setScreenDistance(200);
		
		
		Triangle t1 = new Triangle(new Color (0, 255, 0),new Point3D(1500, 2500, -2500.0000001),
				new Point3D(1000, 1500, -2500),
				new Point3D(2000, 1500, -2500));
		Triangle t12 = new Triangle(new Color (255, 255, 255),new Point3D(1500, 2500, -2500),
				new Point3D(1950, 1600, -2500),
				new Point3D(1050, 1600, -2500));
		Triangle t2 = new Triangle(new Color (0, 255, 0),new Point3D(1500, 1900, -2500.0000005),
				new Point3D(1000, 900, -2500),
				new Point3D(2000, 900, -2500));
		Triangle t22 = new Triangle(new Color (255, 255, 255),new Point3D(1500, 1900, -2500.0000003),
				new Point3D(1950, 1000, -2500),
				new Point3D(1050, 1000, -2500));
		Triangle t3 = new Triangle(new Color (0, 255, 0),new Point3D(1500, 1300, -2500.0000009),
				new Point3D(1000, 300, -2500),
				new Point3D(2000, 300, -2500));
		Triangle t32 = new Triangle(new Color (255, 255, 255),new Point3D(1500, 1300, -2500.0000007),
				new Point3D(1950, 400, -2500),
				new Point3D(1050, 400, -2500));
		Triangle s1 = new Triangle(new Color (220, 160, 0),new Point3D(1700, 300, -2500),
				new Point3D(1300, 300, -2500),
				new Point3D(1300, 0, -2500));
		Triangle s2 = new Triangle(new Color (220, 160, 0),new Point3D(1700, 300, -2500),
				new Point3D(1300, 0, -2500),
				new Point3D(1700, 0, -2500));
		scene.addGeometry(t1);
		scene.addGeometry(t12);
		scene.addGeometry(t2);
		scene.addGeometry(t22);
		scene.addGeometry(t3);
		scene.addGeometry(t32);
		scene.addGeometry(s1);
		scene.addGeometry(s2);
		scene.addLight(new SpotLight(new Color(0,105,0), new Point3D(200, 200, -100), 
			   new Vector(-2, -2, -3), 0.1, 0.00001, 0.000005));
		ImageWriter imageWriter = new ImageWriter("test tree", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.writeToimage();
	}*/
	@Test
	public void snowDay() {
		
			Scene scene = new Scene();
			scene.setScreenDistance(200);
			scene.setBackground(Color.gray);
			Triangle p=new Triangle(new Color(100,40,0),new Point3D(-3000,-1200,0),new Point3D(-5000, -1200, -2700),new Point3D(5000,-1200, -2700));
			Triangle p2=new Triangle(new Color(0,0,100),new Point3D(-3000,-1200,0),new Point3D(5000, -1200, 0),new Point3D(5000, -1200, -2700));
			scene.addGeometry(p);
			Material m4=new Material();	
			m4.set_Kr(1);
			m4.set_n(20);
			p2.setM(m4);
			scene.addGeometry(p2);
			//sighn
			Triangle p3=new Triangle(new Color(0,0,0),new Point3D(-900, -400, -1100.0001),new Point3D(-1700, -400, -1300.0001),new Point3D(-900, -1000, -1100.0001));
			scene.addGeometry(p3);
			Triangle p4=new Triangle(new Color(0,0,0),new Point3D(-900, -1000, -1100.0001),new Point3D(-1700, -400, -1300.0001),new Point3D(-1700, -1000, -1300.0001));
			scene.addGeometry(p4);
			Triangle p5=new Triangle(new Color(0,0,0),new Point3D(-1220, -1200, -1180),new Point3D(-1380, -1200, -1220),new Point3D(-1220, -1000, -1180));
			scene.addGeometry(p5);
			Triangle p6=new Triangle(new Color(0,0,0),new Point3D(-1220, -1000, -1180),new Point3D(-1380, -1200, -1220),new Point3D(-1380, -1000, -1220));
			scene.addGeometry(p6);
			Triangle p7=new Triangle(new Color(255,255,255),new Point3D(-980, -440, -1120),new Point3D(-1620, -440, -1280),new Point3D(-980, -960, -1120));
			scene.addGeometry(p7);
			Triangle p8=new Triangle(new Color(255,255,255),new Point3D(-980, -960, -1120),new Point3D(-1620, -440, -1280),new Point3D(-1620, -960, -1280));
			scene.addGeometry(p8);
			
			//The snow man:
			
			//eyes
			Circle eye1= new Circle(new Color(0, 0, 0),40, new Point3D(-70, 600, -700));//do brown looks creepy
			Material mEye1=new Material();
			mEye1.set_n(10);
			eye1.setM(mEye1);
			scene.addGeometry(eye1);
			Circle eye2= new Circle(new Color(0, 0, 0),40, new Point3D(70, 600, -700));
			Material mEye2=new Material();
			mEye2.set_n(10);
			eye2.setM(mEye2);
			scene.addGeometry(eye2);
			
			//mouth-find bluberry color
			Circle mouth1= new Circle(new Color(0, 0, 255),15, new Point3D(-100, 360, -605));
			Material mMouth1=new Material();
			mMouth1.set_n(10);
			mouth1.setM(mMouth1);
			scene.addGeometry(mouth1);
			Circle mouth2= new Circle(new Color(0, 0, 255),15, new Point3D(-50, 310, -605));
			Material mMouth2=new Material();
			mMouth2.set_n(10);
			mouth2.setM(mMouth2);
			scene.addGeometry(mouth2);
			Circle mouth3= new Circle(new Color(0, 0, 255),15, new Point3D(0, 290, -605));
			Material mMouth3=new Material();
			mMouth3.set_n(10);
			mouth3.setM(mMouth3);
			scene.addGeometry(mouth3);
			Circle mouth4= new Circle(new Color(0, 0, 255),15, new Point3D(50, 310, -605));
			Material mMouth4=new Material();
			mMouth4.set_n(10);
			mouth4.setM(mMouth4);
			scene.addGeometry(mouth4);
			Circle mouth5= new Circle(new Color(0, 0, 255),15, new Point3D(100, 360, -605));
			Material mMouth5=new Material();
			mMouth5.set_n(10);
			mouth5.setM(mMouth5);
			scene.addGeometry(mouth5);
			
			//nose-find carrot color
			Triangle tNose = new Triangle(new Color (200, 0, 0),new Point3D(150, 500, -650),
					new Point3D(0, 500, -700),
					new Point3D(0, 420, -700));		
			scene.addGeometry(tNose);
			Circle cNose= new Circle(new Color(200, 0, 0),30, new Point3D(0, 460, -700));
			Material mcNose=new Material();
			mcNose.set_n(10);
			cNose.setM(mcNose);
			scene.addGeometry(cNose);
			//hands 
			
			Circle head= new Circle(new Color(200, 200, 200),300, new Point3D(0, 600, -1000));
			Circle middle= new Circle(new Color(200, 200, 200),500, new Point3D(0.0, 0.0, -1200));
			Circle body= new Circle(new Color(200, 200, 200),600, new Point3D(0, -600, -1200));
			Material mHead=new Material();
			mHead.set_n(40);
			head.setM(mHead);
			scene.addGeometry(head);
			Material mMiddle=new Material();
			mMiddle.set_n(40);
			middle.setM(mMiddle);
			scene.addGeometry(middle);	
			Material mBody=new Material();
			mBody.set_n(40);
			body.setM(mBody);
			scene.addGeometry(body);
			
			//scene.addGeometry(w22);
			
			//snowflakes
			SnowFlake s1=new SnowFlake(new Point3D(570,1350,-1000), 20, 5, 100, 15, 10);
			scene.addGeometries(s1.CreateSnowFlake());
			SnowFlake s2=new SnowFlake(new Point3D(567,800,-1000), 20, 5, 100, 15, 10);
			scene.addGeometries(s2.CreateSnowFlake());
			SnowFlake s3=new SnowFlake(new Point3D(1000,1000,-1000), 20, 5, 100, 15, 10);
			scene.addGeometries(s3.CreateSnowFlake());
			SnowFlake s4=new SnowFlake(new Point3D(-940,650,-1000), 20, 5, 100, 15, 10);
			scene.addGeometries(s4.CreateSnowFlake());
			SnowFlake s5=new SnowFlake(new Point3D(-700,10,-1000), 20, 5, 100, 15, 10);
			scene.addGeometries(s5.CreateSnowFlake());
			SnowFlake s6=new SnowFlake(new Point3D(200,1100,-1000), 20, 5, 100, 15, 10);
			scene.addGeometries(s6.CreateSnowFlake());
			SnowFlake s7=new SnowFlake(new Point3D(-250,1200,-1000), 20, 5, 100, 15, 10);
			scene.addGeometries(s7.CreateSnowFlake());
			SnowFlake s8=new SnowFlake(new Point3D(-1300,1250,-1000), 20, 5, 100, 15, 10);
			scene.addGeometries(s8.CreateSnowFlake());
			SnowFlake s9=new SnowFlake(new Point3D(-1300,-100,-1000), 20, 5, 100, 15, 10);
			scene.addGeometries(s9.CreateSnowFlake());
			SnowFlake s10=new SnowFlake(new Point3D(-1400,600,-1000), 20, 5, 100, 15, 10);
			scene.addGeometries(s10.CreateSnowFlake());
			SnowFlake s11=new SnowFlake(new Point3D(-770,1350,-1000), 20, 5, 100, 15, 10);
			scene.addGeometries(s11.CreateSnowFlake());
			SnowFlake s12=new SnowFlake(new Point3D(1200,1300,-1000), 20, 5, 100, 15, 10);
			scene.addGeometries(s12.CreateSnowFlake());
			SnowFlake s13=new SnowFlake(new Point3D(1200,600,-1000), 20, 5, 100, 15, 10);
			scene.addGeometries(s13.CreateSnowFlake());
			SnowFlake s14=new SnowFlake(new Point3D(1000,400,-1000), 15, 5, 70, 15, 10);
			scene.addGeometries(s14.CreateSnowFlake());
			SnowFlake s15=new SnowFlake(new Point3D(-600,550,-1000), 15, 5, 70, 15, 10);
			scene.addGeometries(s15.CreateSnowFlake());
			SnowFlake s16=new SnowFlake(new Point3D(-840,250,-1000), 15, 5, 70, 15, 10);
			scene.addGeometries(s16.CreateSnowFlake());
			SnowFlake s17=new SnowFlake(new Point3D(-1100,250,-1000), 15, 5, 70, 15, 10);
			scene.addGeometries(s17.CreateSnowFlake());
			SnowFlake s18=new SnowFlake(new Point3D(1400,10,-1000), 15, 5, 70, 15, 10);
			scene.addGeometries(s18.CreateSnowFlake());
			SnowFlake s19=new SnowFlake(new Point3D(1100,-210,-1000), 15, 5, 70, 15, 10);
			scene.addGeometries(s19.CreateSnowFlake());
			SnowFlake s20=new SnowFlake(new Point3D(0,1300,-1000), 12, 5, 50, 18, 10);
			scene.addGeometries(s20.CreateSnowFlake());
			SnowFlake s21=new SnowFlake(new Point3D(-1500,200,-1000), 12, 5, 50, 18, 10);
			scene.addGeometries(s21.CreateSnowFlake());
			SnowFlake s22=new SnowFlake(new Point3D(-650,1050,-1000), 12, 5, 50, 18, 10);
			scene.addGeometries(s22.CreateSnowFlake());
			SnowFlake s23=new SnowFlake(new Point3D(1500,1050,-1000), 12, 5, 50, 18, 10);
			scene.addGeometries(s23.CreateSnowFlake());
			SnowFlake s24=new SnowFlake(new Point3D(-1100,1000,-1000), 15, 5, 70, 15, 10);
			scene.addGeometries(s24.CreateSnowFlake());
			
			//tree 
			  Triangle t1 = new Triangle(new Color (0, 255, 0),new Point3D(1500, 1300, -2500.0000001),
				new Point3D(1000, 300, -2500),
				new Point3D(2000, 300, -2500));
		Triangle t12 = new Triangle(new Color (255, 255, 255),new Point3D(1500, 1300, -2500),
				new Point3D(1950, 400, -2500),
				new Point3D(1050, 400, -2500));
		Triangle t2 = new Triangle(new Color (0, 255, 0),new Point3D(1500, 700, -2500.0000005),
				new Point3D(1000, -300, -2500),
				new Point3D(2000, -300, -2500));
		Triangle t22 = new Triangle(new Color (255, 255, 255),new Point3D(1500, 700, -2500.0000003),
				new Point3D(1950, -200, -2500),
				new Point3D(1050, -200, -2500));
		Triangle t3 = new Triangle(new Color (0, 255, 0),new Point3D(1500, 100, -2500.0000009),
				new Point3D(1000, -900, -2500),
				new Point3D(2000, -900, -2500));
		Triangle t32 = new Triangle(new Color (255, 255, 255),new Point3D(1500, 100, -2500.0000007),
				new Point3D(1950, -800, -2500),
				new Point3D(1050, -800, -2500));
		Triangle st1 = new Triangle(new Color (220, 160, 0),new Point3D(1700, -900, -2500),
				new Point3D(1300, -900, -2500),
				new Point3D(1300, -1200, -2500));
		Triangle st11 = new Triangle(new Color (220, 160, 0),new Point3D(1700, -900, -2500),
				new Point3D(1300, -1200, -2500),
				new Point3D(1700, -1200, -2500));
		scene.addGeometry(t1);
		scene.addGeometry(t12);
		scene.addGeometry(t2);
		scene.addGeometry(t22);
		scene.addGeometry(t3);
		scene.addGeometry(t32);
		scene.addGeometry(st1);
		scene.addGeometry(st11);
		
		
		
		 Triangle t21 = new Triangle(new Color (0, 255, 0),new Point3D(2300, 1300, -2700.0000001),
					new Point3D(1800, 300, -2700),
					new Point3D(2800, 300, -2700));
			Triangle t212 = new Triangle(new Color (255, 255, 255),new Point3D(2300, 1300, -2700),
					new Point3D(2750, 400, -2700),
					new Point3D(1850, 400, -2700));
			Triangle t2222 = new Triangle(new Color (0, 255, 0),new Point3D(2300, 700, -2700.0000005),
					new Point3D(1800, -300, -2700),
					new Point3D(2800, -300, -2700));
			Triangle t222 = new Triangle(new Color (255, 255, 255),new Point3D(2300, 700, -2700.0000003),
					new Point3D(2750, -200, -2700),
					new Point3D(1850, -200, -2700));
			Triangle t23 = new Triangle(new Color (0, 255, 0),new Point3D(2300, 100, -2700.0000009),
					new Point3D(1800, -900, -2700),
					new Point3D(2800, -900, -2700));
			Triangle t232 = new Triangle(new Color (255, 255, 255),new Point3D(2300, 100, -2700.0000007),
					new Point3D(2750, -800, -2700),
					new Point3D(1850, -800, -2700));
			Triangle st21 = new Triangle(new Color (220, 160, 0),new Point3D(2500, -900, -2700),
					new Point3D(2100, -900, -2700),
					new Point3D(2100, -1200, -2700));
			Triangle st211 = new Triangle(new Color (220, 160, 0),new Point3D(2500, -900, -2700),
					new Point3D(2500, -1200, -2700),
					new Point3D(2100, -1200, -2700));
			scene.addGeometry(t21);
			scene.addGeometry(t212);
			scene.addGeometry(t2222);
			scene.addGeometry(t222);
			scene.addGeometry(t23);
			scene.addGeometry(t232);
			scene.addGeometry(st21);
			scene.addGeometry(st211);
			
			
			
//scene.addLight(new DirectionalLight(Color.LIGHT_GRAY, new Vector(-2, -2, -3)));
			scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-1000, -400, -150), 
					new Vector(2, 1, -3), 0.1, 0.00001, 0.000001));
			//scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, -400, -150), 
			//		new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));
			ImageWriter imageWriter = new ImageWriter("Final Product", 700, 700, 700, 700);

			Render render = new Render(imageWriter, scene);

			render.renderImage();
			render.writeToimage();
		
	}

}
