package mgc.mf.filtre;

import mgc.mf.*;

/**
 * Aplicacio d'un radi Minim.
 * Creation date: (12/01/01 03:27:49)
 * @author: David Rodenas Pico
 */
public 
class ParametresRadiMinim
extends ParametresNul
{
	private double radiMinim;

    public ParametresRadiMinim()
    {
        super();
        radiMinim = 2.0;
    }

    /**
     * Insert the method's description here.
     * Creation date: (12/01/01 03:28:34)
     * @return double
     */
    public double getRadiMinim()
    {
        return radiMinim;
    }

    /**
     * Insert the method's description here.
     * Creation date: (12/01/01 03:28:34)
     * @param newRadiMinim double
     */
    public void setRadiMinim(double newRadiMinim)
    {
        radiMinim = newRadiMinim;
    }
}
