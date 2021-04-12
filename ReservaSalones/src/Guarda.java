/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eljho
 */
public class Guarda extends User{
    private BD bd;
    
    Guarda(String nombre,String apellido,String role,int dni){
        setNombre(nombre);
        setApellido(apellido);
        setRole(role);
        setDni(dni);
    }
    
    public void RegistrarLLegada(Reserva reserva){
        String Values = reserva.MkValuesforGuarda(1);
        getBd().QueryInsertColumnas(Values, "reserva_details", "cod_reserva,observacion,hora_entrega,documento_guarda,llegofuncionario");
    }
    
    public void RegistrarSalida(Reserva reserva){
        getBd().queryUpdate("hora_salida",reserva.getHora_salida(),"reserva_details", "cod_reserva",reserva.getCod_reserva());
        getBd().queryUpdate("observacion_salida",reserva.getObservacion_salida(),"reserva_details", "cod_reserva",reserva.getCod_reserva());
    }
    /**
     * @return the bd
     */
    public BD getBd() {
        return bd;
    }

    /**
     * @param bd the bd to set
     */
    public void setBd(BD bd) {
        this.bd = bd;
    }
    
}
