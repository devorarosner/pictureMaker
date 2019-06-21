package primitives;

public class Vector implements Comparable<Vector> {

	
protected Point3D head;
//***************** Constructors ********************** // 
public Vector(Point3D head)
{	
	this.head = head;
}
public Vector(double x, double y, double z)//for convenience
{	
	this.head = new Point3D(x,y,z);
}
public Vector() 
{	
	this.head = new Point3D();
}
public Vector(Vector v)
{
	this.head= new Point3D(v.head);
}
	//***************** Getters/Setters ********************** // 
	public Point3D getHead()
	{
		return new Point3D(head);
	}
	
	public void setHead(Point3D head)
	{
		this.head = new Point3D(head);
	}	
	
	// ***************** Operations ******************** // 
	public void add(Vector v) 
	{
		head.add(v.getHead());
	}
	public void Substruct(Vector v) 
	{
		head.Substruct(v.getHead());
	}
	public void scale(double scalingFacor)//multiply vector by scalar
	{
		head.setX(new Coordination(head.getX().getX()*scalingFacor));
		head.setY(new Coordination(head.getY().getX()*scalingFacor));
		head.setZ(new Coordination(head.getZ().getX()*scalingFacor));
	}
	public double length()//gets the length of the vector
	{try{
		double l=head.Distance(new Point3D(new Coordination(0),new Coordination(0),new Coordination(0)));
		if(l==0)
			throw new Exception("length cannot be 0");
		return l;
	}
	catch(Exception ex)
	{
		System.out.println(ex.getMessage());
		return -1;
	}
	}	
	
	public void normalize()//normalize the vector
	{
		this.scale(1/length());
	}
	public Vector crossProduct(Vector v)
	{
		Coordination s1=new Coordination(head.getY().getX()*v.head.getZ().getX()-head.getZ().getX()*v.head.getY().getX());
		Coordination s2=new Coordination(head.getZ().getX()*v.head.getX().getX()-head.getX().getX()*v.head.getZ().getX());
		Coordination s3=new Coordination(head.getX().getX()*v.head.getY().getX()-head.getY().getX()*v.head.getX().getX());
		return new Vector(new Point3D(s1,s2,s3));
	}
	public double dotProduct(Vector v)
	{
		return head.getX().getX()*v.head.getX().getX()+head.getY().getX()*v.head.getY().getX()+head.getZ().getX()*v.head.getZ().getX();
	}
	// ***************** Administration  ******************** // 
	@Override
	public String toString() {
		return "[head=" + head + "]";
	}
	public int compareTo(Vector v)
	{
		if( this.head.compareTo(v.head)==0)
			return 0;		
		return -1;
	}
	@Override
	public boolean equals(Object obj) {
		if(this.compareTo((Vector)obj)==0)
			return true;
		return false;
	}
	

}
