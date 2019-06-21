//Hanna Weissberg 
//318796398
package elements;
import java.awt.Color;
import primitives.*;

public abstract class Light {
	protected Color _color;

	//***************** Constructors ********************** //
	public Light(Color _color) {
		this._color = _color;
	}
	public Light(Light l) {
		this._color = l._color;
	}
	public Light() {
		this._color = Color.black;
	}
	//***************** Getters/Setters ********************** // 
	public Color get_color() {
		return _color;
	}
	public void set_color(Color _color) {
		this._color = _color;
	}
	//***************** Administration  ******************** // 
	@Override
	public String toString() {
		return "Light [_color=" + _color + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Light other = (Light) obj;
		if (_color == null) {
			if (other._color != null)
				return false;
		} else if (!_color.equals(other._color))
			return false;
		return true;
	}
	//***************** Operations ******************** // 
	public abstract Color getIntensity(Point3D point);
	public abstract Vector getL(Point3D point);//from the source to the point
}
