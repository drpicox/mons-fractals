package mgc.mf.gui.filtre;

import java.awt.*;
import mgc.mf.gui.*;
import mgc.mf.*;
import mgc.mf.filtre.ParametresTexturaTemperatura;

public
class TexturaTemperatura
extends FiltreNul
{
	/**
	 * PnlNul constructor comment.
	 */
    public TexturaTemperatura() {
		super();
	}

	protected ParametresFiltre crearParametresFiltre()
	{
        return new ParametresTexturaTemperatura();
	}

}
