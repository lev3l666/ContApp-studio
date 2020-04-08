/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.opencsv.CSVWriter;
import comun.local;
import contapp_studio.principal;
import static contapp_studio.principal.tam;
import static contapp_studio.principal.themeChanged;
import controlador.conexion;
import controlador.operaciones;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
import static vista.inicio.superLocalID;
import static vista.inicio.superLocal;

/**
 *
 * @author jairo
 */
public class configRoles extends javax.swing.JFrame {
    Connection con;
    operaciones op;
    conexion cn;
    int conejito=0;
    int cerdito=0;
    int quesito=1;
    int editStatus=0;
    int empleadoStatus=0;
    int superLocalIDOrig=superLocalID;
    String bdEleccion;

    /**
     * Creates new form configRoles
     */
    public configRoles() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Configuracion - " + superLocal);
        //
        cn=new conexion();
        op=new operaciones();
        con=cn.AccederBD();
        //
        actuConfig();
        actuListaUsers();
        actuListaLocales();
        actuListaProductos();
        actuListaEmpleados();
        bdEleccion="id_factura, id_detalle, id_producto, nombre, cantidad, valor, fecha FROM factura NATURAL JOIN detalle NATURAL JOIN productos ORDER BY id_factura";
    }

    private void actuListaUsers(){
        DefaultTableModel datosuser;
        Object[][] dtUser;
        String[] columNames = {"ID","Nombre","Tipo","Contraseña"};  
            dtUser = op.select("usuarios", "id_usuario, nombre, tipo, pass", "id_local=" + superLocalID, con);
            datosuser = new DefaultTableModel(dtUser,columNames);                        
            table.setModel(datosuser);
            TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<TableModel>(datosuser);
            table.setRowSorter(elQueOrdena);

    }
    
    private void actuListaEmpleados(){
        DefaultTableModel datosuser;
        Object[][] dtUser;
        String[] columNames = {"ID","Nombre"};  
            dtUser = op.select("empleados", "id_empleado, nombre", "id_local=" + superLocalID, con);
            datosuser = new DefaultTableModel(dtUser,columNames);                        
            table1.setModel(datosuser);
            TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<TableModel>(datosuser);
            table1.setRowSorter(elQueOrdena);

    }
    
    private void actuListaProductos(){
        DefaultTableModel datos;
        Object[][] dtUser;
        String[] columNames = {"ID","Nombre","Valor"};  
            dtUser = op.select("productos", "id_producto, nombre, valor", "id_local=" + superLocalIDOrig, con);
            datos = new DefaultTableModel(dtUser,columNames);                        
            table2.setModel(datos);
            TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<TableModel>(datos);
            table2.setRowSorter(elQueOrdena);

    }
    
    private void actuConfig(){
        Object[][] dtUser;  
            dtUser = op.select("config", "basico, transporte, apariencia","id_config="+1, con);
            String basico=(dtUser[0][0]).toString();
            String transporte=(dtUser[0][1]).toString();
            String apariencia=(dtUser[0][2]).toString();
            //
            txtBasico.setText(basico);
            txtTransporte.setText(transporte);
            if ("1".equals(apariencia)){
                //windows
                radioWin.setSelected(true);
                radioWinCla.setSelected(false);
                radioNimb.setSelected(false);
                radioMetal.setSelected(false);
            }
            if ("2".equals(apariencia)){
                //windows clasico
                radioWin.setSelected(false);
                radioWinCla.setSelected(true);
                radioNimb.setSelected(false);
                radioMetal.setSelected(false);
            }
            if ("3".equals(apariencia)){
                //nimbus
                radioWin.setSelected(false);
                radioWinCla.setSelected(false);
                radioNimb.setSelected(true);
                radioMetal.setSelected(false);
            }
            if ("4".equals(apariencia)){
                //metal
                radioWin.setSelected(false);
                radioWinCla.setSelected(false);
                radioNimb.setSelected(false);
                radioMetal.setSelected(true);
            }
            //

    }
    
    private void actuListaLocales(){
        Object[][] dtUser1;
        dtUser1 = op.select("locales", "id_local, nombre", null, con);
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for(int i = 0; i<dtUser1.length; i++){
            //modelo.addElement(dtUser1[i][1]);
            modelo.addElement(new local(dtUser1[i][1].toString(),dtUser1[i][0].toString()));
        }
        localCombo.setModel(modelo);
        localCombo1.setModel(modelo); 
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
        radioAdmin = new javax.swing.JRadioButton();
        txt_nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        radioCajero = new javax.swing.JRadioButton();
        btnGuardar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        txt_pass = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        localCombo1 = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        lblBasico = new javax.swing.JLabel();
        txtTransporte = new javax.swing.JFormattedTextField();
        btnEditarSalario = new javax.swing.JButton();
        btnCancelarSalario = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        btnAgregar1 = new javax.swing.JButton();
        btnEditar1 = new javax.swing.JButton();
        btnEliminar1 = new javax.swing.JButton();
        btnGuardar1 = new javax.swing.JButton();
        btnCancelar1 = new javax.swing.JButton();
        txtNombreEmpleado = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        lblTransporte = new javax.swing.JLabel();
        txtBasico = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_nombre1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_pass2 = new javax.swing.JTextField();
        btnGuardar2 = new javax.swing.JButton();
        btnCancelar2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        btnAgregar2 = new javax.swing.JButton();
        btnEditar2 = new javax.swing.JButton();
        btnEliminar2 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        radioMetal = new javax.swing.JRadioButton();
        radioWinCla = new javax.swing.JRadioButton();
        radioNimb = new javax.swing.JRadioButton();
        radioWin = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        localCombo = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestion de roles");
        setAlwaysOnTop(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        radioAdmin.setText("Administrador");
        radioAdmin.setEnabled(false);
        radioAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioAdminActionPerformed(evt);
            }
        });
        jPanel1.add(radioAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        txt_nombre.setEnabled(false);
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 252, -1));

        jLabel2.setText("Contraseña");
        jLabel2.setEnabled(false);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 90, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 397, 80, -1));

        radioCajero.setSelected(true);
        radioCajero.setText("Cajero");
        radioCajero.setEnabled(false);
        radioCajero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCajeroActionPerformed(evt);
            }
        });
        jPanel1.add(radioCajero, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 90, -1));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 397, 80, -1));

        txt_pass.setEnabled(false);
        jPanel1.add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 252, -1));

        jLabel1.setText("Nombre de usuario");
        jLabel1.setEnabled(false);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 259, -1));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Tipo", "Contraseña"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(table);
        table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMaxWidth(30);
            table.getColumnModel().getColumn(2).setMaxWidth(30);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 171, 252, 220));

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 397, 80, -1));

        localCombo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        localCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                localCombo1ActionPerformed(evt);
            }
        });
        jPanel1.add(localCombo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, -1));

        jTabbedPane1.addTab("Roles", jPanel1);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBasico.setText("Basico:");
        lblBasico.setEnabled(false);
        jPanel4.add(lblBasico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, -1));

        txtTransporte.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txtTransporte.setEnabled(false);
        txtTransporte.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        txtTransporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTransporteKeyTyped(evt);
            }
        });
        jPanel4.add(txtTransporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 100, -1));

        btnEditarSalario.setText("Editar");
        btnEditarSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarSalarioActionPerformed(evt);
            }
        });
        jPanel4.add(btnEditarSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 80, -1));

        btnCancelarSalario.setText("Cerrar");
        btnCancelarSalario.setEnabled(false);
        btnCancelarSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarSalarioActionPerformed(evt);
            }
        });
        jPanel4.add(btnCancelarSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 80, -1));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table1.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(table1);
        table1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 189, 252, 200));

        btnAgregar1.setText("Agregar");
        btnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnAgregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 395, 80, -1));

        btnEditar1.setText("Editar");
        btnEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnEditar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 395, 80, -1));

        btnEliminar1.setText("Eliminar");
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 395, 80, -1));

        btnGuardar1.setText("Guardar");
        btnGuardar1.setEnabled(false);
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnGuardar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 90, -1));

        btnCancelar1.setText("Cancelar");
        btnCancelar1.setEnabled(false);
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnCancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 90, -1));

        txtNombreEmpleado.setEnabled(false);
        jPanel4.add(txtNombreEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 252, -1));
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 280, 10));

        jLabel4.setText("Nombre");
        jLabel4.setEnabled(false);
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 252, -1));

        lblTransporte.setText("Transporte:");
        lblTransporte.setEnabled(false);
        jPanel4.add(lblTransporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        txtBasico.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txtBasico.setEnabled(false);
        txtBasico.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        txtBasico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBasicoKeyTyped(evt);
            }
        });
        jPanel4.add(txtBasico, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 100, -1));

        jLabel16.setText("Configurar salario");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 260, -1));

        jLabel17.setText("Configurar empleados");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 250, -1));

        jTabbedPane1.addTab("Empleados", jPanel4);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Nombre de producto");
        jLabel5.setEnabled(false);
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 259, -1));

        txt_nombre1.setEnabled(false);
        jPanel3.add(txt_nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 31, 252, -1));

        jLabel7.setText("Valor");
        jLabel7.setEnabled(false);
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 57, -1, -1));

        txt_pass2.setEnabled(false);
        txt_pass2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_pass2KeyTyped(evt);
            }
        });
        jPanel3.add(txt_pass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 77, 252, -1));

        btnGuardar2.setText("Guardar");
        btnGuardar2.setEnabled(false);
        btnGuardar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar2ActionPerformed(evt);
            }
        });
        jPanel3.add(btnGuardar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 108, 90, -1));

        btnCancelar2.setText("Cancelar");
        btnCancelar2.setEnabled(false);
        btnCancelar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar2ActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancelar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 108, 90, -1));

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tipo", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table2.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(table2);

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 252, 250));

        btnAgregar2.setText("Agregar");
        btnAgregar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar2ActionPerformed(evt);
            }
        });
        jPanel3.add(btnAgregar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 396, 80, -1));

        btnEditar2.setText("Editar");
        btnEditar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar2ActionPerformed(evt);
            }
        });
        jPanel3.add(btnEditar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 396, 80, -1));

        btnEliminar2.setText("Eliminar");
        btnEliminar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar2ActionPerformed(evt);
            }
        });
        jPanel3.add(btnEliminar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 396, 80, -1));
        jPanel3.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 142, 280, 0));

        jTabbedPane1.addTab("Productos", jPanel3);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        radioMetal.setForeground(new java.awt.Color(0, 102, 255));
        radioMetal.setText("Metal");
        radioMetal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMetalActionPerformed(evt);
            }
        });
        jPanel2.add(radioMetal, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 58, -1, -1));

        radioWinCla.setForeground(new java.awt.Color(0, 102, 255));
        radioWinCla.setText("Windows clásico");
        radioWinCla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioWinClaActionPerformed(evt);
            }
        });
        jPanel2.add(radioWinCla, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 32, -1, -1));

        radioNimb.setText("Nimbus");
        radioNimb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNimbActionPerformed(evt);
            }
        });
        jPanel2.add(radioNimb, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 58, -1, -1));

        radioWin.setText("Windows");
        radioWin.setName(""); // NOI18N
        radioWin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioWinActionPerformed(evt);
            }
        });
        jPanel2.add(radioWin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 32, -1, -1));

        jLabel6.setText("Apariencia");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 83, 281, 10));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 280, 10));

        jLabel8.setText("Bases de datos");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jButton3.setText("Exportar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        jButton4.setForeground(new java.awt.Color(255, 0, 51));
        jButton4.setText("Purgar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 80, -1));

        jLabel9.setText("Locales");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 60, -1));

        localCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(localCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 170, -1));

        jButton6.setText("+");
        jButton6.setToolTipText("Agregar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 50, -1));

        jButton7.setText("-");
        jButton7.setToolTipText("Eliminar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 50, -1));

        jLabel10.setForeground(new java.awt.Color(153, 0, 0));
        jLabel10.setText("Opciones del sistema");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel11.setForeground(new java.awt.Color(204, 0, 51));
        jLabel11.setText("AVISO: estas opciones modifican la base de datos");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel12.setForeground(new java.awt.Color(255, 0, 51));
        jLabel12.setText("Alterarla podria terminar en perdida de datos");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jButton8.setText("✎");
        jButton8.setToolTipText("Editar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 50, -1));

        jRadioButton2.setText("Movimientos");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, -1));

        jRadioButton3.setSelected(true);
        jRadioButton3.setText("Facturas");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 70, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/studio logo_32.png"))); // NOI18N
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        jTabbedPane1.addTab("Varios", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        conejito=1;
        jLabel1.setEnabled(true);
        jLabel2.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        txt_pass.setEnabled(true);
        txt_nombre.setEnabled(true);
        radioCajero.setEnabled(true);
        radioAdmin.setEnabled(true);
        btnAgregar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        
        //
        try{
            int row = table.getSelectedRow();
            String nombre=table.getValueAt(row, 1).toString();
            String pass=table.getValueAt(row, 3).toString();
            txt_nombre.setText(nombre);
            txt_pass.setText(pass);
            conejito=2;
            jLabel1.setEnabled(true);
            jLabel2.setEnabled(true);
            btnGuardar.setEnabled(true);
            btnCancelar.setEnabled(true);
            txt_pass.setEnabled(true);
            txt_nombre.setEnabled(true);
            radioCajero.setEnabled(false);
            radioAdmin.setEnabled(false);
            btnAgregar.setEnabled(false);
            btnEditar.setEnabled(false);
            btnEliminar.setEnabled(false);
        }
        catch(Exception ex) {
             JOptionPane.showMessageDialog(this,"Seleccione el usuario a editar");
        }

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        local nombreLocal = (local) localCombo.getSelectedItem() ;
        int idLocal = Integer.parseInt(nombreLocal.getID());
        if(txt_nombre.getText().length()>=5 && txt_pass.getText().length()>=5){
            if (conejito==1){
                //agregar
                op.insertar("usuarios", "nombre,pass,tipo,id_local", "'" + txt_nombre.getText() + "','" + txt_pass.getText() + "'," + quesito +"," + idLocal, con); }
            if (conejito==2){
                //editar
                int row = table.getSelectedRow();
                int id=Integer.parseInt(table.getValueAt(row, 0).toString());
                String nombre=txt_nombre.getText();
                String pass=txt_pass.getText();
                System.out.println(id);
                op.modificar("usuarios", "nombre ='"+nombre+"', pass='"+pass+"'", "id_usuario="+id, con);
                //String table, String value, String where, Connection con
                //String query ="UPDATE "+table+" SET " + value + " WHERE "+ where;
                
                
                
                //desactivar edicion
                jLabel1.setEnabled(false);
                jLabel2.setEnabled(false);
                btnGuardar.setEnabled(false);
                btnCancelar.setEnabled(false);
                txt_pass.setEnabled(false);
                txt_nombre.setEnabled(false);
                radioCajero.setEnabled(false);
                radioAdmin.setEnabled(false);
                btnAgregar.setEnabled(true);
                btnEditar.setEnabled(true);
                btnEliminar.setEnabled(true);
            }
            txt_nombre.setText("");
            txt_pass.setText("");
            actuListaUsers();
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Deben existir 5 caracteres o mas para \nlos campos de usuario y contraseña");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        jLabel1.setEnabled(false);
        jLabel2.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        txt_pass.setEnabled(false);
        txt_nombre.setEnabled(false);
        radioCajero.setEnabled(false);
        radioAdmin.setEnabled(false);
        btnAgregar.setEnabled(true);
        btnEditar.setEnabled(true);
        btnEliminar.setEnabled(true);
        txt_nombre.setText("");
        txt_pass.setText("");

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void radioCajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCajeroActionPerformed
        // TODO add your handling code here:
        radioAdmin.setSelected(false);
        quesito=1;
    }//GEN-LAST:event_radioCajeroActionPerformed

    private void radioAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioAdminActionPerformed
        // TODO add your handling code here:
        radioCajero.setSelected(false);
        quesito=0;
    }//GEN-LAST:event_radioAdminActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        try{
            int row = table.getSelectedRow();
            String id1=table.getValueAt(row, 0).toString();
            String name=table.getValueAt(row, 1).toString();
            int id=Integer.parseInt(id1);
            int response = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar a "+name+"?", "Confirmacion",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                if (id==0){
                    JOptionPane.showMessageDialog(this,"El primer usuario no se puede eliminar.\nSi desea, puede editarlo.");
                }
                else{
                    //"DELETE FROM cliente WHERE id_cliente = '" + var + "';";
                   op.eliminar("usuarios", "id_usuario = "+ id, con);//String table, String where, int value, Connection con
                   actuListaUsers(); 
                }
            }   
        }
        catch(Exception ex) {
             JOptionPane.showMessageDialog(this,"Seleccione el usuario a eliminar");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar1ActionPerformed
        // TODO add your handling code here:
        empleadoStatus=1;
        jLabel4.setEnabled(true);
        btnGuardar1.setEnabled(true);
        btnCancelar1.setEnabled(true);
        txtNombreEmpleado.setEnabled(true);
        btnAgregar1.setEnabled(false);
        btnEditar1.setEnabled(false);
        btnEliminar1.setEnabled(false);
    }//GEN-LAST:event_btnAgregar1ActionPerformed

    private void btnEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar1ActionPerformed
        // TODO add your handling code here:
        try{
            int row = table1.getSelectedRow();
            String nombre=table1.getValueAt(row, 1).toString();
            txtNombreEmpleado.setText(nombre);
            empleadoStatus=0;
            jLabel4.setEnabled(true);
            btnGuardar1.setEnabled(true);
            btnCancelar1.setEnabled(true);
            txtNombreEmpleado.setEnabled(true);
            btnAgregar1.setEnabled(false);
            btnEditar1.setEnabled(false);
            btnEliminar1.setEnabled(false);
        }
        catch(Exception ex) {
             JOptionPane.showMessageDialog(this,"Seleccione el empleado a editar");
        }
    }//GEN-LAST:event_btnEditar1ActionPerformed

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
        // TODO add your handling code here:
        try{
            int row = table1.getSelectedRow();
            String id1=table1.getValueAt(row, 0).toString();
            String name=table1.getValueAt(row, 1).toString();
            int id=Integer.parseInt(id1);
            int response = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar a "+name+"?", "Confirmacion",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                //"DELETE FROM cliente WHERE id_cliente = '" + var + "';";
                op.eliminar("empleados", "id_empleado = "+ id, con);//String table, String where, int value, Connection con
                actuListaEmpleados(); 
                
            }   
        }
        catch(Exception ex) {
             JOptionPane.showMessageDialog(this,"Seleccione el empleado a eliminar");
        }
    }//GEN-LAST:event_btnEliminar1ActionPerformed

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
        // TODO add your handling code here:
        if(txtNombreEmpleado.getText().length()>=5){
            if (empleadoStatus==1){
                //agregar
                op.insertar("empleados", "nombre,id_local", "'" + txtNombreEmpleado.getText() + "'," + superLocalIDOrig, con); }
            if (empleadoStatus==0){
                int row = table1.getSelectedRow();
                int id=Integer.parseInt(table1.getValueAt(row, 0).toString());
                String nombre=txtNombreEmpleado.getText();
                op.modificar("empleados", "nombre ='"+nombre+"'", "id_empleado="+id, con);
                
                //desactivar edicion
                jLabel4.setEnabled(false);
                btnGuardar1.setEnabled(false);
                btnCancelar1.setEnabled(false);
                txtNombreEmpleado.setEnabled(false);
                btnAgregar1.setEnabled(true);
                btnEditar1.setEnabled(true);
                btnEliminar1.setEnabled(true);
            }
        }
            txtNombreEmpleado.setText("");
            actuListaEmpleados();
    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        // TODO add your handling code here:
        jLabel4.setEnabled(false);
        btnGuardar1.setEnabled(false);
        btnCancelar1.setEnabled(false);
        txtNombreEmpleado.setEnabled(false);
        btnAgregar1.setEnabled(true);
        btnEditar1.setEnabled(true);
        btnEliminar1.setEnabled(true);
    }//GEN-LAST:event_btnCancelar1ActionPerformed

    private void radioMetalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMetalActionPerformed
        try {
                for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(
            UIManager.getCrossPlatformLookAndFeelClassName());

                        break;
                    }
                }
            } catch (Exception e) {
                // If Nimbus is not available, you can set the GUI to another look and feel.
            }
        SwingUtilities.updateComponentTreeUI(this);
        themeChanged=true;
        radioNimb.setSelected(false);
        radioWinCla.setSelected(false);
        radioWin.setSelected(false);
        op.modificar("config", "apariencia ="+4+"", "id_config="+1, con);
    }//GEN-LAST:event_radioMetalActionPerformed

    private void radioWinClaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioWinClaActionPerformed
        // TODO add your handling code here:
        try {
                for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");

                        break;
                    }
                }
            } catch (Exception e) {
                // If Nimbus is not available, you can set the GUI to another look and feel.
            }
        SwingUtilities.updateComponentTreeUI(this);
        themeChanged=true;
        radioNimb.setSelected(false);
        radioWin.setSelected(false);
        radioMetal.setSelected(false);
        op.modificar("config", "apariencia ="+2+"", "id_config="+1, con);
    }//GEN-LAST:event_radioWinClaActionPerformed

    private void radioNimbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNimbActionPerformed
        // TODO add your handling code here:
        try {
                for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (Exception e) {
                // If Nimbus is not available, you can set the GUI to another look and feel.
            }
        SwingUtilities.updateComponentTreeUI(this);
        themeChanged=true;
        radioWin.setSelected(false);
        radioWinCla.setSelected(false);
        radioMetal.setSelected(false);
        tam.setSize(tam.width, tam.height+50);
        op.modificar("config", "apariencia ="+3+"", "id_config="+1, con);
    }//GEN-LAST:event_radioNimbActionPerformed

    private void radioWinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioWinActionPerformed
        // TODO add your handling code here:
        try {
                for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

                        break;
                    }
                }
            } catch (Exception e) {
                // If Nimbus is not available, you can set the GUI to another look and feel.
            }
        SwingUtilities.updateComponentTreeUI(this);
        themeChanged=true;
        radioNimb.setSelected(false);
        radioWinCla.setSelected(false);
        radioMetal.setSelected(false);
        op.modificar("config", "apariencia ="+1+"", "id_config="+1, con);
            actuListaLocales();
    }//GEN-LAST:event_radioWinActionPerformed

    private void btnGuardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar2ActionPerformed
        // TODO add your handling code here:
        if(txt_nombre1.getText().length()>=4 && txt_pass2.getText().length()>=4){
            if (cerdito==1){
                //agregar
                op.insertar("productos", "nombre,valor,existencias,id_local", "'" + txt_nombre1.getText() + "'," + Integer.parseInt(txt_pass2.getText()) + "," +0+","+ superLocalIDOrig, con); }
            if (cerdito==2){
                //editar
                int row = table2.getSelectedRow();
                int id=Integer.parseInt(table2.getValueAt(row, 0).toString());
                String nombre=txt_nombre1.getText();
                String pass=txt_pass2.getText();
                System.out.println(id);
                op.modificar("productos", "nombre ='"+nombre+"', valor="+pass, "id_producto="+id, con);
                
                //desactivar edicion
                jLabel5.setEnabled(false);
                jLabel7.setEnabled(false);
                btnGuardar2.setEnabled(false);
                btnCancelar2.setEnabled(false);
                txt_pass2.setEnabled(false);
                txt_nombre1.setEnabled(false);
                btnAgregar2.setEnabled(true);
                btnEditar2.setEnabled(true);
                btnEliminar2.setEnabled(true);
            }
            txt_nombre1.setText("");
            txt_pass2.setText("");
            actuListaProductos();
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Deben existir 4 caracteres o mas para los campos");
        }
    }//GEN-LAST:event_btnGuardar2ActionPerformed

    private void btnCancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar2ActionPerformed
        // TODO add your handling code here:
        jLabel5.setEnabled(false);
        jLabel7.setEnabled(false);
        btnGuardar2.setEnabled(false);
        btnCancelar2.setEnabled(false);
        txt_pass2.setEnabled(false);
        txt_nombre1.setEnabled(false);
        btnAgregar2.setEnabled(true);
        btnEditar2.setEnabled(true);
        btnEliminar2.setEnabled(true);
        txt_nombre1.setText("");
        txt_pass2.setText("");
    }//GEN-LAST:event_btnCancelar2ActionPerformed

    private void btnAgregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar2ActionPerformed
        // TODO add your handling code here:
         cerdito=1;
        jLabel5.setEnabled(true);
        jLabel7.setEnabled(true);
        btnGuardar2.setEnabled(true);
        btnCancelar2.setEnabled(true);
        txt_pass2.setEnabled(true);
        txt_nombre1.setEnabled(true);
        btnAgregar2.setEnabled(false);
        btnEditar2.setEnabled(false);
        btnEliminar2.setEnabled(false);
    }//GEN-LAST:event_btnAgregar2ActionPerformed

    private void btnEditar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar2ActionPerformed
        // TODO add your handling code here:
        //
        try{
            int row = table2.getSelectedRow();
            String nombre=table2.getValueAt(row, 1).toString();
            String pass=table2.getValueAt(row, 2).toString();
            txt_nombre1.setText(nombre);
            txt_pass2.setText(pass);
            cerdito=2;
            jLabel5.setEnabled(true);
            jLabel7.setEnabled(true);
            btnGuardar2.setEnabled(true);
            btnCancelar2.setEnabled(true);
            txt_pass2.setEnabled(true);
            txt_nombre1.setEnabled(true);
            btnAgregar2.setEnabled(false);
            btnEditar2.setEnabled(false);
            btnEliminar2.setEnabled(false);
        }
        catch(Exception ex) {
            System.out.println("Error : " + ex.getMessage());
             JOptionPane.showMessageDialog(this,"Seleccione el producto a editar");
        }
    }//GEN-LAST:event_btnEditar2ActionPerformed

    private void btnEliminar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar2ActionPerformed
        // TODO add your handling code here:
        try{
            int row = table2.getSelectedRow();
            String id1=table2.getValueAt(row, 0).toString();
            String name=table2.getValueAt(row, 1).toString();
            int id=Integer.parseInt(id1);
            int response = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar a "+name+"?", "Confirmacion",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                op.eliminar("productos", "id_producto = "+ id, con);//String table, String where, int value, Connection con
                actuListaProductos();
            }   
        }
        catch(Exception ex) {
             JOptionPane.showMessageDialog(this,"Seleccione el producto a eliminar");
        }
    }//GEN-LAST:event_btnEliminar2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        String nombre = JOptionPane.showInputDialog(this, "Ingrese nombre del local a agregar");
        if (nombre!=null){
            op.insertar("locales", "nombre", "'" + nombre + "'", con); 
            actuListaLocales();
        }
        else{
            System.out.println("vacio");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        local sel = (local) localCombo.getSelectedItem() ;
        int id = Integer.parseInt(sel.getID());
        String nombre = JOptionPane.showInputDialog(this, "Editando nombre de: " + sel.toString(), sel.toString());
        if (nombre!=null){
            op.modificar("locales", "nombre ='"+nombre+"'", "id_local="+id, con);
            actuListaLocales();
        }
        else{
            System.out.println("vacio");
        }
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here: eliiar
        local nombre = (local) localCombo.getSelectedItem() ;
        
        int id = Integer.parseInt(nombre.getID());
        int response = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar el local "+nombre.toString()+"?", "Confirmacion",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                if (id==1){
                    JOptionPane.showMessageDialog(this,"El primer local no se puede eliminar.\nSi desea, puede editarlo.");
                }
                else{
                    //"DELETE FROM cliente WHERE id_cliente = '" + var + "';";
                   op.eliminar("locales", "id_local = "+ id, con);//String table, String where, int value, Connection con
                   actuListaLocales();
                }
            }   
    }//GEN-LAST:event_jButton7ActionPerformed

    private void localCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localCombo1ActionPerformed
        // TODO add your handling code here:
        local nombreLocal = (local) localCombo.getSelectedItem() ;
        int idLocal = Integer.parseInt(nombreLocal.getID());
        superLocalID=idLocal;
        actuListaUsers();
    }//GEN-LAST:event_localCombo1ActionPerformed

    private void txt_pass2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pass2KeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if (!Character.isDigit(c)){
            evt.consume();
            System.out.println("Caracter invalido");
            JOptionPane.showMessageDialog(this,"Caracter invalido; ingrese solo numeros en este campo");
        }
    }//GEN-LAST:event_txt_pass2KeyTyped

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        jRadioButton3.setSelected(false);
        bdEleccion="* FROM movimientos";
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void btnEditarSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarSalarioActionPerformed
        // TODO add your handling code here:
        //if(txt_nombre.getText().length()>=5 && txt_pass.getText().length()>=5){
            if (editStatus==1){
                //modificar
                if(txtBasico.getText().length()>=4 && txtTransporte.getText().length()>=4){
                    op.modificar("config", "basico ="+Integer.parseInt(txtBasico.getText())+", transporte="+Integer.parseInt(txtTransporte.getText()), "id_config="+1, con);
                    btnCancelarSalario.setEnabled(false);
                    lblBasico.setEnabled(false);
                    txtBasico.setEnabled(false);
                    lblTransporte.setEnabled(false);
                    txtTransporte.setEnabled(false);
                    btnEditarSalario.setText("Editar");
                    editStatus=0;
                    actuConfig();
                }
                else{
                    JOptionPane.showMessageDialog(this,"Ingrese una cantidad valida");
                }
            }
            if (editStatus==0){
                //editar
                btnEditarSalario.setText("Guardar");
                btnCancelarSalario.setEnabled(true);
                lblBasico.setEnabled(true);
                txtBasico.setEnabled(true);
                lblTransporte.setEnabled(true);
                txtTransporte.setEnabled(true);
                editStatus=1;
            }
    }//GEN-LAST:event_btnEditarSalarioActionPerformed

    private void btnCancelarSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarSalarioActionPerformed
        // TODO add your handling code here:
        editStatus=0;
        btnEditarSalario.setText("Editar");
        btnCancelarSalario.setEnabled(false);
        lblBasico.setEnabled(false);
        txtBasico.setEnabled(false);
        lblTransporte.setEnabled(false);
        txtTransporte.setEnabled(false);
    }//GEN-LAST:event_btnCancelarSalarioActionPerformed

    private void txtTransporteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTransporteKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if (!Character.isDigit(c)){
            evt.consume();
            System.out.println("Caracter invalido");
            JOptionPane.showMessageDialog(this,"Caracter invalido; ingrese solo numeros en este campo");
        }
    }//GEN-LAST:event_txtTransporteKeyTyped

    private void txtBasicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBasicoKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if (!Character.isDigit(c)){
            evt.consume();
            System.out.println("Caracter invalido");
            JOptionPane.showMessageDialog(this,"Caracter invalido; ingrese solo numeros en este campo");
        }
    }//GEN-LAST:event_txtBasicoKeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        exportar();
    }//GEN-LAST:event_jButton3ActionPerformed
    
    private void exportar(){
        CSVWriter writer;
        Calendar hoy = Calendar.getInstance();
        try {
            //Consulta
            String q="SELECT " +bdEleccion;
            //
            SimpleDateFormat formatoPredefinido = new SimpleDateFormat("d' de 'MMMM");
            String dia=formatoPredefinido.format(hoy.getTime()).toString();
            SimpleDateFormat formatoMes = new SimpleDateFormat("MMMM' de 'yyyy");
            String mes=formatoMes.format(hoy.getTime()).toString();
            //
            File directorio=new File(System.getProperty("user.home")+"/Studio Facturador/Reportes/"+mes); 
            directorio.mkdirs(); 
            //
            PreparedStatement pstm = con.prepareStatement(q);
            ResultSet res = pstm.executeQuery();
            String elegido="facturas";
            if (jRadioButton3.isSelected()){
                elegido="facturas";
            }
            if (jRadioButton2.isSelected()){
                elegido="movimientos";
            }
            Boolean includeHeaders = true;
            writer = new CSVWriter(new FileWriter(directorio+"/"+elegido+"-"+dia+".csv"), CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER);
            writer.writeAll(res, includeHeaders);
            res.close();
            System.out.println("Guardado en: "+directorio);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(configRoles.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(configRoles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (!jRadioButton3.isSelected()&&!jRadioButton2.isSelected()){
            JOptionPane.showMessageDialog(this, "seleccione la base de datos a purgar");
        }
        else{
           String msg = "<html><u><b>PRECAUCION:</b></u><BR>Purgar la base de datos se realiza con fines de<BR> limpieza de datos que <u>ya no son necesarios</u><BR> y pueden ser borrados para conservar <BR>consistencia en la base de datos. <BR>Purgue la base de datos bajo su criterio<BR><u>periodicamente</u><BR><b>¿ESTA SEGURO QUE DESEA PURGAR?</b></html>";
        JLabel label = new JLabel(msg);
        
        exportar();
       // label.setFont(new Font("serif", Font.PLAIN, 14));
        int response = JOptionPane.showConfirmDialog(this, label, "ATENCION",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            //consulta
            if (jRadioButton3.isSelected()){
                String q="TRUNCATE TABLE detalle";
                String q2="TRUNCATE TABLE separe";
                String q3="DELETE FROM factura";
                String q4="ALTER TABLE factura ALTER id_factura RESTART WITH 1";
                try {    
                    PreparedStatement pstm = con.prepareStatement(q);
                    PreparedStatement pstm2 = con.prepareStatement(q2);
                    PreparedStatement pstm3 = con.prepareStatement(q3);
                    PreparedStatement pstm4 = con.prepareStatement(q4);
                    pstm.executeUpdate();
                    pstm2.executeUpdate();
                    pstm3.executeUpdate();
                    pstm4.executeUpdate();
                    JOptionPane.showConfirmDialog(this,"Purga completada con éxito, tabla exportada antes del proceso y guardada");
                }catch (Exception ex) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(this, "ERROR:"+ex);
                }  
            }
            if (jRadioButton2.isSelected()){
                String q="TRUNCATE TABLE movimientos";
                try {    
                    PreparedStatement pstm = con.prepareStatement(q);
                    pstm.executeUpdate();
                }catch (Exception ex) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(this, "ERROR:"+ex);
                }
            }
             
          }  
        }
        
        
    
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        jRadioButton2.setSelected(false);
        bdEleccion="id_factura, id_detalle, id_producto, nombre, cantidad, valor, fecha FROM factura NATURAL JOIN detalle NATURAL JOIN productos ORDER BY id_factura";
    }//GEN-LAST:event_jRadioButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(configRoles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(configRoles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(configRoles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(configRoles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new configRoles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregar1;
    private javax.swing.JButton btnAgregar2;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnCancelar2;
    private javax.swing.JButton btnCancelarSalario;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEditar1;
    private javax.swing.JButton btnEditar2;
    private javax.swing.JButton btnEditarSalario;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnEliminar2;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardar1;
    private javax.swing.JButton btnGuardar2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblBasico;
    private javax.swing.JLabel lblTransporte;
    private javax.swing.JComboBox<String> localCombo;
    private javax.swing.JComboBox<String> localCombo1;
    private javax.swing.JRadioButton radioAdmin;
    private javax.swing.JRadioButton radioCajero;
    private javax.swing.JRadioButton radioMetal;
    private javax.swing.JRadioButton radioNimb;
    private javax.swing.JRadioButton radioWin;
    private javax.swing.JRadioButton radioWinCla;
    private javax.swing.JTable table;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    private javax.swing.JFormattedTextField txtBasico;
    private javax.swing.JTextField txtNombreEmpleado;
    private javax.swing.JFormattedTextField txtTransporte;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_nombre1;
    private javax.swing.JTextField txt_pass;
    private javax.swing.JTextField txt_pass2;
    // End of variables declaration//GEN-END:variables
}
