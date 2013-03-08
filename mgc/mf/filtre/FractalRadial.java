package mgc.mf.filtre;

import java.util.Enumeration;
import java.util.Random;
import java.util.Vector;

import mgc.mf.*;

public 
class FractalRadial
extends Fractal
{
   private transient boolean continuar;
   private transient Random random;

    public FractalRadial()
    { super(); }

	public Objecte fractalitzar (Objecte objecte, ParametresFractals parametres)
	{
		int arestesTallades;
			
        random = new Random(parametres.getSeed());
		continuar = true;

		arestesTallades = partirArestes(objecte, parametres);
		while (arestesTallades != 0)
		{
		  partirTriangles(objecte, parametres);
		  if (!continuar)
			break;

		  Sistema.sPrintln
			("Fractalitzant, arestes tallades: " + arestesTallades);
			
		  arestesTallades = partirArestes(objecte, parametres);
		} // while has arestes seleccionades
		Sistema.sPrintln("Fractalitzat");
			
		return objecte;
	}

	protected Vertex fractalitzar(Vertex vertex,
	                              Aresta aresta,
								  ParametresFractals parametres)
	{
		Pt3D punt;
		double radi;
		double factorElevacio;
		double longitut;
		double dimensioFractal;
		
		longitut = aresta.longitut();
		dimensioFractal = parametres.getDimensioFractal();
		factorElevacio = random.nextDouble() - 0.5;

		punt = vertex.getPunt();
		radi = punt.getRadi();
		radi = radi + longitut * dimensioFractal * factorElevacio;
		punt.setRadi(radi);
		vertex.setPunt(punt);
		
		return vertex; 
	}

	protected Vertex interpolacio(Objecte objecte, 
								  Aresta aresta,
								  double proporcioTall, 
								  ParametresFractals parametres
								  )
	{
	  Vertex v;
	  Pt3D   punt;
	 
	  punt = aresta.interpolacio(proporcioTall);
	  v = new Vertex(objecte, punt);
	  
	  return v;
   }

	public void parar()
	{
	continuar = false;
	}

	protected void partirAresta (Objecte objecte, 
	                             Aresta aresta, 
								 ParametresFractals parametres
								 )
	{
		Vertex vertex;
		double proporcioTall;

		proporcioTall = 0.5;//random.nextDouble();
		vertex = interpolacio(objecte, aresta, proporcioTall, parametres);
		vertex = fractalitzar(vertex, aresta, parametres);
		aresta.setVertexPartir(vertex);
	}

	/**
	 * Parteix les arestes de l'objecte.
	 */
	public int partirArestes(Objecte objecte, 
		                     ParametresFractals parametresFractals)
	{
		Enumeration enumArestes;
		Aresta aresta;
		double longitutMinima;
		double longitutMinima2;
		double longitutAresta2;
		int numArestesPartides;
		
		longitutMinima = parametresFractals.getEpsilon();
		longitutMinima2 = longitutMinima * longitutMinima;
		enumArestes = objecte.getArestes();
		numArestesPartides = 0;

		while (enumArestes.hasMoreElements())
		{
			aresta = (Aresta)enumArestes.nextElement();
			longitutAresta2 = aresta.longitut2();
			if (longitutAresta2 < longitutMinima2)
				continue;
			// Aquest if desapareixera amb optimitzacions i correccions
			if (aresta.partida()) continue;

			numArestesPartides ++;
			partirAresta(objecte, aresta, parametresFractals);
		} // while
		
		return numArestesPartides;	
	}

	/**
	 * Parteix les arestes de l'objecte.
	 */
	public void partirTriangles(Objecte objecte, 
		                        ParametresFractals parametresFractals)
	{
		Enumeration enumTriangles;
		Vector triangles;
		Triangle triangle;
		Object obj;

		enumTriangles = objecte.getTriangles();
		triangles = new Vector(256, 0);
		while (enumTriangles.hasMoreElements())
		{
			obj = enumTriangles.nextElement();
			triangles.addElement(obj);
		} // while
		enumTriangles = triangles.elements();
		while (enumTriangles.hasMoreElements())
		{
			triangle = (Triangle)enumTriangles.nextElement();
			triangle.partirTriangle();
		} // while
		objecte.validar();
	}

	protected Vector seleccionarArestes (Enumeration totesArestes, 
										 ParametresFractals parametres)
	{
	  Enumeration enumArestes;
	  Vector seleccio;
	  Aresta aresta;
	  double longitutAresta;
	  double longitutMinimaAresta;
	  
	  seleccio = new Vector(256, 1024);
	  longitutMinimaAresta = parametres.getEpsilon();
	  
	  enumArestes = totesArestes;
	  while (enumArestes.hasMoreElements())
	  {
		aresta = (Aresta)enumArestes.nextElement();
		longitutAresta = aresta.longitut();
		
		if (longitutAresta > longitutMinimaAresta)
		  seleccio.addElement(aresta);
	  } // While
	  
	  return seleccio;
	}
}
