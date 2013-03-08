package mgc.mf.gui.filtre;

import java.awt.*;
import mgc.mf.gui.*;
import mgc.mf.*;
import mgc.mf.filtre.ParametresPosarTemperatura;

public
class PosarTemperatura
extends Nul
{
    TextField ivjTxTemperaturaCim;
    TextField ivjTxTemperaturaEquador;
    TextField ivjTxTemperaturaPol;

	/**
	 * PnlNul constructor comment.
	 */
    public PosarTemperatura() {
       super();
       initialize();
    }

    protected ParametresFiltre crearParametresFiltre()
    {
    return new ParametresPosarTemperatura();
    }

    private TextField getTxTemperaturaCim()
    {
        if (ivjTxTemperaturaCim == null)
        {
            ivjTxTemperaturaCim = new TextField();
            ivjTxTemperaturaCim.setText("270");
        }

        return ivjTxTemperaturaCim;
    }

    private TextField getTxTemperaturaEquador()
    {
        if (ivjTxTemperaturaEquador == null)
        {
            ivjTxTemperaturaEquador = new TextField();
            ivjTxTemperaturaEquador.setText("320");
        }

        return ivjTxTemperaturaEquador;
    }

    private TextField getTxTemperaturaPol()
    {
        if (ivjTxTemperaturaPol == null)
        {
            ivjTxTemperaturaPol = new TextField();
            ivjTxTemperaturaPol.setText("280");
        }

        return ivjTxTemperaturaPol;
    }

    private int getTemperaturaCim()
    {
        return toInt(getTxTemperaturaCim().getText());
    }

    private int getTemperaturaEquador()
    {
        return toInt(getTxTemperaturaEquador().getText());
    }

    private int getTemperaturaPol()
    {
        return toInt(getTxTemperaturaPol().getText());
    }

    private void initialize()
    {
    addLinea("Equador");
    addLinea("Temperatura Cim", getTxTemperaturaCim());
    addLinea("Temperatura Mar", getTxTemperaturaEquador());
    addLinea("Pol");
    addLinea("Temperatura Mar", getTxTemperaturaPol());
    }

    protected void omplirPanel(ParametresFiltre parametres)
    {
    ParametresPosarTemperatura prm;

    prm = (ParametresPosarTemperatura)parametres;
    getTxTemperaturaCim().setText(toString(prm.getTemperaturaCim()));
    getTxTemperaturaEquador().setText(toString(prm.getTemperaturaEquador()));
    getTxTemperaturaPol().setText(toString(prm.getTemperaturaPol()));
    }

    protected void omplirParametres(ParametresFiltre parametres)
    {
    ParametresPosarTemperatura prm;

    prm = (ParametresPosarTemperatura)parametres;
    prm.setTemperaturaCim(getTemperaturaCim());
    prm.setTemperaturaEquador(getTemperaturaEquador());
    prm.setTemperaturaPol(getTemperaturaPol());
    }
}
