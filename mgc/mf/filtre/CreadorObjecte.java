package mgc.mf.filtre;

import mgc.mf.*;

/**
 * Warper de Objecte -> Filtre.
 */
public
abstract
class CreadorObjecte
extends Nul
{
    public CreadorObjecte()
    { super(); }

    public Objecte filtrar(Objecte obj)
    {
        ParametresObjecte po;

        po = (ParametresObjecte)getParametresFiltre();
        return obtenirObjecte(po);
    }

   public abstract Objecte obtenirObjecte ( ParametresObjecte po );
}
