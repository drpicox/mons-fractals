package mgc.mf.filtre;

import java.awt.Color;
import mgc.mf.*;

/**
 * Aplicacio d'un radi minim.
 * Creation date: (12/01/01 03:27:49)
 * @author: David Rodenas Pico
 */
public 
class ParametresMar
extends ParametresRadiMinim 
{

    private Color color1, color2;

    public ParametresMar()
    {
        super();
        color1 = Color.blue;
        color2 = Color.cyan;
    }

    public Color getColor1 ( ) {
        return color1;
    }
    
    public Color getColor2 ( ) {
        return color2;
    }
    
    public void setColor1 ( Color c ) {
        color1 = c;
    }
    
    public void setColor2 ( Color c ) {
        color2 = c;
    }
    
    public int getColor1Red ( ) {
        return color1.getRed ( );
    }
    
    public int getColor1Green ( ) {
        return color1.getGreen ( );
    }
    
    public int getColor1Blue ( ) {
        return color1.getBlue ( );
    }
    
    public int getColor2Red ( ) {
        return color2.getRed ( );
    }
    
    public int getColor2Green ( ) {
        return color2.getGreen ( );
    }
    
    public int getColor2Blue ( ) {
        return color2.getBlue ( );
    }
    
    public void setColor1Red ( int c ) {
        if ( c < 0 )
            c = 0;
        if ( c > 255 )
            c = 255;
        color1 = new Color ( c, color1.getGreen ( ), color1.getBlue ( ) );
    }
    
    public void setColor1Green ( int c ) {
        if ( c < 0 )
            c = 0;
        if ( c > 255 )
            c = 255;
        color1 = new Color ( color1.getRed ( ), c, color1.getBlue ( ) );
    }
    
    public void setColor1Blue ( int c ) {
        if ( c < 0 )
            c = 0;
        if ( c > 255 )
            c = 255;
        color1 = new Color ( color1.getRed ( ), color1.getGreen ( ), c );
    }
    
    public void setColor2Red ( int c ) {
        if ( c < 0 )
            c = 0;
        if ( c > 255 )
            c = 255;
        color2 = new Color ( c, color2.getGreen ( ), color2.getBlue ( ) );
    }
    
    public void setColor2Green ( int c ) {
        if ( c < 0 )
            c = 0;
        if ( c > 255 )
            c = 255;
        color2 = new Color ( color2.getRed ( ), c, color2.getBlue ( ) );
    }
    
    public void setColor2Blue ( int c ) {
        if ( c < 0 )
            c = 0;
        if ( c > 255 )
            c = 255;
        color2 = new Color ( color2.getRed ( ), color2.getGreen ( ), c );
    }

}
