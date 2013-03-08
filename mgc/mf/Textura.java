package mgc.mf;

import java.awt.Color;

/**
 * Informacio sobre la textura dels objectes.
 * <p>
 *
 * Una textura null sempre sera una textura buida 
 * traspasable.
 */

public 
class Textura 
implements java.io.Serializable
{
  private Color color;
  private double tipusSuperficie;
  private float alfa;
  private int temperatura;
	
  public Textura()
  {
	color = Color.green;
  }      
  public Color getColor() { return color; }      
  public double getTipusSuperficie() { return tipusSuperficie; }    
    
  public void interpolar(Textura textura1, Textura textura2, double proporcio)
  {
	Color color1, color2;
	double r, g, b;
	float a, alfa1, alfa2;
	double tipusSup;
	double p, p1;
	
	p = proporcio;
	p1 = 1 - proporcio;
	
	color1 = textura1.color;
	color2 = textura2.color;    
	alfa1  = textura1.alfa;
	alfa2  = textura2.alfa; 

	tipusSup = textura1.tipusSuperficie * p1 + textura2.tipusSuperficie * p;
	tipusSuperficie = tipusSup;
	
	a = (float)(alfa1 * p1 + alfa2 * p);
	alfa = a;

	r = color1.getRed() * p1 + color2.getRed() * p;
	b = color1.getBlue() * p1 + color2.getBlue() * p;
	g = color1.getGreen() * p1 + color2.getGreen() * p;
		
	if (r < 0) r = 0;
	if (b < 0) b = 0;
	if (g < 0) g = 0;
	if (r > 255) r = 255;
	if (b > 255) b = 255;
	if (g > 255) g = 255;
	
	color = new Color((int)r, (int)g, (int)b);
  }          

  public void setColor(Color color)
  { this.color = color; }      

  public void setColor(int red, int green, int blue)
  {
    if (red < 0) red = 0;
    if (blue < 0) blue = 0;
    if (green < 0) green = 0;
    if (red > 255) red = 255;
    if (blue > 255) blue = 255;
    if (green > 255) green = 255;
    
    color = new Color(red, green, blue);
  }

  public void setColor(float red, float green, float blue)
  {
    if (red < 0) red = 0.0f;
    if (blue < 0) blue = 0.0f;
    if (green < 0) green = 0.0f;
    if (red > 1.0f) red = 1.0f;
    if (blue > 1.0f) blue = 1.0f;
    if (green > 1.0f) green = 1.0f;
    
    color = new Color(red, green, blue);
  }

  public void setTipusSuperficie(double tipusSuperficie) 
  { this.tipusSuperficie = tipusSuperficie; }      

  public String toString ( ) {
	return "[Textura: color=" + color + "; tipusSuperficie=" + tipusSuperficie + "]";
  }      

  public void setAlfa(double alfa)
  { this.alfa = (float)alfa; }
  public void setAlfa(float alfa)
  { this.alfa = (float)alfa; }
  public float getAlfa (float alfa)
  { return alfa; }

  public void setTemperatura(int temperatura)
  {
  if (temperatura < 0) temperatura = 0;
  this.temperatura = temperatura;
  }
  
  public int getTemperatura()
  { return temperatura; }
}
