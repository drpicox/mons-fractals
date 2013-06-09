package mgc.mf.filtre;

import java.util.Enumeration;

import mgc.mf.*;
import mgc.mf.Objecte;

/**
 * Aplica un radi minim sobre tots els objectes.
 * Creation date: (12/01/01 03:27:02)
 * @author: David Rodenas Pico
 */
public
class Agrupar
extends FiltreNul
{
    private transient RnbGenerarObjecte rnb;
    
    public Agrupar()
    {
        super();
    }

    /**
     * filtrar method comment.
     */
    public Objecte filtrar(Objecte objecte) 
    {
        ParametresAgrupar parametres;
        Objecte nou;

        parametres = (ParametresAgrupar)getParametresFiltre();

        rnb = new RnbGenerarObjecte();
        rnb.setStackFiltres(parametres.getStackFiltres());
        rnb.run();
        nou = rnb.getObjecte();

        objecte.fusionar(nou);
        return objecte;
    }

    public void parar()
    {
    super.parar();
    }
}
