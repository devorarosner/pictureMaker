package test;

import static org.junit.Assert.*;

import org.junit.Test;
import primitives.*;
public class testPoint3D {

	@Test
	public void testAdd() {
		Point3D p1=new Point3D(-1,1,1);
		Point3D p2=new Point3D(1,1,0);
		p1.add(p2);
		System.out.println(p1.toString());
		assertEquals(new Point3D(0, 2, 1), p1);
	}
	@Test
	public void testSubstract() {
		Point3D p1=new Point3D(-1,1,1);
		Point3D p2=new Point3D(1,1,0);
		p1.Substruct(p2);
		System.out.println(p1.toString());
		assertEquals(new Point3D(-2, 0, 1), p1);
	}
}
