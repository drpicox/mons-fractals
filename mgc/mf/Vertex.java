package mgc.mf;

public
class Vertex
implements java.io.Serializable
{

   private Pt3D    punt;
   private transient int posicio;
   private Textura textura;

   public Vertex ( Objecte objecte, Pt3D punt ) {
	  this.punt = punt;
	  objecte.addVertex(this);
	  textura = null;
   }         
   public int getPosicio ( ) {
	  return posicio;
   }         
   public Pt3D getPunt ( )
   {
	  return punt;
   }         
   public Textura getTextura()
   { return textura; }         
   public void setPosicio ( int posicio ) {
	  this.posicio = posicio;
   }         
   public void setPunt ( Pt3D punt )
   {
	  this.punt = punt;
   }         
   public void setTextura(Textura textura)
   { this.textura = textura; }         
   public String toString ( ) {
	  return "[Vertex: posicio=" + posicio + "; punt=" + punt + "; textura=" + textura + "]";
   }         
   public void validar ( ) {
	  if ( punt == null ) {
		 throw new ObjecteInvalid ( "Un vertex no te Pt3D assignat." );
	  }
   }         
}
