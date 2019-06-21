package geometries;

import java.util.List;
import java.awt.Color;
import java.util.LinkedList;
import primitives.*;
import java.lang.Math;

public class SnowFlake {
	protected Point3D center;// the center of the snowFlake
	protected double radius1;// the radius of the first circle
	protected double radius2;// the radius of the second circles
	protected double diamondHeight;//the height of the diamonds
	protected int diamondWidth;//the width of the diamonds, must be between 0 to 30
	protected double distance;//the distance between the diamonds and the small circle
	//***************** Constructors ********************** //
	public SnowFlake(Point3D center, double radius1, double radius2, double diamondHeight, int diamondWidth,
			double distance) {
		this.center = new Point3D(center);
		this.radius1 = radius1;
		this.radius2 = radius2;
		this.diamondHeight = diamondHeight;
		try{
			if(diamondWidth<0||diamondWidth>30)
				throw new Exception("the diamond width must be between 0 and 30");
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}	
		this.diamondWidth = diamondWidth;
		this.distance = distance;
	}

	public SnowFlake(SnowFlake s) {
		this.center = s.getCenter();
		this.radius1 = s.radius1;
		this.radius2 = s.radius2;
		this.diamondHeight = s.diamondHeight;
		this.diamondWidth = s.diamondWidth;
		this.distance = s.distance;
	}



	//***************** Getters/Setters ********************** // 
	public Point3D getCenter() {
		return new Point3D(center);
	}
	public void setCenter(Point3D center) {
		this.center = center;
	}

	public double getRadius1() {
		return radius1;
	}

	public void setRadius1(double radius1) {
		this.radius1 = radius1;
	}

	public double getRadius2() {
		return radius2;
	}

	public void setRadius2(double radius2) {
		this.radius2 = radius2;
	}

	public double getDiamondHeight() {
		return diamondHeight;
	}

	public void setDiamondHeight(double diamondHeight) {
		this.diamondHeight = diamondHeight;
	}

	public int getDiamondWidth() {
		return diamondWidth;
	}

	public void setDiamondWidth(int diamondWidth) {
		try{
			if(diamondWidth<0||diamondWidth>30)
				throw new Exception("the diamond width must be between 0 and 30");
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}	
		this.diamondWidth = diamondWidth;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
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
		SnowFlake other = (SnowFlake) obj;
		if (center == null) {
			if (other.center != null)
				return false;
		} else if (!center.equals(other.center))
			return false;
		if (Double.doubleToLongBits(diamondHeight) != Double.doubleToLongBits(other.diamondHeight))
			return false;
		if (diamondWidth != other.diamondWidth)
			return false;
		if (Double.doubleToLongBits(distance) != Double.doubleToLongBits(other.distance))
			return false;
		if (Double.doubleToLongBits(radius1) != Double.doubleToLongBits(other.radius1))
			return false;
		if (Double.doubleToLongBits(radius2) != Double.doubleToLongBits(other.radius2))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SnowFlake [center=" + center + ", radius1=" + radius1 + ", radius2=" + radius2 + ", diamondHeight="
				+ diamondHeight + ", diamondWidth=" + diamondWidth + ", distance=" + distance + "]";
	}


	// ***************** Operations ******************** // 

	public List<Geometry> CreateSnowFlake (){
		return CalculateShape(center.getX().getX(),center.getY().getX(),center.getZ().getX(),
				radius1,radius2,diamondHeight,diamondWidth,distance);

	}



	private List<Geometry> CalculateShape (double x,double y,double z,double r1,double r2,double h,int w, double d)
	{
		Color theColor=new Color (110,180,222);//color of snowFlake
		Circle c=new Circle (theColor,r1,new Point3D(x,y,z));
		Material snowf=new Material();
		snowf.set_n(40);
		snowf.set_Kr(0.5);
		int i=0;
		c.setM(snowf);
		List <Geometry> l=new LinkedList<Geometry>();
		l.add (c);
		while (i <360)
		{
			
			Triangle t1= new Triangle(theColor,new Point3D(x+(r1+10)*(Math.sin(Math.toRadians(i))),y+(r1+10)*(Math.cos(Math.toRadians(i))),z), new Point3D(x+((r1+10)+h/2)*Math.sin(Math.toRadians(i+w)),y+((r1+10)+h/2)*Math.cos (Math.toRadians(i+w)),z), new Point3D(x+((r1+10)+h/2)*Math.sin(Math.toRadians(i-w)),y+((r1+10)+h/2)*Math.cos (Math.toRadians(i-w)),z));
			Triangle t2= new Triangle(theColor,new Point3D(x+(r1+10+h)*Math.sin(Math.toRadians(i)),y+(r1+10+h)*Math.cos (Math.toRadians(i)),z), new Point3D(x+((r1+10)+h/2)*Math.sin(Math.toRadians(i+w)),y+((r1+10)+h/2)*Math.cos (Math.toRadians(i+w)),z), new Point3D(x+((r1+10)+h/2)*Math.sin(Math.toRadians(i-w)),y+((r1+10)+h/2)*Math.cos (Math.toRadians(i-w)),z));
			Circle c1=new Circle (theColor,r2,new Point3D(x+(r1+10+h+d)*Math.sin(Math.toRadians(i)),y+(r1+10+h+d)*Math.cos (Math.toRadians(i)),z));
			t1.setM(snowf);
			t2.setM(snowf);
			c1.setM(snowf);
			l.add(t1);
			l.add(t2);
			l.add(c1);
			i+=60;
		}
		return l;
	}
}


