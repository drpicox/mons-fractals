package mgc.mf.gui;

import java.awt.*;
import mgc.mf.*;

/**
 * Genera un objecte.
 * Creation date: (16/01/01 07:46:41)
 * @author: David Rodenas Pico
 */
public 
class RnbGenerarObjecteGUI
extends RnbGenerarObjecte
{

    private volatile boolean acabat;
    private static Object lock = new Object();
    private java.awt.Button ivjBtParar = null;
    private java.awt.Panel ivjContentsPane = null;
    private java.awt.Dialog ivjDlgEsperar = null;
    private java.awt.Label ivjLbMisstageEspera = null;
    private java.awt.Panel ivjPnlBotons = null;
    private static java.util.ResourceBundle resGUI = java.util.ResourceBundle.getBundle("GUI"); //$NON-NLS-1$;
    private volatile boolean mostratDialeg;

    /**
     * RnbGenerarObjecteGUI constructor comment.
     */
    public RnbGenerarObjecteGUI() {
        super();
        initialize();
    }

	public void esperar()
	{
		try {
			for (int i = 0; i < 10; i++)
				if (acabat)
					{ acabat = false; return; }
				else
                    Thread.sleep(1000);

            synchronized (lock)
            {            
              if (acabat)
                { acabat = false; return; }
              mostratDialeg = true;
            }

            getDlgEsperar().show();

            acabat = false;
            mostratDialeg = false;
		} catch (InterruptedException ie) {}
	}

    /**
     * Return the BtParar property value.
     * @return java.awt.Button
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.Button getBtParar() {
        if (ivjBtParar == null) {
            try {
                ivjBtParar = new java.awt.Button();
                ivjBtParar.setName("BtParar");
                ivjBtParar.setLabel(resGUI.getString("Parar"));
                // user code begin {1}
                ivjBtParar.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        aturar();
                    };
                });
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjBtParar;
    }

    /**
     * Return the ContentsPane property value.
     * @return java.awt.Panel
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.Panel getContentsPane() {
        if (ivjContentsPane == null) {
            try {
                ivjContentsPane = new java.awt.Panel();
                ivjContentsPane.setName("ContentsPane");
                ivjContentsPane.setLayout(new java.awt.BorderLayout());
                getContentsPane().add(getPnlBotons(), "South");
                getContentsPane().add(getLbMisstageEspera(), "Center");
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjContentsPane;
    }

    /**
     * Return the DlgEsperar property value.
     * @return java.awt.Dialog
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.Dialog getDlgEsperar() {
        if (ivjDlgEsperar == null) {
            try {
                ivjDlgEsperar = new java.awt.Dialog(Finestra.sGetDefecte());
                ivjDlgEsperar.setName("DlgEsperar");
                ivjDlgEsperar.setLayout(new java.awt.BorderLayout());
                ivjDlgEsperar.setBounds(184, 109, 201, 58);
                ivjDlgEsperar.setModal(true);
                ivjDlgEsperar.setTitle(resGUI.getString("GenerantObjecte"));
                getDlgEsperar().add(getContentsPane(), "Center");
                // user code begin {1}
                getDlgEsperar().addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        getDlgEsperar().dispose();
                    };
                });
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjDlgEsperar;
    }

    /**
     * Return the LbMisstageEspera property value.
     * @return java.awt.Label
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.Label getLbMisstageEspera() {
        if (ivjLbMisstageEspera == null) {
            try {
                ivjLbMisstageEspera = new java.awt.Label();
                ivjLbMisstageEspera.setName("LbMisstageEspera");
                ivjLbMisstageEspera.setText(resGUI.getString("GenerantObjecte"));
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjLbMisstageEspera;
    }

    /**
     * Return the PnlBotons property value.
     * @return java.awt.Panel
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.Panel getPnlBotons() {
        if (ivjPnlBotons == null) {
            try {
                ivjPnlBotons = new java.awt.Panel();
                ivjPnlBotons.setName("PnlBotons");
                ivjPnlBotons.setLayout(new java.awt.GridBagLayout());
    
                java.awt.GridBagConstraints constraintsBtParar = new java.awt.GridBagConstraints();
                constraintsBtParar.gridx = -1; constraintsBtParar.gridy = -1;
                constraintsBtParar.insets = new java.awt.Insets(4, 4, 4, 4);
                getPnlBotons().add(getBtParar(), constraintsBtParar);
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjPnlBotons;
    }

    /**
     * Called whenever the part throws an exception.
     * @param exception java.lang.Throwable
     */
    private void handleException(java.lang.Throwable exception) {
    
        Sistema.sHandleException(exception);
    }

    /**
     * Initialize the class.
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void initialize() {
        try {
            // user code begin {1}
            // user code end
        } catch (java.lang.Throwable ivjExc) {
            handleException(ivjExc);
        }
        // user code begin {2}
        // user code end
    }

    /**
     * main entrypoint - starts the part when it is run as an application
     * @param args java.lang.String[]
     */
    public static void main(java.lang.String[] args) {
        try {
            RnbGenerarObjecteGUI aRnbGenerarObjecteGUI;
            aRnbGenerarObjecteGUI = new RnbGenerarObjecteGUI();
        } catch (Throwable exception) {
            System.err.println("Exception occurred in main() of mgc.mf.RnbGenerarObjecte");
            exception.printStackTrace(System.out);
        }
    }

    public void run()

    {
        acabat = false;  
        try { super.run(); }
        catch (Throwable th)
        { handleException(th); }

        synchronized (lock)
        {
            acabat = true;
            if (!mostratDialeg)
                return;
        }

        try {           
          Thread.sleep(5000);
          System.gc();
        } catch (InterruptedException ie) {}

        if (mostratDialeg)
            getDlgEsperar().dispose();
    }

    public void aturar()
    {
    synchronized (lock)
    {
    getBtParar().setEnabled(false);
    if (acabat) return;
    parar();
    }
    }
}
