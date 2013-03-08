package mgc.mf.gui;

import java.awt.*;

/**
 * Insert the type's description here.
 * Creation date: (15/01/01 07:59:22)
 * @author: David Rodenas Pico
 */
public 
class Finestra 
extends Frame 
{
    private static Finestra defecte;
    
    /**
     * Finestra constructor comment.
     */
    public Finestra() {
        super();
        if (defecte == null)
            defecte = this;
    }

    /**
     * Finestra constructor comment.
     * @param title java.lang.String
     */
    public Finestra(String title) {
        super(title);
        if (defecte == null)
            defecte = this;
    }

    public static Finestra sGetDefecte()
    {
        return defecte;
    }
}
