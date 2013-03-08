package mgc.mf.filtre;

import mgc.mf.*;

/**
 * Superclase per unificar els algorismes fractals.
 * Creation date: (16/01/01 10:46:33)
 * @author: David Rodenas Pico 
 */
public
abstract
class Fractal 
extends Nul 
{
    /**
     * AlgorismeFractal constructor comment.
     */
    public Fractal() {
        super();
    }

	/**
	 * filtrar method comment.
	 */
	public Objecte filtrar(Objecte objecte) 
	{
		objecte = super.filtrar(objecte);
		objecte = fractalitzar
			(objecte, 
			 (ParametresFractals)getParametresFiltre());
		
		return objecte;
	}

	public abstract Objecte fractalitzar
        (Objecte objecte, ParametresFractals parametres);
}
