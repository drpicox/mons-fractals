package mgc.mf.filtre;

import mgc.mf.*;

/**
 * Aplicacio d'un radi Minim.
 * Creation date: (12/01/01 03:27:49)
 * @author: David Rodenas Pico
 */
public 
class ParametresTraslacio
extends ParametresNul
{
    private double x;
    private double y;
    private double z;

    public ParametresTraslacio()
    {
        super();
        x = 0.0;
        y = 0.0;
        z = 0.0;
    }

    public double getX()
    { return x; }
    public double getY()
    { return y; }
    public double getZ()
    { return z; }

    public void setX(double c)
    { x = c;  }
    public void setY(double c)
    { y = c;  }
    public void setZ(double c)
    { z = c;  }
}
