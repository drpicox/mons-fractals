package mgc.mf.gui.filtre;

import java.awt.*;
import mgc.mf.gui.*;
import mgc.mf.*;
import mgc.mf.filtre.ParametresTexturaAleatoria;

public
class TexturaAleatoria
extends Nul
{
    TextField ivjTxSeed;

	/**
	 * PnlNul constructor comment.
	 */
    public TexturaAleatoria() {
		super();
		initialize();
	}

	protected ParametresFiltre crearParametresFiltre()
	{
        return new ParametresTexturaAleatoria();
	}

    private TextField getTxSeed()
    {
        if (ivjTxSeed == null)
        {
            ivjTxSeed = new TextField();
            ivjTxSeed.setText("1234");
        }

        return ivjTxSeed;
    }

    private int getSeed()
    {
        return toInt(getTxSeed().getText());
    }

    private void initialize()
    {
    
    addLinea("Seed", getTxSeed());
    }

	protected void omplirPanel(ParametresFiltre parametres)
	{
        ParametresTexturaAleatoria prm;

        prm = (ParametresTexturaAleatoria)parametres;
        getTxSeed().setText(toString(prm.getSeed()));
	}

	protected void omplirParametres(ParametresFiltre parametres)
	{
        ParametresTexturaAleatoria prm;

        prm = (ParametresTexturaAleatoria)parametres;
        prm.setSeed(getSeed());
	}
}
