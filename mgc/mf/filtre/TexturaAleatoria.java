package mgc.mf.filtre;

import java.awt.Color;
import java.util.Enumeration;
import java.util.Random;
import java.util.Vector;

import mgc.mf.*;

/**
 * Filtre que coloritza un objecte de forma aleatoria.
 */
public
class TexturaAleatoria
extends FiltreNul
{
  private transient Random random;

  public TexturaAleatoria()
  {
  	super();
  }

  public Objecte filtrar(Objecte objecte)
  {
    ParametresTexturaAleatoria pfc;
    Vertex vertex;
    Enumeration enumVertexs;
    Textura textura;
    Color color;
    
    pfc = (ParametresTexturaAleatoria)getParametresFiltre();
    random = new Random(pfc.getSeed());
    
    Sistema.sPrintln("Aplicant filtre colortizat aleatori");

    enumVertexs = objecte.getVertexs();
    while (enumVertexs.hasMoreElements())
    {
      vertex = (Vertex)enumVertexs.nextElement();
      textura = new Textura();
      color = new Color(random.nextFloat(),
                        random.nextFloat(),
                        random.nextFloat());
      textura.setTipusSuperficie(random.nextDouble());
      textura.setColor(color);
      vertex.setTextura(textura);
    } // while
	
    return objecte;   
  }
}
