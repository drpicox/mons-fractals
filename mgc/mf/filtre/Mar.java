package mgc.mf.filtre;

import java.awt.Color;
import java.util.Enumeration;

import mgc.mf.*;
import mgc.mf.Objecte;

/**
 * Crea un mar sobre tots els objectes.
 * Creation date: (12/01/01 03:27:02)
 * @author: David Rodenas Pico
 */
public
class Mar
extends RadiMinim
{
    
    protected transient Color color1, color2;

    public Mar()
    {
        super();
    }

    /**
     * filtrar method comment.
     */
    public Objecte filtrar(Objecte objecte) 
    {
        ParametresMar parametresMar;
        Enumeration enumArestes;
        Enumeration enumVertexs;
        Vertex vertex, v1, v2;
        Aresta aresta;
        Textura text;
        Pt3D p1, p2, punt;
        double radi, r1, r2, tipusSuperficie, rLimit;
        int r, g, b;

        Sistema.sPrintln("Aplicant filtre Mar");

        parametresMar = (ParametresMar)getParametresFiltre ( );
        radi = parametresMar.getRadiMinim ( );
        color1 = parametresMar.getColor1 ( );
        color2 = parametresMar.getColor2 ( );

        enumArestes = objecte.getArestes ( );
        while ( enumArestes.hasMoreElements ( ) )
        {
            aresta = (Aresta)enumArestes.nextElement ( );
            v1 = aresta.getVertex1 ( );
            v2 = aresta.getVertex2 ( );
            p1 = v1.getPunt ( );
            p2 = v2.getPunt ( );
            r1 = p1.getRadi ( );
            r2 = p2.getRadi ( );
            if ( r1 > radi  && r2 < radi )
            {
                punt = new Pt3D ( p2 );
                punt.setRadi ( radi );
                vertex = new Vertex ( objecte, punt );
                text = calcularTextura ( v1.getTextura ( ), v2.getTextura ( ), ( radi - r2 ) / ( r1 - r2 ) );
                vertex.setTextura ( text );
                aresta.setVertexPartir ( vertex );
            }
            else if ( r1 < radi  && r2 > radi )
            {
                punt = new Pt3D ( p1 );
                punt.setRadi ( radi );
                vertex = new Vertex ( objecte, punt );
                text = calcularTextura ( v1.getTextura ( ), v2.getTextura ( ), ( radi - r1 ) / ( r2 - r1 ) );
                vertex.setTextura ( text );
                aresta.setVertexPartir ( vertex );
            }
        }
        
        objecte.partirTriangles ( );

        Sistema.sPrintln("Aplicant alcada al mar.");
        super.filtrar(objecte);

        Sistema.sPrintln("Acolorint el mar.");
        enumVertexs = objecte.getVertexs ( );
        while ( enumVertexs.hasMoreElements ( ) )
        {
            vertex = (Vertex)enumVertexs.nextElement ( );
            punt = vertex.getPunt ( );
            radi *= 1.0000001;
            if ( punt.getRadi() <= radi )
            {
                punt.setRadi(radi);
                vertex.setTextura ( acolorir ( vertex.getTextura ( ) ) );
            }
        }

        return objecte;
    }
    
    protected Textura acolorir ( Textura text ) {
        double tipusSuperficie;
        int r, g, b;
        Color color;
        
        tipusSuperficie = text.getTipusSuperficie ( );
        r = (int)( color1.getRed ( ) * tipusSuperficie + color2.getRed ( ) * ( 1 - tipusSuperficie ) );
        g = (int)( color1.getGreen ( ) * tipusSuperficie + color2.getGreen ( ) * ( 1 - tipusSuperficie ) );
        b = (int)( color1.getBlue ( ) * tipusSuperficie + color2.getBlue ( ) * ( 1 - tipusSuperficie ) );
        color = new Color ( r, g, b );
        text.setColor ( color );
        
        return text;
    }
    
    protected Textura calcularTextura ( Textura t1, Textura t2, double percentatge ) {
        Textura text;

        text = new Textura ( );
        text.interpolar ( t1, t2, percentatge );
        text = acolorir ( text );
        
        return text;
    }

}
