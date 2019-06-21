package test;

import static org.junit.Assert.*;
import java.awt.Color;
import java.util.List;
import org.junit.Test;
import elements.Camera;
import geometries.*;
import primitives.*;

public class testTriangle {

	@Test
	public void testNormal() {
		Point3D p1=new Point3D(0,0,0);
		Point3D p2=new Point3D(0,0,1);
		Point3D p3=new Point3D(0,1,0);
		Triangle pl1=new Triangle(Color.black,p1,p2,p3);
		Vector v=pl1.getNormal(p1);
		System.out.println(v.toString());
		assertEquals(new Vector(1, 0, 0), v);
	}
	@Test
	public void testIntersectionPoints()//Triangle in the size of the view plain
	{
		Camera c=new Camera(new Point3D(), new Vector(1,0, 0), new Vector(0, 1, 0));
		Triangle t=new Triangle(Color.WHITE,new Point3D(0,0,-3),new Point3D(0,3,0),new Point3D(3,0,0));
		Ray con=c.constructRayThroughAPixel2(3, 3, 2, 2, 1, 3, 3);
		System.out.println(con.toString());
		List<Point3D> p=t.findIntersections(con);
		if(p==null)
			System.out.println("no intersection");
		else
			System.out.println(p.get(0).toString());
	}
	@Test
	public void testIntersectionPoints2()//triangle bigger then the view plane
	{
		Camera c=new Camera(new Point3D(), new Vector(1,0, 0), new Vector(0, 1, 0));
		Triangle t=new Triangle(Color.WHITE,new Point3D(0,10,-2),new Point3D(1,-1,-2),new Point3D(-1,-1,-2));
		Ray con1=c.constructRayThroughAPixel2(3, 3, 2, 2, 1, 3, 3);//the ray in the middle of the view plain
		Ray con2=c.constructRayThroughAPixel2(3, 3, 2, 1, 1, 3, 3);//the ray in top middle of the view plain
		System.out.println(con1.toString());
		System.out.println(con2.toString());
		List<Point3D> p1=t.findIntersections(con1);
		List<Point3D> p2=t.findIntersections(con2);		
		if(p1==null)
		{
			System.out.println("no intersection");
			assertNull(p1);
		}		
		else
		{
			System.out.println("p1: "+p1.get(0).toString());
			Point3D temp= new Point3D(0,0,-2);
			assertEquals(temp, p1.get(0));
		}	
		if(p2==null)
		{
			System.out.println("no intersection");
			assertNull(p2);
		}		
		else
		{
			System.out.println("p2: "+p2.get(0).toString());
			Point3D temp= new Point3D(0,2,-2);
			assertEquals(temp, p2.get(0));
		}	
	}

}
