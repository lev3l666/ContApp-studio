package contapp_studio;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import static vista.abono.pagadoPubli;
/**
 * @web http://jc-mouse.blogspot.com/
 * @author Mouse
 */
public class FormatoTabla extends DefaultTableCellRenderer{    
    Font normal = new Font( "Arial",Font.PLAIN,12 );
    Font negrilla = new Font( "Helvetica",Font.BOLD,18 );
    Font cursiva = new Font( "Times new roman",Font.ITALIC,12 );

    @Override 
    public Component getTableCellRendererComponent ( JTable table, Object value, boolean selected, boolean focused, int row, int column ) 
    {
        setEnabled(table == null || table.isEnabled()); 
        
        setBackground(Color.white);//color de fondo
        table.setFont(normal);//tipo de fuente
        table.setForeground(Color.black);//color de texto
        setHorizontalAlignment(2);//derecha
                
        //si la celda esta vacia se reemplaza por el texto "<vacio>" y se rellena la celda de color negro y fuente color blanco
        //System.out.println("Valor de celda= "+table.getValueAt(row,3).toString()+"Valor pagado: "+pagadoPubli);
        if(Integer.parseInt((String) table.getValueAt(row,3))>pagadoPubli){ 
            setBackground(Color.white);//color de fondo
            table.setFont(normal);//tipo de fuente
            table.setForeground(Color.black);//color de texto
        }
        else{
            setBackground(Color.black);                         
            table.setForeground(Color.white);
            table.setFont(cursiva);
        }
        /*--------*/
        /*/si la celda contiene números
        if(isNumber(String.valueOf(table.getValueAt(row,column)))){
            setBackground(Color.BLUE); 
            setHorizontalAlignment(4);//izquierda
        }/*/      
        
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);         
        return this;
 }
    
 //
 private boolean isNumber(String cadena){
         try {
             Double.parseDouble(cadena.replace(",", ""));
         } catch (NumberFormatException nfe){
             String newCadena = cadena.replace(".", "").replace(',', '.');
             try{
                 Double.parseDouble(newCadena);
             } catch (NumberFormatException nfe2){
                 return false;
             }
        }
         return true;
    }

}
