/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contapp_studio;

import comun.usuario;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import vista.factura;
import vista.abono;
import contapp_studio.ButtonTabComponent;
import controlador.conexion;
import controlador.operaciones;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import vista.cierreCaja;
import vista.consulta;
import static vista.inicio.superUser;
import static vista.inicio.superUserType;
import static vista.inicio.superLocalID;
import static vista.inicio.superLocal;
import vista.inventario;
import vista.nomina;

/**
 *
 * @author jairo
 */
public class principal extends javax.swing.JFrame {
    String version="1.0";
    public static Toolkit tk = Toolkit.getDefaultToolkit();
    public static boolean themeChanged=false;
    public static int noti=0;
    //
    public static JMenuItem menuItem;
    public static Dimension tam;
    public static ArrayList<Component> bloqueadas = new ArrayList<Component>();
    public static DefaultListModel notificaciones = new DefaultListModel();
    private String presente=null;
    Connection con;
    operaciones op;
    conexion cn;
    private usuario usr;
    private vista.inicio clave= new vista.inicio();
    //contador de pestañas
    int facturaPesta;
    int abonoPesta;
    int nominaPesta;
    int inventarioPesta;
    int movimientosPesta;
    int graficosPesta;

    /**
     * Creates new form principal
     */
    public principal() { 
        cn=new conexion();
        op=new operaciones();
        con=cn.AccederBD();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/iconos/studio logo.png")));
        //inicializar contador de pestañas
        facturaPesta=1;
        abonoPesta=1;
        nominaPesta=1;
        inventarioPesta=1;
        movimientosPesta=1;
        graficosPesta=1;
        Calendar hoy = Calendar.getInstance();
                SimpleDateFormat formatoPredefinido = new SimpleDateFormat("yyyy-MM-dd");
                presente=formatoPredefinido.format(hoy.getTime()).toString();
                //
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Studio facturador - " + superLocal);
        //si es cajero, desactivar opciones
        if (superUserType==1){
            jMenuItem4.setEnabled(false);//roles
            jMenuItem1.setEnabled(false);//salir
            btnNomina.setEnabled(false);
            btnInventario.setEnabled(false);
            jMenu1.setForeground(new java.awt.Color(0,51,255));
            jMenu1.setText(superUser + " - Cajero");//setear nombre de usuario
        }
        else
        {
            jMenu1.setForeground(new java.awt.Color(255,51,51));
            jMenu1.setText(superUser + " - Admin");//setear nombre de usuario
        }
       menuItem = new JMenuItem(new AbstractAction("Notificaciones ("+ noti +")") {
            public void actionPerformed(ActionEvent e) {
                jTabbedPane1.setSelectedIndex(0);
                listNotificaciones.requestFocus();
                listNotificaciones.setSelectedIndex(1);
            }
        });
       jMenuBar1.add(menuItem);
              tam=this.getSize();

       listNotificaciones.setModel(notificaciones);
       listNotificaciones.setSelectionBackground(Color.CYAN);
        ListDataListener listDataListener = new ListDataListener() {
      public void contentsChanged(ListDataEvent listDataEvent) {
        appendEvent(listDataEvent);
      }

      public void intervalAdded(ListDataEvent listDataEvent) {
        appendEvent(listDataEvent);
      }

      public void intervalRemoved(ListDataEvent listDataEvent) {
        appendEvent(listDataEvent);
      }

      private void appendEvent(ListDataEvent listDataEvent) {
          Color colorin;
          if(notificaciones.getSize()>0){
              colorin=(new java.awt.Color(0,153,51));
          }
          else{
              colorin=(new java.awt.Color(192,192,192));
          }
        switch (listDataEvent.getType()) {
        case ListDataEvent.CONTENTS_CHANGED:
          System.out.println("Type: Contents Changed");
          menuItem.setText("Notificaciones ("+ notificaciones.getSize() +")");
          menuItem.setForeground(colorin);
          break;
        case ListDataEvent.INTERVAL_ADDED:
          System.out.println("Type: Interval Added");
          menuItem.setText("Notificaciones ("+ notificaciones.getSize() +")");
          menuItem.setForeground(colorin);
          break;
        case ListDataEvent.INTERVAL_REMOVED:
          System.out.println("Type: Interval Removed");
          menuItem.setText("Notificaciones ("+ notificaciones.getSize() +")");
          menuItem.setForeground(colorin);
          break;
        }
        System.out.println(", Index0: " + listDataEvent.getIndex0());
        System.out.println(", Index1: " + listDataEvent.getIndex1());
        notificaciones = (DefaultListModel) listDataEvent.getSource();
        System.out.println(notificaciones);
      }
    };

    notificaciones.addListDataListener(listDataListener);
    notificaciones();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        PPALlNumFac = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        PPALnumSepareReg = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PPALnumSepareEntreg = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        PPALnumMovimientosReg = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        PPALnumIngresos = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        PPALnumGastos = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        PPALnumBalance = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        PPALprodVendidos = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        PPALprodSeparados = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        PPALnumIngresosVentas = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        PPALnumIngresosAbono = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        PPALnumAcumulaSeparaciones = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listNotificaciones = new javax.swing.JList<>();
        jButton7 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        btnNomina = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentShown(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/121860_40690_128.png"))); // NOI18N
        jButton1.setText("Facturar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/121907_40737_128.png"))); // NOI18N
        jButton4.setText("Graficos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/121868_40698_128.png"))); // NOI18N
        btnInventario.setText("Inventario");
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/121862_40692_128.png"))); // NOI18N
        jButton8.setText("Abonar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Registro día"));

        PPALlNumFac.setForeground(new java.awt.Color(0, 153, 51));
        PPALlNumFac.setText("0");

        jLabel1.setText("Facturas registradas");

        PPALnumSepareReg.setForeground(java.awt.Color.red);
        PPALnumSepareReg.setText("0");

        jLabel2.setText("Separe registrados");

        PPALnumSepareEntreg.setForeground(new java.awt.Color(0, 153, 51));
        PPALnumSepareEntreg.setText("0");

        jLabel3.setText("Separe entregados");

        PPALnumMovimientosReg.setForeground(java.awt.Color.blue);
        PPALnumMovimientosReg.setText("0");

        jLabel4.setText("Movimientos registrados");

        PPALnumIngresos.setForeground(new java.awt.Color(0, 153, 51));
        PPALnumIngresos.setText("0");

        jLabel5.setText("En ingresos");

        PPALnumGastos.setForeground(java.awt.Color.red);
        PPALnumGastos.setText("0");

        jLabel6.setText("En gastos");

        PPALnumBalance.setForeground(java.awt.Color.blue);
        PPALnumBalance.setText("0");

        jLabel7.setText("Balance");

        jLabel8.setText("Productos vendidos");

        PPALprodVendidos.setForeground(new java.awt.Color(0, 153, 51));
        PPALprodVendidos.setText("0");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/121968_40798_128.png"))); // NOI18N

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/studio logo.png"))); // NOI18N

        PPALprodSeparados.setForeground(java.awt.Color.red);
        PPALprodSeparados.setText("0");

        jLabel13.setText("Productos separados");

        PPALnumIngresosVentas.setForeground(new java.awt.Color(0, 153, 51));
        PPALnumIngresosVentas.setText("0");

        jLabel14.setText("En ventas");

        PPALnumIngresosAbono.setForeground(new java.awt.Color(0, 153, 51));
        PPALnumIngresosAbono.setText("0");

        jLabel15.setText("En abonos");

        jLabel16.setText("En separaciones");

        PPALnumAcumulaSeparaciones.setForeground(java.awt.Color.red);
        PPALnumAcumulaSeparaciones.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PPALlNumFac)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(PPALprodVendidos)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(PPALnumSepareReg)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(PPALnumSepareEntreg)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(PPALnumMovimientosReg)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(PPALprodSeparados)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(PPALnumIngresos)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(PPALnumGastos)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(PPALnumBalance)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(PPALnumIngresosVentas)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(PPALnumIngresosAbono)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(PPALnumAcumulaSeparaciones)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16))
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PPALlNumFac)
                            .addComponent(jLabel1)))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PPALprodVendidos)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PPALnumSepareReg)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PPALprodSeparados)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PPALnumSepareEntreg)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PPALnumMovimientosReg)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(PPALnumIngresosVentas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(PPALnumIngresosAbono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PPALnumIngresos)
                    .addComponent(jLabel5))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(PPALnumAcumulaSeparaciones))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PPALnumGastos)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PPALnumBalance)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        listNotificaciones.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Notificaciones y recordatorios"));
        listNotificaciones.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listNotificaciones.setOpaque(false);
        listNotificaciones.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                listNotificacionesPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(listNotificaciones);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/122033_40863_128.png"))); // NOI18N
        jButton7.setToolTipText("Leer notificación");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Notas"));
        jTextArea1.setOpaque(false);
        jScrollPane2.setViewportView(jTextArea1);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/122034_40864_128.png"))); // NOI18N
        jButton9.setToolTipText("Agregar notificación");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/122041_40871_128.png"))); // NOI18N
        jButton10.setToolTipText("Rehacer notificaciones iniciales");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        btnNomina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/121863_40693_128.png"))); // NOI18N
        btnNomina.setText("Nómina");
        btnNomina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNominaActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/121851_40681_128.png"))); // NOI18N
        jButton2.setText("Movimientos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/121990_40820_128.png"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/121852_40682_128.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnNomina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnInventario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 473, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnNomina, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Menu", jPanel1);

        jMenu1.setForeground(new java.awt.Color(255, 51, 51));
        jMenu1.setText("Usuario");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/121973_40803_128.png"))); // NOI18N
        jMenuItem5.setText("Cerrar sesion");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/121997_40827_128.png"))); // NOI18N
        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Opciones");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/122046_40876_128.png"))); // NOI18N
        jMenuItem4.setText("Configuracion");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/121967_40797_128.png"))); // NOI18N
        jMenuItem2.setText("Acerca de");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        factura p=new factura(); //declarar tab de factura predeterminada
        jTabbedPane1.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
        jTabbedPane1.add("Factura #"+facturaPesta, p);//crear tab predeterminada
        ButtonTabComponent boton;
        boton=new ButtonTabComponent(jTabbedPane1);
        boton.setIdTab(0);// 0 para que se cierre, 1 para que no
        jTabbedPane1.setTabComponentAt(jTabbedPane1.getTabCount() - 1, boton);//setear boton X
        jTabbedPane1.setSelectedIndex(jTabbedPane1.getTabCount() - 1);//ir a nueva tab
        jTabbedPane1.setBackgroundAt(jTabbedPane1.getTabCount() - 1, new java.awt.Color(153, 255, 153));
        facturaPesta++;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        consulta p=new consulta(); //declarar tab de consulta predeterminada
        jTabbedPane1.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
        jTabbedPane1.add("Movimientos #" + movimientosPesta, p);//crear tab predeterminada
        jTabbedPane1.setTabComponentAt(jTabbedPane1.getTabCount() - 1, new ButtonTabComponent(jTabbedPane1));//setear boton X
        jTabbedPane1.setSelectedIndex(jTabbedPane1.getTabCount() - 1);//ir a nueva tab
        jTabbedPane1.setBackgroundAt(jTabbedPane1.getTabCount() - 1, new java.awt.Color(153,204,255));
        movimientosPesta++;
   
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:   
        tk.beep();
        if (jTabbedPane1.getTabCount()>1){
          JOptionPane.showMessageDialog(this, "No puede salir sin antes cerrar las pestañas abiertas", "Operación imposible", JOptionPane.ERROR_MESSAGE);
        }
        else{
          int response = JOptionPane.showConfirmDialog(null, "¿Está seguro de salir?", "Salir",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                cn.cerracon();
               System.exit(0);
                }  
        }
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        URL url = this.getClass().getResource("/iconos/about.png");  
        ImageIcon icon = new ImageIcon(url);  
        JLabel label = new JLabel("");  
        label.setIcon(icon);  
        JPanel myPanel = new JPanel();
        myPanel.add(label);
        myPanel.add(new JLabel("                                                                                                          V."+version));
        myPanel.add(new JLabel("Creado por Jairo Andrés Sierra Cardona para Studio almacenes"));
        myPanel.add(new JLabel("Medellin 2016"));
        myPanel.add(Box.createVerticalStrut(20));
        myPanel.add(new JLabel("CONTACTO: jairosierra@hotmail.com"));
        myPanel.add(Box.createVerticalStrut(20));
        myPanel.add(new JLabel("LICENCIAS"));
        myPanel.add(Box.createVerticalStrut(10)); 
        myPanel.add(new JLabel("Este programa utiliza los siguientes componentes en su funcionamiento:"));
        myPanel.add(Box.createVerticalStrut(10));
        myPanel.add(new JLabel("Librería \"Derby.jar\" de \"Oracle\" licencia Apache 2.0"));
        myPanel.add(new JLabel("Librería \"jCalendar\" de \"Kai Tödter\" licencia GNU lgpl"));
        myPanel.add(new JLabel("Librería \"jFreeChart\" de \"David Gilbert\" licencia GNU lgpl"));
        myPanel.add(new JLabel("Librería \"OpenCSV\" de \"Glen Smith\" licencia Apache 2.0"));
        myPanel.add(new JLabel("IconPack \"Primo\" de \"Webdesigner Depot\" licencia Creative Commons"));
        myPanel.add(Box.createVerticalStrut(10)); 
        myPanel.add(new JLabel("Este programa y sus componentes no mencionados no pueden ser"));
        myPanel.add(new JLabel("redistribuidos y/o reproducidos o activados sin previo consentimiento"));
        myPanel.add(new JLabel("ni licencia registrada por parte de su creador y/o tienda certificada."));
        myPanel.add(new JLabel("No se permitirá el uso compartido de claves ni activadores, su licencia"));
        myPanel.add(new JLabel("es propietaria, personal e instransferible. El uso indebido de ésta es"));
        myPanel.add(new JLabel("penado por la ley de protección intelectual."));
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.PAGE_AXIS));
        JOptionPane.showMessageDialog(this, myPanel,"Acerca de", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        if (jTabbedPane1.getTabCount()>1){
           JOptionPane.showMessageDialog(this, "Debe cerrar las pestañas abiertas para configurar");
            
        }
        else
        {
            new vista.configRoles().setVisible(true); 
        }
         //this.setVisible(false);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        tk.beep();
        if (jTabbedPane1.getTabCount()>1){
          JOptionPane.showMessageDialog(this, "No puede salir sin antes cerrar las pestañas abiertas", "Operación imposible", JOptionPane.ERROR_MESSAGE);
        }
        else{
           int response = JOptionPane.showConfirmDialog(null, "¿Está seguro de cerrar sesion?", "Cerrar sesion",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                notificaciones.clear();
               this.dispose();
               new vista.inicio().setVisible(true);
                } 
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        // TODO add your handling code here:
        JTabbedPane sourceTabbedPane = (JTabbedPane) evt.getSource();
        int index = sourceTabbedPane.getSelectedIndex();
        System.out.println("Tab cambiada a: " + sourceTabbedPane.getTitleAt(index));
        jTabbedPane1.setSelectedIndex(index);
        if (themeChanged==true){
            SwingUtilities.updateComponentTreeUI(this);
            themeChanged=false;
            this.setSize(tam);
        }
        
        
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        abono p=new abono(); //declarar tab de factura predeterminada
        jTabbedPane1.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
        jTabbedPane1.add("Abono #"+abonoPesta, p);//crear tab predeterminada
        jTabbedPane1.setTabComponentAt(jTabbedPane1.getTabCount() - 1, new ButtonTabComponent(jTabbedPane1));//setear boton X
        jTabbedPane1.setSelectedIndex(jTabbedPane1.getTabCount() - 1);//ir a nueva tab
        jTabbedPane1.setBackgroundAt(jTabbedPane1.getTabCount() - 1, new java.awt.Color(153, 255, 153));
        
        abonoPesta++;
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        cierreCaja p=new cierreCaja(); //declarar tab de consulta predeterminada
        jTabbedPane1.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
        jTabbedPane1.add("Gráfico #"+graficosPesta, p);//crear tab predeterminada
        jTabbedPane1.setTabComponentAt(jTabbedPane1.getTabCount() - 1, new ButtonTabComponent(jTabbedPane1));//setear boton X
        jTabbedPane1.setSelectedIndex(jTabbedPane1.getTabCount() - 1);//ir a nueva tab
        jTabbedPane1.setBackgroundAt(jTabbedPane1.getTabCount() - 1, new java.awt.Color(153,204,255));
        graficosPesta++;
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        // TODO add your handling code here:
        inventario p=new inventario(); //declarar tab de factura predeterminada
        jTabbedPane1.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
        jTabbedPane1.add("Inventario #"+inventarioPesta, p);//crear tab predeterminada
        jTabbedPane1.setTabComponentAt(jTabbedPane1.getTabCount() - 1, new ButtonTabComponent(jTabbedPane1));//setear boton X
        jTabbedPane1.setSelectedIndex(jTabbedPane1.getTabCount() - 1);//ir a nueva tab
        jTabbedPane1.setBackgroundAt(jTabbedPane1.getTabCount() - 1, new java.awt.Color(153, 255, 153));
        inventarioPesta++;
    }//GEN-LAST:event_btnInventarioActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        try{
            notificaciones.remove(listNotificaciones.getSelectedIndex());
        }catch(Exception ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Seleccione notificación para marcar como leída", "error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        String respuesta=JOptionPane.showInputDialog(this, "Ingrese recordatorio a añadir");
        if(respuesta!=null){
            notificaciones.add(0, respuesta);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void listNotificacionesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_listNotificacionesPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_listNotificacionesPropertyChange
    
    private void actualizar(){
        //variables
        int facturasDia=0;
        int separesRegis=0;
        int separesEntr=0;
        int movimientos=0;
        int ingresos=0;
        int gastos=0;
        int prodVendidos=0;
        int prodSeparados=0;
        int IngresosVentas=0;
        int IngresosAbono=0;
        int AcumulaSeparaciones=0;
        //
        //procedimientos para llenar variables//
        //----REGISTRO DEL DÍA
        //facturasDia
        try { 
            String dtUser1="SELECT count(id_factura) as total FROM factura WHERE fecha='"+presente+"' AND id_local="+superLocalID+" AND id_factura NOT IN (SELECT id_factura FROM separe)";
            ResultSet res = con.prepareStatement(dtUser1).executeQuery();
            res.next();
            facturasDia = res.getInt("total");
            System.out.println(facturasDia);
            res.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        //separesRegis
        try { 
            String dtUser1="SELECT count(id_separe) as total FROM separe NATURAL JOIN factura WHERE fecha='"+presente+"' AND id_local="+superLocalID;
            ResultSet res = con.prepareStatement(dtUser1).executeQuery();
            res.next();
            separesRegis = res.getInt("total");
            res.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        //separesEntr
        try { 
            String dtUser1="SELECT count(tipo) as total FROM movimientos WHERE fecha='"+presente+"' AND tipo='Producto entregado' AND id_local="+superLocalID;
            ResultSet res = con.prepareStatement(dtUser1).executeQuery();
            res.next();
            separesEntr = res.getInt("total");
            res.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        //movimientos
        try { 
            String dtUser1="SELECT count(id_movimiento) as total FROM movimientos WHERE fecha='"+presente+"' AND id_local="+superLocalID;
            ResultSet res = con.prepareStatement(dtUser1).executeQuery();
            res.next();
            movimientos = res.getInt("total");
            res.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
       //ingresos
        try { 
            String dtUser1="SELECT SUM(valor) as total FROM movimientos WHERE fecha='"+presente+"'  AND valor>0 AND id_local="+superLocalID; //
            ResultSet res = con.prepareStatement(dtUser1).executeQuery();
            res.next();
            ingresos = res.getInt("total");
            res.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        //gastos
        try { 
            String dtUser1="SELECT SUM(valor) as total FROM movimientos WHERE fecha='"+presente+"'  AND valor<0 AND id_local="+superLocalID;
            ResultSet res = con.prepareStatement(dtUser1).executeQuery();
            res.next();
            gastos = res.getInt("total");
            res.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        //prodComprados
         try { 
            String dtUser1="SELECT SUM(cantidad) as total FROM detalle NATURAL JOIN factura WHERE fecha='"+presente+"' AND id_local="+superLocalID+" AND id_factura NOT IN (SELECT id_factura FROM separe)";
            ResultSet res = con.prepareStatement(dtUser1).executeQuery();
            res.next();
            prodVendidos = res.getInt("total");
            res.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         //prodSeparados
         try { 
            String dtUser1="SELECT SUM(cantidad) as total FROM detalle NATURAL JOIN factura WHERE fecha='"+presente+"' AND id_local="+superLocalID+" AND id_factura IN (SELECT id_factura FROM separe)";
            ResultSet res = con.prepareStatement(dtUser1).executeQuery();
            res.next();
            prodSeparados = res.getInt("total");
            res.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         //IngresosVentas
         try { 
            String dtUser1="SELECT SUM(valor*cantidad) as total FROM detalle NATURAL JOIN factura WHERE fecha='"+presente+"' AND id_local="+superLocalID+" AND id_factura NOT IN (SELECT id_factura FROM separe)";
            ResultSet res = con.prepareStatement(dtUser1).executeQuery();
            res.next();
            IngresosVentas = res.getInt("total");
            res.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         //IngresosAbono
         try { 
            String dtUser1="SELECT SUM(valor) as total FROM movimientos WHERE fecha='"+presente+"' AND tipo='Abono agregado' AND id_local="+superLocalID;
            ResultSet res = con.prepareStatement(dtUser1).executeQuery();
            res.next();
            IngresosAbono = res.getInt("total");
            res.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        //AcumulaSeparaciones
        try { 
            String dtUser1="SELECT SUM(valor*cantidad) as total FROM detalle NATURAL JOIN factura WHERE fecha='"+presente+"' AND id_local="+superLocalID+" AND id_factura IN (SELECT id_factura FROM separe)";
            ResultSet res = con.prepareStatement(dtUser1).executeQuery();
            res.next();
            AcumulaSeparaciones = res.getInt("total");
            res.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        //****REGISTRO DEL DÍA
        
        //
        PPALlNumFac.setText(Integer.toString(facturasDia));
        PPALnumSepareReg.setText(Integer.toString(separesRegis));
        PPALnumSepareEntreg.setText(Integer.toString(separesEntr));
        PPALnumMovimientosReg.setText(Integer.toString(movimientos));
        PPALnumIngresos.setText(Integer.toString(ingresos+IngresosVentas));
        PPALnumGastos.setText(Integer.toString(gastos));
        PPALnumBalance.setText(Integer.toString(ingresos+IngresosVentas+gastos));
        PPALprodVendidos.setText(Integer.toString(prodVendidos));
        PPALprodSeparados.setText(Integer.toString(prodSeparados));
        PPALnumIngresosVentas.setText(Integer.toString(IngresosVentas));
        PPALnumIngresosAbono.setText(Integer.toString(IngresosAbono));
        PPALnumAcumulaSeparaciones.setText(Integer.toString(AcumulaSeparaciones));
    }
    
    private void notificaciones(){
        //fecha
        Calendar hoy = Calendar.getInstance();
        SimpleDateFormat formatoDia = new SimpleDateFormat("dd");
        SimpleDateFormat formatoPredefinido = new SimpleDateFormat("yyyy-MM-dd"); //("d/MM/yyyy hh:mm a");
        String diaDeHoy=formatoDia.format(hoy.getTime()).toString();
        hoy.add(Calendar.DATE, -30);
        String pasado=(formatoPredefinido.format(hoy.getTime()).toString());
        System.out.println("\nDía de hoy es "+diaDeHoy+" y hace 30 días era: "+pasado);
        //---NOTIFICACIONES
        //productos bajo umbral
        try { 
            String dtUser1="SELECT nombre FROM productos WHERE id_local="+superLocalID+" AND existencias<11";
            ResultSet res = con.prepareStatement(dtUser1).executeQuery();
            while(res.next()){
                String umbralProductos = res.getString("nombre");
                umbralProductos="ALERTA: "+umbralProductos+" tiene <10 existencias";
                if(!notificaciones.contains(umbralProductos)){
                    notificaciones.add(0, umbralProductos); 
                }
            }
            res.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        //fecha pago
        if(!notificaciones.contains("Se acerca fecha de pago a empleados")||!notificaciones.contains("Día de pago a empleados")){
           if(Integer.parseInt(diaDeHoy)==14||Integer.parseInt(diaDeHoy)==13||Integer.parseInt(diaDeHoy)==12||Integer.parseInt(diaDeHoy)==29||Integer.parseInt(diaDeHoy)==28||Integer.parseInt(diaDeHoy)==30||Integer.parseInt(diaDeHoy)==31){
                notificaciones.add(0, "Se acerca fecha de pago a empleados"); 
            }
            if(Integer.parseInt(diaDeHoy)==15||Integer.parseInt(diaDeHoy)==1){
                notificaciones.add(0, "Día de pago a empleados"); 
            } 
        }
        //Empleado sin pagar
        try { 
            Calendar emple = Calendar.getInstance();
            SimpleDateFormat formatoDiaEmple = new SimpleDateFormat("yyyy-MM-dd"); //("d/MM/yyyy hh:mm a");
            String diaDeHoyEmple=formatoDiaEmple.format(emple.getTime()).toString();
            emple.add(Calendar.DATE, -15);
            String pasadoEmple=(formatoDiaEmple.format(emple.getTime()).toString());
            String dtUser1="SELECT nombre FROM empleados WHERE id_local="+superLocalID+" AND fechaUltimoPago<='"+pasadoEmple+"'";
            ResultSet res = con.prepareStatement(dtUser1).executeQuery();
            while(res.next()){
                String textoNoti = res.getString("nombre");
                textoNoti="AVISO: empleado "+textoNoti+" sin pagar";
                if(!notificaciones.contains(textoNoti)){
                    notificaciones.add(0, textoNoti); 
                }
            }
            res.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        //vencimiento separe
        try { 
            String dtUser1="SELECT nombre FROM separe NATURAL JOIN factura WHERE id_local="+superLocalID+" AND fecha='"+pasado+"'";
            ResultSet res = con.prepareStatement(dtUser1).executeQuery();
            while(res.next()){
                String textoNoti = res.getString("nombre");
                textoNoti="AVISO: se vence el separe de "+textoNoti+" el día de hoy";
                if(!notificaciones.contains(textoNoti)){
                    notificaciones.add(0, textoNoti); 
                }
            }
            res.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        //vencimiento mañana
        try { 
            hoy.add(Calendar.DATE, 1);
            String pasadoMenos1=(formatoPredefinido.format(hoy.getTime()).toString());
            String dtUser1="SELECT nombre FROM separe NATURAL JOIN factura WHERE id_local="+superLocalID+" AND fecha='"+pasadoMenos1+"'";
            ResultSet res = con.prepareStatement(dtUser1).executeQuery();
            while(res.next()){
                String textoNoti = res.getString("nombre");
                textoNoti="AVISO: se vence el separe de "+textoNoti+" el día de mañana";
                if(!notificaciones.contains(textoNoti)){
                    notificaciones.add(0, textoNoti); 
                }
            }
            res.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        //vencimiento en dos días
        try { 
            hoy.add(Calendar.DATE, 1);
            String pasadoMenos1=(formatoPredefinido.format(hoy.getTime()).toString());
            String dtUser1="SELECT nombre FROM separe NATURAL JOIN factura WHERE id_local="+superLocalID+" AND fecha='"+pasadoMenos1+"'";
            ResultSet res = con.prepareStatement(dtUser1).executeQuery();
            while(res.next()){
                String textoNoti = res.getString("nombre");
                textoNoti="AVISO: se vence el separe de "+textoNoti+" en dos días";
                if(!notificaciones.contains(textoNoti)){
                    notificaciones.add(0, textoNoti); 
                }
            }
            res.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        //vencido
        try { 
            String dtUser1="SELECT nombre FROM separe NATURAL JOIN factura WHERE id_local="+superLocalID+" AND fecha<='"+pasado+"'";
            ResultSet res = con.prepareStatement(dtUser1).executeQuery();
            while(res.next()){
                String textoNoti = res.getString("nombre");
                textoNoti="AVISO: se venció el separe de "+textoNoti;
                if(!notificaciones.contains(textoNoti)){
                    notificaciones.add(0, textoNoti); 
                }
            }
            res.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    private void jPanel1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentShown
        // TODO add your handling code here:
        actualizar();
    }//GEN-LAST:event_jPanel1ComponentShown

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        notificaciones();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void btnNominaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNominaActionPerformed
        // TODO add your handling code here:
        nomina p=new nomina(); //declarar tab de factura predeterminada
        jTabbedPane1.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
        jTabbedPane1.add("Nómina #"+nominaPesta, p);//crear tab predeterminada
        jTabbedPane1.setTabComponentAt(jTabbedPane1.getTabCount() - 1, new ButtonTabComponent(jTabbedPane1));//setear boton X
        jTabbedPane1.setSelectedIndex(jTabbedPane1.getTabCount() - 1);//ir a nueva tab
        jTabbedPane1.setBackgroundAt(jTabbedPane1.getTabCount() - 1, new java.awt.Color(153, 255, 153));
        nominaPesta++;
    }//GEN-LAST:event_btnNominaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                new principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PPALlNumFac;
    private javax.swing.JLabel PPALnumAcumulaSeparaciones;
    private javax.swing.JLabel PPALnumBalance;
    private javax.swing.JLabel PPALnumGastos;
    private javax.swing.JLabel PPALnumIngresos;
    private javax.swing.JLabel PPALnumIngresosAbono;
    private javax.swing.JLabel PPALnumIngresosVentas;
    private javax.swing.JLabel PPALnumMovimientosReg;
    private javax.swing.JLabel PPALnumSepareEntreg;
    private javax.swing.JLabel PPALnumSepareReg;
    private javax.swing.JLabel PPALprodSeparados;
    private javax.swing.JLabel PPALprodVendidos;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnNomina;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JList<String> listNotificaciones;
    // End of variables declaration//GEN-END:variables

    
}
