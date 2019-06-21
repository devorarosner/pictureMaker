package elements;

import java.awt.Color;

import primitives.Point3D;
import primitives.Vector;

public class AmbientLight extends Light{
	protected double _ka=0.1;

	//***************** Constructors ********************** //
	public AmbientLight(Color _color,double d) {
		super(_color);
		try{
			if(d<0||d>1)
				throw new Exception("ka must be a fraction");
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		_ka=d;
	}
	public AmbientLight(Color _color) {
		super(_color);
	}
	public AmbientLight(AmbientLight l) {
		super(l._color);
		_ka=l._ka;
	}
	public AmbientLight() {
		super();	
	}
	//***************** Getters/Setters ********************** // 
	public double get_ka() {
		return _ka;
	}
	public void set_ka(double ka) {
		try{
			if(ka<0||ka>1)
				throw new Exception("ka must be a fraction");
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		this._ka = ka;
	}


	//***************** Administration  ******************** // 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AmbientLight other = (AmbientLight) obj;
		if (Double.doubleToLongBits(_ka) != Double.doubleToLongBits(other._ka))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AmbientLight [_ka=" + _ka + "]";
	}	

	//***************** Operations ******************** // 
	@Override
	public Color getIntensity(Point3D point) {
		int b =(int) (_color.getBlue()*_ka);
		if(b>255)
			b=255;
		int r =(int) (_color.getRed()*_ka);
		if(r>255)
			r=255;
		int g=(int) (_color.getGreen()*_ka);
		if(g>255)
			g=255;
		return new Color(r,g,b);	}

	@Override
	public Vector getL(Point3D point) {		
		return new Vector();
	}

}
