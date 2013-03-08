package mgc.mf.filtre;

import java.awt.Color;
import mgc.mf.*;

public class AfegirAnells extends Nul
{
   public Objecte filtrar(Objecte obj)
   {
      Vertex mat[][];
      Aresta ares[][], mat2[];
      double radi, x, z, angle, h, w, d;
      int i, nVoltes;
      Color colorAnell;
      Textura textura;
      ParametresAfegirAnells params;

      params = (ParametresAfegirAnells)getParametresFiltre();
      nVoltes = params.getDivisions();
      colorAnell = params.getColor();
      w = params.getAmplada();
      d = params.getDistancia();
      h = params.getGruix();

      mat = new Vertex[nVoltes][4];
      ares = new Aresta[nVoltes][4];
      mat2 = new Aresta[8];

      obj.calcularBoundingBox();
      radi = obj.getRadiMaxim();
      if (radi < 0) radi = 1.0;
      radi += d;
      for (i = 0; i < nVoltes; i++)
      {
         angle = (2 * Math.PI) / nVoltes;
         x = Math.cos(i * angle);
         z = Math.sin(i * angle);
         mat[i][0] = new Vertex(obj, new Pt3D(x*radi, 0.0, z*radi));
         mat[i][1] = new Vertex(obj, new Pt3D(x*(radi + 0.5*w), -0.5*h, z*(radi + 0.5*w)));
         mat[i][2] = new Vertex(obj, new Pt3D(x*(radi + 0.5*w), 0.5*h, z*(radi + 0.5*w)));
         mat[i][3] = new Vertex(obj, new Pt3D(x*(radi + w), 0.0, z*(radi + w)));
         textura = new Textura();
         textura.setColor(colorAnell);
         mat[i][0].setTextura(textura);
         textura = new Textura();
         textura.setColor(colorAnell);
         mat[i][1].setTextura(textura);
         textura = new Textura();
         textura.setColor(colorAnell);
         mat[i][2].setTextura(textura);
         textura = new Textura();
         textura.setColor(colorAnell);
         mat[i][3].setTextura(textura);
         ares[i][0] = new Aresta(obj, mat[i][0], mat[i][2]);
         ares[i][1] = new Aresta(obj, mat[i][2], mat[i][3]);
         ares[i][2] = new Aresta(obj, mat[i][0], mat[i][1]);
         ares[i][3] = new Aresta(obj, mat[i][1], mat[i][3]);
      }
      
      for (i = 0; i < nVoltes - 1; i++)
      {
         mat2[0] = new Aresta(obj, mat[i][0], mat[i+1][0]);
         mat2[1] = new Aresta(obj, mat[i+1][0], mat[i][2]);
         mat2[2] = new Aresta(obj, mat[i+1][2], mat[i][2]);
         mat2[3] = new Aresta(obj, mat[i+1][2], mat[i][3]);
         mat2[4] = new Aresta(obj, mat[i][3], mat[i+1][3]);
         mat2[5] = new Aresta(obj, mat[i][1], mat[i+1][0]);
         mat2[6] = new Aresta(obj, mat[i][1], mat[i+1][1]);
         mat2[7] = new Aresta(obj, mat[i][3], mat[i+1][1]);
         new Triangle(obj, mat2[0], mat2[1], ares[i][0]);
         new Triangle(obj, mat2[2], mat2[1], ares[i+1][0]);
         new Triangle(obj, mat2[2], mat2[3], ares[i][1]);
         new Triangle(obj, mat2[4], mat2[3], ares[i+1][1]);
         new Triangle(obj, mat2[5], mat2[0], ares[i][2]);
         new Triangle(obj, mat2[5], mat2[6], ares[i+1][2]);
         new Triangle(obj, mat2[7], mat2[6], ares[i][3]);
         new Triangle(obj, mat2[7], mat2[4], ares[i+1][3]);
      }
      i = nVoltes - 1;
      mat2[0] = new Aresta(obj, mat[i][0], mat[0][0]);
      mat2[1] = new Aresta(obj, mat[0][0], mat[i][2]);
      mat2[2] = new Aresta(obj, mat[0][2], mat[i][2]);
      mat2[3] = new Aresta(obj, mat[0][2], mat[i][3]);
      mat2[4] = new Aresta(obj, mat[i][3], mat[0][3]);
      mat2[5] = new Aresta(obj, mat[i][1], mat[0][0]);
      mat2[6] = new Aresta(obj, mat[i][1], mat[0][1]);
      mat2[7] = new Aresta(obj, mat[i][3], mat[0][1]);
      new Triangle(obj, mat2[0], mat2[1], ares[i][0]);
      new Triangle(obj, mat2[2], mat2[1], ares[0][0]);
      new Triangle(obj, mat2[2], mat2[3], ares[i][1]);
      new Triangle(obj, mat2[4], mat2[3], ares[0][1]);
      new Triangle(obj, mat2[5], mat2[0], ares[i][2]);
      new Triangle(obj, mat2[5], mat2[6], ares[0][2]);
      new Triangle(obj, mat2[7], mat2[6], ares[i][3]);
      new Triangle(obj, mat2[7], mat2[4], ares[0][3]);

      return obj;
   }
}