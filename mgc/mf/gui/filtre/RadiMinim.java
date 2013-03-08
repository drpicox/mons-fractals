package mgc.mf.gui.filtre;

import java.awt.*;
import mgc.mf.gui.*;
import mgc.mf.*;
import mgc.mf.filtre.ParametresRadiMinim;

public
class RadiMinim
extends Nul
{
    TextField ivjTxRadiMinim;

	/**
	 * PnlNul constructor comment.
	 */
    public RadiMinim() {
		super();
		initialize();
	}

	protected ParametresFiltre crearParametresFiltre()
	{
        return new ParametresRadiMinim();
	}

    private TextField getTxRadiMinim()
    {
        if (ivjTxRadiMinim == null)
        {
            ivjTxRadiMinim = new TextField();
            ivjTxRadiMinim.setText("2.0");
        }

        return ivjTxRadiMinim;
    }

    private double getRadiMinim()
    {
        return toDouble(getTxRadiMinim().getText());
    }

    private void initialize()
    {
    
    addLinea("Radi Minim", getTxRadiMinim());
    }

	protected void omplirPanel(ParametresFiltre parametres)
	{
        ParametresRadiMinim prm;

        prm = (ParametresRadiMinim)parametres;
        getTxRadiMinim().setText(toString(prm.getRadiMinim()));
	}

	protected void omplirParametres(ParametresFiltre parametres)
	{
        ParametresRadiMinim prm;

        prm = (ParametresRadiMinim)parametres;
        prm.setRadiMinim(getRadiMinim());
	}
}
