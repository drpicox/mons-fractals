package mgc.mf.gui.filtre;

import java.awt.*;
import mgc.mf.gui.*;
import mgc.mf.*;
import mgc.mf.filtre.ParametresObjecteEsfera;

public
class ObjecteCub
extends Nul
{
    public ObjecteCub()
    { super(); } 

	protected ParametresFiltre crearParametresFiltre()
	{
        return new ParametresObjecteEsfera();
	}

                                            
}
