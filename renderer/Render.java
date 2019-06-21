package renderer;
import java.awt.Color;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import elements.Light;
import geometries.FlatGeometry;
import geometries.Geometry;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import scene.*;
import java.lang.Math;
public class Render {

	protected ImageWriter imw;
	protected Scene s;

	// ***************** Constructors ********************** // 
	public Render(ImageWriter imw, Scene s) {
		super();
		this.imw = new ImageWriter(imw);
		this.s = new Scene(s);
	}
	public Render(Render r) {
		this.imw = r.getImw();
		this.s = r.getS();
	}

	// ***************** Getters/Setters ********************** //
	public ImageWriter getImw() {
		return new ImageWriter(imw);
	}
	public void setImw(ImageWriter imw) {
		this.imw = new ImageWriter(imw);
	}
	public Scene getS() {
		return new Scene(s);
	}
	public void setS(Scene s) {
		this.s = new Scene(s);
	}
	// ***************** Administration  ******************** // 
	@Override
	public String toString() {
		return "Render [imw=" + imw + ", s=" + s + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Render other = (Render) obj;		
		if (s == null) {
			if (other.s != null)
				return false;
		} else if (!s.equals(other.s))
			return false;
		return true;
	}

	// ***************** Operations ******************** // 
	//prints the grid
	public void printGrid(int interval)
	{
		for (int i = 0; i < imw.getNx(); i++)
			for (int j = 0; j < imw.getNy(); j++) 
				if(i%interval==0||j%interval==0||i+1==imw.getNx()||j+1==imw.getNy())
					imw.writePixel(i, j,Color.GRAY);					
	}
	//gets the intersection points
	private Map<Geometry,List<Point3D>> getSceneRayIntersections(Ray r)
	{
		Iterator<Geometry> geometries=s.getGeometriesIterator();
		Map<Geometry,List<Point3D>> intersectionPoints =new HashMap<Geometry,List<Point3D>>();
		while(geometries.hasNext())
		{
			Geometry geometry=geometries.next();
			List<Point3D> geometryIntersectionPoints=geometry.findIntersections(r);
			if(geometryIntersectionPoints!=null)
				intersectionPoints.put(geometry,geometryIntersectionPoints);
		}
		if(intersectionPoints.isEmpty())
			return null;
		return intersectionPoints;
	}
	//gets the closest point
	private Map<Geometry,Point3D> getClosestPoint(Map<Geometry,List<Point3D>> p)
	{
		double distance=Double.MAX_VALUE;
		Point3D p0=s.getCam().getCenter();
		Map<Geometry,Point3D> minDistancePoint=new HashMap<Geometry,Point3D>();
		for (Entry<Geometry,List<Point3D>> entry: p.entrySet())
		{
			for	(Point3D point:entry.getValue())			
				if(p0.Distance(point)<distance)
				{
					minDistancePoint.clear();
					minDistancePoint.put(entry.getKey(), new Point3D(point));
					distance=p0.Distance(point);
				}			
		}
		return minDistancePoint;
	}
	//calculates the diffusive light
	private Color calcDiffusiveComp(double kd,Vector N ,Vector L,Color c)
	{
		L.normalize();
		double temp=N.dotProduct(L)*kd;
		int b=(int) (temp*c.getBlue());
		int r=(int) (temp*c.getRed());
		int g=(int) (temp*c.getGreen());
		if(b<0)
			b*=-1;	
		if(r<0)
			r*=-1;	
		if(g<0)
			g*=-1;
		if(b>255)
			b=255;	
		if(r>255)
			r=255;	
		if(g>255)
			g=255;	
		return new Color(r,g, b);
	}
	//calculates the specular light
	private Color calcSpecularComp(double ks,Vector p0 ,Vector N,Vector L,double n,Color c)
	{
		L.normalize();
		double temp=(L.dotProduct(N))*2;
		if(temp>0)//it takes the wrong normal of the geometry
			return new Color(0,0,0);
		Vector temp2=new Vector(N);
		temp2.scale(temp);
		Vector R=new Vector(L);
		R.Substruct(temp2);
		R.normalize();
		temp=p0.dotProduct(R);
		double temp3=(Math.pow(temp, n))*ks;
		int b=(int) (temp3*c.getBlue());
		int r=(int) (temp3*c.getRed());
		int g=(int) (temp3*c.getGreen());
		if(b<0)
			b*=-1;	
		if(r<0)
			r*=-1;	
		if(g<0)
			g*=-1;
		if(b>255)
			b=255;	
		if(r>255)
			r=255;	
		if(g>255)
			g=255;	
		return new Color(r,g, b);	
	}

