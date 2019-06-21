package primitives;
import java.lang.Math;

public class Point3D extends Point2D
{
protected Coordination z;
//***************** Constructors ********************** // 
public Point3D(Coordination x, Coordination y, Coordination z)
{
	super(x, y);
	this.z = new Coordination(z);
}
public Point3D(double x, double y, double z)//for convenience
{
	super(x, y);
	this.z = new Coordination(z);
}
public Point3D()
{
	super();
	this.z=new Coordination();
}
public Point3D(Point3D p3) {
	super(p3.getX(), p3.getY());
	this.z=new Coordination(p3.getZ());
}
//***************** Getters/Setters ********************** // 
public Coordination getZ()
{
	return new Coordination(z);
}
public void setZ(Coordination z)
{
	this.z = new Coordination(z);
}

//***************** Administration  ******************** // 
@Override
public String toString()
{
	return "[x=" + x + ",y=" + y+" ,z=" + z + "]";
}

public int compareTo(Point3D p3)
{
	if((this.x.compareTo(p3.getX())==0)&&(this.y.compareTo(p3.getY())==0)&&(this.z.compareTo(p3.getZ())==0))
		return 0;
	return -1;
}
@Override
public boolean equals(Object obj) {
	if(compareTo((Point3D) obj)==0)
		return true;
	return false;
}
//***************** Operations ******************** // 
public double Distance(Point3D p3)//calculates the distance between two points in 3D
{
	return Math.sqrt(Math.pow(this.x.getX()-p3.getX().getX(), 2)+Math.pow(this.y.getX()-p3.getY().getX(), 2)+Math.pow(this.z.getX()-p3.getZ().getX(), 2));
}
public void add(Point3D p3) 
{
	this.x.add(p3.getX());
	this.y.add(p3.getY());
	this.z.add(p3.getZ());
}
public void Substruct(Point3D p3) 
{
	this.x.Substruct(p3.getX());
	this.y.Substruct(p3.getY());
	this.z.Substruct(p3.getZ());
}
}
