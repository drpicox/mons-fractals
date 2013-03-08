package mgc.mf.gui;

import java.awt.*;
import mgc.mf.*;

/**
 * Seleccio d'un filtre.
 * Creation date: (15/01/01 07:22:46)
 * @author: David Rodenas Pico
 */
public
class DlgSeleccionarFiltre
extends Dialog
{
	private Button ivjBtAcceptar = null;
	private Button ivjBtCancelar = null;
	private Panel ivjContentsPane = null;
	private List ivjLsTipusFiltres = null;
	private Panel ivjPnlBotons = null;
	private static java.util.ResourceBundle resGUI = java.util.ResourceBundle.getBundle("GUI"); //$NON-NLS-1$;
	private String tipusSeleccionat;

     
    /**
     * DlgSeleccionarFiltre constructor comment.
     * @param parent java.awt.Frame
     */
    public DlgSeleccionarFiltre(java.awt.Frame parent) {
        super(parent);
        initialize();
    }

    /**
     * DlgSeleccionarFiltre constructor comment.
     * @param parent java.awt.Frame
     * @param title java.lang.String
     */
    public DlgSeleccionarFiltre(Frame parent, String title) {
        super(parent, title);
    }
    /**
     * DlgSeleccionarFiltre constructor comment.
     * @param parent java.awt.Frame
     * @param title java.lang.String
     * @param modal boolean
     */
    public DlgSeleccionarFiltre(Frame parent, String title, boolean modal) {
        super(parent, title, modal);
    }

    /**
     * DlgSeleccionarFiltre constructor comment.
     * @param parent java.awt.Frame
     * @param modal boolean
     */
    public DlgSeleccionarFiltre(Frame parent, boolean modal) {
        super(parent, modal);
    }
    /**

     * Comment
     */
    public void acceptarFiltre() 
    {
        String seleccio;
    
        seleccio = getLsTipusFiltres().getSelectedItem();
        if (seleccio == null)
        {
            Sistema.sPrintln("Si us plau selecciona un filtre abans");
            return;
        }
    
        tipusSeleccionat = seleccio;
        dispose();
    }

    /**
     * connEtoC1:  (DlgSeleccionarFiltre.window.windowClosing(java.awt.event.WindowEvent) --> DlgSeleccionarFiltre.dispose()V)
     * @param arg1 java.awt.event.WindowEvent
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void connEtoC1(java.awt.event.WindowEvent arg1) {
        try {
            // user code begin {1}
            // user code end
            this.dispose();
            // user code begin {2}
            // user code end
        } catch (java.lang.Throwable ivjExc) {
            // user code begin {3}
            // user code end
            handleException(ivjExc);
        }
    }

    /**
     * connEtoC2:  (BtAcceptar.action. --> DlgSeleccionarFiltre.acceptarFiltre()V)
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void connEtoC2() {
        try {
            // user code begin {1}
            // user code end
            this.acceptarFiltre();
            // user code begin {2}
            // user code end
        } catch (java.lang.Throwable ivjExc) {
            // user code begin {3}
            // user code end
            handleException(ivjExc);
        }
    }

    /**
     * connEtoC3:  (LsTipusFiltres.action. --> DlgSeleccionarFiltre.acceptarFiltre()V)
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void connEtoC3() {
        try {
            // user code begin {1}
            // user code end
            this.acceptarFiltre();
            // user code begin {2}
            // user code end
        } catch (java.lang.Throwable ivjExc) {
            // user code begin {3}
            // user code end
            handleException(ivjExc);
        }
    }

    /**
     * connEtoM1:  (BtCancelar.action.actionPerformed(java.awt.event.ActionEvent) --> DlgSeleccionarFiltre.dispose()V)
     * @param arg1 java.awt.event.ActionEvent
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void connEtoM1(java.awt.event.ActionEvent arg1) {
        try {
            // user code begin {1}
            // user code end
            this.dispose();
            // user code begin {2}
            // user code end
        } catch (java.lang.Throwable ivjExc) {
            // user code begin {3}
            // user code end
            handleException(ivjExc);
        }
    }

    /**
     * Return the BtAcceptar property value.
     * @return java.awt.Button
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.Button getBtAcceptar() {
        if (ivjBtAcceptar == null) {
            try {
                ivjBtAcceptar = new java.awt.Button();
                ivjBtAcceptar.setName("BtAcceptar");
                ivjBtAcceptar.setLabel(resGUI.getString("Acceptar"));
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjBtAcceptar;
    }

    /**
     * Return the BtCancelar property value.
     * @return java.awt.Button
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.Button getBtCancelar() {
        if (ivjBtCancelar == null) {
            try {
                ivjBtCancelar = new java.awt.Button();
                ivjBtCancelar.setName("BtCancelar");
                ivjBtCancelar.setLabel(resGUI.getString("Cancelar"));
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjBtCancelar;
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
                getContentsPane().add(getLsTipusFiltres(), "Center");
                getContentsPane().add(getPnlBotons(), "South");
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
     * Return the LsTipusFiltres property value.
     * @return java.awt.List
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.List getLsTipusFiltres() {
        if (ivjLsTipusFiltres == null) {
            try {
                ivjLsTipusFiltres = new java.awt.List();
                ivjLsTipusFiltres.setName("LsTipusFiltres");
                // user code begin {1}
                String strNumFiltres;
                int numFiltres;
             
                strNumFiltres = resGUI.getString("InfoFiltresNumeroFiltres");
                numFiltres = new Integer(strNumFiltres).intValue();
                for (int i = 0; i < numFiltres; i++)
                    ivjLsTipusFiltres.add(resGUI.getString("InfoFiltresTipusFiltre" + i));       
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjLsTipusFiltres;
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
    
                java.awt.GridBagConstraints constraintsBtAcceptar = new java.awt.GridBagConstraints();
                constraintsBtAcceptar.gridx = -1; constraintsBtAcceptar.gridy = -1;
                constraintsBtAcceptar.insets = new java.awt.Insets(4, 4, 4, 4);
                getPnlBotons().add(getBtAcceptar(), constraintsBtAcceptar);
    
                java.awt.GridBagConstraints constraintsBtCancelar = new java.awt.GridBagConstraints();
                constraintsBtCancelar.gridx = -1; constraintsBtCancelar.gridy = -1;
                constraintsBtCancelar.insets = new java.awt.Insets(4, 4, 4, 4);
                getPnlBotons().add(getBtCancelar(), constraintsBtCancelar);
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
     * Initializes connections
     * @exception java.lang.Exception The exception description.
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void initConnections() throws java.lang.Exception {
        // user code begin {1}
        // user code end
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                connEtoC1(e);
            };
        });
        getBtCancelar().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                connEtoM1(e);
            };
        });
        getBtAcceptar().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                connEtoC2();
            };
        });
        getLsTipusFiltres().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                connEtoC3();
            };
        });
    }

    /**
     * Initialize the class.
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void initialize() {
        try {
            // user code begin {1}
            // user code end
            setName("DlgSeleccionarFiltre");
            setLayout(new java.awt.BorderLayout());
            setSize(223, 299);
            setModal(true);
            setTitle(resGUI.getString("SeleccionarFiltre"));
            add(getContentsPane(), "Center");
            initConnections();
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
            DlgSeleccionarFiltre aDlgSeleccionarFiltre = new mgc.mf.gui.DlgSeleccionarFiltre(new java.awt.Frame());
            aDlgSeleccionarFiltre.setModal(true);
            aDlgSeleccionarFiltre.addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                };
            });
            aDlgSeleccionarFiltre.setVisible(true);
        } catch (Throwable exception) {
            System.err.println("Exception occurred in main() of java.awt.Dialog");
            exception.printStackTrace(System.out);
        }
    }

	public String seleccionarTipusFiltre()
	{
		tipusSeleccionat = null;
		show();
		return tipusSeleccionat;
	}
}
