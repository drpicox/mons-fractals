package mgc.mf;

import java.awt.Color;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Hashtable;
import java.util.Vector;
import java.util.Enumeration;

public class TraductorBDG implements Traductor
{
    private Hashtable colors;
    
    public void traduir (Objecte obj, PrintWriter out)
    {
        Enumeration e;
        Triangle t;
        Vertex v;
        Pt3D p;
        int i = 0;
        Vector vertexs = new Vector(obj.getNumVertexs());

        for (e = obj.getVertexs(); e.hasMoreElements();)
        {
           v = (Vertex)e.nextElement();
           vertexs.addElement(v);
           v.setPosicio(i);
           i++;
        }
        
         /****************  OBJECTE  *************/
         out.println("1"); // Numero d'objectes
         out.println("OBJECTE");  // Nom
         out.println("<CAP>");  // Material
         out.println("<CAP>");  // Textura
         out.println("3");  // Tipus BROBJECTE
         out.println("0");  // Index inferior dels punts
         out.println(obj.getNumVertexs() - 1);  // Index superior dels punts
         out.println(obj.getNumTriangles());  // Nombre de cares
         out.flush();
	 /*****************  CARA  ************/
         // Pla.normal.x
         // Pla.normal.y
         // Pla.normal.z
         // Pla.d
         // Material
         // Flags
         // Textura
        Sistema.sPrintln("TraductorBDG: Escrivint triangles");
        for (e = obj.getTriangles(); e.hasMoreElements();)
        {
            t = (Triangle)e.nextElement();
            calculaNormal(t, out);
            out.println(afegirColor(t.getTextura().getColor()));
            out.println("0");
            out.println("<CAP>");
            /*****************  POLIGON  **************/
            // Flags poligon
            // Nombre d'arestes
            // apuntadors ordenats als vertexs
            // Fi de cara (0) o forat (1)
            out.println("0");
            out.println("3");
            out.println(t.getVertex1().getPosicio());
            out.println(t.getVertex2().getPosicio());
            out.println(t.getVertex3().getPosicio());
            out.println("0");
	    out.flush();
        }
      /*****************  VERTEXS  ***************/
      // vertex.x
      // vertex.y
      // vertex.z
      Sistema.sPrintln("TraductorBDG: Escrivint vertexs");
      for (i = 0; i < vertexs.size(); i++)
      {
         v = (Vertex)vertexs.elementAt(i);
         p = v.getPunt();
         out.println(s(p.x));
         out.println(s(p.y));
         out.println(s(p.z));
	 out.flush();
      }
      Sistema.sPrintln("TraductorBDG: Escrivint materials");
      try {
      materials(new PrintWriter(new FileWriter("material.dat")));
      } catch (Exception e1) {System.out.println(e);}
      
    }
    
   private void calculaNormal(Triangle t, PrintWriter out)
   {
      Pt3D p1, p2, p3, n, b;
      double d, mod;
      
      p1 = t.getVertex1().getPunt();
      p2 = t.getVertex2().getPunt();
      p3 = t.getVertex3().getPunt();
      
      n = new Pt3D();
      b = new Pt3D();
      n.x = (p1.z + p2.z)*(p1.y - p2.y);
      n.x += (p2.z + p3.z)*(p2.y - p3.y);
      n.x += (p1.z + p3.z)*(p3.y - p1.y);

      n.y = (p1.x + p2.x)*(p1.z - p2.z);
      n.y += (p2.x + p3.x)*(p2.z - p3.z);
      n.y += (p3.x + p1.x)*(p3.z - p1.z);

      n.z = (p1.y + p2.y)*(p1.x - p2.x);
      n.z += (p2.y + p3.y)*(p2.x - p3.x);
      n.z += (p3.y + p1.y)*(p3.x - p1.x);

      b.x = (p1.x + p2.x + p3.x) * 1/3;
      b.y = (p1.y + p2.y + p3.y) * 1/3;
      b.z = (p1.z + p2.z + p3.z) * 1/3;

      mod = n.getRadi();
      n.x /= mod;
      n.y /= mod;
      n.z /= mod;

      d = -(n.x * b.x + n.y * b.y + n.z * b.z);

      out.println(s(n.x));
      out.println(s(n.y));
      out.println(s(n.z));
      out.println(s(d));
   }
   
   private String s(double d)
   {
      String neg;
      int e, dec;
      
      if (d < 0) { d = -d; neg = "-"; } else neg = "";
      e = (int)d;
      dec = (int) (d*100.0);
      dec %= 100;
      if (dec < 10)
         return neg + e + ".0" + dec;
      else
         return neg + e + "." + dec;
   }
   
   private void materials(PrintWriter out)
   {
      int i = 0;
      Enumeration e;
      Color c;

      if (colors != null)
      {
	 i = colors.size();
         out.println(i);
	 for(e = colors.keys(); e.hasMoreElements();)
         {
            c = (Color)e.nextElement();
            out.println((String)colors.get(c));
            out.println(s(c.getRed()/255.0));
            out.println(s(c.getGreen()/255.0));
            out.println(s(c.getBlue()/255.0));
            out.println(1.0);
            out.println(1.0);
            out.println(1.0);
            out.println(0.8);
            out.println(0.8);
            out.println(0.2);
            out.println(50.0);
            out.println(0.0);
            out.println(1.0);
            out.println(0.0);
	    out.flush();
         }
      }
      else throw new RuntimeException("No hi ha materials");
      if (i < 1)
         throw new RuntimeException("No s'han definit colors");
      out.close();
   }
   
   private String afegirColor(Color c)
   {
      String nomColor;
      int n;
      
      if (colors == null) colors = new Hashtable();
      nomColor = (String)colors.get(c);
      if (nomColor == null)
      {
         n = colors.size() + 1;
         nomColor = "COLOR" + n;
         colors.put(c, nomColor);
      }
      return nomColor;
   }
}