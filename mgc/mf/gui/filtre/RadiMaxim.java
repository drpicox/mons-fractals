package mgc.mf.gui.filtre;

import java.awt.*;
import mgc.mf.gui.*;
import mgc.mf.*;
import mgc.mf.filtre.ParametresRadiMaxim;

public
class RadiMaxim
extends Nul
{
    TextField ivjTxRadiMaxim;

	/**
	 * PnlNul constructor comment.
	 */
    public RadiMaxim() {
		super();
		initialize();
	}

	protected ParametresFiltre crearParametresFiltre()
	{
        return new ParametresRadiMaxim();
	}

    private TextField getTxRadiMaxim()
    {
        if (ivjTxRadiMaxim == null)
        {
            ivjTxRadiMaxim = new TextField();
            ivjTxRadiMaxim.setText("2.0");
        }

        return ivjTxRadiMaxim;
    }

    private double getRadiMaxim()
    {
        return toDouble(getTxRadiMaxim().getText());
    }

    private void initialize()
    {
    
    addLinea("Radi Maxim", getTxRadiMaxim());
    }

	protected void omplirPanel(ParametresFiltre parametres)
	{
        ParametresRadiMaxim prm;

        prm = (ParametresRadiMaxim)parametres;
        getTxRadiMaxim().setText(toString(prm.getRadiMaxim()));
	}

	protected void omplirParametres(ParametresFiltre parametres)
	{
        ParametresRadiMaxim prm;

        prm = (ParametresRadiMaxim)parametres;
        prm.setRadiMaxim(getRadiMaxim());
	}
}
