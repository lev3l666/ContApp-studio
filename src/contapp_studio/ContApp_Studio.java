/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contapp_studio;

import controlador.conexion;
import controlador.operaciones;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jairo
 */
public class ContApp_Studio {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Connection con;
        operaciones op;
        conexion cn;
        Object[][] dtUser;
        cn=new conexion();
        op=new operaciones();
        con=cn.AccederBD();         
        try{
            dtUser = op.select("usuarios", "id_usuario, nombre, tipo", null, con);
            System.out.println(dtUser[0][1]);
            new vista.inicio().setVisible(true);
        }
        catch(Exception e){
        //se comprueba si es el primer uso
            System.out.println(e.getLocalizedMessage());
            cn.CrearBD();
            new vista.primeraVez().setVisible(true);
        }
    }
    
    
}
