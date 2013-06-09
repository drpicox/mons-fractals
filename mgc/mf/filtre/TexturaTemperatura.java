package mgc.mf.filtre;

import java.awt.Color;
import java.util.Enumeration;
import java.util.Random;
import java.util.Vector;

import mgc.mf.*;

/**
 * Filtre que coloritza un objecte.
 */
public
class TexturaTemperatura
extends FiltreNul
{

  private static final Color glac = new Color ( 217, 249, 255 );
  private static final Color pedraFosca = new Color ( 47, 47, 28 );
  private static final Color pedraClara = new Color ( 177, 160, 143 );
  private static final Color boscFosc = new Color ( 67, 88, 37 );
  private static final Color boscMig = new Color ( 79, 172, 51 );
  private static final Color boscClar = new Color ( 163, 231, 61 );
  private static final Color boscMarro = new Color ( 169, 160, 54 );
  private static final Color vermellMart = new Color ( 252, 64, 10 );
  private static final Color magmaFred = new Color ( 90, 12, 12 );
  private static final Color magmaNormal = new Color ( 222, 73, 10 );
  private static final Color magmaCalent = new Color ( 231, 203, 5 );
  private static final Color blancGrogos = new Color ( 254, 247, 194 );
  private static final Color blancBlavos = new Color ( 194, 254, 231 );
  private static final Color blanc = new Color ( 255, 255, 255 );
  private static final Color sorra = new Color ( 218, 190, 80 );

  private transient Random random;
  private static transient Color[][] colors = {
    { glac, pedraFosca, sorra },             // 220
    { sorra, glac, pedraFosca },             // 273
    { boscMig, boscFosc, pedraFosca },       // 283
    { boscClar, boscMig, pedraFosca },       // 293
    { boscMarro, boscClar, sorra },          // 303
    { boscClar, boscMarro, sorra },          // 323
    { pedraFosca, sorra, boscMarro },        // 373
    { sorra, pedraClara, vermellMart },      // 473
    { pedraFosca, pedraClara, sorra },       // 1000
    { magmaNormal, magmaFred, pedraFosca },  // 2000
    { magmaCalent, magmaNormal, magmaFred }, // 2500
    { magmaNormal, magmaCalent, magmaFred }, // 5000
    { magmaCalent, blancGrogos, magmaCalent }, // 5500
    { blancGrogos, blancBlavos, blanc }      // oo
  };
  
  public TexturaTemperatura()
  {
  	super();
  }

  public Objecte filtrar(Objecte objecte)
  {
    Vertex vertex;
    Enumeration enumVertexs;
    Textura textura;
    Color color;
    
    Sistema.sPrintln("Aplicant filtre coloritzar per temperatura");

    enumVertexs = objecte.getVertexs();
    while (enumVertexs.hasMoreElements())
    {
      vertex = (Vertex)enumVertexs.nextElement();
      textura = vertex.getTextura ( );
      color = aleatoritzarColor ( textura.getTemperatura(),
                                  textura.getTipusSuperficie() );
      textura.setColor(color);
    } // while
	
    return objecte;   
  }
  
  protected Color aleatoritzarColor ( int dTemp, double dSup ) {
    Color color;
    int cTemp, cSup;
    int r, g, b;
    char max;
    
    cTemp = indexTemperatura ( dTemp );
    cSup  = indexTS ( dSup );
    color = colors[cTemp][cSup];
    
    r = color.getRed ( );
    g = color.getGreen ( );
    b = color.getBlue ( );
    max = maxim ( r, g, b );
    switch ( max ) {
      case 'r':
        r = r + (int)( Math.min ( r, 255 - r ) * dSup / 5 );
        g = g - (int)( Math.min ( g, 255 - g ) * dSup / 5 );
        b = b - (int)( Math.min ( b, 255 - b ) * dSup / 5 );
        break;
      case 'g':
        r = r - (int)( Math.min ( r, 255 - r ) * dSup / 5 );
        g = g + (int)( Math.min ( g, 255 - g ) * dSup / 5 );
        b = b - (int)( Math.min ( b, 255 - b ) * dSup / 5 );
        break;
      case 'b':
        r = r - (int)( Math.min ( r, 255 - r ) * dSup / 5 );
        g = g - (int)( Math.min ( g, 255 - g ) * dSup / 5 );
        b = b + (int)( Math.min ( b, 255 - b ) * dSup / 5 );
        break;
    }
    
    color = new Color ( r, g, b );
    
    return color;
  }

  protected int indexTS ( double ts ) {
    if ( ts < 0.3 )
      return 0;
    if ( ts > 0.8 )
      return 2;
    return 1;
  }

  protected int indexTemperatura ( int tmp ) {
    int[] taula = { 220, 273, 283, 293, 303, 323, 373, 473, 1000, 2000, 2500, 5000, 5500 };
    int i;

    i = 0;
    for (; i < taula.length; i++)
        if (tmp < taula[i])
            return i;
    return i;
  }

  protected char maxim ( int r, int g, int b ) {
    if ( r >= g && r >= b )
      return 'r';
    if ( g >= r && g >= b )
      return 'g';
    return 'b';
  }

}
