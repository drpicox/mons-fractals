package mgc.mf;

/**
 * Insert the type's description here.
 * Creation date: (11/01/01 12:48:22)
 * @author: 
 */
public 
class Sistema 
{
	private static Sistema defecte;

	public Sistema()
	{}
	public void handleException(Throwable th)
	{
		println(th.toString());
		System.out.println("Trobada excepcio!");
		th.printStackTrace(System.out);
	}
	public void print(String text)
	{
		System.out.print(text);
	}
	public void println(String text)
	{
		System.out.println(text);
	}
	public static Sistema sGetDefecte()
	{
		if (defecte == null)
			defecte = new Sistema();

		return defecte;
	}
	public static void sHandleException(Throwable th)
	{
	    sGetDefecte().handleException(th);
	}
	public static void sPrint(String text)
	{
		sGetDefecte().print(text);
	}
	public static void sPrintln(String text)
	{
		sGetDefecte().println(text);
	}
	public static void sSetDefecte(Sistema sistema)
	{
		if (defecte != null)
			throw new RuntimeException("Sistema ja establert");

		defecte = sistema;
	}

    public static boolean sEstablert()
    { return defecte != null; }
}
