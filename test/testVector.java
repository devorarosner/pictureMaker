package test;

import static org.junit.Assert.*;

import org.junit.Test;

import primitives.*;

public class testVector {
	@Test
	public void testAdd() {
		Vector v1=new Vector(-1,1,1);
		Vector v2=new Vector(1,1,0);
		v1.add(v2);
		System.out.println(v1.toString());
		assertEquals(new Vector(0, 2, 1), v1);
	}
	@Test
	public void testSubsract() {
		Vector v1=new Vector(-1,1,1);
		Vector v2=new Vector(1,1,0);
		v1.Substruct(v2);
		System.out.println(v1.toString());
		assertEquals(new Vector(-2, 0, 1), v1);
	}
	@Test
	public void testScaling() {
		Vector v1=new Vector(-1,1,0);
		v1.scale(3);
		System.out.println(v1.toString());
		assertEquals(new Vector(-3, 3, 0), v1);
		v1.scale(-1);
		System.out.println(v1.toString());
		assertEquals(new Vector(3, -3, 0), v1);
	}
	@Test
	public void testDotProduct() {
		Vector v1=new Vector(-1,1,1);
		Vector v2=new Vector(1,1,0);
		double s=v1.dotProduct(v2);
		System.out.println(s);
		assertEquals(0, s,0);
	}
	@Test
	public void testLength() {
		Vector v1=new Vector(0,3,4);
		double d=v1.length();
		System.out.println(d);
		assertEquals(5, d,0);
}
	@Test
	public void testNormalize() {
		Vector v1=new Vector(0,0,4);
		v1.normalize();
		System.out.println(v1.toString());
		assertEquals(new Vector(0,0 ,1), v1);
	}
	@Test
	public void testCrossProduct() {
		Vector v1=new Vector(-1,1,1);
		Vector v2=new Vector(1,1,0);
		Vector v= v1.crossProduct(v2);
		System.out.println(v.toString());
		assertEquals(new Vector(-1, 1, -2), v);
	}
}