	private static Color addRGBColor(Color c1,Color c2)
	{
		int r=c1.getRed()+c2.getRed();
		int g=c1.getGreen()+c2.getGreen();
		int b=c1.getBlue()+c2.getBlue();
		if(b>255)
			b=255;	
		if(r>255)
			r=255;	
		if(g>255)
			g=255;
		return new Color(r, g, b);
	}
	private Ray constructReflectedRay(Vector N, Point3D p, Ray inRay) {
		//floating point problem
		Point3D geometryPoint = new Point3D(p);
		Vector epsVector = new Vector(N);
		epsVector.scale(2);
		epsVector.normalize();
		geometryPoint.add(epsVector.getHead());		
		Vector help=inRay.getDirection();
		help.normalize();
		double temp=(help.dotProduct(epsVector))*2;		
		Vector temp2=new Vector(epsVector);
		temp2.scale(temp);
		help.Substruct(temp2);
		help.normalize();
		Ray R=new Ray(geometryPoint,help);		
		return R;
	}

	//checks if the geometry is occluded by another
	private boolean occluded(Light light, Point3D point, Geometry geometry) {
		Vector lightDirection = light.getL(point);
		lightDirection.scale(-1);
		Point3D geometryPoint = new Point3D(point);
		//floating point problem
		Vector epsVector = new Vector(geometry.getNormal(point));
		epsVector.scale(0.1);
		geometryPoint.add(epsVector.getHead());
		Ray lightRay = new Ray(geometryPoint, lightDirection);	
		Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersections(lightRay);
		if(intersectionPoints!=null)
		{
			// Flat geometry cannot self intersect
			if (geometry instanceof FlatGeometry)
				intersectionPoints.remove(geometry);												
			for (Entry<Geometry, List<Point3D>> entry: intersectionPoints.entrySet())							
				if (entry.getKey().getM().get_Kt() == 0)//if the occluding geometry is transparent.
					return true;
		}
		return false;
	}
	private Color calcColor(Geometry geometry, Point3D point, Ray inRay) {
		return calcColor(geometry, point, inRay, 0);
	}
	//calculates the color
	private Color calcColor(Geometry g, Point3D p,Ray inRay,int level)
	{
		if (level == s.getRecursionLevel()) return new Color(0, 0, 0);

		Color ambientLight=s.getAml().getIntensity(p);	
		Color emissionLight=g.getEmission();
		Iterator<Light> lights=s.getLightsIterator();
		Color diffuseLight=new Color(0,0,0);
		Point3D t= new Point3D(p);
		t.Substruct(s.getCam().getCenter());
		Vector V=new Vector(t);
		V.normalize();
		Color specularLight=new Color(0,0,0);
		while(lights.hasNext()){
			Light light=lights.next();
			if (!occluded(light, p, g)){
				Color temp1=addRGBColor(diffuseLight, calcDiffusiveComp(g.getM().get_Kd(), g.getNormal(p),light.getL(p), light.getIntensity(p)));
				diffuseLight=temp1;		
				Color temp2=addRGBColor(specularLight, calcSpecularComp(g.getM().get_Ks(),V, g.getNormal(p), light.getL(p),g.getM().get_n(),light.getIntensity(p)));
				specularLight=temp2;
			}
		}
		// Recursive call for a reflected ray
		
		Ray reflectedRay = constructReflectedRay(g.getNormal(p), p, inRay);
		Map<Geometry, List<Point3D>> reflectedIntersectionPoints = getSceneRayIntersections(reflectedRay);
		Color reflectedColor;
		if(reflectedIntersectionPoints==null)//if there is no other geometries in the way
			reflectedColor=s.getBackground();
		else{
			Map<Geometry,Point3D> reflectedEntry = getClosestPoint(reflectedIntersectionPoints);					
			Geometry temp=null;
			for ( Geometry key : reflectedEntry.keySet() ) 
				temp=key;
			reflectedColor= calcColor(temp,reflectedEntry.get(temp), reflectedRay,level+1);
		}
		double kr = g.getM().get_Kr();
		int b=(int) (kr*reflectedColor.getBlue());
		int r=(int) (kr*reflectedColor.getRed());
		int green=(int) (kr*reflectedColor.getGreen());
		if(b<0)
			b*=-1;	
		if(r<0)
			r*=-1;	
		if(green<0)
			green*=-1;
		if(b>255)
			b=255;	
		if(r>255)
			r=255;	
		if(green>255)
			green=255;	
		Color reflectedLight = new Color(r,green, b);			
		// Recursive call for a refracted ray	
		//floating point problem
		Point3D geometryPoint = new Point3D(p);
		Vector epsVector = new Vector(g.getNormal(p));
		epsVector.scale(-2);
		epsVector.normalize();
		geometryPoint.add(epsVector.getHead());
		Ray refractedRay = new Ray(geometryPoint,inRay.getDirection());
		Map<Geometry, List<Point3D>> refractedIntersectionPoints = getSceneRayIntersections(refractedRay);
		Color refractedColor;
		if(refractedIntersectionPoints==null)//if there is no other geometries in the way
			refractedColor=s.getBackground();
		else{
			Map<Geometry,Point3D> refractedEntry = getClosestPoint(refractedIntersectionPoints);	
			Geometry temp2=null;			
			for ( Geometry key : refractedEntry.keySet() ) 
				temp2=key;
			refractedColor= calcColor(temp2,refractedEntry.get(temp2), refractedRay,level+1);
		}
		double kt = g.getM().get_Kt();
		b=(int) (kt*refractedColor.getBlue());
		r=(int) (kt*refractedColor.getRed());
		green=(int) (kt*refractedColor.getGreen());
		if(b<0)
			b*=-1;	
		if(r<0)
			r*=-1;	
		if(green<0)
			green*=-1;
		if(b>255)
			b=255;	
		if(r>255)
			r=255;	
		if(green>255)
			green=255;	
		Color refractedLight = new Color(r,green, b);		
		//add together all of the components
		return addRGBColor(ambientLight, addRGBColor(emissionLight, addRGBColor(diffuseLight, addRGBColor(specularLight ,addRGBColor(reflectedLight,refractedLight)))));
	}

