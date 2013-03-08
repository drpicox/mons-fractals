package mgc.mf.gui;

import mgc.mf.*;
import java.awt.*;

/**
 * Insert the type's description here.
 * Creation date: (12/01/01 03:48:12)
 * @author: David Rodenas Pico
 */
public 
class PnlParametresFiltre 
extends Panel
{
  private int numeroFiles;

    public void on()
    {}

    public void off()
    {}

    /**
     * PnlParametresFiltre constructor comment.
     */
    public PnlParametresFiltre() {
        super();
        initialize();
    }

    protected void addLinea(String lab)
	{
        addLinea(new Label(lab));
	}

	protected void addLinea(Component drt)
	{
		addLinea("", drt);
	}

	protected void addLinea(Component esq, Component drt)
	{
		GridBagConstraints constraints;
		
		constraints = new GridBagConstraints();
		constraints.gridx = 0; 
		constraints.gridy = numeroFiles;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(4, 4, 4, 4);
		add(esq, constraints);

		constraints = new GridBagConstraints();
		constraints.gridx = 1; 
		constraints.gridy = numeroFiles;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weightx = 1.0;
		constraints.insets = new Insets(4, 4, 4, 4);
		add(drt, constraints);

		numeroFiles ++;

	}
	protected void addLinea(String esq, Component drt)
	{
		addLinea(new Label(esq), drt);
	}
	protected ParametresFiltre crearParametresFiltre()
	{
		return new ParametresFiltre();
	}
	public ParametresFiltre getParametresFiltre()
	{
		ParametresFiltre retorn;

		retorn = crearParametresFiltre();
		omplirParametres(retorn);

		return retorn;
	}
	private void initialize()
	{
		setLayout(new GridBagLayout());
	}
  public static void main(String p[])
  {
	  Frame frame;
	  Component comp;

	  frame = new Frame();
	  comp = new mgc.mf.gui.filtre.FractalRadialTexturat();
	  frame.add(comp);
	  frame.pack();
	  frame.show();
  }    
	protected void omplirPanel(ParametresFiltre parametres)
	{
	}
	protected void omplirParametres(ParametresFiltre parametres)
	{
	}
	public void setParametresFiltre(ParametresFiltre parametres)
	{
		omplirPanel(parametres);
	}
  public double toDouble(String string)
  {
	  return new Double(string).doubleValue();
  }  
  public int toInt(String string)
  {
	  return new Integer(string).intValue();
  }    
  public String toString(double d)
  {
	  return "" + d;
  }  
  public String toString(int i)
  {
	  return "" + i;
  }  
}
