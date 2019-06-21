package test;

import static org.junit.Assert.*;

import org.junit.Test;

import elements.Camera;

import java.awt.Color;
import java.util.List;

import primitives.*;
import geometries.*;
public class testPlain {

	@Test
	public void testNormal() {
		Point3D p1=new Point3D(0,3,4);
		Vector v2=new Vector(1,0,0);
		Plain pl1=new Plain(Color.black,p1,v2);
		Vector v=pl1.getNormal(p1);
		System.out.println(v.toString());
		Vector normal=new Vector(new Point3D(1, 0, 0));		
		assertEquals(normal, v);
	}
	@Test
	public void testIntersectionPoints()//regular plain
	{
		Point3D p1=new Point3D(1,1,-7);
		Vector v2=new Vector(0,0,-1);
		Plain pl1=new Plain(Color.black,p1,v2);
		Camera c=new Camera(new Point3D(), new Vector(1,0, 0), new Vector(0, 1, 0));
		Ray r=c.constructRayThroughAPixel2(3, 3, 1, 1, 1, 3, 3);
		List<Point3D> l=pl1.findIntersections(r);
		if(l==null)
		{
			System.out.println("no intersection");
			assertNull(l);
		}		
		else
		{
			Point3D temp= new Point3D(-7,7,-7);
			assertEquals(temp, l.get(0));
		}		
	}
	@Test
	public void testIntersectionPoints2()//a plain who is on the camera itself, therefore, not seen
	{
		Point3D p1=new Point3D(1,0,7);
		Vector v2=new Vector(0,1,0);
		Plain pl1=new Plain(Color.black,p1,v2);
		Camera c=new Camera(new Point3D(), new Vector(1,0, 0), new Vector(0, 1, 0));
		Ray r=c.constructRayThroughAPixel2(3, 3, 2, 2, 1, 3, 3);
		List<Point3D> l=pl1.findIntersections(r);
		if(l==null)
		{
			System.out.println("no intersection");
			assertNull(l);
		}

		else
		{
			Point3D temp= new Point3D(0,0,0);
			assertEquals(temp, l.get(0));	
		}
	}
}
