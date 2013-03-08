package mgc.mf.filtre;

import java.util.*;
import mgc.mf.*;

public 
class ParametresFractals
extends ParametresFiltre
{
   private double epsilon;
   private double dimensioFractal;
   private int seed;
   
   public ParametresFractals() 
   { 
	   dimensioFractal = 0.1;
	   epsilon = 1;
	   seed = 1234;
   }   

    /**
     * Insert the method's description here.
     * Creation date: (09/01/01 00:42:00)
     * @return double
     */
    public double getDimensioFractal() {
        return dimensioFractal;
    }
    /**
     * Insert the method's description here.
     * Creation date: (09/01/01 00:42:00)
     * @return double
     */
    public double getEpsilon() {
        return epsilon;
    }
    /**
     * Insert the method's description here.
     * Creation date: (16/01/01 10:51:11)
     * @return int
     */
    public int getSeed() {
        return seed;
    }
    /**
     * Insert the method's description here.
     * Creation date: (09/01/01 00:42:00)
     * @param newDimensioFractal double
     */
    public void setDimensioFractal(double newDimensioFractal) {
        dimensioFractal = newDimensioFractal;
    }
    /**
     * Insert the method's description here.
     * Creation date: (09/01/01 00:42:00)
     * @param newEpsilon double
     */
    public void setEpsilon(double newEpsilon) {
        epsilon = newEpsilon;
    }
    /**
     * Insert the method's description here.
     * Creation date: (16/01/01 10:51:11)
     * @param newSeed int
     */
    public void setSeed(int newSeed) {
        seed = newSeed;
    }

    public String toString()
    { return "[eps: " + epsilon +
             ", dF: " + dimensioFractal +
             ", seed: " + seed +
             "|" + super.toString() + "|]";
    }
}