	//creates the image
	public void renderImage() 
	{
		for (int i = 0; i < imw.getNx(); i++) 
			for (int j = 0; j < imw.getNy(); j++)
			{			
				List<Ray> rays = s.getCam().constructRayThroughAPixel(imw.getNx(),imw.getNy(), i, j,s.getScreenDistance(), imw.getWidth(), imw.getHeight());
				int r=0;
				int g=0;
				int b=0;
				for(Ray ray  : rays)
				{
				Map<Geometry,List<Point3D>> intersectionPoints=getSceneRayIntersections(ray);
				if(intersectionPoints==null||intersectionPoints.size()==0)
					{
					r+=s.getBackground().getRed();
					g+=s.getBackground().getGreen();
					b+=s.getBackground().getBlue();
					}
				else
				{
					Map<Geometry,Point3D> closestPoint=getClosestPoint(intersectionPoints);
					Geometry temp=null;
					for ( Geometry key : closestPoint.keySet() ) 
						temp=key;
					Color c=calcColor(temp,closestPoint.get(temp),ray);
					r+=c.getRed();
					g+=c.getGreen();
					b+=c.getBlue();
					
				}	
				}
				r=r/5;
				g=g/5;
				b=b/5;
				if(b>255)
					b=255;	
				if(r>255)
					r=255;	
				if(g>255)
					g=255;	
				imw.writePixel(i, j, new Color(r,g,b));
			}		
	}
	public void writeToimage(){
		imw.writeToimage();
	}	
}
