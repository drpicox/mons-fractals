package mgc.mf.gui.filtre;

import mgc.mf.*;
import mgc.mf.filtre.*;
import mgc.mf.gui.*;
/**
 * Insert the type's description here.
 * Creation date: (14/01/01 00:11:09)
 * @author: David Rodenas Pico
 */
public 
class FiltreNul
extends PnlParametresFiltre 
{
	/**
	 * PnlNul constructor comment.
	 */
	public FiltreNul() {
		super();
		initialize();
	}
	protected ParametresFiltre crearParametresFiltre()
	{
		return new ParametresNul();
	}
	private void initialize()
	{
		// BUIT
	}
	protected void omplirPanel(ParametresFiltre parametres)
	{
		//buit
	}
	protected void omplirParametres(ParametresFiltre parametres)
	{
		// nul
	}
}
