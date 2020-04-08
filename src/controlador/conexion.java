/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jairo
 */
public class conexion {
    private Connection conn = null;
    public Connection CrearBD(){
       try{
         //obtenemos el driver de para mysql
         Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         //obtenemos la conexión
         conn = DriverManager.getConnection("jdbc:derby:.\\DB;create=true");
         if (conn!=null){
            System.out.println("BD OK");
            String tablaLocales="CREATE TABLE locales (id_local BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), nombre varchar(255),PRIMARY KEY (id_local))";
            String tablaUsuarios="CREATE TABLE usuarios (id_usuario BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), id_local BIGINT,nombre varchar(255), pass varchar(255), tipo INT, FOREIGN KEY (id_local) REFERENCES locales(id_local),PRIMARY KEY (id_usuario))";
            String tablaEmpleados="CREATE TABLE empleados ( id_empleado BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), nombre varchar(255) , deuda INT DEFAULT NULL , fechaUltimoPago DATE , id_local BIGINT,FOREIGN KEY (id_local) REFERENCES locales(id_local),PRIMARY KEY (id_empleado))";
            String tablaProductos="CREATE TABLE productos ( id_producto BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), nombre VARCHAR(255) NOT NULL , valor INT NOT NULL , existencias INT ,id_local BIGINT,FOREIGN KEY (id_local) REFERENCES locales(id_local),PRIMARY KEY (id_producto))";
            String tablaMovimientos="CREATE TABLE movimientos ( id_movimiento BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), descripcion VARCHAR(255) , tipo VARCHAR(255) NOT NULL , valor INT , fecha DATE NOT NULL , id_local BIGINT,FOREIGN KEY (id_local) REFERENCES locales(id_local),PRIMARY KEY (id_movimiento))";
            String tablaFactura="CREATE TABLE factura ( id_factura BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), fecha DATE NOT NULL , id_local BIGINT,FOREIGN KEY (id_local) REFERENCES locales(id_local),PRIMARY KEY (id_factura))";
            String tablaSepare="CREATE TABLE separe ( id_separe BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),id_factura BIGINT NOT NULL , nombre VARCHAR(255) NOT NULL , telefono VARCHAR(255) , abono INT NOT NULL , id_local BIGINT,FOREIGN KEY (id_local) REFERENCES locales(id_local),FOREIGN KEY (id_factura) REFERENCES factura(id_factura) ,PRIMARY KEY (id_separe))";
            String tablaDetalle="CREATE TABLE detalle ( id_detalle BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),id_factura BIGINT NOT NULL , id_producto BIGINT NOT NULL , cantidad INT NOT NULL , valor INT NOT NULL , id_local BIGINT,FOREIGN KEY (id_local) REFERENCES locales(id_local),FOREIGN KEY (id_factura) REFERENCES factura(id_factura) ,FOREIGN KEY (id_producto) REFERENCES productos(id_producto) ,PRIMARY KEY (id_detalle))";
            String tablaConfig="CREATE TABLE config (id_config INT,basico INT,transporte INT, apariencia INT)";

            String desc="disconnect;";
            try {
                
                //
                PreparedStatement pstm = conn.prepareStatement(tablaLocales);
                pstm.execute();
                pstm.close();
                System.out.println("Listo Locales");
                //
                PreparedStatement pstm2 = conn.prepareStatement(tablaUsuarios);
                pstm2.execute();
                pstm2.close();
                System.out.println("Listo Usuarios");
                //
                PreparedStatement pstm3 = conn.prepareStatement(tablaEmpleados);
                pstm3.execute();
                pstm3.close();
                System.out.println("Listo Empleados");
                //
                PreparedStatement pstm4 = conn.prepareStatement(tablaProductos);
                pstm4.execute();
                pstm4.close();
                System.out.println("Listo Productos");
                //
                PreparedStatement pstm5 = conn.prepareStatement(tablaMovimientos);
                pstm5.execute();
                pstm5.close();
                System.out.println("Listo Movimientos");
                //
                PreparedStatement pstm6 = conn.prepareStatement(tablaFactura);
                pstm6.execute();
                pstm6.close();
                System.out.println("Listo Factura");
                //
                PreparedStatement pstm7 = conn.prepareStatement(tablaSepare);
                pstm7.execute();
                pstm7.close();
                System.out.println("Listo Separe");
                //
                PreparedStatement pstm8 = conn.prepareStatement(tablaDetalle);
                pstm8.execute();
                pstm8.close();
                System.out.println("Listo Detalle");
                //
                PreparedStatement pstm9 = conn.prepareStatement(tablaConfig);
                pstm9.execute();
                pstm9.close();
                System.out.println("Listo Config");
                //
                System.out.println("\nTodas las tablas creadas");
                PreparedStatement pstmF = conn.prepareStatement(desc);
                pstmF.execute();
                pstmF.close();

                System.out.println("BD creada correctamente");
            } 
            catch (SQLException ex) {
                System.out.println("Ya creada " + ex.getLocalizedMessage());
            }
         }
      }catch(SQLException e){
       System.out.println("Error SQL: " + e.getMessage());
      }catch(ClassNotFoundException e){
        System.out.println("Error JAVA: " + e.getMessage());
      }
       return conn;
  }
    
     public Connection AccederBD(){
       try{
         //obtenemos el driver de para mysql
         Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         //obtenemos la conexión
         conn = DriverManager.getConnection("jdbc:derby:.\\DB");
         if (conn!=null){
            System.out.println("BD Accedida");
         }
      }catch(SQLException e){
       System.out.println("Error" + e.getMessage());
      }catch(ClassNotFoundException e){
       System.out.println("Error" + e.getMessage());
      }
       return conn;
  }
     
      public void cerracon(){
        try {
            //conn.close();
            DriverManager.getConnection("jdbc:derby:.\\DB;shutdown=true");
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
     
}
