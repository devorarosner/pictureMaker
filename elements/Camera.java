package elements;
import java.util.LinkedList;
import java.util.List;

import primitives.*;
public class Camera 
{
	protected Point3D center;
	protected Vector VUP;//axis Y
	protected Vector VRIGHT;//axis X
	protected Vector VTOWARDS;//axis Z (in the negative direction)
	//***************** Constructors ********************** // 
	public Camera(Point3D center, Vector vUP, Vector vRIGHT, Vector vTOWARDS) {
		super();
		this.center = new Point3D();
		VUP = new Vector(vUP);
		VRIGHT = new Vector(vRIGHT);
		VTOWARDS = new Vector(vTOWARDS);
		VUP.normalize();
		VRIGHT.normalize();
		VTOWARDS.normalize();
	}
	public Camera(Point3D center, Vector vRIGHT, Vector vUP) {
		super();
		this.center = new Point3D();
		//complete the last direction
		VTOWARDS = vUP.crossProduct(vRIGHT);
		VRIGHT = new Vector(vRIGHT);
		VUP = new Vector(vUP);
		VUP.normalize();
		VRIGHT.normalize();
		VTOWARDS.normalize();
	}
	public Camera() {
		super();
		center=new Point3D();
		VUP = new Vector(0,1,0);
		VRIGHT = new Vector(1,0,0);
		VTOWARDS = new Vector(0,0,-1);
	}
	public Camera(Camera c) {
		super();
		center= new Point3D(c.getCenter());
		VUP = new Vector(c.getVUP());
		VRIGHT = new Vector(c.getVRIGHT());
		VTOWARDS = new Vector(c.getVTOWARDS());
	}
	//***************** Getters/Setters ********************** // 
	public Point3D getCenter() {
		return new Point3D(center);
	}
	public void setCenter(Point3D center) {
		this.center = new Point3D(center);
	}
	public Vector getVUP() {
		return new Vector(VUP);
	}
	public void setVUP(Vector vUP) {
		VUP = new Vector(vUP);
	}
	public Vector getVRIGHT() {
		return new Vector(VRIGHT);
	}
	public void setVRIGHT(Vector vRIGHT) {
		VRIGHT = new Vector(vRIGHT);
	}
	public Vector getVTOWARDS() {
		return new Vector(VTOWARDS);
	}
	public void setVTOWARDS(Vector vTOWARDS) {
		VTOWARDS = new Vector(vTOWARDS);
	}
	// ***************** Administration  ******************** // 
	public int compareTo(Camera c)
	{
		if ((center.compareTo(c.getCenter())==0)&&(VUP.compareTo(c.getVUP())==0)&&(VRIGHT.compareTo(c.getVRIGHT())==0)&&(VTOWARDS.compareTo(c.getVTOWARDS())==0))
			return 0;
		return -1;	
	}
	@Override
	public boolean equals(Object obj) {
		if(compareTo((Camera) obj)==0)
			return true;
		return false;
	}
	@Override
	public String toString() {
		return "[center=" + center + ", VUP=" + VUP + ", VRIGHT=" + VRIGHT + ", VTOWARDS=" + VTOWARDS + "]";
	}
	// ***************** Operations ******************** // 
	//The camera constructs rays through the pixels in the view plane
	public Ray constructRayThroughAPixel2(int Nx,int Ny,double i,double j,double screenDist,double screenWidth,double screenHeight)
	{
		//calculating the pixels ratio
		double Rx=screenWidth/Nx;
		double Ry=screenHeight/Ny;
		//calculating the directions
		Vector vx=new Vector(VRIGHT);
		vx.scale((i-(double)Nx/2)*Rx-Rx/2);
		Vector vy=new Vector(VUP);
		vy.scale((j-(double)Ny/2)*Ry-Ry/2);
		//calculating the direction
		Vector temp=new Vector(vx);
		temp.Substruct(vy);
		//calculating Pc (the center of the plane view)
		Point3D pc=new Point3D(center);
		Vector temp2=new Vector(VTOWARDS);
		temp2.scale(screenDist);
		pc.add(temp2.getHead());
		//calculating p (the point in the center of the pixel)
		Point3D p=new Point3D(pc);
		p.add(temp.getHead());
		//constructing the ray
		Point3D help=new Point3D(p);
		help.Substruct(center);		
		Vector v=new Vector(help);
		v.normalize();
		Ray r=new Ray(center,v);
		return r;
	}
	//super sampling
	public List<Ray> constructRayThroughAPixel(int Nx,int Ny,double i,double j,double screenDist,double screenWidth,double screenHeight)
	{
		//calculating the pixels ratio
		double Rx=screenWidth/Nx;
		double Ry=screenHeight/Ny;
		//calculating the directions
		Vector vx=new Vector(VRIGHT);
		vx.scale((i-(double)Nx/2)*Rx-Rx/2);
		Vector vy=new Vector(VUP);
		vy.scale((j-(double)Ny/2)*Ry-Ry/2);
		//calculating the direction
		Vector temp=new Vector(vx);
		temp.Substruct(vy);
		//calculating Pc (the center of the plane view)
		Point3D pc=new Point3D(center);
		Vector temp2=new Vector(VTOWARDS);
		temp2.scale(screenDist);
		pc.add(temp2.getHead());
		//calculating p (the point in the center of the pixel)
		Point3D p=new Point3D(pc);
		p.add(temp.getHead());
		//added part
		
		
		Point3D p1=new Point3D(p);
		p1.add(new Point3D(Rx/2,Ry/2,0));
		Point3D p2=new Point3D(p);
		p2.add(new Point3D(-Rx/2,Ry/2,0));
		Point3D p3=new Point3D(p);
		p3.add(new Point3D(Rx/2,-Ry/2,0));
		Point3D p4=new Point3D(p);
		p4.add(new Point3D(-Rx/2,-Ry/2,0));
		
		p1.Substruct(center);		
		Vector v1=new Vector(p1);
		v1.normalize();
		Ray r1=new Ray(center,v1);
		
		p2.Substruct(center);		
		Vector v2=new Vector(p2);
		v2.normalize();
		Ray r2=new Ray(center,v2);
		
		p3.Substruct(center);		
		Vector v3=new Vector(p3);
		v3.normalize();
		Ray r3=new Ray(center,v3);
		
		p4.Substruct(center);		
		Vector v4=new Vector(p4);
		v4.normalize();
		Ray r4=new Ray(center,v4);
		//added part
		
		//constructing the ray
		Point3D help=new Point3D(p);
		help.Substruct(center);		
		Vector v=new Vector(help);
		v.normalize();
		Ray r=new Ray(center,v);
		
		List<Ray> l=new LinkedList<Ray>();
		l.add(r);
		l.add(r1);
		l.add(r2);
		l.add(r3);
		l.add(r4);
		return l;
	}
}
