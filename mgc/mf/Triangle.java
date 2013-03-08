package mgc.mf;

public class Triangle {

   private Aresta a1, a2, a3;
   private Objecte obj;
   private transient Textura textura;
   
   public Triangle ( Objecte obj, Aresta a1, Aresta a2, Aresta a3 ) {
	  this.obj = obj;
	  this.a1 = a1;
	  this.a2 = a2;
	  this.a3 = a3;
	  a1.addTriangle(this);
	  a2.addTriangle(this);
	  a3.addTriangle(this);
	  obj.addTriangle(this);
   }         
	public Aresta anteriorAresta ( Aresta a ) {
		if ( a == a1 )
			return a3;
		else if ( a == a2 )
			return a1;
		else if (a == a3 )
			return a2;
		else
			return null;
	}
	public Aresta anteriorSemiaresta ( Aresta a ) {
		Aresta a1, aa;

		aa = anteriorAresta(a);
		a1 = aa.getArestaPartit1();
		if (a1.vertexComu(a) != null)
			return a1;
		
		return aa.getArestaPartit2();
	}
   public boolean containsAresta ( Aresta a ) {
	  return ( a == a1 || a == a2 || a == a3 );
   }         
   public Aresta getAresta1 ( ) {
	  return a1;
   }         
   public Aresta getAresta2 ( ) {
	  return a2;
   }         
   public Aresta getAresta3 ( ) {
	  return a3;
   }         
   public Objecte getObjecte ( ) {
	  return obj;
   }         
   public Textura getTextura ( ) 
   {
   	if (textura == null)
	{
	 textura = new Textura();
	 textura.interpolar(getVertex1().getTextura(),
	                    getVertex2().getTextura(), .5);
	 textura.interpolar(textura,
	                    getVertex3().getTextura(), .3);			    
	}
        return textura;
   }         
   public Vertex getVertex1 ( ) {
	  return a1.vertexComu ( a2 );
   }         
   public Vertex getVertex2 ( ) {
	  return a2.vertexComu ( a3 );
   }         
   public Vertex getVertex3 ( ) {
	  return a3.vertexComu ( a1 );
   }         
	/**
	 * Si cal es parteix el triangle.
	 */
	public void partirTriangle()
	{
		Aresta a1, a2, a3, as, ap;
		int cont;

		a1 = this.a1;
		a2 = this.a2;
		a3 = this.a3;
		cont = 0;
		as = null;
		ap = null;

		if (a1.partida()) { cont++; ap = a1; }
 		else as = a1;
		if (a2.partida()) { cont++; ap = a2; }
		else as = a2;
		if (a3.partida()) { cont++; ap = a3; }
		else as = a3;

		switch (cont)
		{
		case 1: partirTriangleEn2(ap); break;
		case 2: partirTriangleEn3(as); break;
		case 3: partirTriangleEn4(); break;
		default:
		}
	}
	protected void partirTriangleEn2(Aresta aPartida)
	{
		Aresta A, a1, a2, t, B, C;
		Triangle T1, T2;

		A = aPartida;
		B = seguentAresta(aPartida);
		C = seguentAresta(B);

		a1 = primeraSemiaresta(A);
		a2 = ultimaSemiaresta(A);

		obj.removeAresta(A);
		obj.removeTriangle(this);
		B.removeTriangle(this);
		C.removeTriangle(this);

		t = new Aresta(obj, B, a2);

		T1 = new Triangle(obj, a2, B, t);
		T2 = new Triangle(obj, a1, t, C);
	}
	protected void partirTriangleEn3(Aresta aSencera)
	{
		Aresta A, a1, a2, B, b1, b2, C, t1, t2;
		Triangle T1, T2, T3;

		A = seguentAresta(aSencera);
		B = seguentAresta(A);
		C = aSencera;

		a1 = primeraSemiaresta(A);
		a2 = ultimaSemiaresta(A);
		b1 = primeraSemiaresta(B);
		b2 = ultimaSemiaresta(B);

		obj.removeAresta(A);
		obj.removeAresta(B);
		obj.removeTriangle(this);
		C.removeTriangle(this);

		t1 = new Aresta(obj, a2, b1);
		t2 = new Aresta(obj, b2, C);

		T1 = new Triangle(obj, a2, b1, t1);
		T2 = new Triangle(obj, b2, C, t2);		
		T3 = new Triangle(obj, a1, t1, t2);		
	}
	protected void partirTriangleEn4()
	{
		Aresta A, a1, a2, 
		       B, b1, b2, 
		       C, c1, c2, 
		       t1, t2, t3;
		       
		Triangle T1, T2, T3, T4;

		A = this.a1;
		B = this.a2;
		C = this.a3;

		a1 = primeraSemiaresta(A);
		a2 = ultimaSemiaresta(A);
		b1 = primeraSemiaresta(B);
		b2 = ultimaSemiaresta(B);
		c1 = primeraSemiaresta(C);
		c2 = ultimaSemiaresta(C);

		obj.removeAresta(A);
		obj.removeAresta(B);
		obj.removeAresta(C);
		obj.removeTriangle(this);

		t1 = new Aresta(obj, a2, b1);
		t2 = new Aresta(obj, b2, c1);
		t3 = new Aresta(obj, c2, a1);

		T1 = new Triangle(obj, a2, b1, t1);
		T2 = new Triangle(obj, b2, c1, t2);		
		T3 = new Triangle(obj, c2, a1, t3);		
		T4 = new Triangle(obj, t1, t2, t3);	
	}
	public Aresta primeraSemiaresta ( Aresta a ) {
		Aresta a1, as;

		as = seguentAresta(a);
		a1 = a.getArestaPartit1();
		if (a1.vertexComu(as) != null)
			return a.getArestaPartit2();
		
		return a1;
	}
	public Aresta seguentAresta ( Aresta a ) {
		if ( a == a1 )
			return a2;
		else if ( a == a2 )
			return a3;
		else if (a == a3 )
			return a1;
		else
			return null;
	}
	public Aresta seguentSemiaresta ( Aresta a ) {
		Aresta a1, as;

		as = seguentAresta(a);
		a1 = as.getArestaPartit1();
		if (a1.vertexComu(a) != null)
			return a1;
		
		return as.getArestaPartit2();
	}
	public boolean sentitArestaInvertit ( Aresta aresta ) 
	{
		Aresta seguentAresta;
		Vertex comu;

		seguentAresta = seguentAresta(aresta);
		comu = aresta.vertexComu(seguentAresta);
		if (comu == aresta.getVertex2())
			return false;
		else
			return true;
	}
	public void setAresta1 ( Aresta aresta ) {
		a1 = aresta;
	}
	public void setAresta2 ( Aresta aresta ) {
		a2 = aresta;
	}
	public void setAresta3 ( Aresta aresta ) {
		a3 = aresta;
	}
	public void setObjecte ( Objecte obj ) {
		this.obj = obj;
	}
	public void setTextura ( Textura textura ) {
		this.textura = textura;
	}
   private boolean tancat ( ) {
	  Vertex v1, v2, v3;
	  
	  v1 = a1.vertexComu ( a2 );
	  v2 = a2.vertexComu ( a3 );
	  v3 = a3.vertexComu ( a1 );
	  
	  return ( v1 != v2 && v1 != v3 && v2 != v3 );
   }            
	public Aresta ultimaSemiaresta ( Aresta a ) {
		Aresta a1, as;

		as = seguentAresta(a);
		a1 = a.getArestaPartit1();
		if (a1.vertexComu(as) != null)
			return a1;
		
		return a.getArestaPartit2();
	}
   public void validar ( ) {
	  if ( a1 == null || a2 == null || a3 == null ) {
		 throw new ObjecteInvalid ( "Un triangle te alguna aresta nula." );
	  }
	  if ( obj == null ) {
		 throw new ObjecteInvalid ( "Un triangle no pertany a cap objecte." );
	  }
	  if ( !a1.containsTriangle ( this ) || !a2.containsTriangle ( this ) || !a3.containsTriangle ( this ) ) {
		 throw new ObjecteInvalid ( "Una aresta del triangle no conte el propi triangle." );
	  }
	  if (!obj.containsAresta(a1) ||
		  !obj.containsAresta(a2) ||
		  !obj.containsAresta(a3))
	  	throw new ObjecteInvalid
	  		("Les arestes del triangle tenen que ser de l'objecte");
	  if ( !tancat ( ) ) {
		 throw new ObjecteInvalid ( "Un triangle no esta ben tancat." );
	  }

	  Vertex v1, v2, v3;
	  
	  v1 = a1.vertexComu ( a2 );
	  v2 = a2.vertexComu ( a3 );
	  v3 = a3.vertexComu ( a1 );

	  if (v1 == null ||
		  v2 == null ||
		  v3 == null)
	  	throw new ObjecteInvalid
	  		("Les arestes del triangle tenen que tenir vertexs en comu");
   }                  
}
