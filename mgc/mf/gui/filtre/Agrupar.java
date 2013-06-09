package mgc.mf.gui.filtre;

import mgc.mf.gui.*;
import mgc.mf.*;
import mgc.mf.filtre.FiltreNul;
import mgc.mf.filtre.ParametresAgrupar;

public
class Agrupar
extends FiltreNul
{
    private FinestraPrincipal finestraPrincipal;

	/**
	 * PnlNul constructor comment.
	 */
    public Agrupar() {
		super();
		initialize();
	}

	protected ParametresFiltre crearParametresFiltre()
	{
        return new ParametresAgrupar();
	}

    private void initialize()
    {
    }

    public synchronized void on()
    {
        if (finestraPrincipal == null)
            finestraPrincipal = new FinestraPrincipal();

        finestraPrincipal.show();
    }

    public synchronized void off()
    {
        if (finestraPrincipal == null)
            return;

        finestraPrincipal.dispose();
        finestraPrincipal = null;
    }

    protected synchronized void omplirPanel(ParametresFiltre parametres)
	{
        ParametresAgrupar p;

        if (finestraPrincipal == null)
            finestraPrincipal = new FinestraPrincipal();

        p = (ParametresAgrupar)parametres;
        finestraPrincipal.setStackFiltres(p.getStackFiltres());
	}

    protected synchronized void omplirParametres(ParametresFiltre parametres)
	{
        ParametresAgrupar prm;

        if (finestraPrincipal == null) return;

        prm = (ParametresAgrupar)parametres;
        prm.setStackFiltres(finestraPrincipal.getStackFiltres());
	}

    private void handleException(java.lang.Throwable exception) {
    
        Sistema.sHandleException(exception);
    }
}
