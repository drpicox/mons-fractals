package mgc.mf.filtre;

import mgc.mf.*;
import java.awt.Color;

public class ObjecteCub extends CreadorObjecte
{

   public Objecte obtenirObjecte ( ParametresObjecte po ) {
	  Objecte obj;
	  Aresta[] vAres;
	  Vertex[] vVert;
	  Triangle[] vTriangles;
	  Textura[] vTextures;
	  Color color;
	  int index;
		
	  obj        = new Objecte ( );
	  vAres      = new Aresta[18];
	  vVert      = new Vertex[8];
	  vTriangles = new Triangle[12];
	  vTextures  = new Textura[8];
		
	  vVert[0] = new Vertex ( obj, new Pt3D ( -1, -1,  1 ) );
	  vVert[1] = new Vertex ( obj, new Pt3D (  1, -1,  1 ) );
	  vVert[2] = new Vertex ( obj, new Pt3D (  1,  1,  1 ) );
	  vVert[3] = new Vertex ( obj, new Pt3D ( -1,  1,  1 ) );
	  vVert[4] = new Vertex ( obj, new Pt3D ( -1, -1, -1 ) );
	  vVert[5] = new Vertex ( obj, new Pt3D (  1, -1, -1 ) );
	  vVert[6] = new Vertex ( obj, new Pt3D (  1,  1, -1 ) );
	  vVert[7] = new Vertex ( obj, new Pt3D ( -1,  1, -1 ) );

	  for ( index = 0; index <= 7; index++ ) {
		 vTextures[index] = new Textura ( );
		 vTextures[index].setTipusSuperficie ( Math.random ( ) );
		 vVert[index].setTextura ( vTextures[index] );
	  }

	  vTextures[0].setColor ( Color.red );
	  vTextures[1].setColor ( Color.green );
	  vTextures[2].setColor ( Color.blue );
	  vTextures[3].setColor ( Color.cyan );
	  vTextures[4].setColor ( Color.magenta );
	  vTextures[5].setColor ( Color.yellow );
	  vTextures[6].setColor ( Color.pink );
	  vTextures[7].setColor ( Color.orange );


	  vAres[0]  = new Aresta ( obj, vVert[0], vVert[1] );
	  vAres[1]  = new Aresta ( obj, vVert[1], vVert[2] );
	  vAres[2]  = new Aresta ( obj, vVert[2], vVert[3] );
	  vAres[3]  = new Aresta ( obj, vVert[3], vVert[0] );
	  vAres[4]  = new Aresta ( obj, vVert[4], vVert[5] );
	  vAres[5]  = new Aresta ( obj, vVert[5], vVert[6] );
	  vAres[6]  = new Aresta ( obj, vVert[6], vVert[7] );
	  vAres[7]  = new Aresta ( obj, vVert[7], vVert[4] );
	  vAres[8]  = new Aresta ( obj, vVert[0], vVert[4] );
	  vAres[9]  = new Aresta ( obj, vVert[1], vVert[5] );
	  vAres[10] = new Aresta ( obj, vVert[2], vVert[6] );
	  vAres[11] = new Aresta ( obj, vVert[3], vVert[7] );
	  vAres[12] = new Aresta ( obj, vVert[0], vVert[2] );
	  vAres[13] = new Aresta ( obj, vVert[1], vVert[6] );
	  vAres[14] = new Aresta ( obj, vVert[4], vVert[6] );
	  vAres[15] = new Aresta ( obj, vVert[0], vVert[7] );
	  vAres[16] = new Aresta ( obj, vVert[0], vVert[5] );
	  vAres[17] = new Aresta ( obj, vVert[2], vVert[7] );

	  vTriangles[0]  = new Triangle ( obj, vAres[2], vAres[3],  vAres[12] );
	  vTriangles[1]  = new Triangle ( obj, vAres[0], vAres[1],  vAres[12] );
	  vTriangles[2]  = new Triangle ( obj, vAres[1], vAres[13], vAres[10] );
	  vTriangles[3]  = new Triangle ( obj, vAres[5], vAres[13], vAres[9]  );
	  vTriangles[4]  = new Triangle ( obj, vAres[4], vAres[14], vAres[5]  );
	  vTriangles[5]  = new Triangle ( obj, vAres[6], vAres[14], vAres[7]  );
	  vTriangles[6]  = new Triangle ( obj, vAres[7], vAres[8],  vAres[15] );
	  vTriangles[7]  = new Triangle ( obj, vAres[3], vAres[11], vAres[15] );
	  vTriangles[8]  = new Triangle ( obj, vAres[4], vAres[16], vAres[8]  );
	  vTriangles[9]  = new Triangle ( obj, vAres[0], vAres[16], vAres[9]  );
	  vTriangles[10] = new Triangle ( obj, vAres[2], vAres[17], vAres[11] );
	  vTriangles[11] = new Triangle ( obj, vAres[6], vAres[17], vAres[10] );
		
	  obj.validar ( );
		
	  return obj;
   }            
}
