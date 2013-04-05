package mgc.mf.filtre;

import mgc.mf.*;

/**
 * Filtre buit que no fa res.
 * Creation date: (14/01/01 00:05:10)
 * @author: David Rodenas Pico
 */
public 
class Nul 
implements Filtre 
{
	private ParametresFiltre parametresFiltre;
	private transient boolean parar;

/**
 * FiltreNul constructor comment.
 */
public Nul() {
	super();
}
	/**
	 * filtrar method comment.
	 */
	public Objecte filtrar(Objecte objecte) 
	{
		parar = false;
		return objecte;
	}
/**
 * getParametresFiltre method comment.
 */
public ParametresFiltre getParametresFiltre() 
{
	return parametresFiltre;
}
	public boolean isParat()
	{ return parar; }
	/**
	 * parar method comment.
	 */
	public void parar() 
	{
		parar = true;
	}
/**
 * getParametresFiltre method comment.
 */
public void setParametresFiltre
  (ParametresFiltre parametres) 
{
	parametresFiltre = parametres;
}
}
