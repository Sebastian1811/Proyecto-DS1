/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eljho
 */
public class Sede {
    private int NumSede;
    private String Nombre;
    private String Direccion;
    
    Sede(int Numsede,String Nombre,String Direccion){
        this.NumSede = Numsede;
        this.Direccion = Direccion;
        this.Nombre = Nombre;
    }

    /**
     * @return the NumSede
     */
    public int getNumSede() {
        return NumSede;
    }

    /**
     * @param NumSede the NumSede to set
     */
    public void setNumSede(int NumSede) {
        this.NumSede = NumSede;
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
     * @return the Direccion
     */
    public String getDireccion() {
        return Direccion;
    }

    /**
     * @param Direccion the Direccion to set
     */
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    
    public String MkValues(){
        return "'"+NumSede+"',"+"'"+Nombre+"',"+"'"+Direccion+"'";
    }
}
