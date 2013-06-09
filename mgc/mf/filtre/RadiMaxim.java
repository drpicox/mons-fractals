package mgc.mf.filtre;

import java.util.Enumeration;

import mgc.mf.*;
import mgc.mf.Objecte;

/**
 * Aplica un radi Maxim sobre tots els objectes.
 * Creation date: (12/01/01 03:27:02)
 * @author: David Rodenas Pico
 */
public
class RadiMaxim
extends FiltreNul
{

    public RadiMaxim()
    {
        super();
    }

    /**
     * filtrar method comment.
     */
    public Objecte filtrar(Objecte objecte) 
    {
        ParametresRadiMaxim parametresRadiMaxim;
        Enumeration enumVertexs;
        Vertex vertex;
        Pt3D punt;
        double radiMaxim;
        double radi;

        super.filtrar(objecte);
    
        Sistema.sPrintln("Aplicant filtre radi maxim");
     
        parametresRadiMaxim =
            (ParametresRadiMaxim)getParametresFiltre();
        radiMaxim = parametresRadiMaxim.getRadiMaxim();
     
        enumVertexs = objecte.getVertexs();
        while (enumVertexs.hasMoreElements())
        {
            vertex = (Vertex)enumVertexs.nextElement();
            punt = vertex.getPunt();
            radi = punt.getRadi();
            if (radi > radiMaxim)
                punt.setRadi(radiMaxim);
            vertex.setPunt(punt);
        } // while

        return objecte;
    }
}
