/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eljho
 */
public class Evento {
    private String Codigo;
    private String Tipo;
    private String Nombre;

    /**
     * @return the Codigo
     */
    Evento(String codigo,String nombre){ // constructor para asignatura
        Nombre = nombre;
        Codigo = codigo;
    }
    
    Evento (String codigo, String nombre, String tipo){ // constructor para evento
        Nombre = nombre;
        Codigo = codigo;
        Tipo = tipo;
    }
    public String getCodigo() {
        return Codigo;
    }

    /**
     * @param Codigo the Codigo to set
     */
    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    /**
     * @return the Tipo
     */
    public String getTipo() {
        return Tipo;
    }

    /**
     * @param Tipo the Tipo to set
     */
    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public String MkvaluesforAsignatura(){
        return Codigo;
    }
    public String MkvaluesforEvent(){
        return Codigo +",'"+Tipo+"'";
    }
    public String MkvaluesforActividad(){
        return Codigo +",'"+Nombre+"'";
    }
    public String MkvaluesforAsociado(String codProg){
        return Codigo+",'"+codProg+"'";
    }
}
