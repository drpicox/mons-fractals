package mgc.mf.filtre;

import java.awt.Color;
import mgc.mf.*;

public class ParametresAfegirAnells extends ParametresNul
{
   private Color color;
   private int divisions;
   private double amplada, dist, gruix;

   public double getAmplada()
   {
      return amplada;
   }

   public double getDistancia()
   {
      return dist;
   }

   public double getGruix()
   {
      return gruix;
   }

   public Color getColor()
   {
      return color;
   }

   public int getDivisions()
   {
      return divisions;
   }

   public void setAmplada(double w)
   {
      amplada = w;
   }

   public void setDistancia(double d)
   {
      dist = d;
   }

   public void setGruix(double h)
   {
      gruix = h;
   }

   public void setColor(Color c)
   {
      color = c;
   }

   public void setDivisions(int d)
   {
      divisions = d;
   }
}