package test;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import elements.Camera;
import geometries.*;
import primitives.*;

public class testCircle {
	@Test
	public void testNormal() {
		Point3D p1=new Point3D(0,0,0);
		Circle c1=new Circle(Color.black,1,p1);
		Vector v=c1.getNormal(new Point3D(0,0,1));
		System.out.println(v.toString());
		assertEquals(new Vector(0, 0, 1), v);
	}
	@Test
	public void testIntersectionPoints1() //two intersections
	{
		Camera c=new Camera(new Point3D(), new Vector(1,0, 0), new Vector(0, 1, 0));	   
	    Ray con=c.constructRayThroughAPixel2(3, 3, 2, 2, 1, 3, 3);//construct the ray in the middle		
		Circle cir2=new Circle(Color.black,1,new Point3D(0,0,-4));
		List<Point3D> p=cir2.findIntersections(con);
		System.out.println(p.get(0).toString());
		System.out.println(p.get(1).toString());
		List<Point3D> l= new LinkedList<Point3D>();
		Point3D p1=new Point3D(0,0,-3);
		Point3D p2=new Point3D(0,0,-5);
		l.add(p1);
		l.add(p2);
		assertEquals(l.get(0), p.get(0));
		assertEquals(l.get(1), p.get(1));								
	}
	@Test
	public void testIntersectionPoints2() //one intersection
	{
		Camera c=new Camera(new Point3D(), new Vector(1,0, 0), new Vector(0, 1, 0));	   
	    Ray con=c.constructRayThroughAPixel2(3, 3, 2, 2, 1, 3, 3);//construct the ray in the middle		
		Circle cir2=new Circle(Color.black,1,new Point3D(0,1,-4));
		List<Point3D> p=cir2.findIntersections(con);
		System.out.println(p.get(0).toString());
		System.out.println(p.size());		
		Point3D p1=new Point3D(0,0,-4);		
		assertEquals(p1, p.get(0));
	}
	
}
