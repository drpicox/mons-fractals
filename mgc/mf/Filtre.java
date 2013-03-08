package mgc.mf;

/**
 * Filtra un objecte.
 * Creation date: (12/01/01 03:24:59)
 * @author: David Rodenas Pico
 */
public 
interface Filtre
extends java.io.Serializable
{
	Objecte filtrar(Objecte objecte);
	ParametresFiltre getParametresFiltre();
	void parar();
	void setParametresFiltre(ParametresFiltre parametres);
}
