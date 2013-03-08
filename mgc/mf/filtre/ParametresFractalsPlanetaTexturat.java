package mgc.mf.filtre;

import java.util.Random;

public
class ParametresFractalsPlanetaTexturat
extends ParametresFractalsPlaneta
{
	private double dimensioFractalTextura;
	private int seedTextura;
  public ParametresFractalsPlanetaTexturat()
  { super();

	  dimensioFractalTextura = 0.2;
	  seedTextura = 1234;
  }            
/**
 * Insert the method's description here.
 * Creation date: (11/01/01 23:33:43)
 * @return double
 */
public double getDimensioFractalTextura() {
	return dimensioFractalTextura;
}
/**
 * Insert the method's description here.
 * Creation date: (16/01/01 11:09:45)
 * @return int
 */
public int getSeedTextura() {
	return seedTextura;
}
/**
 * Insert the method's description here.
 * Creation date: (11/01/01 23:33:43)
 * @param newDimensioFractalTextura double
 */
public void setDimensioFractalTextura(double newDimensioFractalTextura) {
	dimensioFractalTextura = newDimensioFractalTextura;
}
/**
 * Insert the method's description here.
 * Creation date: (16/01/01 11:09:45)
 * @param newSeedTextura int
 */
public void setSeedTextura(int newSeedTextura) {
	seedTextura = newSeedTextura;
}
}
