//Devora Rozner 206672545 
//Hanna Weissberg 318796398
package geometries;
import primitives.*;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

public class Plain extends Geometry implements FlatGeometry {

	protected Point3D p;
	protected Vector v;
	//***************** Constructors ********************** //
	public Plain() {
		super();
		p=new Point3D();
		v=new Vector();
	}
	public Plain(Color c, Point3D p, Vector v) {
		super(c);
		this.p =new Point3D(p);
		this.v = new Vector(v);
	}
	public Plain(Plain pl) {
		super();
		this.p =new Point3D(pl.p);
		this.v = new Vector(pl.v);
	}
	public Plain(Color c, Point3D p1, Point3D p2, Point3D p3) {
		super(c);
		Point3D help1=new Point3D(p2);
		help1.Substruct(p1);
		Vector v1=new Vector(help1);
		Point3D help2=new Point3D(p2);
		help2.Substruct(p3);
		Vector v2=new Vector(help2);
		this.v=v1.crossProduct(v2);
		this.p=new Point3D(p1);		
	}
	//***************** Getters/Setters ********************** // 
	public Point3D getP() {
		return new Point3D (p);
	}
	public void setP(Point3D p) {
		this.p = new Point3D(p);
	}
	public Vector getV() {
		return new Vector(v);
	}
	public void setV(Vector v) {
		this.v = new Vector(v);
	}
	// ***************** Administration  ******************** // 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plain other = (Plain) obj;
		if (p == null) {
			if (other.p != null)
				return false;
		} else if (!p.equals(other.p))
			return false;
		if (v == null) {
			if (other.v != null)
				return false;
		} else if (!v.equals(other.v))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Plain [p=" + p + ", v=" + v + "]";
	}
	// ***************** Operations ******************** // 
	@Override
	public Vector getNormal(Point3D p) {
		Vector help=new Vector(v);
		help.normalize();
		return help;
	}
	@Override
	public List<Point3D> findIntersections(Ray r)
	{
		if(r.getDirection().dotProduct(v)==0)						
		return null;
		Vector N=new Vector(v);
		N.normalize();
		Vector v0=r.getDirection();
		Point3D p0=r.getStartR();
		p0.Substruct(p);		
		Vector help =new Vector(p0);		
		double t=(-N.dotProduct(help))/N.dotProduct(v0);		
		if(t<0)
			return null;		
		 v0=r.getDirection();
		 p0=r.getStartR();
		 v0.scale(t);		 
		 p0.add(v0.getHead());
		Point3D pWanted=new Point3D(p0);
		List<Point3D> l=new LinkedList<Point3D>();
		l.add(pWanted);
		return l;
	}

}
