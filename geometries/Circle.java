//Devora Rozner 206672545 
//Hanna Weissberg 318796398
package geometries;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import java.lang.Math;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Circle extends Geometry{
	protected double radius;
	protected Point3D center;
	//***************** Constructors ********************** //
	public Circle(Color c, double radius, Point3D center) {
		super(c);
		this.radius = radius;
		this.center = new Point3D(center);
	}

	public Circle(Circle ci) {
		super(ci.emission);
		this.radius = ci.radius;
		this.center = new Point3D(ci.center);
	}

	public Circle() {
		super();
		radius=0;
		center= new Point3D();
	}
	//***************** Getters/Setters ********************** // 
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Point3D getCenter() {
		return new Point3D(center);
	}

	public void setCenter(Point3D center) {
		this.center = new Point3D(center);
	}
	// ***************** Administration  ******************** // 
	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", center=" + center + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circle other = (Circle) obj;
		if (center == null) {
			if (other.center != null)
				return false;
		} else if (!center.equals(other.center))
			return false;
		if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
			return false;
		return true;
	}
	//***************** Operations ******************** // 
	@Override
	public Vector getNormal(Point3D p) {
		Point3D help=new Point3D(p);
		help.Substruct(center);
		Vector v=new Vector(help);
		v.normalize();
		return v;
	}

	@Override
	public List<Point3D> findIntersections(Ray r) 
	{
		Vector v0=r.getDirection();
		Point3D p0=r.getStartR();
		Point3D O=new Point3D(center);
		O.Substruct(p0);
		Vector L=new Vector(O);	
		double tm=L.dotProduct(v0);
		double length=0;
		if(L.equals(new Vector(0,0,0))==false)
			length=L.length();
		double d=Math.sqrt(Math.pow(length,2)-Math.pow(tm,2));
		if(d>radius)
			return null;
		double th=Math.sqrt(Math.pow(radius,2)-Math.pow(d,2));
		double t1=tm-th;
		double t2=tm+th;
		List<Point3D> l=new LinkedList<Point3D>();		
		if(t1>0)			
		{
			v0.scale(t1);
			p0.add(v0.getHead());
			Point3D p1=new Point3D(p0);
			l.add(p1);
		}
		if(t1!=t2)
			if(t2>0)
			{
				v0=r.getDirection();
				p0=r.getStartR();
				v0.scale(t2);
				p0.add(v0.getHead());
				Point3D p2=new Point3D(p0);
				l.add(p2);
			}
		if(l.isEmpty())
			return null;
		return l;			
	}

}
