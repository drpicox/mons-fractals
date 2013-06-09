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
class Traslacio
extends FiltreNul
{

    public Traslacio()
    {
        super();
    }

    /**
     * filtrar method comment.
     */
    public Objecte filtrar(Objecte objecte) 
    {
        ParametresTraslacio parametresTraslacio;
        Enumeration enumVertexs;
        Vertex vertex;
        Pt3D punt;
        double x, y, z;
        double radi;

        super.filtrar(objecte);
    
        Sistema.sPrintln("Aplicant filtre traslacio");
     
        parametresTraslacio =
            (ParametresTraslacio)getParametresFiltre();
        x = parametresTraslacio.getX();
        y = parametresTraslacio.getY();
        z = parametresTraslacio.getZ();
     
        enumVertexs = objecte.getVertexs();
        while (enumVertexs.hasMoreElements())
        {
            vertex = (Vertex)enumVertexs.nextElement();
            punt = vertex.getPunt();
            punt.x += x;
            punt.y += y;
            punt.z += z;
            vertex.setPunt(punt);
        } // while

        return objecte;
    }
}
