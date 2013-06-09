package mgc.mf.gui.filtre;

import java.awt.*;
import java.util.*;

import mgc.mf.*;
import mgc.mf.filtre.*;

/**
 * Insert the type's description here.
 * Creation date: (09/01/01 00:34:13)
 * @author: David Rodenas Pico
 */
public 
class FractalRadialTexturat 
extends FractalRadial 
{
	private static java.util.ResourceBundle resGUI = java.util.ResourceBundle.getBundle("GUI"); //$NON-NLS-1$;
	private java.awt.TextField ivjTxDimensioFractalTextura;
	private java.awt.TextField ivjTxSeedTextura;

/**
 * PnlFractalitzacioPlanetaFractal constructor comment.
 */
public FractalRadialTexturat() 
{
	super();
	initialize();
}
	protected ParametresFiltre crearParametresFiltre()
	{
		return new ParametresFractalsPlanetaTexturat();
	}
/**
 * Comment
 */
public double getDimensioFractalTextura() 
{
	String str;
	double ret;

	str = getTxDimensioFractalTextura().getText();
	ret = Double.parseDouble(str);
	
	return ret;
}
/**
 * Comment
 */
public int getSeedTextura() 
{
	String str;
	int ret;

	str = getTxSeedTextura().getText();
	ret = Integer.parseInt(str);
	
	return ret;
}
	public java.awt.TextField getTxDimensioFractalTextura()
	{
		if (ivjTxDimensioFractalTextura == null)
		{
			ivjTxDimensioFractalTextura = new java.awt.TextField();
			ivjTxDimensioFractalTextura.setText("1.2");
		}

		return ivjTxDimensioFractalTextura;
	}
	public java.awt.TextField getTxSeedTextura()
	{
		if (ivjTxSeedTextura == null)
		{
			ivjTxSeedTextura = new java.awt.TextField();
			ivjTxSeedTextura.setText("1234");
		}

		return ivjTxSeedTextura;
	}
	private void initialize() 
	{
		addLinea(new Label(resGUI.getString("Textura")));
		addLinea(resGUI.getString("DimensioFractal"),
				 getTxDimensioFractalTextura());
		addLinea(resGUI.getString("Llavor"),
				 getTxSeedTextura());
	}
	protected void omplirPanel(ParametresFiltre parametres)
	{
		ParametresFractalsPlanetaTexturat pfpt;
		double dimensioFractal;
		int seed;

		pfpt = (ParametresFractalsPlanetaTexturat)parametres;
		super.omplirPanel(parametres);
		
		dimensioFractal = pfpt.getDimensioFractalTextura();
		seed = pfpt.getSeedTextura();

		getTxSeedTextura().setText(Double.toString(seed));
		getTxDimensioFractalTextura().setText
			(Double.toString(dimensioFractal));
	}
	protected void omplirParametres(ParametresFiltre parametres)
	{
		ParametresFractalsPlanetaTexturat pfpt;
		double dimensioFractal;
		int seed;

		super.omplirParametres(parametres);
		
		pfpt = (ParametresFractalsPlanetaTexturat)parametres;
		dimensioFractal = getDimensioFractalTextura();
		seed = getSeedTextura();
	
		pfpt.setDimensioFractalTextura(dimensioFractal);
		pfpt.setSeedTextura(seed);
	}
}
