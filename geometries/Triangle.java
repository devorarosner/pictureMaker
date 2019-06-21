//Devora Rozner 206672545 
//Hanna Weissberg 318796398
package geometries;

import java.awt.Color;
import java.util.List;

import primitives.*;

public class Triangle extends Geometry implements FlatGeometry{
protected Point3D p1;
protected Point3D p2;
protected Point3D p3;
//***************** Constructors ********************** //
public Triangle(Color c, Point3D p1, Point3D p2, Point3D p3) {
	super(c);
	this.p1 =new Point3D(p1);
	this.p2 = new Point3D(p2);
	this.p3 = new Point3D(p3);
}
public Triangle() {
	super();
	this.p1=new Point3D();
	this.p2=new Point3D();
	this.p3=new Point3D();
}
public Triangle(Triangle t) {
	super(t.emission);
	this.p1 =new Point3D(t.p1);
	this.p2 = new Point3D(t.p2);
	this.p3 = new Point3D(t.p3);
}
//***************** Getters/Setters ********************** // 
public Point3D getP1() {
	return new Point3D(p1);
}
public void setP1(Point3D p1) {
	this.p1 =new Point3D(p1);
}
public Point3D getP2() {
	return new Point3D(p2);
}
public void setP2(Point3D p2) {
	this.p2 =new Point3D(p2);
}
public Point3D getP3() {
	return new Point3D(p3);
}
public void setP3(Point3D p3) {
	this.p3 = new Point3D(p3);
}
// ***************** Administration  ******************** // 
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!super.equals(obj))
		return false;
	if (getClass() != obj.getClass())
		return false;
	Triangle other = (Triangle) obj;
	if (p1 == null) {
		if (other.p1 != null)
			return false;
	} else if (!p1.equals(other.p1))
		return false;
	if (p2 == null) {
		if (other.p2 != null)
			return false;
	} else if (!p2.equals(other.p2))
		return false;
	if (p3 == null) {
		if (other.p3 != null)
			return false;
	} else if (!p3.equals(other.p3))
		return false;
	return true;
}
@Override
public String toString() {
	return "Triangle [p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + "]";
}

//***************** Operations ******************** // 
@Override
public Vector getNormal(Point3D p) {
	Plain help=new Plain(emission,p1,p2,p3);
	return help.getNormal(p);	
}
@Override
public List<Point3D> findIntersections(Ray r)
{
	Plain pl=new Plain(emission,p1,p2,p3);
	List<Point3D> l= pl.findIntersections(r);
	if(l==null)		
	   return null;
	Triangle t1=new Triangle(emission,r.getStartR(),p2,p1);
	Triangle t2=new Triangle(emission,r.getStartR(),p3,p2);
	Triangle t3=new Triangle(emission,r.getStartR(),p1,p3);
	Vector N1=t1.getNormal(r.getStartR());
	N1.normalize();
	Vector N2=t2.getNormal(r.getStartR());
	N2.normalize();
	Vector N3=t3.getNormal(r.getStartR());
	N3.normalize();	
	Point3D p=new Point3D(l.get(0));
	p.Substruct(r.getStartR());
	Vector v=new Vector(p);
	double check1=v.dotProduct(N1);
	double check2=v.dotProduct(N2);
	double check3=v.dotProduct(N3);
	if((check1>=0&&check2>=0&&check3>=0)||(check1<=0&&check2<=0&&check3<=0))
		return l;
 return null;
	
}

}
