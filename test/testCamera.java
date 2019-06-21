package test;

import static org.junit.Assert.*;

import org.junit.Test;
import elements.*;
import primitives.*;
public class testCamera {

	@Test
	public void testRaysConstruction()
	{
		//for the test, lets choose the middle pixel in a simple plane view
		Vector v1=new Vector(1,0,0);
		Vector v2=new Vector(0,1,0);
		Point3D p=new Point3D(0,0,0);
		Camera c=new Camera(p,v1,v2);
		Ray con=c.constructRayThroughAPixel2(3, 3, 2, 2, 1, 3, 3);
		System.out.println(con.toString());
		Ray r= new Ray(new Point3D(0,0,0),new Vector(0, 0, -1));
		assertEquals(r, con);				
	}
}
