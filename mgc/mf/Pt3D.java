package mgc.mf;

public
class Pt3D
implements java.io.Serializable
{

   public double x, y, z;
   
   public static final Pt3D pOrigen = new Pt3D ( );
   
   public Pt3D ( ) {
	  this(0.0, 0.0, 0.0);
   }         
   public Pt3D ( double c )
   { this(c, c, c); }         
   public Pt3D ( double x, double y, double z ) {
	  this.x = x;
	  this.y = y;
	  this.z = z;
   }         
   public Pt3D (Pt3D p)
   { this(p.x, p.y, p.z); }         
   public double getRadi ( ) {
	  return Math.sqrt ( x * x + y * y + z * z );
   }         
   public void multiplicar(double escalar)
   {
	  x *= escalar;
	  y *= escalar;
	  z *= escalar;
   }         
   public void normalitzar () 
   {  
	  double radi;
	  
	  radi = getRadi();
	  x /= radi;
	  y /= radi;
	  z /= radi;
   }         
   public void setRadi ( double radi ) {
	  normalitzar();
	  multiplicar(radi);
   }         
   public void sumar(double escalar)
   {
	  sumar(escalar, escalar, escalar);
   }         
   public void sumar(double sx, double sy, double sz)
   {
	  x += sx;
	  y += sy;
	  z += sz;
   }         
   public void sumar(Pt3D p)
   {
	  sumar(p.x, p.y, p.z);
   }         
   public String toString ( ) {
	  return "[Pt3D: x=" + x + "; y=" + y + "; z=" + z + "]";
   }         
}
