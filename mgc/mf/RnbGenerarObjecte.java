package mgc.mf;

import java.util.*;
/**
 * Clase que genera un objecte.
 * Creation date: (16/01/01 07:29:13)
 * @author: David Rodenas Pico
 */
public 
class RnbGenerarObjecte
implements Runnable 
{
	private StackFiltres filtres;
	private Objecte objecte;
	private boolean parar;
	private Filtre filtreActual;

/**
 * RnbGenerarObjecte constructor comment.
 */
public RnbGenerarObjecte() {
	super();
}
	public Objecte getObjecte()
	{ return objecte; }
	public boolean isParat()
	{ return parar; }
	public void isParat(boolean p)
	{
		if (p)
			parar();
			
		parar = p; 
	}
	public void parar()
	{ 
		parar = true;
		try { filtreActual.parar(); }
		catch (NullPointerException npe) {}
	}
	/**
	 * run method comment.
	 */
	public void run() 
	{
		Enumeration enumFiltres;
		ParametresFiltre parametres;
		Filtre filtre;
		String nom, tipus;

		Sistema.sPrintln("Aplicant filtres...");
		isParat(false);
		objecte = new Objecte();
		enumFiltres = filtres.getAllFiltres();
		while (enumFiltres.hasMoreElements())
		{
			filtre = (Filtre)enumFiltres.nextElement();
			parametres = filtre.getParametresFiltre();
			nom = parametres.getNomFiltre();
			tipus = parametres.getTipusFiltre();
			Sistema.sPrintln("Aplicant filtre " +
				nom + "(" + tipus + ")");	
			filtreActual = filtre;			
			if (isParat())
				break;
			objecte = filtre.filtrar(objecte);
            filtreActual = null;
            parametres = null;
            nom = null;
            System.gc();
		}

		if (isParat())
			Sistema.sPrintln("Aplicacio de filtres aturat");
		else
            {
            Sistema.sPrintln("Comprovant validesa de l'objecte...");
            objecte.validar();
            Sistema.sPrintln("Aplicacio de filtres finalitzat");
            }
	}
	public void setStackFiltres(StackFiltres stackFiltres)
	{ filtres = stackFiltres; }
}
