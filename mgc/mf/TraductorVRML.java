package mgc.mf;

import java.util.Enumeration;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.awt.Color;

public class TraductorVRML implements Traductor
{
   private double xmax, ymax, zmax;

	private void afegirPunts(double radi, PrintWriter out)
	{
	   Pt3D p;
	   int i;
	   double signe, x, y, z;

      out.println("Transform");
      out.println("{");
      out.println("   children");
      out.println("   Shape");
      out.println("   {");
      out.println("      appearance Appearance");
      out.println("      {");
      out.println("         material Material");
      out.println("         {");
      out.println("            emissiveColor 1 1 1");
      out.println("         }");
      out.println("      }");
      out.println("      geometry");
      out.println("      PointSet");
      out.println("      {");
      out.println("          coord");
      out.println("          Coordinate");
      out.println("          {");
      out.println("             point[");
for (i = 0; i < 5000; i++)
{
   x = Math.random();
   signe = Math.random();
   if (signe < 0.5) x = -x;

   y = Math.random();
   signe = Math.random();
   if (signe < 0.5) y = -y;

   z = Math.random();
   signe = Math.random();
   if (signe < 0.5) z = -z;

   p = new Pt3D(x, y, z);
   p.setRadi(radi);
   out.println(s(p.x) + " " + s(p.y) + " " + s(p.z) + ",");
}
   p = new Pt3D(Math.random(), Math.random(), Math.random());
   p.setRadi(radi);
   out.println(s(p.x) + " " + s(p.y) + " " + s(p.z));
      out.println("             ]");
      out.println("          }");
      out.println("      }");
      out.println("   }");
      out.println("}");
	}

	private void afegirTextura(Textura t, PrintWriter out)
	{
		Color c;

		out.println("      appearance Appearance");
		out.println("    {");
		out.println("         material Material");
		out.println("         {");
   
		if (t != null)
		{
			c = t.getColor();
			out.print("           diffuseColor ");
			out.println(s(c.getRed()/255.0) + " " + s(c.getGreen()/255.0) + " " +
			   s(c.getBlue()/255.0));
		}
		else out.println("        diffuseColor 0.612 0.478 0.329");
		out.println("         }"); //END Appearance
		out.println("      }"); //END Material
	}

	private void afegirTexturaVertexs(Enumeration e, PrintWriter out)
	{
		int i = 0;
		Vertex v;
		Color c;

        Sistema.sPrintln("TraductorVRML: Texturant vertexs");
		out.println("           color");
		out.println("           Color");
		out.println("           {");
		out.println("              color [");

		v = (Vertex)e.nextElement();
		v.setPosicio(i);
		c = v.getTextura().getColor();
		out.print(s(c.getRed()/255.0) + " " + s(c.getGreen()/255.0) + " " +
		   s(c.getBlue()/255.0));

		while ( e.hasMoreElements() )
		{
			i++;
			v = (Vertex)e.nextElement();
			v.setPosicio(i);
			c = v.getTextura().getColor();
			out.println(",");
			out.print(s(c.getRed()/255.0) + " " + s(c.getGreen()/255.0) + " " +
			   s(c.getBlue()/255.0));
	   }
		out.println();
		out.println("                    ]");
		out.println("           }"); //END Color
        out.flush();
	}

	private void capsaleraVRML(PrintWriter out)
	{
		out.println("#VRML V2.0 utf8");
		out.println();
   
		out.println("WorldInfo");
		out.println("{");
		out.println("title \"Planetes Fractals\"");
		out.println("info [\"David Rodenas, Jordi Camps, Pau Ortega 2001\"]");
		out.println("}");
	}

