package mgc.mf.gui.filtre;

import java.awt.*;
import mgc.mf.gui.*;
import mgc.mf.*;
import mgc.mf.filtre.ParametresMar;

public
class Mar
extends RadiMinim
{

    TextField ivjTxColor1Red;
    TextField ivjTxColor1Green;
    TextField ivjTxColor1Blue;
    TextField ivjTxColor2Red;
    TextField ivjTxColor2Green;
    TextField ivjTxColor2Blue;

    public Mar() {
		super();
		initialize();
	}

	protected ParametresFiltre crearParametresFiltre()
	{
        return new ParametresMar();
	}

    private TextField getTxColor1Red()
    {
        if (ivjTxColor1Red == null)
        {
            ivjTxColor1Red = new TextField();
            ivjTxColor1Red.setText("20");
        }

        return ivjTxColor1Red;
    }

    private TextField getTxColor1Green()
    {
        if (ivjTxColor1Green == null)
        {
            ivjTxColor1Green = new TextField();
            ivjTxColor1Green.setText("40");
        }

        return ivjTxColor1Green;
    }

    private TextField getTxColor1Blue()
    {
        if (ivjTxColor1Blue == null)
        {
            ivjTxColor1Blue = new TextField();
            ivjTxColor1Blue.setText("255");
        }

        return ivjTxColor1Blue;
    }

    private TextField getTxColor2Red()
    {
        if (ivjTxColor2Red == null)
        {
            ivjTxColor2Red = new TextField();
            ivjTxColor2Red.setText("15");
        }

        return ivjTxColor2Red;
    }

    private TextField getTxColor2Green()
    {
        if (ivjTxColor2Green == null)
        {
            ivjTxColor2Green = new TextField();
            ivjTxColor2Green.setText("235");
        }

        return ivjTxColor2Green;
    }

    private TextField getTxColor2Blue()
    {
        if (ivjTxColor2Blue == null)
        {
            ivjTxColor2Blue = new TextField();
            ivjTxColor2Blue.setText("255");
        }

        return ivjTxColor2Blue;
    }

    private int getColor1Red()
    {
        return toInt(getTxColor1Red().getText());
    }

    private int getColor1Green()
    {
        return toInt(getTxColor1Green().getText());
    }

    private int getColor1Blue()
    {
        return toInt(getTxColor1Blue().getText());
    }

    private int getColor2Red()
    {
        return toInt(getTxColor2Red().getText());
    }

    private int getColor2Green()
    {
        return toInt(getTxColor2Green().getText());
    }

    private int getColor2Blue()
    {
        return toInt(getTxColor2Blue().getText());
    }

    private void initialize()
    {
        addLinea("Color 1, vermell", getTxColor1Red());
        addLinea("Color 1, verd", getTxColor1Green());
        addLinea("Color 1, blau", getTxColor1Blue());
        addLinea("Color 2, vermell", getTxColor2Red());
        addLinea("Color 2, verd", getTxColor2Green());
        addLinea("Color 2, blau", getTxColor2Blue());
    }

	protected void omplirPanel(ParametresFiltre parametres)
	{
        ParametresMar prm;

        super.omplirPanel ( parametres );
        prm = (ParametresMar)parametres;
        getTxColor1Red().setText(toString(prm.getColor1Red()));
        getTxColor1Green().setText(toString(prm.getColor1Green()));
        getTxColor1Blue().setText(toString(prm.getColor1Blue()));
        getTxColor2Red().setText(toString(prm.getColor2Red()));
        getTxColor2Green().setText(toString(prm.getColor2Green()));
        getTxColor2Blue().setText(toString(prm.getColor2Blue()));
	}

	protected void omplirParametres(ParametresFiltre parametres)
	{
        ParametresMar prm;

        super.omplirParametres ( parametres );
        prm = (ParametresMar)parametres;
        prm.setColor1Red(getColor1Red());
        prm.setColor1Green(getColor1Green());
        prm.setColor1Blue(getColor1Blue());
        prm.setColor2Red(getColor2Red());
        prm.setColor2Green(getColor2Green());
        prm.setColor2Blue(getColor2Blue());
	}

}
