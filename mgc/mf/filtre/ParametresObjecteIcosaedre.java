package mgc.mf.filtre;

public class ParametresObjecteIcosaedre extends ParametresObjecte 
{

   private double radi;

   public ParametresObjecteIcosaedre()
   {
	  this(1.0);
   }         

   public ParametresObjecteIcosaedre(double radi)
   {
	  super();
	  this.radi = radi;
   }         

   public double getRadi()
   {
	  return radi;
   }         

   public void setRadi(double radi)
   {
	  this.radi = radi;
   }         
}
