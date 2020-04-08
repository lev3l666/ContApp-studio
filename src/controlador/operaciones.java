/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author jairo
 */
public class operaciones {
    
     public Object [][] select(String table, String fields, String where, Connection con){
      int registros = 0;      
      String colname[] = fields.split(",");

      //Consultas SQL
      String q ="SELECT " + fields + " FROM " + table;
      String q2 = "SELECT count(*) as total FROM " + table;
      if(where!=null)
      {
          q+= " WHERE " + where;
          q2+= " WHERE " + where;
      }
       try{
         PreparedStatement pstm = con.prepareStatement(q2);
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
          System.out.println(e.getLocalizedMessage());
      }
    System.out.println(q);///////////////////////////////////////////////////////////////////////////
    //se crea una matriz con tantas filas y columnas que necesite
    Object[][] data = new String[registros][fields.split(",").length];
    //realizamos la consulta sql y llenamos los datos en la matriz "Object"
      try{
         PreparedStatement pstm = con.prepareStatement(q);
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            for(int j=0; j<=fields.split(",").length-1;j++){
                data[i][j] = res.getString( colname[j].trim() );
            }
            i++;         }
         res.close();
          }catch(SQLException e){
            System.out.println(e);
    }
    return data;
 }
      public int insertar(String table, String fields, String values,Connection con){
        int generatedkey=0;
        //Se arma la consulta
        String q=" INSERT INTO " + table + " ( " + fields + " ) VALUES ( " + values + " ) ";
        System.out.println(q);////////////////////////////////////////////////////////////////////////
        //se ejecuta la consulta
        try {
            PreparedStatement pstm = con.prepareStatement(q, Statement.RETURN_GENERATED_KEYS);
            
            pstm.execute();
            
            ResultSet rs=pstm.getGeneratedKeys();
            System.out.println("Insertado correctamente");
            if (rs.next()) {
                generatedkey=rs.getInt(1);   
               System.out.println("ID auto generado: " + generatedkey); 
            }
            pstm.close();
        } 
        catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        
      return generatedkey;
    }
     
    public boolean eliminar(String table, String where,  Connection con){
        String query ="DELETE FROM " + table + " WHERE " + where ;
        System.out.println(query);//////////////////////////////////////////////////////////////////////
        boolean res=false;
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.execute();
            pstm.close();
            res=true;
            System.out.println("Eliminado correctamente");
        }
        catch (SQLException ex) {
            System.out.println("No se pudo eliminar: "+ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(null,"No se pudo eliminar elemento, debe primero purgar todas las relaciones hijas e intentarlo de nuevo\nCodigo de error: "+ex.getLocalizedMessage());
        }
        return res;
    }
    
    public boolean modificar(String table, String value, String where, Connection con){
        String query ="UPDATE "+table+" SET " + value + " WHERE "+ where;
        boolean res=false;
        System.out.println(query);/////////////////////////////////////////////////////////////////////////////
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.execute();
            pstm.close();
            res=true;
            System.out.println("Editado correctamente");
        } 
        catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return res;
    }
    
}
