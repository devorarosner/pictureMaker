package scene;
import java.awt.Color;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import geometries.*;
import elements.*;

public class Scene {
	protected String name;
	protected Color background;
	protected List<Geometry> geometries;
	protected Camera cam;
	protected double screenDistance;
	protected AmbientLight aml;
	protected List<Light> lights;
	protected int RECURSION_LEVEL;

	//***************** Constructors ********************** //
	public Scene(String name, Color background, List<Geometry> geometries, Camera cam, double screenDistance,AmbientLight a,List<Light> l,int rL)
	{
		this.name = name;
		this.background = background;
		this.geometries =new LinkedList<Geometry>(geometries);
		this.cam =new Camera(cam);
		this.screenDistance = screenDistance;
		this.aml=new AmbientLight(a);
		this.lights=new LinkedList<Light>(l);
		this.RECURSION_LEVEL=rL;
	}
	//without an already exist geometry list and light list
	public Scene(String name, Color background, Camera cam, double screenDistance,AmbientLight a, int rL)
	{
		this.name = name;
		this.background = background;
		this.geometries =new LinkedList<Geometry>();
		this.cam =new Camera(cam);
		this.screenDistance = screenDistance;
		this.aml=new AmbientLight(a);
		this.lights=new LinkedList<Light>();
		this.RECURSION_LEVEL=rL;
	}
	//without recursion level
	public Scene(String name, Color background, Camera cam, double screenDistance,AmbientLight a)
	{
		this.name = name;
		this.background = background;
		this.geometries =new LinkedList<Geometry>();
		this.cam =new Camera(cam);
		this.screenDistance = screenDistance;
		this.aml=new AmbientLight(a);
		this.lights=new LinkedList<Light>();
		this.RECURSION_LEVEL=2;
	}
	public Scene()
	{
		name ="";
		background=Color.black;
		geometries=new LinkedList<Geometry>();
		cam=new Camera();
		screenDistance=0;
		this.aml=new AmbientLight();
		this.lights=new LinkedList<Light>();
		this.RECURSION_LEVEL=2;
	}
	public Scene(Scene s)
	{
		this.name = s.name;
		this.background = s.background;
		this.geometries =new LinkedList<Geometry>(s.geometries);
		this.cam =new Camera(s.cam);
		this.screenDistance = s.screenDistance;
		this.aml=new AmbientLight(s.aml);
		this.lights=new LinkedList<Light>(s.lights);
		this.RECURSION_LEVEL=s.RECURSION_LEVEL;
	}
	//***************** Getters/Setters ********************** // 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Color getBackground() {
		return background;
	}
	public void setBackground(Color background) {
		this.background = background;
	}
	public List<Geometry> getGeometries() {
		return new LinkedList<Geometry>(geometries);
	}
	public void setGeometries(List<Geometry> geometries) {
		this.geometries = new LinkedList<Geometry>(geometries);
	}
	public Camera getCam() {
		return new Camera(cam);
	}
	public void setCam(Camera cam) {
		this.cam = new Camera(cam);
	}
	public double getScreenDistance() {
		return screenDistance;
	}
	public void setScreenDistance(double screenDistance) {
		this.screenDistance = screenDistance;
	}
	public AmbientLight getAml() {
		return new AmbientLight(aml);
	}
	public void setAml(AmbientLight amb) {
		this.aml = amb;
	}
	public List<Light> getLights() {
		return new LinkedList<Light>(lights);
	}
	public void setLights(List<Light> Lights) {
		this.lights = new LinkedList<Light>(Lights);
	}
	public int getRecursionLevel() {
		return RECURSION_LEVEL;
	}
	public void setRecursionLevel(int rL) {
		this.RECURSION_LEVEL = rL;
	}
	//***************** Administration  ******************** //
	@Override
	public String toString() {
		return "Scene [name=" + name + ", background=" + background + ", geometries=" + geometries + ", cam=" + cam
				+ ", screenDistance=" + screenDistance+" , " +aml+", lights="+lights+", Recursion Level="+RECURSION_LEVEL+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Scene other = (Scene) obj;
		if (aml == null) {
			if (other.aml != null)
				return false;
		} else if (!aml.equals(other.aml))
			return false;
		if (background == null) {
			if (other.background != null)
				return false;
		} else if (!background.equals(other.background))
			return false;
		if (cam == null) {
			if (other.cam != null)
				return false;
		} else if (!cam.equals(other.cam))
			return false;
		if (geometries == null) {
			if (other.geometries != null)
				return false;
		} else if (!geometries.equals(other.geometries))
			return false;
		if (lights == null) {
			if (other.lights != null)
				return false;
		} else if (!lights.equals(other.lights))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;		
		if (RECURSION_LEVEL!=other.RECURSION_LEVEL)
			return false;
		if (Double.doubleToLongBits(screenDistance) != Double.doubleToLongBits(other.screenDistance))
			return false;
		return true;
	}

	//***************** Operations ******************** // 
	public void addGeometry(Geometry g)
	{
		if(g!=null)
			geometries.add(g);
	}
	public void addGeometries(List<Geometry> g)
	{
		if(g!=null)
			geometries.addAll(g);
	}
	public Iterator<Geometry> getGeometriesIterator()
	{
		return geometries.iterator();
	}
	public void addLight(Light l) 
	{
		if(l!=null)
			lights.add(l);
	}
	public Iterator<Light> getLightsIterator()
	{
		return lights.iterator();
	}
}
