package mgc.mf.gui.filtre;

import java.awt.*;
import mgc.mf.gui.*;
import mgc.mf.*;
import mgc.mf.filtre.ParametresObjecteEsfera;

public
class ObjecteEsfera
extends FiltreNul
{
    TextField ivjTxRadi;
    TextField ivjTxDivisionsLongitut;
    TextField ivjTxDivisionsLatitut;

	/**
	 * PnlNul constructor comment.
	 */
    public ObjecteEsfera() {
		super();
		initialize();
	}

	protected ParametresFiltre crearParametresFiltre()
	{
        return new ParametresObjecteEsfera();
	}

    private TextField getTxRadi()
    {
        if (ivjTxRadi == null)
        {
            ivjTxRadi = new TextField();
            ivjTxRadi.setText("1.0");
        }

        return ivjTxRadi;
    }

    private TextField getTxDivisionsLongitut()
    {
        if (ivjTxDivisionsLongitut == null)
        {
            ivjTxDivisionsLongitut = new TextField();
            ivjTxDivisionsLongitut.setText("4");
        }

        return ivjTxDivisionsLongitut;
    }

    private TextField getTxDivisionsLatitut()
    {
        if (ivjTxDivisionsLatitut == null)
        {
            ivjTxDivisionsLatitut = new TextField();
            ivjTxDivisionsLatitut.setText("3");
        }

        return ivjTxDivisionsLatitut;
    }

    private double getRadi()
    {
        return toDouble(getTxRadi().getText());
    }

    private int getDivisionsLongitut()
    {
        return toInt(getTxDivisionsLongitut().getText());
    }

    private int getDivisionsLatitut()
    {
        return toInt(getTxDivisionsLatitut().getText());
    }

    private void initialize()
    {
    
    addLinea("Radi", getTxRadi());
    addLinea("Divisions Longitut", getTxDivisionsLongitut());
    addLinea("Divisions Latitut", getTxDivisionsLatitut());
    }

	protected void omplirPanel(ParametresFiltre parametres)
	{
        ParametresObjecteEsfera prm;

        prm = (ParametresObjecteEsfera)parametres;
        getTxRadi().setText(toString(prm.getRadi()));
        getTxDivisionsLongitut().setText(toString(prm.getDivisionsLongitut()));
        getTxDivisionsLatitut().setText(toString(prm.getDivisionsLatitut()));
	}

	protected void omplirParametres(ParametresFiltre parametres)
	{
        ParametresObjecteEsfera prm;

        prm = (ParametresObjecteEsfera)parametres;
        prm.setRadi(getRadi());
        prm.setDivisionsLongitut(getDivisionsLongitut());
        prm.setDivisionsLatitut(getDivisionsLatitut());
	}
}
