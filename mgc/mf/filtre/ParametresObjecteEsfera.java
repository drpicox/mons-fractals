package mgc.mf.filtre;
import mgc.mf.*;

public 
class ParametresObjecteEsfera 
extends ParametresObjecte 
{

   private int divisionsLongitut;
   private int divisionsLatitut;
   private double radi;

   public ParametresObjecteEsfera ( ) {
	  this ( 1.0, 10, 10 );
   }         

   public ParametresObjecteEsfera ( double radi, int dLong, int dLat ) {
	  super ( );
	  this.radi         = radi;
	  divisionsLongitut = dLong;
	  divisionsLatitut  = dLat;
   }         

   public int getDivisionsLatitut ( ) {
	  return divisionsLatitut;
   }         

   public int getDivisionsLongitut ( ) {
	  return divisionsLongitut;
   }         

   public double getRadi ( ) {
	  return radi;
   }         

   public void setDivisionsLatitut ( int dl ) {
      if ( dl > 1 )
         divisionsLatitut = dl;
      else
         divisionsLatitut = 2;
   }         

   public void setDivisionsLongitut ( int dl ) {
      if ( dl > 2 )
         divisionsLongitut = dl;
      else
         divisionsLongitut = 3;
   }         

   public void setRadi ( double radi ) {
	  this.radi = radi;
   }         

}
