package mgc.mf.gui.filtre;

import java.awt.*;
import mgc.mf.gui.*;
import mgc.mf.*;
import mgc.mf.filtre.ParametresAfegirAnells;

public
class AfegirAnells
extends Nul
{
    TextField ivjTxColorR;
    TextField ivjTxColorG;
    TextField ivjTxColorB;
    TextField ivjTxDivisions;
    TextField ivjTxAmplada;
    TextField ivjTxDistancia;
    TextField ivjTxGruix;

	/**
	 * PnlNul constructor comment.
	 */
    public AfegirAnells() {
		super();
		initialize();
	}

	protected ParametresFiltre crearParametresFiltre()
	{
        return new ParametresAfegirAnells();
	}

    private TextField getTxAmplada()
    {
        if (ivjTxAmplada == null)
        {
            ivjTxAmplada = new TextField();
            ivjTxAmplada.setText("0.5");
        }

        return ivjTxAmplada;
    }

    private TextField getTxDistancia()
    {
        if (ivjTxDistancia == null)
        {
            ivjTxDistancia = new TextField();
            ivjTxDistancia.setText("0.5");
        }

        return ivjTxDistancia;
    }
    private TextField getTxGruix()
    {
        if (ivjTxGruix == null)
        {
            ivjTxGruix = new TextField();
            ivjTxGruix.setText("0.01");
        }

        return ivjTxGruix;
    }
    private TextField getTxColorR()
    {
        if (ivjTxColorR == null)
        {
            ivjTxColorR = new TextField();
            ivjTxColorR.setText("140");
        }

        return ivjTxColorR;
    }

    private TextField getTxColorG()
    {
        if (ivjTxColorG == null)
        {
            ivjTxColorG = new TextField();
            ivjTxColorG.setText("140");
        }

        return ivjTxColorG;
    }

    private TextField getTxColorB()
    {
        if (ivjTxColorB == null)
        {
            ivjTxColorB = new TextField();
            ivjTxColorB.setText("140");
        }

        return ivjTxColorB;
    }

    private TextField getTxDivisions()
    {
        if (ivjTxDivisions == null)
        {
            ivjTxDivisions = new TextField();
            ivjTxDivisions.setText("30");
        }

        return ivjTxDivisions;
    }

    private double getAmplada()
    {
        return toDouble(getTxAmplada().getText());
    }

    private double getDistancia()
    {
        return toDouble(getTxDistancia().getText());
    }

    private double getGruix()
    {
        return toDouble(getTxGruix().getText());
    }

    private int getColorR()
    {
        return toInt(getTxColorR().getText());
    }

    private int getColorG()
    {
        return toInt(getTxColorG().getText());
    }

    private int getColorB()
    {
        return toInt(getTxColorB().getText());
    }

    private int getDivisions()
    {
        return toInt(getTxDivisions().getText());
    }

    private void initialize()
    {
    
    addLinea("Color, vermell", getTxColorR());
    addLinea("Color, verd", getTxColorG());
    addLinea("Color, blau", getTxColorB());
    addLinea("Divisions", getTxDivisions());
    addLinea("Amplada", getTxAmplada());
    addLinea("Distancia", getTxDistancia());
    addLinea("Gruix", getTxGruix());
    }

	protected void omplirPanel(ParametresFiltre parametres)
	{
        ParametresAfegirAnells prm;
        Color c;

        prm = (ParametresAfegirAnells)parametres;
        c = prm.getColor();
        getTxColorR().setText(toString(c.getRed()));
        getTxColorG().setText(toString(c.getGreen()));
        getTxColorB().setText(toString(c.getBlue()));
        getTxDivisions().setText(toString(prm.getDivisions()));
        getTxAmplada().setText(toString(prm.getAmplada()));
        getTxDistancia().setText(toString(prm.getDistancia()));
        getTxGruix().setText(toString(prm.getGruix()));
	}

	protected void omplirParametres(ParametresFiltre parametres)
	{
        ParametresAfegirAnells prm;
        Color c;

        prm = (ParametresAfegirAnells)parametres;
        c = new Color(getColorR(), getColorG(), getColorB());
        prm.setColor(c);
        prm.setDivisions(getDivisions());
        prm.setAmplada(getAmplada());
        prm.setDistancia(getDistancia());
        prm.setGruix(getGruix());
	}
}
