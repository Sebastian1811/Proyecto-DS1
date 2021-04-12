/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eljho
 */
public class Ambiente {
    private String Cod_amb;
    private String Cod_sede;
    private String Area;
    private String Nombre;
    private String capacidad;
    private String tipoAmb;
    
    Ambiente (String codAmb, String area,String nombre,String capacidad,String tipo,String codSede ){
        Cod_amb = codAmb;
        Area = area;
        Nombre = nombre;
        this.capacidad = capacidad;
        this.tipoAmb = tipo;
        Cod_sede = codSede;
    }

    /**
     * @return the Cod_amb
     */
    public String getCod_amb() {
        return Cod_amb;
    }

    /**
     * @param Cod_amb the Cod_amb to set
     */
    public void setCod_amb(String Cod_amb) {
        this.Cod_amb = Cod_amb;
    }

    /**
     * @return the Area
     */
    public String getArea() {
        return Area;
    }

    /**
     * @param Area the Area to set
     */
    public void setArea(String Area) {
        this.Area = Area;
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

    /**
     * @return the capacidad
     */
    public String getCapacidad() {
        return capacidad;
    }

    /**
     * @param capacidad the capacidad to set
     */
    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * @return the tipoAmb
     */
    public String getTipoAmb() {
        return tipoAmb;
    }

    /**
     * @param tipoAmb the tipoAmb to set
     */
    public void setTipoAmb(String tipoAmb) {
        this.tipoAmb = tipoAmb;
    }

    public String Mkvalues(){
        return "'"+Cod_amb+"',"+"'"+Area+"',"+"'"+Nombre+"',"+capacidad+","+"'"+tipoAmb+"',"+Cod_sede;
    }
}
