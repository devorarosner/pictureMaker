package primitives;

public class Coordination implements Comparable<Coordination> {
	
	
	protected double x;
	//***************** Constructors ********************** //
	public Coordination(double x)
	{
		this.x = x;
	}
	public Coordination() {
		super();
		this.x=0;
	}
	public Coordination(Coordination a)
	{
		this.x=a.getX();
	}
	//***************** Getters/Setters ********************** // 
	public double getX()
	{
		return x;
	}
	public void setX(double x)
	{
		this.x = x;
	}
	// ***************** Administration  ******************** // 
	public int compareTo(Coordination a)
	{
		if (this.x==a.getX())
			return 0;
		return -1;
	}
	@Override
	public boolean equals(Object obj) {
		if(this.compareTo((Coordination)obj)==0)
			return true;
		return false;
	}
	@Override
	public String toString()
	{
		return " "+x+" ";
	}
	// ***************** Operations ******************** // 
	public void add(Coordination a)
	{
		this.x=this.x+a.getX();
	}
	public void Substruct(Coordination a)
	{
		this.x=this.x-a.getX();
	}
	
}
