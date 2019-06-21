package primitives;
import java.lang.Math;

public class Point2D implements Comparable<Point2D> {
	protected Coordination x;
	protected Coordination y;
	//***************** Constructors ********************** // 
	public Point2D(Coordination x, Coordination y)
	{
		super();
		this.x = new Coordination(x);
		this.y = new Coordination(y);
	}
	public Point2D(double x, double y)//for convenience
	{
		super();
		this.x = new Coordination(x);
		this.y = new Coordination(y);
	}
	public Point2D()
	{
		super();
		this.x = new Coordination();
		this.y = new Coordination();
	}
	public Point2D(Point2D p2)
	{
		super();
		this.x = new Coordination(p2.getX());
		this.y = new Coordination(p2.getY());
	}
	//***************** Getters/Setters ********************** // 
	public Coordination getX()
	{
		return new Coordination(x);
	}
	public void setX(Coordination x)
	{
		this.x = new Coordination(x);
	}
	public Coordination getY()
	{
		return new Coordination(y);
	}
	public void setY(Coordination y)
	{
		this.y = new Coordination(y);
	}
	
	// ***************** Administration  ******************** // 
	@Override
	public String toString() {
		return "[x=" + x + ", y=" + y+"]";
	}
	public int compareTo(Point2D p2)
	{
		if((this.x.compareTo(p2.getX())==0)&&(this.y.compareTo(p2.getY())==0))
			return 0;
		return -1;
	}	
	@Override
	public boolean equals(Object obj) {
		if(this.compareTo((Point2D)obj)==0)
			return true;
		return false;
	}
	// ***************** Operations ******************** // 
	public double Distance(Point2D p2)//calculates the distance between two points in 2D
	{
			return Math.sqrt(Math.pow(this.x.getX()-p2.getX().getX(), 2)+Math.pow(this.y.getX()-p2.getY().getX(), 2));
		}
	public void add(Point2D p2) 
	{
		this.x.add(p2.getX());
		this.y.add(p2.getY());
	}
	public void Substruct(Point2D p2) 
	{
		this.x.Substruct(p2.getX());
		this.y.Substruct(p2.getY());
	}
}
