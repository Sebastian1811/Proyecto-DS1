/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eljho
 */
public class Programa {
    private String Nombre;
    private String Jornada;
    private int Codigo;

    /**
     * @return the Nombre
     */
    Programa (String nombre,String jornada,int codigo){
        Nombre = nombre;
        Jornada = jornada;
        Codigo = codigo;
    }
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Jornada
     */
    public String getJornada() {
        return Jornada;
    }

    /**
     * @param Jornada the Jornada to set
     */
    public void setJornada(String Jornada) {
        this.Jornada = Jornada;
    }

    /**
     * @return the Codigo
     */
    public int getCodigo() {
        return Codigo;
    }

    /**
     * @param Codigo the Codigo to set
     */
    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }
    
    public String MkValues(){
        return Codigo+","+"'"+Nombre+"',"+"'"+Jornada+"'";
    }
    
}
