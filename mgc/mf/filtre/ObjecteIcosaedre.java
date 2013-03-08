package mgc.mf.filtre;

import java.awt.Color;
import mgc.mf.*;

public class ObjecteIcosaedre extends CreadorObjecte
{
   public Objecte obtenirObjecte(ParametresObjecte po)
   {
      double r, h, w, R;
      int i;
      Objecte obj;
      Vertex p[] = new Vertex[12];
      Aresta a[] = new Aresta[30];
      Triangle t[] = new Triangle[20];
      Textura textura;
      ParametresObjecteIcosaedre params;
   
      obj = new Objecte();
      params = (ParametresObjecteIcosaedre)po;
      R = params.getRadi();
   
      r = R * Math.sin(63.43 * Math.PI / 180.0);
      h = R * Math.cos(63.43 * Math.PI / 180.0);
      w = 72.0 * Math.PI / 180.0;
   
      p[0] = new Vertex(obj, new Pt3D(0.0, 0.0, R));
      p[1] = new Vertex(obj, new Pt3D(0.0, -r, h));
      p[2] = new Vertex(obj, new Pt3D(r * Math.sin(w), -r * Math.cos(w), h));
      p[3] = new Vertex(obj, new Pt3D(r * Math.sin(2*w), -r * Math.cos(2*w), h));
      p[4] = new Vertex(obj, new Pt3D(r * Math.sin(3*w), -r * Math.cos(3*w), h));
      p[5] = new Vertex(obj, new Pt3D(r * Math.sin(4*w), -r * Math.cos(4*w), h));
      p[6] = new Vertex(obj, new Pt3D(0.0, r, -h));
      p[7] = new Vertex(obj, new Pt3D(-r * Math.sin(w), r * Math.cos(w), -h));
      p[8] = new Vertex(obj, new Pt3D(-r * Math.sin(2*w), r * Math.cos(2*w), -h));
      p[9] = new Vertex(obj, new Pt3D(-r * Math.sin(3*w), r * Math.cos(3*w), -h));
      p[10] = new Vertex(obj, new Pt3D(-r * Math.sin(4*w), r * Math.cos(4*w), -h));
      p[11] = new Vertex(obj, new Pt3D(0.0, 0.0, -R));

		for (i = 0; i < 12; i++)
		{
   		textura = new Textura();
   		textura.setColor(new Color((float)Math.abs(p[i].getPunt().x / R),
   									   (float)Math.abs(p[i].getPunt().y / R),
   									   (float)Math.abs(p[i].getPunt().z / R)));
   		p[i].setTextura ( textura );
		}

      a[0] = new Aresta(obj, p[0], p[1]); a[1] = new Aresta(obj, p[0], p[2]);
      a[2] = new Aresta(obj, p[0], p[3]); a[3] = new Aresta(obj, p[0], p[4]);
      a[4] = new Aresta(obj, p[0], p[5]); a[5] = new Aresta(obj, p[1], p[2]);
      a[6] = new Aresta(obj, p[2], p[3]); a[7] = new Aresta(obj, p[3], p[4]);
      a[8] = new Aresta(obj, p[4], p[5]); a[9] = new Aresta(obj, p[1], p[5]);
      a[10] = new Aresta(obj, p[1], p[8]); a[11] = new Aresta(obj, p[1], p[9]);
      a[12] = new Aresta(obj, p[2], p[9]); a[13] = new Aresta(obj, p[2], p[10]);
      a[14] = new Aresta(obj, p[3], p[10]); a[15] = new Aresta(obj, p[3], p[6]);
      a[16] = new Aresta(obj, p[4], p[6]); a[17] = new Aresta(obj, p[4], p[7]);
      a[18] = new Aresta(obj, p[5], p[7]); a[19] = new Aresta(obj, p[5], p[8]);
      a[20] = new Aresta(obj, p[6], p[7]); a[21] = new Aresta(obj, p[7], p[8]);
      a[22] = new Aresta(obj, p[8], p[9]); a[23] = new Aresta(obj, p[9], p[10]);
      a[24] = new Aresta(obj, p[10], p[6]); a[25] = new Aresta(obj, p[6], p[11]);
      a[26] = new Aresta(obj, p[7], p[11]); a[27] = new Aresta(obj, p[8], p[11]);
      a[28] = new Aresta(obj, p[9], p[11]); a[29] = new Aresta(obj, p[10], p[11]);
   
      t[0] = new Triangle(obj,a[0],a[5],a[1]); t[1] = new Triangle(obj,a[1],a[6],a[2]);
      t[2] = new Triangle(obj,a[2],a[7],a[3]); t[3] = new Triangle(obj,a[3],a[8],a[4]);
      t[4] = new Triangle(obj,a[4],a[9],a[0]); t[5] = new Triangle(obj,a[11],a[12],a[5]);
      t[6] = new Triangle(obj,a[13],a[14],a[6]); t[7] = new Triangle(obj,a[15],a[16],a[7]);
      t[8] = new Triangle(obj,a[17],a[18],a[8]); t[9] = new Triangle(obj,a[19],a[10],a[9]);
      t[10] = new Triangle(obj,a[23],a[13],a[12]); t[11] = new Triangle(obj,a[24],a[15],a[14]);
      t[12] = new Triangle(obj,a[20],a[17],a[16]); t[13] = new Triangle(obj,a[21],a[19],a[18]);
      t[14] = new Triangle(obj,a[22],a[11],a[10]); t[15] = new Triangle(obj,a[23],a[28],a[29]);
      t[16] = new Triangle(obj,a[24],a[29],a[25]); t[17] = new Triangle(obj,a[20],a[25],a[26]);
      t[18] = new Triangle(obj,a[21],a[26],a[27]); t[19] = new Triangle(obj,a[22],a[27],a[28]);

      obj.validar();

      return obj;
   }
}