package mgc.mf.filtre;

import java.util.Enumeration;
import java.util.Random;
import java.util.Vector;

import mgc.mf.*;


/**
 * Parametres per la textura aleatoria (basicament seed).
 * Creation date: (12/01/01 03:27:49)
 * @author: David Rodenas Pico
 */
public 
class ParametresTexturaAleatoria
extends ParametresNul
{
	private int seed;

	/**
	 * ParametresFiltraAlcadaMinima constructor comment.
	 */
    public ParametresTexturaAleatoria() 
	{
	  super();
		
	  seed = 1234;
	}
	
	public int getSeed()
	{ return seed; }
	
	/**
	 * Insert the method's description here.
	 * Creation date: (12/01/01 03:28:34)
	 * @param newRadiMinim double
	 */
	public void setSeed(int seed) 
	{
	  this.seed = seed;
	}

}
