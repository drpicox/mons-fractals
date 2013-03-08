package mgc.mf;

import java.util.Enumeration;
import java.util.Stack;

/**
 * Insert the type's description here.
 * Creation date: (13/01/01 23:49:01)
 * @author: David Rodenas Pico
 */
public 
class StackFiltres
implements java.io.Serializable
{
	private Stack filtres;

/**
 * StackFiltros constructor comment.
 */
public StackFiltres() 
{
	super();

	filtres = new Stack();
}
	public Enumeration getAllFiltres()
	{
		return filtres.elements();
	}
	public Filtre getFiltre(int i)
	{
		return (Filtre)filtres.elementAt(i);
	}
	public int getNumFiltres()
	{
		return filtres.size();
	}
	public void insertFiltreAt(Filtre i, int pos)
	{
		filtres.insertElementAt(i, pos);
	}
	public void pushFiltre(Filtre filtre)
	{
		filtres.push(filtre);
	}
	public void removeFiltre(int i)
	{
		filtres.removeElementAt(i);
	}
	public void removeFiltre(Filtre filtre)
	{
		filtres.removeElement(filtre);
	}
}
