/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comun;

/**
 *
 * @author jairo
 */
public class producto {
    private String id;
    private String nombre ;
    private String valor ;
    private String existencias ;
    //
    public producto (String id, String nombre, String valor, String existencias ) {

    this.nombre=nombre;
    this.id=id;
    this.existencias=existencias;
    this.valor=valor;
}

    public producto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @return the existencias
     */
    public String getExistencias() {
        return existencias;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * @param existencias the existencias to set
     */
    public void setExistencias(String existencias) {
        this.existencias = existencias;
    }
    
    @Override
    public String toString() {
        return nombre;
    }
}
