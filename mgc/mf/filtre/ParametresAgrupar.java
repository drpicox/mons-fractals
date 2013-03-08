package mgc.mf.filtre;

import mgc.mf.*;

/**
 * Agrupa un altere objecte sobre l'objecte inicial.
 * Creation date: (12/01/01 03:27:49)
 * @author: David Rodenas Pico
 */
public 
class ParametresAgrupar
extends ParametresNul
{
    private StackFiltres stackFiltres;

    public ParametresAgrupar()
    {
        super();
        stackFiltres = new StackFiltres();
    }

    /**
     * Insert the method's description here.
     * Creation date: (12/01/01 03:28:34)
     * @return double
     */
    public StackFiltres getStackFiltres()
    {
        return stackFiltres;
    }

    /**
     * Insert the method's description here.
     * Creation date: (12/01/01 03:28:34)
     * @param newStackFiltres double
     */
    public void setStackFiltres(StackFiltres newStackFiltres)
    {
        stackFiltres = newStackFiltres;
    }
}
