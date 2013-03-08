package mgc.mf.filtre;

import java.awt.Color;
import java.util.Enumeration;
import java.util.Random;

import mgc.mf.*;

public
class FractalRadialTexturat
extends FractalRadial
{
  private transient Random random;

  public FractalRadialTexturat()
  { super(); }

  protected Objecte coloritzar(Objecte objecte, ParametresFractals parametres)
  {
	ParametresFractalsPlanetaTexturat pfpt;
	Vertex vertex;
	Enumeration enumVertexs;
	Textura textura;
	Color color;

	pfpt = (ParametresFractalsPlanetaTexturat)parametres;
    random = new Random(pfpt.getSeed());
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

  public Objecte fractalitzar (Objecte objecte, ParametresFractals parametres)
  {
	ParametresFractalsPlanetaTexturat pfpt;

	pfpt = (ParametresFractalsPlanetaTexturat)parametres;
    random = new Random(pfpt.getSeed());

	//objecte = coloritzar(objecte, parametres);
    objecte = super.fractalitzar(objecte, parametres);
	//posarGrisos(objecte, parametres);
	
	return objecte;
  }

	protected Vertex interpolacio(Objecte objecte, 
								  Aresta aresta,
								  double proporcioTall, 
								  ParametresFractals parametres)
	{
	  ParametresFractalsPlanetaTexturat pfpt;
	  Vertex vertex, v1, v2;
	  Textura textura, t1, t2;
	  Pt3D   punt;
	  double factorElevacio;
	  double dimensioFractal;
	  double longitut, radi;
	  double tipusSup1, tipusSup2, tipusSup;
	  
	  pfpt = (ParametresFractalsPlanetaTexturat)parametres;
	  v1 = aresta.getVertex1();
	  v2 = aresta.getVertex2();
	  t1 = v1.getTextura();
	  t2 = v2.getTextura();
	  tipusSup1 = t1.getTipusSuperficie();
	  tipusSup2 = t2.getTipusSuperficie();
	  factorElevacio = random.nextDouble() - 0.5;
	  dimensioFractal = pfpt.getDimensioFractalTextura();
	  
	  vertex = super.interpolacio(objecte, aresta, proporcioTall, parametres);
	  textura = vertex.getTextura();
	  if (textura == null) textura = new Textura();
	  longitut = tipusSup1 - tipusSup2;
		  				
	  textura.interpolar(
		t1, t2, 
	  	proporcioTall + factorElevacio * longitut * dimensioFractal);
	  vertex.setTextura(textura);
	  
	  return vertex;
   }

  protected Objecte posarGrisos(Objecte objecte, ParametresFractals parametres)
  {
	Vertex vertex;
	Enumeration enumVertexs;
	Textura textura;
	Color color;
	double tipusSup;

	enumVertexs = objecte.getVertexs();
	while (enumVertexs.hasMoreElements())
	{
	  vertex = (Vertex)enumVertexs.nextElement();
	  textura = vertex.getTextura();
	  tipusSup = textura.getTipusSuperficie();
	  textura.setColor(new Color((float)tipusSup, (float)tipusSup, (float)tipusSup));
	  vertex.setTextura(textura);
	} // while
	
	return objecte;
  }              
}
