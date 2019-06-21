//defines with position and direction
package elements;
import java.awt.Color;
import primitives.Point3D;
import primitives.Vector;

public class SpotLight extends PointLight{
	protected Vector _direction;

	//***************** Constructors ********************** //
	public SpotLight() {
		super();
		_direction=new Vector();
	}

	public SpotLight(Color _color, Point3D _position,Vector direction, double _kc, double _kl, double _kq) {
		super(_color, _position, _kc, _kl, _kq);
		_direction=direction;
		_direction.normalize();
	}
	
	public SpotLight(SpotLight l) {
		super(l._color,l._position,l._kc,l._kl,l._kq);
		_direction=l.get_direction();		
	}
	
	//***************** Getters/Setters ********************** // 
	public Vector get_direction() {
		return new Vector(_direction);
	}

	public void set_direction(Vector _direction) {
		this._direction = _direction;
		_direction.normalize();
	}

	
	//***************** Administration  ******************** // 
	@Override
	public String toString() {
		return "SpotLight [direction=" + _direction +"position=" + _position + ", kc=" + _kc + ", kl=" + _kl + ", kq=" + _kq+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpotLight other = (SpotLight) obj;
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
		Vector dir=new Vector(_direction);
		dir.normalize();
		double d=_position.Distance(point);
		double temp=_kc+_kl*d+_kq*d*d;
		double temp2=dir.dotProduct(getL(point));		
		int b =(int) (_color.getBlue()*temp2/temp);
		if(b<0)
			b*=-1;
		if(b>255)
			b=255;		
		int r =(int) (_color.getRed()*temp2/temp);
		if(r<0)
			r*=-1;
		if(r>255)
			r=255;		
		int g=(int) (_color.getGreen()*temp2/temp);
		if(g<0)
			g*=-1;
		if(g>255)
			g=255;
		
		return new Color(r,g,b); 
	}

	@Override
	public Vector getL(Point3D point) {
		Point3D p=new Point3D(point);
		p.Substruct(_position);
		Vector L=new Vector(p);
		L.normalize();
		return L;		
	}
}
