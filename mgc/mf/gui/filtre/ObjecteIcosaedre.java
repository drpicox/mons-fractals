package mgc.mf.gui.filtre;

import java.awt.*;
import mgc.mf.gui.*;
import mgc.mf.*;
import mgc.mf.filtre.ParametresObjecteIcosaedre;

public class ObjecteIcosaedre extends Nul
{
    TextField ivjTxRadi;

	/**
	 * PnlNul constructor comment.
	 */
    public ObjecteIcosaedre() {
		super();
		initialize();
	}

	protected ParametresFiltre crearParametresFiltre()
	{
        return new ParametresObjecteIcosaedre();
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

    private double getRadi()
    {
        return toDouble(getTxRadi().getText());
    }

    private void initialize()
    {
       addLinea("Radi", getTxRadi());
    }

	protected void omplirPanel(ParametresFiltre parametres)
	{
        ParametresObjecteIcosaedre prm;

        prm = (ParametresObjecteIcosaedre)parametres;
        getTxRadi().setText(toString(prm.getRadi()));
	}

	protected void omplirParametres(ParametresFiltre parametres)
	{
        ParametresObjecteIcosaedre prm;

        prm = (ParametresObjecteIcosaedre)parametres;
        prm.setRadi(getRadi());
	}
}
