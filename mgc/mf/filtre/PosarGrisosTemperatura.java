package mgc.mf.filtre;

import java.awt.Color;
import java.util.Enumeration;
import java.util.Random;
import java.util.Vector;

import mgc.mf.*;

/**
 * Filtre que posa grisos depenent del tipus superficie.
 */
public
class PosarGrisosTemperatura
extends FiltreNul
{
  public PosarGrisosTemperatura()
  {
  	super();
  }

  public Objecte filtrar(Objecte objecte)
  {
    Vertex vertex;
    Enumeration enumVertexs;
    Textura textura;
    Color color;
    double tipusSup;
    float f;

    objecte = super.filtrar(objecte);
    Sistema.sPrintln("Aplicant filtre posar grisos temperatura");

    enumVertexs = objecte.getVertexs();
    while (enumVertexs.hasMoreElements())
    {
      vertex = (Vertex)enumVertexs.nextElement();
      textura = vertex.getTextura();
      tipusSup = textura.getTemperatura();
      tipusSup /= 255.0;
      f = (float)tipusSup;
      if (f < 0.0) f = (float)0.0;
      if (f > 1.0) f = (float)1.0;
      textura.setColor(f, f, f);
      vertex.setTextura(textura);
    } // while
    
    return objecte;
 }
}
