//defines with position (like a bulb)
package elements;
import java.awt.Color;
import primitives.Point3D;
import primitives.Vector;

public class PointLight extends Light{
	protected Point3D _position;
	protected double _kc;
	protected double _kl;
	protected double _kq;

	//***************** Constructors ********************** //
	public PointLight() {
		super();
		_position=new Point3D();		
		_kc=1;
		_kl=1;
		_kq=1;
	}

	public PointLight(PointLight l) {
		super(l);
		this._position = l.get_position();
		this._kc = l._kc;
		this._kl = l._kl;
		this._kq = l._kq;
	}

	public PointLight(Color _color, Point3D _position, double _kc, double _kl, double _kq) {
		super(_color);
		try{
			if(_kc<0||_kc>1)
				throw new Exception("kc must be a fraction");
			if(_kl<0||_kl>1)
				throw new Exception("kl must be a fraction");
			if(_kq<0||_kq>1)
				throw new Exception("kq must be a fraction");
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}		
		this._position = _position;		
		this._kc = _kc;
		this._kl = _kl;
		this._kq = _kq;
	}
	//***************** Getters/Setters ********************** // 

	public Point3D get_position() {
		return new Point3D(_position);
	}

	public void set_position(Point3D _position) {
		this._position = _position;
	}

	public double get_kc() {
		return _kc;
	}

	public void set_kc(int _kc) {
		try{
			if(_kc<0||_kc>1)
				throw new Exception("kc must be a fraction");		
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}		
		this._kc = _kc;
	}

	public double get_kl() {
		return _kl;
	}

	public void set_kl(int _kl) {
		try{
			
			if(_kl<0||_kl>1)
				throw new Exception("kl must be a fraction");
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}		
	
		this._kl = _kl;
	}

	public double get_kq() {
		return _kq;
	}

	public void set_kq(int _kq) {
		try{			
			if(_kq<0||_kq>1)
				throw new Exception("kq must be a fraction");
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}		
		this._kq = _kq;
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
		PointLight other = (PointLight) obj;
		if (_kc != other._kc)
			return false;
		if (_kl != other._kl)
			return false;
		if (_kq != other._kq)
			return false;
		if (_position == null) {
			if (other._position != null)
				return false;
		} else if (!_position.equals(other._position))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PointLight [_position=" + _position + ", _kc=" + _kc + ", _kl=" + _kl + ", _kq=" + _kq + "]";
	}

	//***************** Operations ******************** // 

	@Override
	public Color getIntensity(Point3D point) {
		double d=_position.Distance(point);
		double temp=_kc+_kl*d+_kq*d*d;
		int b =(int) (_color.getBlue()/temp);
		if(b>255)
			b=255;
		int r =(int) (_color.getRed()/temp);
		if(r>255)
			r=255;
		int g=(int) (_color.getGreen()/temp);
		if(g>255)
			g=255;
		return new Color(r,g,b);	}

	@Override
	public Vector getL(Point3D point) {
		Point3D p=new Point3D(point);
		p.Substruct(_position);
		Vector L=new Vector(p);
		L.normalize();
		return L;		
	}

}
