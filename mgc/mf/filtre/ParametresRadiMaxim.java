package mgc.mf.filtre;

import mgc.mf.*;

/**
 * Aplicacio d'un radi maxim.
 * Creation date: (12/01/01 03:27:49)
 * @author: David Rodenas Pico
 */
public 
class ParametresRadiMaxim
extends ParametresNul
{
	private double radiMaxim;

    public ParametresRadiMaxim()
    {
        super();
        radiMaxim = 2.0;
    }

    /**
     * Insert the method's description here.
     * Creation date: (12/01/01 03:28:34)
     * @return double
     */
    public double getRadiMaxim()
    {
        return radiMaxim;
    }

    /**
     * Insert the method's description here.
     * Creation date: (12/01/01 03:28:34)
     * @param newRadiMinim double
     */
    public void setRadiMaxim(double newRadiMaxim)
    {
        radiMaxim = newRadiMaxim;
    }
}
