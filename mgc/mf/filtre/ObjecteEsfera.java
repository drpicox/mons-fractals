package mgc.mf.filtre;

import mgc.mf.*;
import java.awt.Color;
import java.util.Vector;
import java.util.Enumeration;

public class ObjecteEsfera extends CreadorObjecte
{
  private transient Vector vArestes;  

  private Aresta cercarAresta ( Objecte obj, Vertex v1, Vertex v2 ) {

	Aresta a;
	Enumeration e;

	for ( e = vArestes.elements ( ); e.hasMoreElements ( ); ) {
	  a = (Aresta)e.nextElement ( );
	  if ( ( a.getVertex1 ( ) == v1 && a.getVertex2 ( ) == v2 ) ||
		   ( a.getVertex1 ( ) == v2 && a.getVertex2 ( ) == v1 ) )
		return a;
	}
	a = new Aresta ( obj, v1, v2 );
	vArestes.addElement ( a );
	return a;
  }

  public Objecte obtenirObjecte ( ParametresObjecte po ) {
	Objecte obj;
	Vertex[][] vVert;
	Textura textura;
	Vertex vSuperior, vInferior;
	Color color;
	int index, i = 0, j = 0;
	double alfa, beta, dAlfa, dBeta;
	double radi;
	int divisionsLongitut, divisionsLatitut;
	ParametresObjecteEsfera poe;
	  
	if ( po == null )
	  po = new ParametresObjecteEsfera ( );

	poe = (ParametresObjecteEsfera)po;
	radi = poe.getRadi ( );
	divisionsLongitut = poe.getDivisionsLongitut ( );
	divisionsLatitut  = poe.getDivisionsLatitut ( );
	dAlfa = 360.0 / divisionsLongitut;
	dBeta = 180.0 / divisionsLatitut;

	/* Convertim els valors a radians */
	dAlfa *= Math.PI / 180.0;
	dBeta *= Math.PI / 180.0;
	  
	obj   = new Objecte ( );
	vVert = new Vertex[divisionsLatitut][];
	for ( index = 0; index < divisionsLatitut; index++ ) {
	  vVert[index] = new Vertex[divisionsLongitut + 1];
	}
	
	vArestes = new Vector ( );
	
	/* Generacio dels vertexs de l'esfera */
	for ( beta = ( -Math.PI / 2 ) + dBeta, i = 0; i < divisionsLatitut - 1; beta += dBeta, i++ ) {
	  for ( alfa = 0, j = 0; j < divisionsLongitut; alfa += dAlfa, j++ ) {
		vVert[i][j] = new Vertex ( obj, 
								   new Pt3D ( Math.cos ( alfa ) * Math.cos ( beta ) * radi,
											  Math.sin ( beta ) * radi,
											  Math.sin ( alfa ) * Math.cos ( beta ) * radi ) );
		textura = new Textura ( );
		textura.setTipusSuperficie ( Math.random ( ) );
		textura.setColor ( new Color ( (float)Math.abs ( vVert[i][j].getPunt ( ).x / radi ),
									   (float)Math.abs ( vVert[i][j].getPunt ( ).y / radi ),
									   (float)Math.abs ( vVert[i][j].getPunt ( ).z / radi ) ) );
		vVert[i][j].setTextura ( textura );
	  }
	  vVert[i][divisionsLongitut] = vVert[i][0];
	}
	
	/* Generacio dels triangles de l'esfera sense les tapes */
	for ( i = 0; i < divisionsLatitut - 2; i++ ) {
	  for ( j = 0; j < divisionsLongitut; j++ ) {
		new Triangle ( obj,
					   cercarAresta ( obj, vVert[i][j], vVert[i + 1][j] ),
					   cercarAresta ( obj, vVert[i + 1][j], vVert[i][j + 1] ),
					   cercarAresta ( obj, vVert[i][j + 1], vVert[i][j] ) );
	  }
	}

	for ( i = 1; i < divisionsLatitut - 1; i++ ) {
	  for ( j = 1; j <= divisionsLongitut; j++ ) {
		new Triangle ( obj,
					   cercarAresta ( obj, vVert[i][j], vVert[i - 1][j] ),
					   cercarAresta ( obj, vVert[i - 1][j], vVert[i][j - 1] ),
					   cercarAresta ( obj, vVert[i][j - 1], vVert[i][j] ) );
	  }
	}

	/* Generacio de les tapes superior i inferior */
	vSuperior = new Vertex ( obj, new Pt3D ( 0,  radi, 0 ) );
	textura = new Textura ( );
	textura.setTipusSuperficie ( Math.random ( ) );
	textura.setColor ( Color.pink );
	vSuperior.setTextura ( textura );

	vInferior = new Vertex ( obj, new Pt3D ( 0, -radi, 0 ) );
	textura = new Textura ( );
	textura.setTipusSuperficie ( Math.random ( ) );
	textura.setColor ( Color.orange );
	vInferior.setTextura ( textura );

	for ( j = 0; j < divisionsLongitut; j++ ) {
	  new Triangle ( obj,
					 cercarAresta ( obj, vSuperior, vVert[divisionsLatitut - 2][j + 1] ),
					 cercarAresta ( obj, vVert[divisionsLatitut - 2][j + 1], vVert[divisionsLatitut - 2][j] ),
					 cercarAresta ( obj, vVert[divisionsLatitut - 2][j], vSuperior ) );
	  new Triangle ( obj,
					 cercarAresta ( obj, vInferior, vVert[0][j] ),
					 cercarAresta ( obj, vVert[0][j], vVert[0][j + 1] ),
					 cercarAresta ( obj, vVert[0][j + 1], vInferior ) );
	}
	
	obj.validar ( );
	
	return obj;
  }  
}
