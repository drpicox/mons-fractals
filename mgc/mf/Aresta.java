package mgc.mf;

public
class Aresta
implements java.io.Serializable
{

   private Vertex vertex1, vertex2;
   private Objecte objecte;
   private Triangle t1, t2;
   
	/*
	Part auxiliar per als talls del fractalitzat.
	 */
	private transient Aresta arestaPartit1;
	private transient Aresta arestaPartit2;
	private transient Vertex vertexNou;

	public Aresta ( Objecte objecte, Aresta a1, Aresta a2 ) {
		Vertex vComu, v1, v2, vA, vB;
		
		vComu = a1.vertexComu(a2);
		vA = a1.getVertex1();
		if (vA != vComu)
			v1 = vA;
		else
			v1 = a1.getVertex2();
			
		vB = a2.getVertex1();
		if (vB != vComu)
			v2 = vB;
		else
			v2 = a2.getVertex2();
			
		vertex1 = v1;
		vertex2 = v2;
		this.objecte = objecte;
		objecte.addAresta(this);
	}
	public Aresta ( Objecte objecte, Vertex vertex1, Vertex vertex2 ) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		objecte.addAresta(this);
		this.objecte = objecte;
	}
	public void addTriangle(Triangle t)
	{
		if (t1 == null)
			{ t1 = t; }
		else if (t2 == null)
			{ t2 = t; }
		else
			throw new RuntimeException("Una aresta pot tenir maxim de dos triangles"); 
	}
	public boolean containsTriangle ( Triangle t ) {
		return ( t == t1 || t == t2 );
	}
	public Aresta getArestaPartit1() 
	{ 
		if (arestaPartit1 == null)
			  arestaPartit1 = new Aresta
			  	(objecte, vertex1, vertexNou);
			  	
		return arestaPartit1; 
	}
	public Aresta getArestaPartit2() 
	{
		if (arestaPartit2 == null)
			  arestaPartit2 = new Aresta
			  	(objecte, vertex2, vertexNou);

		return arestaPartit2; 
	}
/**
 * Insert the method's description here.
 * Creation date: (09/01/01 12:59:19)
 * @return mgc.mf.Objecte
 */
public Objecte getObjecte() {
	return objecte;
}
	public Triangle getT1 ( ) {
		return t1;
	}
	public Triangle getT2 ( ) {
		return t2;
	}
	public Vertex getVertex1 ( ) {
		return vertex1;
	}
	public Vertex getVertex2 ( ) {
		return vertex2;
	}
	public Vertex getVertexPartir() { return vertexNou; }
	public Pt3D interpolacio(double p)
	{
		Pt3D punt, pv1, pv2;
		double p1;
		
		pv1 = vertex1.getPunt ( );
		pv2 = vertex2.getPunt ( );
		p1 = 1 - p;
		
		punt = new Pt3D ( );

		punt.x = pv1.x * p1 + pv2.x * p;
		punt.y = pv1.y * p1 + pv2.y * p;
		punt.z = pv1.z * p1 + pv2.z * p;
		
		return punt;
	}
	public double longitut ( )
	{
		Pt3D pv1, pv2;
		double x, y, z;
		
		pv1 = vertex1.getPunt ( );
		pv2 = vertex2.getPunt ( );
		
		x = pv2.x - pv1.x;
		y = pv2.y - pv1.y;
		z = pv2.z - pv1.z;
		
		x *= x;
		y *= y;
		z *= z;
		 
		return Math.sqrt(x + y + z);
	}
	public double longitut2 ( )
	{
		Pt3D pv1, pv2;
		double x, y, z;
		
		pv1 = vertex1.getPunt ( );
		pv2 = vertex2.getPunt ( );
		
		x = pv2.x - pv1.x;
		y = pv2.y - pv1.y;
		z = pv2.z - pv1.z;
		
		x *= x;
		y *= y;
		z *= z;
		 
		return x + y + z;
	}
	public boolean partida()
	{
		return vertexNou != null;
	}
	public void removeTriangle(Triangle t)
	{
		if (t1 == t)
			t1 = null;
		else if (t2 == t)
			t2 = null;
		else
		  throw new RuntimeException
						   ("Nomes es pot treure un triangle de l'aresta"); 
	}
/**
 * Insert the method's description here.
 * Creation date: (09/01/01 12:59:19)
 * @param newObjecte mgc.mf.Objecte
 */
public void setObjecte(Objecte newObjecte) {
	objecte = newObjecte;
}
	public void setT1 ( Triangle t1 ) {
		this.t1 = t1;
	}
	public void setT2 ( Triangle t2 ) {
		this.t2 = t2;
	}
	public void setVertex1 ( Vertex v ) {
		vertex1 = v;
	}
	public void setVertex2 ( Vertex v ) {
		vertex2 = v;
	}
	public void setVertexPartir(Vertex vertexNou)
	{
	  if (this.vertexNou != null)
		throw new RuntimeException("Vertex nou ja assignat");
	 
	  this.vertexNou = vertexNou;
	}
	public String toString()
	{
		return "[Aresta " + hashCode() + "]";
	}
	public void validar ( ) {
		if ( vertex1 == null || vertex2 == null ) {
			throw new ObjecteInvalid 
						   ( "Cap vertex de l'aresta pot ser nul" );
		}		
		if (vertex1 == vertex2)
			throw new ObjecteInvalid
				("L'aresta no pot tenir dos vegades el mateix vertex");
		if (!objecte.containsVertex(vertex1) ||
			!objecte.containsVertex(vertex2))
			throw new ObjecteInvalid
				("L'objecte te que contenir els vertexs de l'aresta");
		if ( t1 == null || t2 == null ) {
			throw new ObjecteInvalid 
						  ( "Cap triangle de l'aresta pot ser nul" );
		}
		if (t1 == t2)
			throw new ObjecteInvalid
				("L'aresta no pot tindre dos vegades el mateix vertex");
		if (!objecte.containsTriangle(t1) ||
			!objecte.containsTriangle(t2))
			throw new ObjecteInvalid
				("L'aresta conte un triangle que no es a l'objecte");
		
		if (!t1.containsAresta ( this ) || 
			!t2.containsAresta ( this ) ) 
			throw new ObjecteInvalid 
			   ("Els triangles de l'aresta han de contenir les arestes");
			  
		if (t1.sentitArestaInvertit(this) ==
			t2.sentitArestaInvertit(this))
			throw new ObjecteInvalid
				("El sentit de les arestes te que estar invertit en " +
				 "un triangle i no invertit en l'altre");
	}
	public Vertex vertexComu ( Aresta a ) {
		if ( vertex1 == a.vertex1	|| vertex1 == a.vertex2 )
			return vertex1;
		else if ( vertex2 == a.vertex1 || vertex2 == a.vertex2 )
			return vertex2;
		else
			return null;
	}
}