	private void coordVertexs(Enumeration e, PrintWriter out)
	{
		Vertex v;
		Pt3D p;

		out.println("           coord");
		out.println("           Coordinate");
		out.println("           {");
		out.println("               point[");

        Sistema.sPrintln("TraductorVRML: Escrivint vertexs");
		v = (Vertex)e.nextElement();
		p = v.getPunt();
		out.print(s(p.x) +" "+ s(p.y) +" "+ s(p.z));
		if (xmax < p.x) xmax = p.x;
		if (ymax < p.y) ymax = p.y;
		if (zmax < p.z) zmax = p.z;
		
		while ( e.hasMoreElements() )
		{
			v = (Vertex)e.nextElement();
			p = v.getPunt();
			out.println(",");
   		out.print(s(p.x) +" "+ s(p.y) +" "+ s(p.z));
   		if (xmax < p.x) xmax = p.x;
   		if (ymax < p.y) ymax = p.y;
   		if (zmax < p.z) zmax = p.z;
		}

		out.println();
		out.println("                    ]");
		out.println("           }"); //END Coordinate
        out.flush();
	}

	private void indexVertexs(Enumeration e, PrintWriter out)
	{
		Triangle t;

        Sistema.sPrintln("TraductorVRML: Escrivint triangles");
		out.println("               coordIndex [ ");
		t = (Triangle)e.nextElement();
		out.print(t.getVertex1().getPosicio() + ", ");
		out.print(t.getVertex2().getPosicio() + ", ");
		out.print(t.getVertex3().getPosicio());

		while ( e.hasMoreElements() )
		{
			t = (Triangle)e.nextElement();
			out.println(", -1,");
			out.print(t.getVertex1().getPosicio() + ", ");
			out.print(t.getVertex2().getPosicio() + ", ");
			out.print(t.getVertex3().getPosicio());
		}
		out.println();
		out.println("                          ]");
        out.flush();
	}

	public void traduir (Objecte obj, PrintWriter out)
	{
		xmax = 0.0;
		ymax = 0.0;
		zmax = 0.0;
		double rMax = 0.0;

		capsaleraVRML(out);

		out.println("NavigationInfo");
		out.println("{");
		out.println("   type \"EXAMINE\"");
		out.println("}");
		out.println("DEF Objecte Transform");
		out.println("{");
		out.println("   children");
		out.println("   Shape");
		out.println("   {");

		afegirTextura(obj.getTextura(), out);
		out.flush();

		out.println("       geometry");
		out.println("       IndexedFaceSet");
		out.println("       {");
		out.println("          creaseAngle 0.611");
		
		afegirTexturaVertexs(obj.getVertexs(), out);
		out.flush();

		coordVertexs(obj.getVertexs(), out);
		out.flush();

		indexVertexs(obj.getTriangles(), out);
		out.flush();

		out.println("       }"); //END IndexedFaceSet
		out.println("   }"); //END Shape
		out.println("}"); //END Transform

		rMax = Math.max(xmax, ymax);
		rMax = Math.max(rMax, zmax);
		afegirPunts(50.0 * rMax, out);

		rMax = rMax + 2.5 * rMax;

		out.println("DirectionalLight");
		out.println("{");
		out.println("   direction -1 0 -1");
		out.println("}");

		out.println("Viewpoint");
		out.println("{");
		out.println("  description \"View 1\"");
		out.println("  position 0.0 0.0 " + s(rMax));
		out.println("}");

		out.println("Viewpoint");
		out.println("{");
		out.println("  description \"View 2\"");
		out.println("  position 0.0 " + s(rMax) + " 0.0");
		out.println("  orientation  1 0 0 -1.57");
		out.println("}");

		out.println("Viewpoint");
		out.println("{");
		out.println("  description \"View 3\"");
		out.println("  position " + s(rMax) + " 0.0 0.0");
		out.println("  orientation 0 1 0 1.57");
		out.println("}");

		out.println("DEF rellotge TimeSensor");
		out.println("{");
		out.println("   enabled TRUE");
		out.println("   cycleInterval 60");
		out.println("   loop TRUE");
		out.println("}");

		out.println("DEF animador OrientationInterpolator");
		out.println("{");
		out.println("   key [ 0 ,0.5 ,1 ]");
		out.println("   keyValue [ 0 1 0 0 ,0 1 0 3.14 ,0 1 0 6.28 ]");
		out.println("}");

		out.println("ROUTE animador.value_changed TO Objecte.set_rotation");
		out.println("ROUTE rellotge.fraction_changed TO animador.set_fraction");
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
}
