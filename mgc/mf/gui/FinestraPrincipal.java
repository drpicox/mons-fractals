package mgc.mf.gui;

import java.io.*;
import java.awt.*;
import mgc.mf.*;

/**
 * Finestra principal de presentacio.
 * Creation date: (14/01/01 00:28:44)
 * @author: David Rodenas Pico
 */
public 
class FinestraPrincipal 
extends Finestra 
{
	private Panel ivjContentsPane = null;
	private MenuBar ivjFinestraPrincipalMenuBar = null;
	private MenuItem ivjMenuSeparator1 = null;
	private Menu ivjMnFitxer = null;
	private MenuItem ivjMnFitxerSortir = null;
	private TextField ivjTxBarraEstat = null;
	private static java.util.ResourceBundle resGUI = java.util.ResourceBundle.getBundle("GUI"); //$NON-NLS-1$;
	private PnlStackFiltres ivjPanelStackFiltres = null;
	/** Stack de filtres actualment generat. */
	private StackFiltres filtres;
	private FileDialog ivjDlgExportar = null;
	private FileDialog ivjDlgObrir = null;
	private FileDialog ivjDlgSalvar = null;
	private MenuItem ivjMnFitxerNou = null;
	private MenuItem ivjMnFitxerObrir = null;
	private Menu ivjMnuFitxerExportar = null;
	private MenuItem ivjMnuFitxerSalvar = null;
	private Objecte objecte;
	private Button ivjBtRegenerar = null;
	private Panel ivjPnlBarraEines = null;
	private FlowLayout ivjPnlBarraEinesFlowLayout = null;


    public StackFiltres getStackFiltres()
    {
        getPanelStackFiltres().acceptarCanvis();
        return filtres;
    }

    public void setStackFiltres(StackFiltres filtres)
    {
        try {
        getPanelStackFiltres().setStackFiltres(filtres);
        } catch (Throwable th) {
            handleException(th);
        }
        this.filtres = filtres;
    }


    /**
     * FinestraPrincipal constructor comment.
     */
    public FinestraPrincipal() {
        super();
        initialize();
    }

    /**
     * FinestraPrincipal constructor comment.
     * @param title java.lang.String
     */
    public FinestraPrincipal(String title) {
        super(title);
    }

	private void afegirTraductor(String traductor)
	{
		Menu menu;
		MenuItem menuItem;

		menu = getMnuFitxerExportar();
		menuItem = new MenuItem(traductor);
		menuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				String str;
				str = e.getActionCommand();
				executarTraductor(str);
			};
		});
		menu.add(menuItem);
	}

	private void afegirTraductors()
	{
		String traductor;
		String strNumTraductor;
		int numTraductor;

		strNumTraductor = resGUI.getString("InfoTraductorsNumeroTraductors");
		numTraductor = new Integer(strNumTraductor).intValue();
		for (int i = 0; i < numTraductor; i++)
		{
			traductor = resGUI.getString("InfoTraductorsTipusTraductor" + i);
			afegirTraductor(traductor);
		}			
	}
    
    /**
     * connEtoC1:  (MnFitxerSortir.action. --> FinestraPrincipal.sortir()V)
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void connEtoC1() {
        try {
            // user code begin {1}
            // user code end
            this.sortir();
            // user code begin {2}
            // user code end
        } catch (java.lang.Throwable ivjExc) {
            // user code begin {3}
            // user code end
            handleException(ivjExc);
        }
    }
    /**
     * connEtoC2:  (FinestraPrincipal.window.windowClosing(java.awt.event.WindowEvent) --> FinestraPrincipal.sortir()V)
     * @param arg1 java.awt.event.WindowEvent
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void connEtoC2(java.awt.event.WindowEvent arg1) {
        try {
            // user code begin {1}
            // user code end
            this.sortir();
            // user code begin {2}
            // user code end
        } catch (java.lang.Throwable ivjExc) {
            // user code begin {3}
            // user code end
            handleException(ivjExc);
        }
    }
    /**
     * connEtoC3:  (MnFitxerNou.action. --> FinestraPrincipal.fitxerNou()V)
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void connEtoC3() {
        try {
            // user code begin {1}
            // user code end
            this.fitxerNou();
            // user code begin {2}
            // user code end
        } catch (java.lang.Throwable ivjExc) {
            // user code begin {3}
            // user code end
            handleException(ivjExc);
        }
    }
    /**
     * connEtoC4:  (MnFitxerObrir.action. --> FinestraPrincipal.fitxerObrir()V)
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void connEtoC4() {
        try {
            // user code begin {1}
            // user code end
            this.fitxerObrir();
            // user code begin {2}
            // user code end
        } catch (java.lang.Throwable ivjExc) {
            // user code begin {3}
            // user code end
            handleException(ivjExc);
        }
    }
    /**
     * connEtoC5:  (MnuFitxerSalvar.action. --> FinestraPrincipal.fitxerSalvar()V)
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void connEtoC5() {
        try {
            // user code begin {1}
            // user code end
            this.fitxerSalvar();
            // user code begin {2}
            // user code end
        } catch (java.lang.Throwable ivjExc) {
            // user code begin {3}
            // user code end
            handleException(ivjExc);
        }
    }
    /**
     * connEtoC6:  (BtRegenerar.action. --> FinestraPrincipal.objecteRegenerar()V)
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void connEtoC6() {
        try {
            // user code begin {1}
            // user code end
            this.objecteRegenerar();
            // user code begin {2}
            // user code end
        } catch (java.lang.Throwable ivjExc) {
            // user code begin {3}
            // user code end
            handleException(ivjExc);
        }
    }
	public void executarTraductor(String tipus)
	{
		String fitxer;
		String dir;
		FileDialog fd;
		
	try {
		if (objecte == null)
		{
			Sistema.sPrintln("No s'ha generat l'objecte");
			return;
		}

		Sistema.sPrintln("Exportant a " + tipus);
		fd = getDlgExportar();
		fd.show();
		fitxer = fd.getFile();
		if (fitxer == null)
			return;

		Class claseTraductor;
		Traductor traductor;
		FileWriter fw;
		PrintWriter pw;

		dir = fd.getDirectory();
		fw = new FileWriter(dir + fitxer);
		pw = new PrintWriter(fw);

		claseTraductor = Class.forName("mgc.mf.Traductor" + tipus);
		traductor = (Traductor)claseTraductor.newInstance();
		traductor.traduir(objecte, pw);
		
		pw.flush();
		fw.flush();
		pw.close();
		fw.close();

		Sistema.sPrintln("Exportat");
		
	} catch (java.lang.Throwable ivjExc) {
		handleException(ivjExc);
	}

	}
    /**
     * Comment
     */
    public void fitxerNou()
    throws Throwable
    {
        filtres = new StackFiltres();
        getPanelStackFiltres().setStackFiltres(filtres);
    }
    /**
     * Comment
     */
    public void fitxerObrir()
    throws Throwable
    {
        String fitxer;
        String dir;
        FileDialog fd;
    
        fd = getDlgObrir();
        fd.show();
        fitxer = fd.getFile();
        if (fitxer == null)
            return;
    
        FileInputStream fis;
        ObjectInputStream ois;
    
        dir = fd.getDirectory();
        fis = new FileInputStream(dir + fitxer);
        ois = new ObjectInputStream(fis);
        filtres = (StackFiltres)ois.readObject();
        ois.close();
        fis.close();
    
        getPanelStackFiltres().setStackFiltres(filtres);
    }
    /**
     * Comment
     */
    public void fitxerSalvar() 
    throws Throwable
    {
        String fitxer;
        String dir;
        FileDialog fd;
    
        getPanelStackFiltres().acceptarCanvis();
        fd = getDlgSalvar();
        fd.show();
        fitxer = fd.getFile();
        if (fitxer == null)
            return;
    
        FileOutputStream fos;
        ObjectOutputStream oos;
    
        dir = fd.getDirectory();
        fos = new FileOutputStream(dir + fitxer);
        oos = new ObjectOutputStream(fos);
        oos.writeObject(filtres);
        oos.close();
        fos.close();
    }
    /**
     * Return the BtRegenerar property value.
     * @return java.awt.Button
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.Button getBtRegenerar() {
        if (ivjBtRegenerar == null) {
            try {
                ivjBtRegenerar = new java.awt.Button();
                ivjBtRegenerar.setName("BtRegenerar");
                ivjBtRegenerar.setActionCommand("BtRegenerar");
                ivjBtRegenerar.setLabel(resGUI.getString("Regenerar"));
                ivjBtRegenerar.setForeground(java.awt.Color.black);
                ivjBtRegenerar.setBackground(java.awt.Color.lightGray);
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjBtRegenerar;
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
                getContentsPane().add(getTxBarraEstat(), "South");
                getContentsPane().add(getPanelStackFiltres(), "Center");
                getContentsPane().add(getPnlBarraEines(), "North");
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
     * Return the DlgExportar property value.
     * @return java.awt.FileDialog
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.FileDialog getDlgExportar() {
        if (ivjDlgExportar == null) {
            try {
                ivjDlgExportar = new java.awt.FileDialog(this);
                ivjDlgExportar.setName("DlgExportar");
                ivjDlgExportar.setLayout(null);
                ivjDlgExportar.setMode(java.awt.FileDialog.SAVE);
                ivjDlgExportar.setTitle(resGUI.getString("ExportantStack"));
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjDlgExportar;
    }
    /**
     * Return the DlgObrir property value.
     * @return java.awt.FileDialog
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.FileDialog getDlgObrir() {
        if (ivjDlgObrir == null) {
            try {
                ivjDlgObrir = new java.awt.FileDialog(this);
                ivjDlgObrir.setName("DlgObrir");
                ivjDlgObrir.setLayout(null);
                ivjDlgObrir.setTitle(resGUI.getString("ObrirStackMF"));
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjDlgObrir;
    }
    /**
     * Return the DlgSalvar property value.
     * @return java.awt.FileDialog
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.FileDialog getDlgSalvar() {
        if (ivjDlgSalvar == null) {
            try {
                ivjDlgSalvar = new java.awt.FileDialog(this);
                ivjDlgSalvar.setName("DlgSalvar");
                ivjDlgSalvar.setLayout(null);
                ivjDlgSalvar.setMode(java.awt.FileDialog.SAVE);
                ivjDlgSalvar.setTitle(resGUI.getString("SalvarStackMF"));
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjDlgSalvar;
    }
    /**
     * Return the FinestraPrincipalMenuBar property value.
     * @return java.awt.MenuBar
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.MenuBar getFinestraPrincipalMenuBar() {
        if (ivjFinestraPrincipalMenuBar == null) {
            try {
                ivjFinestraPrincipalMenuBar = new java.awt.MenuBar();
                ivjFinestraPrincipalMenuBar.add(getMnFitxer());
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjFinestraPrincipalMenuBar;
    }
    /**
     * Return the MenuSeparator1 property value.
     * @return java.awt.MenuItem
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.MenuItem getMenuSeparator1() {
        if (ivjMenuSeparator1 == null) {
            try {
                ivjMenuSeparator1 = new java.awt.MenuItem();
                ivjMenuSeparator1.setLabel("-");
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjMenuSeparator1;
    }
    /**
     * Return the MnFitxer property value.
     * @return java.awt.Menu
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.Menu getMnFitxer() {
        if (ivjMnFitxer == null) {
            try {
                ivjMnFitxer = new java.awt.Menu();
                ivjMnFitxer.setLabel(resGUI.getString("MenuFitxer"));
                ivjMnFitxer.add(getMnFitxerNou());
                ivjMnFitxer.add(getMnFitxerObrir());
                ivjMnFitxer.add(getMnuFitxerSalvar());
                ivjMnFitxer.add(getMnuFitxerExportar());
                ivjMnFitxer.add(getMenuSeparator1());
                ivjMnFitxer.add(getMnFitxerSortir());
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjMnFitxer;
    }
    /**
     * Return the MnFitxerNou property value.
     * @return java.awt.MenuItem
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.MenuItem getMnFitxerNou() {
        if (ivjMnFitxerNou == null) {
            try {
                ivjMnFitxerNou = new java.awt.MenuItem();
                ivjMnFitxerNou.setLabel(resGUI.getString("Nou"));
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjMnFitxerNou;
    }
    /**
     * Return the MnFitxerObrir property value.
     * @return java.awt.MenuItem
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.MenuItem getMnFitxerObrir() {
        if (ivjMnFitxerObrir == null) {
            try {
                ivjMnFitxerObrir = new java.awt.MenuItem();
                ivjMnFitxerObrir.setLabel(resGUI.getString("Obrir_"));
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjMnFitxerObrir;
    }
    /**
     * Return the MnFitxerSortir property value.
     * @return java.awt.MenuItem
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.MenuItem getMnFitxerSortir() {
        if (ivjMnFitxerSortir == null) {
            try {
                ivjMnFitxerSortir = new java.awt.MenuItem();
                ivjMnFitxerSortir.setLabel(resGUI.getString("Sortir"));
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjMnFitxerSortir;
    }
    /**
     * Return the MnuFitxerExportar property value.
     * @return java.awt.Menu
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.Menu getMnuFitxerExportar() {
        if (ivjMnuFitxerExportar == null) {
            try {
                ivjMnuFitxerExportar = new java.awt.Menu();
                ivjMnuFitxerExportar.setLabel(resGUI.getString("Exportar"));
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjMnuFitxerExportar;
    }
    /**
     * Return the MnuFitxerSalvar property value.
     * @return java.awt.MenuItem
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.MenuItem getMnuFitxerSalvar() {
        if (ivjMnuFitxerSalvar == null) {
            try {
                ivjMnuFitxerSalvar = new java.awt.MenuItem();
                ivjMnuFitxerSalvar.setShortcut(new java.awt.MenuShortcut(java.awt.event.KeyEvent.VK_S, false));
                ivjMnuFitxerSalvar.setLabel(resGUI.getString("Salvar_"));
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjMnuFitxerSalvar;
    }
    /**
     * Return the PanelStackFiltres property value.
     * @return mgc.mf.gui.PnlStackFiltres
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private PnlStackFiltres getPanelStackFiltres() {
        if (ivjPanelStackFiltres == null) {
            try {
                ivjPanelStackFiltres = new mgc.mf.gui.PnlStackFiltres();
                ivjPanelStackFiltres.setName("PanelStackFiltres");
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjPanelStackFiltres;
    }
    /**
     * Return the PnlBarraEines property value.
     * @return java.awt.Panel
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.Panel getPnlBarraEines() {
        if (ivjPnlBarraEines == null) {
            try {
                ivjPnlBarraEines = new java.awt.Panel();
                ivjPnlBarraEines.setName("PnlBarraEines");
                ivjPnlBarraEines.setLayout(getPnlBarraEinesFlowLayout());
                ivjPnlBarraEines.setBackground(java.awt.Color.darkGray);
                ivjPnlBarraEines.setForeground(java.awt.Color.lightGray);
                getPnlBarraEines().add(getBtRegenerar(), getBtRegenerar().getName());
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjPnlBarraEines;
    }
    /**
     * Return the PnlBarraEinesFlowLayout property value.
     * @return java.awt.FlowLayout
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.FlowLayout getPnlBarraEinesFlowLayout() {
        java.awt.FlowLayout ivjPnlBarraEinesFlowLayout = null;
        try {
            /* Create part */
            ivjPnlBarraEinesFlowLayout = new java.awt.FlowLayout();
            ivjPnlBarraEinesFlowLayout.setAlignment(java.awt.FlowLayout.LEFT);
            ivjPnlBarraEinesFlowLayout.setVgap(0);
            ivjPnlBarraEinesFlowLayout.setHgap(0);
        } catch (java.lang.Throwable ivjExc) {
            handleException(ivjExc);
        };
        return ivjPnlBarraEinesFlowLayout;
    }
    /**
     * Return the TxBarraEstat property value.
     * @return java.awt.TextField
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.TextField getTxBarraEstat() {
        if (ivjTxBarraEstat == null) {
            try {
                ivjTxBarraEstat = new java.awt.TextField();
                ivjTxBarraEstat.setName("TxBarraEstat");
                ivjTxBarraEstat.setText("Mons Fractals 1.1");
                ivjTxBarraEstat.setBackground(java.awt.Color.darkGray);
                ivjTxBarraEstat.setEditable(false);
                ivjTxBarraEstat.setForeground(java.awt.Color.lightGray);
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjTxBarraEstat;
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
        getMnFitxerSortir().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                connEtoC1();
            };
        });
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                connEtoC2(e);
            };
        });
        getMnFitxerNou().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                connEtoC3();
            };
        });
        getMnFitxerObrir().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                connEtoC4();
            };
        });
        getMnuFitxerSalvar().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                connEtoC5();
            };
        });
        getBtRegenerar().addActionListener(new java.awt.event.ActionListener() {
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
            addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosing(java.awt.event.WindowEvent e) {
                  sortir();
                };
            });
            // user code end
            setName("FinestraPrincipal");
            setMenuBar(getFinestraPrincipalMenuBar());
            setLayout(new java.awt.BorderLayout());
            setSize(497, 371);
            setTitle("MonsFractals 1.1");
            add(getContentsPane(), "Center");
            initConnections();
        } catch (java.lang.Throwable ivjExc) {
            handleException(ivjExc);
        }
        // user code begin {2}
        if (!Sistema.sEstablert())
        new SistemaGUI(getTxBarraEstat());
        try {
            filtres = new mgc.mf.StackFiltres();
            getPanelStackFiltres().setStackFiltres(filtres);
            afegirTraductors();
        } catch (java.lang.Throwable ivjExc) {
            handleException(ivjExc);
        }
        // user code end
    }
    /**
     * main entrypoint - starts the part when it is run as an application
     * @param args java.lang.String[]
     */
    public static void main(java.lang.String[] args) {
        try {
            FinestraPrincipal aFinestraPrincipal;
            aFinestraPrincipal = new FinestraPrincipal();
            aFinestraPrincipal.setVisible(true);
        } catch (Throwable exception) {
            System.err.println("Exception occurred in main() of java.awt.Frame");
            exception.printStackTrace(System.out);
        }
    }
    /**
     * Comment
     */
    public void objecteRegenerar() 
    {
        RnbGenerarObjecteGUI rnb;
     
        getPanelStackFiltres().acceptarCanvis();
        rnb = new RnbGenerarObjecteGUI();
        rnb.setStackFiltres(filtres);
        new Thread(rnb).start();
        rnb.esperar();
        objecte = rnb.getObjecte();
    }
    /**
     * Comment
     */
    public void sortir() 
    {
        if (Finestra.sGetDefecte() != this)
            return;

        dispose();
        System.exit(0);
    }
}
