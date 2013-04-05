package mgc.mf.gui.filtre;

import java.awt.*;
import mgc.mf.gui.*;
import mgc.mf.*;
import mgc.mf.filtre.ParametresTraslacio;

public
class Traslacio
extends Nul
{
    TextField ivjTxX;
    TextField ivjTxY;
    TextField ivjTxZ;

	/**
	 * PnlNul constructor comment.
	 */
    public Traslacio() {
		super();
		initialize();
	}

	protected ParametresFiltre crearParametresFiltre()
	{
        return new ParametresTraslacio();
	}

    private TextField getTxX()
    {
        if (ivjTxX == null)
        {
            ivjTxX = new TextField();
            ivjTxX.setText("0.0");
        }

        return ivjTxX;
    }

    private TextField getTxY()
    {
        if (ivjTxY == null)
        {
            ivjTxY = new TextField();
            ivjTxY.setText("0.0");
        }

        return ivjTxY;
    }

    private TextField getTxZ()
    {
        if (ivjTxZ == null)
        {
            ivjTxZ = new TextField();
            ivjTxZ.setText("0.0");
        }

        return ivjTxZ;
    }

    private double get_X()
    {
        return toDouble(getTxX().getText());
    }

    private double get_Y()
    {
        return toDouble(getTxY().getText());
    }

    private double get_Z()
    {
        return toDouble(getTxZ().getText());
    }

    private void initialize()
    {
    addLinea("x", getTxX());
    addLinea("y", getTxY());
    addLinea("z", getTxZ());
    }

	protected void omplirPanel(ParametresFiltre parametres)
	{
        ParametresTraslacio prm;

        prm = (ParametresTraslacio)parametres;
        getTxX().setText(toString(prm.getX()));
        getTxY().setText(toString(prm.getY()));
        getTxZ().setText(toString(prm.getZ()));
	}

	protected void omplirParametres(ParametresFiltre parametres)
	{
        ParametresTraslacio prm;

        prm = (ParametresTraslacio)parametres;
        prm.setX(get_X());
        prm.setY(get_Y());
        prm.setZ(get_Z());
	}
}
