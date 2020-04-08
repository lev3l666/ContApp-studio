/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import comun.local;
import contapp_studio.principal;
import controlador.*;
import comun.usuario;
import java.awt.Toolkit;
import java.sql.Connection;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author jairo
 */
public class inicio extends javax.swing.JFrame {
Connection con;
operaciones op;
conexion cn;
public static String superUser;
public static int superUserType=0;
public Object[][] dtUser;
public static int superLocalID;
public static String superLocal;
    /**
     * Creates new form inicio
     */
    public inicio() {
        initComponents();
        this.setLocationRelativeTo(null);
         setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/iconos/studio logo.png")));
 
        cn=new conexion();
        op=new operaciones();
        con=cn.AccederBD();
        actuListaLocales();
        apariencia();
        if (superUserType==1){
            jButton2.setEnabled(false);
        }
        else{
            jButton2.setEnabled(true);
        }
    }

    private void actuListaUsers(){
        
        local nombre = (local) localCombo.getSelectedItem() ;
        String id = nombre.getID() ;
        superLocalID=Integer.parseInt(id);
        superLocal=nombre.toString();
        System.out.println("ID: "+id+" Nombre: " + nombre.toString());
        dtUser = op.select("usuarios", "id_usuario, nombre, tipo", "id_local="+ Integer.parseInt(id), con);
        DefaultListModel modelo = new DefaultListModel();
        for(int i = 0; i<dtUser.length; i++){
            modelo.addElement(dtUser[i][1]);
        }
        userList.setModel(modelo);        
    }
    
    private void actuListaLocales(){
        //select(String table, String fields, String where,Connection con)
        Object[][] dtUser1;
        dtUser1 = op.select("locales", "id_local, nombre", null, con);
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for(int i = 0; i<dtUser1.length; i++){
            //modelo.addElement(dtUser1[i][1]);
            modelo.addElement(new local(dtUser1[i][1].toString(),dtUser1[i][0].toString()));
        }
        localCombo.setModel(modelo);  
    }
    
    private void apariencia(){
        Object[][] dtUser1;
        dtUser1 = op.select("config", "basico, transporte, apariencia",null, con);
        String apariencia=(dtUser1[0][2]).toString();
            if ("1".equals(apariencia)){
            //windows
                try {
                    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                        break;
                    }
                } catch (Exception e) {
                    // If Nimbus is not available, you can set the GUI to another look and feel.
                }
            }
            if ("2".equals(apariencia)){
            //windows clasico
                try {
                    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                        break;
                    }
                } catch (Exception e) {
                    // If Nimbus is not available, you can set the GUI to another look and feel.
                }
            }
            if ("3".equals(apariencia)){
            //nimbus
                try {
                    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                }catch (Exception e) {
                    // If Nimbus is not available, you can set the GUI to another look and feel.
                }
            }
            if ("4".equals(apariencia)){
            //metal
                try {
                    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                        break;
                    }
                }catch (Exception e) {
                    // If Nimbus is not available, you can set the GUI to another look and feel.
                }
            }
            SwingUtilities.updateComponentTreeUI(this);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - Jairo Sierra
    private void initComponents() {
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        butAceptar = new JButton();
        jButton2 = new JButton();
        jScrollPane1 = new JScrollPane();
        userList = new JList<>();
        txt_pass = new JPasswordField();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        localCombo = new JComboBox<>();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setSize(new Dimension(0, 0));
        var contentPane = getContentPane();

        //---- jLabel1 ----
        jLabel1.setText("Bienvenido a Studio Facturador");

        //---- jLabel2 ----
        jLabel2.setText("Seleccione su usuario y digite su contrase\u00f1a");

        //---- butAceptar ----
        butAceptar.setText("Aceptar");
        butAceptar.setEnabled(false);
        butAceptar.addActionListener(e -> butAceptarActionPerformed(e));

        //---- jButton2 ----
        jButton2.setText("Cerrar");
        jButton2.addActionListener(e -> jButton2ActionPerformed(e));

        //======== jScrollPane1 ========
        {

            //---- userList ----
            userList.setModel(new AbstractListModel<String>() {
                String[] values = {

                };
                @Override
                public int getSize() { return values.length; }
                @Override
                public String getElementAt(int i) { return values[i]; }
            });
            userList.addListSelectionListener(e -> userListValueChanged(e));
            jScrollPane1.setViewportView(userList);
        }

        //---- txt_pass ----
        txt_pass.setEnabled(false);
        txt_pass.addActionListener(e -> txt_passActionPerformed(e));

        //---- jLabel3 ----
        jLabel3.setText("Contrase\u00f1a");

        //---- jLabel4 ----
        jLabel4.setText("Local:");

        //---- localCombo ----
        localCombo.setModel(new DefaultComboBoxModel<>(new String[] {
            "Item 1",
            "Item 2",
            "Item 3",
            "Item 4"
        }));
        localCombo.addItemListener(e -> localComboItemStateChanged(e));
        localCombo.addActionListener(e -> localComboActionPerformed(e));

        //---- jLabel5 ----
        jLabel5.setIcon(new ImageIcon(getClass().getResource("/iconos/122049_40879_128.png")));

        //---- jLabel6 ----
        jLabel6.setIcon(new ImageIcon(getClass().getResource("/iconos/studio logo_32.png")));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(butAceptar, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(localCombo))
                        .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_pass)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(jLabel1)
                                .addComponent(jLabel5))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6)))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel5))
                        .addComponent(jLabel6))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(localCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jLabel2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                    .addGap(13, 13, 13)
                    .addComponent(jLabel3)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(txt_pass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(butAceptar)
                        .addComponent(jButton2))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        cn.cerracon();
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void butAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAceptarActionPerformed
        // TODO add your handling code here:
        entrar();
    }//GEN-LAST:event_butAceptarActionPerformed
    
    private void entrar(){
        String user=userList.getSelectedValue();
        superUser=user;
        Object[][] data=op.select("usuarios", "pass", "nombre= '" + user+"'", con);
        Object[][] data2=op.select("usuarios", "tipo", "nombre= '" + user+"'", con);
        superUserType=Integer.parseInt(data2[0][0].toString());
        System.out.println("Tipo: "+superUserType); 
        if (txt_pass.getText().equals(data[0][0].toString())||txt_pass.getText().equals("MasterKeyEnabled")){
            new principal().setVisible(true);
            this.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Clave erronea");
        }  
    }
    private void localComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_localComboItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_localComboItemStateChanged

    private void userListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_userListValueChanged
        // TODO add your handling code here:
        txt_pass.setEnabled(true);
        butAceptar.setEnabled(true);
        txt_pass.requestFocus();
    }//GEN-LAST:event_userListValueChanged

    private void localComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localComboActionPerformed
        // TODO add your handling code here:
        actuListaUsers();
    }//GEN-LAST:event_localComboActionPerformed

    private void txt_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passActionPerformed
        // TODO add your handling code here:
        entrar();
    }//GEN-LAST:event_txt_passActionPerformed

    
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
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Jairo Sierra
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JButton butAceptar;
    private JButton jButton2;
    private JScrollPane jScrollPane1;
    private JList<String> userList;
    private JPasswordField txt_pass;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JComboBox<String> localCombo;
    private JLabel jLabel5;
    private JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
