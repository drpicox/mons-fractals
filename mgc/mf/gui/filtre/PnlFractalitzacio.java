package mgc.mf.gui.filtre;

import java.awt.*;
import java.util.*;

import mgc.mf.*;
import mgc.mf.filtre.*;

/**
 * Panell d'edicio dels parametres normals.
 * Creation date: (09/01/01 00:01:34)
 * @author: David Rodenas Pico
 */
public 
class PnlFractalitzacio
extends FiltreNul
{
	private static java.util.ResourceBundle resGUI = java.util.ResourceBundle.getBundle("GUI"); //$NON-NLS-1$;
	private TextField ivjTxDimensioFractal = null;
	private TextField ivjTxEpsilon = null;
	private TextField ivjTxSeed = null;

/**
 * PnlFractalitzacio constructor comment.
 */
public PnlFractalitzacio() 
{
	super();
	initialize();
}
	protected ParametresFiltre crearParametresFiltre()
	{
		return new ParametresFractals();
	}
/**
 * Comment
 */
public double getDimensioFractal() 
{
	String str;
	double ret;

	str = getTxDimensioFractal().getText();
	ret = Double.parseDouble(str);
	
	return ret;
}
/**
 * Comment
 */
public double getEpsilon() 
{
	String str;
	double ret;

	str = getTxEpsilon().getText();
	ret = Double.parseDouble(str);
	
	return ret;
}
/**
 * Comment
 */
public int getSeed() 
{
	String str;
	int ret;

	str = getTxSeed().getText();
	ret = Integer.parseInt(str);
	
	return ret;
}
/**
 * Return the TxDimensioFractal property value.
 * @return java.awt.TextField
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private java.awt.TextField getTxDimensioFractal() {
	if (ivjTxDimensioFractal == null) {
		ivjTxDimensioFractal = new java.awt.TextField();
		ivjTxDimensioFractal.setName("TxDimensioFractal");
		ivjTxDimensioFractal.setText("0.2");
	}
	return ivjTxDimensioFractal;
}
/**
 * Return the TxEpsilon property value.
 * @return java.awt.TextField
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private java.awt.TextField getTxEpsilon() {
	if (ivjTxEpsilon == null) {
		ivjTxEpsilon = new java.awt.TextField();
		ivjTxEpsilon.setName("TxEpsilon");
		ivjTxEpsilon.setText("0.9");
	}
	return ivjTxEpsilon;
}
/**
 * Return the TxSeed property value.
 * @return java.awt.TextField
 */
private java.awt.TextField getTxSeed() {
	if (ivjTxSeed == null) {
		ivjTxSeed = new java.awt.TextField();
		ivjTxSeed.setName("TxSeed");
		ivjTxSeed.setText("1234");
	}
	return ivjTxSeed;
}
	private void initialize()
	{
		addLinea(new Label(resGUI.getString("Fractal")));
		addLinea(resGUI.getString("DimensioFractal"),
				 getTxDimensioFractal());
		addLinea(resGUI.getString("Llavor"),
				 getTxSeed());
		addLinea(resGUI.getString("Epsilon"),
				 getTxEpsilon());
	}
	protected void omplirPanel(ParametresFiltre parametres)
	{
		ParametresFractals parametresFractals;
		double epsilon;
		double dimensioFractal;
		int seed;

		parametresFractals = (ParametresFractals)parametres;
		super.omplirPanel(parametres);
		
		epsilon = parametresFractals.getEpsilon();
		dimensioFractal = parametresFractals.getDimensioFractal();
		seed = parametresFractals.getSeed();

		getTxSeed().setText(toString(seed));
		getTxDimensioFractal().setText(toString(dimensioFractal));
		getTxEpsilon().setText(toString(epsilon));
	}
	protected void omplirParametres(ParametresFiltre parametres)
	{
		ParametresFractals parametresFractals;
		double epsilon;
		double dimensioFractal;
		int seed;
		
		parametresFractals = (ParametresFractals)parametres;
		super.omplirParametres(parametres);
				
		epsilon = getEpsilon();
		dimensioFractal = getDimensioFractal();
		seed = getSeed();
	
		parametresFractals.setEpsilon(epsilon);
		parametresFractals.setDimensioFractal(dimensioFractal);
		parametresFractals.setSeed(seed);
	}
}
