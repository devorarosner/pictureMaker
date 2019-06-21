//Hanna Weissberg 318796398
package primitives;

public class Material { //k equals 1- full mode, k equals 0- no mode
	private double _Kd; // Diffusion attenuation coefficient
	private double _Ks; // Specular attenuation coefficient
	private double _Kr;// Reflection attenuation coefficient (mirror effect- 1 is perfect mirror, 0 is matt)
	private double _Kt;// Refraction attenuation coefficient (transparency effect-1 is full seen through)
	private double _n;  // Refraction index

	//***************** Constructors ********************** //

	public Material(double _Kd, double _Ks,double _Kr,double _Kt,double _n) {		
		try{
			if(_Kd<0||_Kd>1)
				throw new Exception("Kd must be a fraction");
			if(_Ks<0||_Ks>1)
				throw new Exception("Ks must be a fraction");
			if(_Kr<0||_Kr>1)
				throw new Exception("Kr must be a fraction");
			if(_Kt<0||_Kt>1)
				throw new Exception("Kt must be a fraction");
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}		
		this._Kd = _Kd;
		this._Ks = _Ks;
		this._Kr = _Kr;
		this._Kt = _Kt;
		this._n = _n;
	}
	public Material(Material m) {
		this._Kd = m._Kd;
		this._Ks = m._Ks;
		this._Kr = m._Kr;
		this._Kt = m._Kt;
		this._n = m._n;
	}

	public Material() {
		this._Kd = 1;
		this._Ks = 1;
		this._Kr = 0;
		this._Kt = 0;
		this._n = 1;
	}
	//***************** Getters/Setters ********************** // 
	public double get_Kd() {
		return _Kd;
	}
	public void set_Kd(double _Kd) {
		try{
			if(_Kd<0||_Kd>1)
				throw new Exception("Kd must be a fraction");		
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}		
		this._Kd = _Kd;
	}
	public double get_Ks() {
		return _Ks;
	}
	public void set_Ks(double _Ks) {
		try{			
			if(_Ks<0||_Ks>1)
				throw new Exception("Ks must be a fraction");			
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}		
		this._Ks = _Ks;
	}
	public double get_Kt() {
		return _Kt;
	}
	public void set_Kt(double _Kt) {
		try{
			if(_Kt<0||_Kt>1)
				throw new Exception("Kt must be a fraction");		
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}		
		this._Kt = _Kt;
	}
	public double get_Kr() {
		return _Kr;
	}
	public void set_Kr(double _Kr) {
		try{			
			if(_Kr<0||_Kr>1)
				throw new Exception("Kr must be a fraction");			
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}		
		this._Kr = _Kr;
	}
	public double get_n() {
		return _n;
	}
	public void set_n(double _n) {	
		this._n = _n;
	}

	//***************** Administration  ******************** // 
	@Override
	public String toString() {
		return "Material [_Kd=" + _Kd + ", _Ks=" + _Ks+", _Kr=" + _Kr + ", _Kt=" + _Kt + ", _n=" + _n + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Material other = (Material) obj;
		if (Double.doubleToLongBits(_Kd) != Double.doubleToLongBits(other._Kd))
			return false;
		if (Double.doubleToLongBits(_Ks) != Double.doubleToLongBits(other._Ks))
			return false;
		if (Double.doubleToLongBits(_Kr) != Double.doubleToLongBits(other._Kr))
			return false;
		if (Double.doubleToLongBits(_Kt) != Double.doubleToLongBits(other._Kt))
			return false;
		if (Double.doubleToLongBits(_n) != Double.doubleToLongBits(other._n))
			return false;
		return true;
	}




}
