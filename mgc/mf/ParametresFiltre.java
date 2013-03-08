package mgc.mf;

/**
 * Agrupacio de tots els parametres.
 * Creation date: (12/01/01 03:25:46)
 * @author: David Rodenas Pico
 */
public class ParametresFiltre 
extends java.lang.Object
implements java.io.Serializable
{
	private String nomFiltre;
	private String tipusFiltre;

    /**
     * ParametresFiltre constructor comment.
     */
    public ParametresFiltre() {
        super();
    }
    /**
     * Insert the method's description here.
     * Creation date: (14/01/01 04:35:54)
     * @return java.lang.String
     */
    public java.lang.String getNomFiltre() {
        return nomFiltre;
    }
    /**
     * Insert the method's description here.
     * Creation date: (14/01/01 04:35:54)
     * @return java.lang.String
     */
    public java.lang.String getTipusFiltre() {
        return tipusFiltre;
    }
    /**
     * Insert the method's description here.
     * Creation date: (14/01/01 04:35:54)
     * @param newNomFiltre java.lang.String
     */
    public void setNomFiltre(java.lang.String newNomFiltre) {
        nomFiltre = newNomFiltre;
    }
    /**
     * Insert the method's description here.
     * Creation date: (14/01/01 04:35:54)
     * @param newTipusFiltre java.lang.String
     */
    public void setTipusFiltre(java.lang.String newTipusFiltre) {
        tipusFiltre = newTipusFiltre;
    }

    public String toString()
    {
    return "[" + nomFiltre + "(" + tipusFiltre + ")" +
           "|" + super.toString() + "|]";

    }
}
