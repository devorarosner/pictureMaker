package elements;

import java.awt.Color;

import primitives.Point3D;
import primitives.Vector;

public class DirectionalLight extends Light{
	protected Vector _direction;

	//***************** Constructors ********************** //
	public DirectionalLight() {
		super();
		_direction=new Vector();
	}
	public DirectionalLight(DirectionalLight l) {
		super(l._color);
		_direction=l.get_direction();
	}
	public DirectionalLight(Color _color, Vector _direction) {
		super(_color);
		this._direction = new Vector(_direction);
	}

	//***************** Getters/Setters ********************** // 
	public Vector get_direction() {
		return new Vector(_direction);
	}

	public void set_direction(Vector _direction) {
		this._direction = _direction;
	}

	//***************** Administration  ******************** // 
	@Override
	public String toString() {
		return "DirectionalLight [_direction=" + _direction + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DirectionalLight other = (DirectionalLight) obj;
		if (_direction == null) {
			if (other._direction != null)
				return false;
		} else if (!_direction.equals(other._direction))
			return false;
		return true;
	}


	//***************** Operations ******************** // 

	@Override
	public Color getIntensity(Point3D point) {
		return _color;
	}

	@Override
	public Vector getL(Point3D point) {
		Vector L=new Vector(_direction);
		L.normalize();
		return L;	
	}

}
