 //Hanna Weissberg 318796398
package geometries;
import primitives.*;
import java.awt.Color;
import java.util.List;

public abstract class Geometry {
protected Color emission;
protected Material m;

//***************** Constructors ********************** //
public Geometry(Color c,Material m) {
	this.emission = c;
	this.m=m;
}
public Geometry(Color c){//without material 
	this.emission = c;
	m=new Material();
}
public Geometry() {	
	emission=Color.black;
	m=new Material();
}
public Geometry(Geometry g) {
	this.emission = g.emission;
	this.m=new Material(g.m);
}
//***************** Getters/Setters ********************** // 
public Color getEmission() {
	return emission;
}

public void setEmission(Color c) {
	this.emission = c;
}
public Material getM() {
	return new Material(m);
}

public void setM(Material m) {
	this.m = m;
}
// ***************** Administration  ******************** // 
@Override
public String toString() {
	return "Geometry [color=" + emission + " , "+m+"]";
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Geometry other = (Geometry) obj;
	if (emission == null) {
		if (other.emission != null)
			return false;
	} else if (!emission.equals(other.emission))
		return false;
	if (m == null) {
		if (other.m != null)
			return false;
	} else if (!m.equals(other.m))
		return false;
	return true;
}
//***************** Operations ******************** // 
public abstract Vector getNormal(Point3D p);
public abstract List<Point3D> findIntersections(Ray r);//linked list
}
