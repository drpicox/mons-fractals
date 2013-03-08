package mgc.mf.gui;

import java.awt.TextField;
import mgc.mf.*;

/**
 * Insert the type's description here.
 * Creation date: (11/01/01 12:51:51)
 * @author: 
 */
public
class SistemaGUI 
extends Sistema 
{
	private TextField text;
	private String str;

	public SistemaGUI (TextField textField)
	{
		super();
		text = textField;
		str = "";
		sSetDefecte(this);
	}
	public void print(String t)
	{
		str = str + t;
		text.setText(str + t);
	}
	public void println(String t)
	{
		text.setText(str + t);
		str = "";
	}
}
