package mgc.mf.gui;

import java.awt.*;

import mgc.mf.*;
import mgc.mf.filtre.*;

/**
 * Panel d'edicio l'stack de filtres.
 * Creation date: (14/01/01 00:53:51)
 * @author: David Rodenas Pico
 */
public 
class PnlStackFiltres
extends Panel
{
	private Button ivjBtAbaix = null;
	private Button ivjBtAdal = null;
	private Button ivjBtEsborrar = null;
	private Panel ivjPnLlistaFiltre = null;
	private GridLayout ivjPnlStackFiltresGridLayout = null;
	private Panel ivjPnMovimentLlista = null;
	private Panel ivjPnPropietatsFiltre = null;
	private TextField ivjTxNomFiltre = null;
	private static java.util.ResourceBundle resGUI = java.util.ResourceBundle.getBundle("GUI"); //$NON-NLS-1$;
	private String tipusFiltreSeleccionat;
	private List ivjLsFiltres = null;
	private Label ivjLbNom = null;
	private Panel ivjPnDummy = null;
	private BorderLayout ivjPnDummyBorderLayout = null;
	private BorderLayout ivjPnLlistaFiltreBorderLayout = null;
	/** Posicio actual seleccionada (del qual es mostra el panell).
	 *  -1 si no n'hi ha cap de seleccionada. */
	private int seleccionat;
	/** El que s'edita. */
	private StackFiltres filtres;
	/** Panel que edita els parametres del filtre seleccionat. */
	private PnlParametresFiltre panelParametres;
	private Button ivjBtAfegir = null;
	private Panel ivjPnFiltre = null;
	private Panel ivjPnEdicioFiltre = null;
    /**
     * PnlStackFiltres constructor comment.
     */
    public PnlStackFiltres() {
            super();
            initialize();
    }
	public void acceptarCanvis()
	{
		if (seleccionat < 0)
			return;

		Filtre filtre;
		ParametresFiltre parametres;
		List llista;
		String nomFiltre;
		int anticSeleccionat;

		llista = getLsFiltres();
		anticSeleccionat = llista.getSelectedIndex();
		
		filtre = filtres.getFiltre(seleccionat);
		parametres = panelParametres.getParametresFiltre();
		filtre.setParametresFiltre(parametres);
		nomFiltre = getTxNomFiltre().getText();
		parametres.setNomFiltre(nomFiltre);
		parametres.setTipusFiltre(tipusFiltreSeleccionat);
		llista.delItem(seleccionat);
		llista.add(nomFiltre, seleccionat);

		if (anticSeleccionat >= 0)
			llista.select(anticSeleccionat);
	}
    
    /**
     * Comment
     */
    public void afegirFiltre()
    throws Throwable
    {
        DlgSeleccionarFiltre dlg;
        String tipusFiltre;
        Class claseFiltre;
        Class clasePanell;
        Filtre filtre;
        PnlParametresFiltre panell;
        ParametresFiltre parametres;
        List llista;
    
        dlg = new DlgSeleccionarFiltre(Finestra.sGetDefecte());
        tipusFiltre = dlg.seleccionarTipusFiltre();
        requestFocus();
        if (tipusFiltre == null)
            return;
     
        claseFiltre = Class.forName("mgc.mf.filtre." + tipusFiltre);
        clasePanell = Class.forName("mgc.mf.gui.filtre." + tipusFiltre);
        filtre = (Filtre)claseFiltre.newInstance();
        panell = (PnlParametresFiltre)clasePanell.newInstance();
        parametres = panell.getParametresFiltre();
        parametres.setNomFiltre("Sense nom - " + tipusFiltre);
        parametres.setTipusFiltre(tipusFiltre);
        filtre.setParametresFiltre(parametres);
    
        llista = getLsFiltres();
        filtres.pushFiltre(filtre);
        llista.add(parametres.getNomFiltre());
        llista.select(filtres.getNumFiltres() - 1);
        seleccionarFiltre();
    }
    /**
     * connEtoC1:  (LsFiltres.item.itemStateChanged(java.awt.event.ItemEvent) --> PnlStackFiltres.seleccionarFiltre()V)
     * @param arg1 java.awt.event.ItemEvent
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void connEtoC1(java.awt.event.ItemEvent arg1) {
        try {
            // user code begin {1}
            // user code end
            this.seleccionarFiltre();
            // user code begin {2}
            // user code end
        } catch (java.lang.Throwable ivjExc) {
            // user code begin {3}
            // user code end
            handleException(ivjExc);
        }
    }
    /**
     * connEtoC2:  (TxNomFiltre.text.textValueChanged(java.awt.event.TextEvent) --> PnlStackFiltres.seleccionarFiltre()V)
     * @param arg1 java.awt.event.TextEvent
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void connEtoC2(java.awt.event.TextEvent arg1) {
        try {
            // user code begin {1}
            // user code end
            this.seleccionarFiltre();
            // user code begin {2}
            // user code end
        } catch (java.lang.Throwable ivjExc) {
            // user code begin {3}
            // user code end
            handleException(ivjExc);
        }
    }
    /**
     * connEtoC3:  (BtEsborrar.action. --> PnlStackFiltres.filtreEsborrar()V)
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void connEtoC3() {
        try {
            // user code begin {1}
            // user code end
            this.filtreEsborrar();
            // user code begin {2}
            // user code end
        } catch (java.lang.Throwable ivjExc) {
            // user code begin {3}
            // user code end
            handleException(ivjExc);
        }
    }
    /**
     * connEtoC4:  (BtAfegir.action. --> PnlStackFiltres.afegirFiltre()V)
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void connEtoC4() {
        try {
            // user code begin {1}
            // user code end
            this.afegirFiltre();
            // user code begin {2}
            // user code end
        } catch (java.lang.Throwable ivjExc) {
            // user code begin {3}
            // user code end
            handleException(ivjExc);
        }
    }
    /**
     * connEtoC5:  (BtAdal.action. --> PnlStackFiltres.filtreAdalt()V)
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void connEtoC5() {
        try {
            // user code begin {1}
            // user code end
            this.filtreAdalt();
            // user code begin {2}
            // user code end
        } catch (java.lang.Throwable ivjExc) {
            // user code begin {3}
            // user code end
            handleException(ivjExc);
        }
    }
    /**
     * connEtoC6:  (BtAbaix.action. --> PnlStackFiltres.filtreAbaix()V)
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void connEtoC6() {
        try {
            // user code begin {1}
            // user code end
            this.filtreAbaix();
            // user code begin {2}
            // user code end
        } catch (java.lang.Throwable ivjExc) {
            // user code begin {3}
            // user code end
            handleException(ivjExc);
        }
    }
    /**
     * Comment
     */
    public void filtreAbaix() 
    throws Throwable
    {
        Filtre filtre;
        List llista;
        String nom;
        int seleccio;
    
        acceptarCanvis();
        llista = getLsFiltres();
     
        seleccionat = -1;
        seleccio = llista.getSelectedIndex();
        nom = llista.getSelectedItem();
        filtre = filtres.getFiltre(seleccio);
        filtres.removeFiltre(seleccio);
        llista.remove(seleccio);
        seleccio ++;
        llista.add(nom, seleccio);
        filtres.insertFiltreAt(filtre, seleccio);
        llista.select(seleccio);
    
        seleccionarFiltre();
    }
    /**
     * Comment
     */
    public void filtreAdalt() 
    throws Throwable
    {
        Filtre filtre;
        List llista;
        String nom;
        int seleccio;
    
        acceptarCanvis();
        llista = getLsFiltres();
     
        seleccionat = -1;
        seleccio = llista.getSelectedIndex();
        nom = llista.getSelectedItem();
        filtre = filtres.getFiltre(seleccio);
        filtres.removeFiltre(seleccio);
        llista.remove(seleccio);
        seleccio --;
        llista.add(nom, seleccio);
        filtres.insertFiltreAt(filtre, seleccio);
        llista.select(seleccio);
    
        seleccionarFiltre();
    }
    /**
     * Esborra un element de la pila/stack.
     */
    public void filtreEsborrar()
    throws Throwable
    {
        List llista;
        int seleccio;
    
        llista = getLsFiltres();
        seleccio = llista.getSelectedIndex();
        if (seleccio < 0)
            return;
    
        acceptarCanvis();
        seleccionat = -1;
    
        llista.remove(seleccio);
        filtres.removeFiltre(seleccio);
         
        testFiltresNoBuit(); 
        if (seleccio == filtres.getNumFiltres())
            seleccio --;
    
        llista.select(seleccio);
        seleccionarFiltre();
    }
    /**
     * Return the BtAbaix property value.
     * @return java.awt.Button
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.Button getBtAbaix() {
        if (ivjBtAbaix == null) {
            try {
                ivjBtAbaix = new java.awt.Button();
                ivjBtAbaix.setName("BtAbaix");
                ivjBtAbaix.setLabel("Abaix");
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjBtAbaix;
    }
    /**
     * Return the BtAdal property value.
     * @return java.awt.Button
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.Button getBtAdal() {
        if (ivjBtAdal == null) {
            try {
                ivjBtAdal = new java.awt.Button();
                ivjBtAdal.setName("BtAdal");
                ivjBtAdal.setLabel(resGUI.getString("Adalt"));
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjBtAdal;
    }
    /**
     * Return the Button1 property value.
     * @return java.awt.Button
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.Button getBtAfegir() {
        if (ivjBtAfegir == null) {
            try {
                ivjBtAfegir = new java.awt.Button();
                ivjBtAfegir.setName("BtAfegir");
                ivjBtAfegir.setLabel(resGUI.getString("Afegir"));
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjBtAfegir;
    }
    /**
     * Return the BtEsborrar property value.
     * @return java.awt.Button
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.Button getBtEsborrar() {
        if (ivjBtEsborrar == null) {
            try {
                ivjBtEsborrar = new java.awt.Button();
                ivjBtEsborrar.setName("BtEsborrar");
                ivjBtEsborrar.setLabel(resGUI.getString("Esborrar"));
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjBtEsborrar;
    }
    /**
     * Return the LbNom property value.
     * @return java.awt.Label
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.Label getLbNom() {
        if (ivjLbNom == null) {
            try {
                ivjLbNom = new java.awt.Label();
                ivjLbNom.setName("LbNom");
                ivjLbNom.setText(resGUI.getString("Nom"));
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjLbNom;
    }
    /**
     * Return the LsFiltres property value.
     * @return java.awt.List
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.List getLsFiltres() {
        if (ivjLsFiltres == null) {
            try {
                ivjLsFiltres = new java.awt.List();
                ivjLsFiltres.setName("LsFiltres");
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjLsFiltres;
    }
        private PnlParametresFiltre getPanel(String tipus)
            throws Throwable
        {
            PnlParametresFiltre panel;
            Class claseFiltre;
    
            claseFiltre = Class.forName
                ("mgc.mf.gui.filtre." + tipus);
            panel = (PnlParametresFiltre)claseFiltre.newInstance();
    
            return panel;
        }
        protected PnlParametresFiltre getPanel(Filtre filtre)
            throws Throwable
        {
            ParametresFiltre parametres;
            String tipusFiltre;
    
            parametres = filtre.getParametresFiltre();
            tipusFiltre = parametres.getTipusFiltre();
         
            return getPanel(tipusFiltre);
        }
    /**
     * Return the PnDummy property value.
     * @return java.awt.Panel
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.Panel getPnDummy() {
        if (ivjPnDummy == null) {
            try {
                ivjPnDummy = new java.awt.Panel();
                ivjPnDummy.setName("PnDummy");
                ivjPnDummy.setLayout(getPnDummyBorderLayout());
                getPnDummy().add(getPnMovimentLlista(), "East");
                getPnDummy().add(getBtEsborrar(), "West");
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjPnDummy;
    }
    /**
     * Return the PnDummyBorderLayout property value.
     * @return java.awt.BorderLayout
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.BorderLayout getPnDummyBorderLayout() {
        java.awt.BorderLayout ivjPnDummyBorderLayout = null;
        try {
            /* Create part */
            ivjPnDummyBorderLayout = new java.awt.BorderLayout();
            ivjPnDummyBorderLayout.setVgap(4);
            ivjPnDummyBorderLayout.setHgap(4);
        } catch (java.lang.Throwable ivjExc) {
            handleException(ivjExc);
        };
        return ivjPnDummyBorderLayout;
    }
    /**
     * Return the PnEdicioFiltr property value.
     * @return java.awt.Panel
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.Panel getPnEdicioFiltre() {
        if (ivjPnEdicioFiltre == null) {
            try {
                ivjPnEdicioFiltre = new java.awt.Panel();
                ivjPnEdicioFiltre.setName("PnEdicioFiltre");
                ivjPnEdicioFiltre.setLayout(new java.awt.BorderLayout());
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjPnEdicioFiltre;
    }
    /**
     * Return the PnEdicioFiltre property value.
     * @return java.awt.Panel
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.Panel getPnFiltre() {
        if (ivjPnFiltre == null) {
            try {
                ivjPnFiltre = new java.awt.Panel();
                ivjPnFiltre.setName("PnFiltre");
                ivjPnFiltre.setLayout(new java.awt.BorderLayout());
                getPnFiltre().add(getPnPropietatsFiltre(), "North");
                getPnFiltre().add(getPnEdicioFiltre(), "Center");
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjPnFiltre;
    }
    /**
     * Return the PnLlistaFiltre property value.
     * @return java.awt.Panel
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.Panel getPnLlistaFiltre() {
        if (ivjPnLlistaFiltre == null) {
            try {
                ivjPnLlistaFiltre = new java.awt.Panel();
                ivjPnLlistaFiltre.setName("PnLlistaFiltre");
                ivjPnLlistaFiltre.setLayout(getPnLlistaFiltreBorderLayout());
                getPnLlistaFiltre().add(getLsFiltres(), "Center");
                getPnLlistaFiltre().add(getPnDummy(), "South");
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjPnLlistaFiltre;
    }
    /**
     * Return the PnLlistaFiltreBorderLayout property value.
     * @return java.awt.BorderLayout
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.BorderLayout getPnLlistaFiltreBorderLayout() {
        java.awt.BorderLayout ivjPnLlistaFiltreBorderLayout = null;
        try {
            /* Create part */
            ivjPnLlistaFiltreBorderLayout = new java.awt.BorderLayout();
            ivjPnLlistaFiltreBorderLayout.setVgap(2);
            ivjPnLlistaFiltreBorderLayout.setHgap(2);
        } catch (java.lang.Throwable ivjExc) {
            handleException(ivjExc);
        };
        return ivjPnLlistaFiltreBorderLayout;
    }
    /**
     * Return the PnlStackFiltresGridLayout property value.
     * @return java.awt.GridLayout
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.GridLayout getPnlStackFiltresGridLayout() {
        java.awt.GridLayout ivjPnlStackFiltresGridLayout = null;
        try {
            /* Create part */
            ivjPnlStackFiltresGridLayout = new java.awt.GridLayout(1, 2);
        } catch (java.lang.Throwable ivjExc) {
            handleException(ivjExc);
        };
        return ivjPnlStackFiltresGridLayout;
    }
    /**
     * Return the PnMovimentLlista property value.
     * @return java.awt.Panel
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.Panel getPnMovimentLlista() {
        if (ivjPnMovimentLlista == null) {
            try {
                ivjPnMovimentLlista = new java.awt.Panel();
                ivjPnMovimentLlista.setName("PnMovimentLlista");
                ivjPnMovimentLlista.setLayout(new java.awt.GridBagLayout());
    
                java.awt.GridBagConstraints constraintsBtAdal = new java.awt.GridBagConstraints();
                constraintsBtAdal.gridx = 1; constraintsBtAdal.gridy = 0;
                constraintsBtAdal.anchor = java.awt.GridBagConstraints.EAST;
                getPnMovimentLlista().add(getBtAdal(), constraintsBtAdal);
    
                java.awt.GridBagConstraints constraintsBtAbaix = new java.awt.GridBagConstraints();
                constraintsBtAbaix.gridx = 2; constraintsBtAbaix.gridy = 0;
                constraintsBtAbaix.anchor = java.awt.GridBagConstraints.EAST;
                getPnMovimentLlista().add(getBtAbaix(), constraintsBtAbaix);
    
                java.awt.GridBagConstraints constraintsBtAfegir = new java.awt.GridBagConstraints();
                constraintsBtAfegir.gridx = 0; constraintsBtAfegir.gridy = 0;
                getPnMovimentLlista().add(getBtAfegir(), constraintsBtAfegir);
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjPnMovimentLlista;
    }
    /**
     * Return the PnPropietatsFiltre property value.
     * @return java.awt.Panel
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.Panel getPnPropietatsFiltre() {
        if (ivjPnPropietatsFiltre == null) {
            try {
                ivjPnPropietatsFiltre = new java.awt.Panel();
                ivjPnPropietatsFiltre.setName("PnPropietatsFiltre");
                ivjPnPropietatsFiltre.setLayout(new java.awt.BorderLayout());
                getPnPropietatsFiltre().add(getTxNomFiltre(), "Center");
                getPnPropietatsFiltre().add(getLbNom(), "West");
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjPnPropietatsFiltre;
    }
    /**
     * Return the TxNomFiltre property value.
     * @return java.awt.TextField
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.TextField getTxNomFiltre() {
        if (ivjTxNomFiltre == null) {
            try {
                ivjTxNomFiltre = new java.awt.TextField();
                ivjTxNomFiltre.setName("TxNomFiltre");
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjTxNomFiltre;
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
        getLsFiltres().addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent e) {
                connEtoC1(e);
            };
        });
        getTxNomFiltre().addTextListener(new java.awt.event.TextListener() {
            public void textValueChanged(java.awt.event.TextEvent e) {
                connEtoC2(e);
            };
        });
        getBtEsborrar().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                connEtoC3();
            };
        });
        getBtAfegir().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                connEtoC4();
            };
        });
        getBtAdal().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                connEtoC5();
            };
        });
        getBtAbaix().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                connEtoC6();
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
            setName("PnlStackFiltres");
            setLayout(getPnlStackFiltresGridLayout());
            setSize(426, 240);
            add(getPnLlistaFiltre(), getPnLlistaFiltre().getName());
            add(getPnFiltre(), getPnFiltre().getName());
            initConnections();
        } catch (java.lang.Throwable ivjExc) {
            handleException(ivjExc);
        }
        // user code begin {2}
        seleccionat = -1;
        // user code end
    }
    /**
     * main entrypoint - starts the part when it is run as an application
     * @param args java.lang.String[]
     */
    public static void main(java.lang.String[] args) {
        try {
            Frame frame = new java.awt.Frame();
            PnlStackFiltres aPnlStackFiltres;
            aPnlStackFiltres = new PnlStackFiltres();
            frame.add("Center", aPnlStackFiltres);
            frame.setSize(aPnlStackFiltres.getSize());
            frame.addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                };
            });
            frame.setVisible(true);
        } catch (Throwable exception) {
            System.err.println("Exception occurred in main() of java.awt.Panel");
            exception.printStackTrace(System.out);
        }
    }
	protected void seleccionarFiltre() throws Throwable
	{			
		List llista;
		int nouSeleccionat;
		
		testFiltresNoBuit();
		
		llista = getLsFiltres();
		nouSeleccionat = llista.getSelectedIndex();

		acceptarCanvis();
		if (nouSeleccionat == seleccionat)
			return;
			
        if (panelParametres != null) {
			getPnEdicioFiltre().remove(panelParametres);
            panelParametres.off();
        }

		if (nouSeleccionat < 0) {
			getBtAdal().setEnabled(false);
			getBtAbaix().setEnabled(false);
			getBtEsborrar().setEnabled(false);
			panelParametres = null;
			seleccionat = nouSeleccionat;
			return;
		}
			
		Filtre filtre;
		ParametresFiltre parametres;
		String tipusFiltre;
		String nomFiltre;
		PnlParametresFiltre panel;

		filtre = filtres.getFiltre(nouSeleccionat);
		parametres = filtre.getParametresFiltre();
		tipusFiltre = parametres.getTipusFiltre();
		nomFiltre = parametres.getNomFiltre();
		panel = getPanel(filtre);
		panel.setParametresFiltre(parametres);
		getTxNomFiltre().setText(nomFiltre);
		tipusFiltreSeleccionat = tipusFiltre;

		seleccionat = nouSeleccionat;
		panelParametres = panel;
		Toolkit.getDefaultToolkit().sync();
		getPnEdicioFiltre().add(panel, BorderLayout.NORTH);
		getPnEdicioFiltre().validate();
		//getPnEdicioFiltre().doLayout();
		//getPnEdicioFiltre().repaint();

		// Botons de la llista
		if (seleccionat < filtres.getNumFiltres() - 1)
			getBtAbaix().setEnabled(true);
		else
			getBtAbaix().setEnabled(false);
			
		if (seleccionat > 0)
			getBtAdal().setEnabled(true);
		else
			getBtAdal().setEnabled(false);
			
		getBtEsborrar().setEnabled(true);
		getPnEdicioFiltre().add(panel);
        panel.on();
	}
	public void setStackFiltres(StackFiltres stackFiltres)
		throws Throwable
	{
		Filtre filtre;
		ParametresFiltre parametres;
		List list;
		String nomFiltre;
		int numFiltres;

        // Llista de filtres
		list = getLsFiltres();

		if (filtres != null) {

			// No s'accepten els canvis.
            acceptarCanvis();
            if (seleccionat >= 0)
                list.deselect(seleccionat);
            seleccionarFiltre();

			seleccionat = -1;
			panelParametres = null;	
		}

		// Assignar la variable en si	
		filtres = stackFiltres;

        // la llista estara buida
		list.removeAll();

		// Omplir la llista d'stacks
		numFiltres = stackFiltres.getNumFiltres();
		for (int i = 0; i < numFiltres; i++)
		{
			filtre = filtres.getFiltre(i);
			parametres = filtre.getParametresFiltre();
			nomFiltre = parametres.getNomFiltre();
			list.add(nomFiltre, i);
		}

		testFiltresNoBuit();
		// Seleccionar el primer
		list.select(0);
		seleccionarFiltre();
	}
	private void testFiltresNoBuit()
	{
		if (filtres.getNumFiltres() > 0)
			return;

		Filtre filtre;
		ParametresFiltre parametres;
		List llista;

		filtre = new Nul();
		parametres = new ParametresNul();
		parametres.setNomFiltre("Objecte Buit");
		parametres.setTipusFiltre("Nul");
		filtre.setParametresFiltre(parametres);

		llista = getLsFiltres();
		filtres.pushFiltre(filtre);
		llista.add(parametres.getNomFiltre());
		llista.select(0);
	}
}
