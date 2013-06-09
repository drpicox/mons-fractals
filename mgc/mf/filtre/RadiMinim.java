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
class RadiMinim
extends FiltreNul
{

    public RadiMinim()
    {
        super();
    }

    /**
     * filtrar method comment.
     */
    public Objecte filtrar(Objecte objecte) 
    {
        ParametresRadiMinim parametresRadiMinim;
        Enumeration enumVertexs;
        Vertex vertex;
        Pt3D punt;
        double radiMinim;
        double radi;

        super.filtrar(objecte);
    
        Sistema.sPrintln("Aplicant filtre radi minim");
     
        parametresRadiMinim =
            (ParametresRadiMinim)getParametresFiltre();
        radiMinim = parametresRadiMinim.getRadiMinim();
     
        enumVertexs = objecte.getVertexs();
        while (enumVertexs.hasMoreElements())
        {
            vertex = (Vertex)enumVertexs.nextElement();
            punt = vertex.getPunt();
            radi = punt.getRadi();
            if (radi < radiMinim)
                punt.setRadi(radiMinim);
            vertex.setPunt(punt);
        } // while

        return objecte;
    }
}
