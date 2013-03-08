package mgc.mf;

import java.util.*;

public
class Objecte
implements java.io.Serializable
{

	private Hashtable vertexs, arestes, triangles;
    private Textura textura;

    /**
     * Es fusiona amb un altre objecte,
     * l'altre objecte queda inservible.
     */
    public void fusionar(Objecte objecte)
    {
    Enumeration enumVertexs;
    Enumeration enumArestes;
    Enumeration enumTriangles;

    enumVertexs = objecte.getVertexs();
    enumArestes = objecte.getArestes();
    enumTriangles = objecte.getTriangles();

    Vertex vertex;
    while (enumVertexs.hasMoreElements())
        {
        vertex = (Vertex)enumVertexs.nextElement();
        addVertex(vertex);
        } // while

    Aresta aresta;
    while (enumArestes.hasMoreElements())
        {
        aresta = (Aresta)enumArestes.nextElement();
        addAresta(aresta);
        aresta.setObjecte(this);
        } // while

    Triangle triangle;
    while (enumTriangles.hasMoreElements())
        {
        triangle = (Triangle)enumTriangles.nextElement();
        addTriangle(triangle);
        triangle.setObjecte(this);
        } // while

    }

    private double radiMinim, radiMaxim;
    private Pt3D puntMinim, puntMaxim;

    public void calcularBoundingBox()
    {
    puntMinim.x = 1./.0;
    puntMinim.y = 1./.0;
    puntMinim.z = 1./.0;
    puntMaxim.x = -1./.0;
    puntMaxim.y = -1./.0;
    puntMaxim.z = -1./.0;
    radiMinim = 1./.0;
    radiMaxim = -1./.0;

    // Per tots els vertexs...
    Enumeration enumVertexs;
    Vertex vertex;
    Pt3D punt;
    double radi;

    enumVertexs = getVertexs();
    while (enumVertexs.hasMoreElements())
        {
        vertex = (Vertex)enumVertexs.nextElement();
        punt = vertex.getPunt();
        radi = punt.getRadi();
        if (radiMinim > radi) radiMinim = radi;
        if (radiMaxim < radi) radiMaxim = radi;
        if (puntMinim.x > punt.x) puntMinim.x = punt.x;
        if (puntMinim.y > punt.y) puntMinim.y = punt.y;
        if (puntMinim.z > punt.z) puntMinim.z = punt.z;
        if (puntMaxim.x < punt.x) puntMaxim.x = punt.x;
        if (puntMaxim.y < punt.y) puntMaxim.y = punt.y;
        if (puntMaxim.z < punt.z) puntMaxim.z = punt.z;
        } // while
    }

    public double getRadiMinim()
    { return radiMinim; }
    public double getRadiMaxim()
    { return radiMaxim; }
    public Pt3D getPuntMinim()
    { return puntMinim; }
    public Pt3D getPuntMaxim()
    { return puntMaxim; }

    
    public Objecte ( ) {
        vertexs = new Hashtable ( );
        arestes = new Hashtable ( );
        triangles = new Hashtable ( );
                puntMinim = new Pt3D();
                puntMaxim = new Pt3D();
    }
    public void addAresta ( Aresta a ) {
        if (arestes.put ( a, a ) != null)
                  throw new RuntimeException
                    ("No es pot afegir una aresta que ja hi es");
    }
    public void addTriangle ( Triangle t ) {
        if (triangles.put ( t, t ) != null)
                  throw new RuntimeException
                    ("No es pot afegir un triangle que ja hi es");
    }
    public void addVertex ( Vertex v ) {
        if (vertexs.put ( v, v ) != null)
                  throw new RuntimeException
                    ("No es pot afegir un vertex que ja hi es");
    }
    public boolean containsAresta ( Aresta a ) {
        return arestes.containsKey(a);
    }
    public boolean containsTriangle ( Triangle t ) {
        return triangles.containsKey(t);
    }
    public boolean containsVertex ( Vertex v ) {
        return vertexs.containsKey(v);
    }
    public Enumeration getArestes ( ) {
        return arestes.elements ( );
    }
    public int getNumArestes ( ) {
        return arestes.size ( );
    }
    public int getNumTriangles ( ) {
        return triangles.size ( );
    }
    public int getNumVertexs ( ) {
        return vertexs.size ( );
    }
        public Textura getTextura()
        { return textura; }
    public Enumeration getTriangles ( ) {
        return triangles.elements ( );
    }
    public Enumeration getVertexs ( ) {
        return vertexs.elements ( );
    }
    /**
     * Parteix les arestes de l'objecte.
     */
    public void partirTriangles()
    {
        Enumeration enumTriangles;
        Vector triangles;
        Triangle triangle;
        Object obj;
    
        enumTriangles = getTriangles();
        triangles = new Vector(256, 0);
        while (enumTriangles.hasMoreElements())
        {
            obj = enumTriangles.nextElement();
            triangles.addElement(obj);
        } // while
        enumTriangles = triangles.elements();
        while (enumTriangles.hasMoreElements())
        {
            triangle = (Triangle)enumTriangles.nextElement();
            triangle.partirTriangle();
        } // while
    }

    public void removeAresta ( Aresta a ) {
        arestes.remove ( a );
    }

    public void removeTriangle ( Triangle t ) {
        triangles.remove ( t );
    }

    public void removeVertex ( Vertex v ) {
        vertexs.remove ( v );
    }

    public void setTextura(Textura textura)
    { this.textura = textura; }

    public void validar ( ) {
        Enumeration e;
        Vertex v;
        Aresta a;
        Triangle t;
     
        for ( e = vertexs.elements ( ); e.hasMoreElements ( ); ) {
            v = (Vertex)e.nextElement ( );
            v.validar ( );
        }
     
        for ( e = arestes.elements ( ); e.hasMoreElements ( ); ) {
            a = (Aresta)e.nextElement ( );
            if ( a.getObjecte ( ) != this ) {
                throw new ObjecteInvalid ( "L'objecte no es el mateix que el assignat a la seva aresta." );
            }
            a.validar ( );
        }
     
        for ( e = triangles.elements ( ); e.hasMoreElements ( ); ) {
            t = (Triangle)e.nextElement ( );
            if ( t.getObjecte ( ) != this ) {
                throw new ObjecteInvalid ( "L'objecte no es el mateix que el assignat a un triangle." );
            }
            t.validar ( );
        }
     
    }


    }
