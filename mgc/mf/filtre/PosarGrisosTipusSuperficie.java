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
class PosarGrisosTipusSuperficie
extends Nul
{
  public PosarGrisosTipusSuperficie()
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

    Sistema.sPrintln("Aplicant filtre posar grisos");

    enumVertexs = objecte.getVertexs();
    while (enumVertexs.hasMoreElements())
    {
      vertex = (Vertex)enumVertexs.nextElement();
      textura = vertex.getTextura();
      tipusSup = textura.getTipusSuperficie();
      f = (float)tipusSup;
      if (f < 0.0) f = (float)0.0;
      if (f > 1.0) f = (float)1.0;
      textura.setColor(new Color(f,f,f));
      vertex.setTextura(textura);
    } // while
    
    return objecte;
 }
}
