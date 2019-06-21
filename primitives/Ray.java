package primitives;

public class Ray implements Comparable<Ray> 
{
protected Point3D startR;//starting point
protected Vector direction;//vector of direction
//***************** Constructors ********************** // 
public Ray(Point3D startR, Vector direction) 
{
	super();
	this.startR = new Point3D(startR);
	this.direction = new Vector(direction);
}
public Ray()
{
	this.startR = new Point3D();
	this.direction = new Vector();
}
public Ray(Ray r)
{
	this.startR = new Point3D(r.getStartR());
	this.direction=new Vector(r.getDirection());
}
//***************** Getters/Setters ********************** // 
public Point3D getStartR() 
{
	return new Point3D(startR);
}
public void setStartR(Point3D startR)
{
	this.startR = new Point3D(startR);
}
public Vector getDirection() 
{
	return new Vector(direction);
}
public void setDirection(Vector direction) 
{
	this.direction = new Vector(direction);
}
//***************** Administration  ******************** // 
public int compareTo(Ray r)
{
	if (this.startR.compareTo(r.startR)==0&&this.direction.compareTo(r.direction)==0)
return 0;
return -1;
}
@Override
public boolean equals(Object obj) {
	if(compareTo((Ray) obj)==0)
		return true;
	return false;
}
@Override
public String toString() {
	return "[startR=" + startR + ", direction=" + direction + "]";
}
}
