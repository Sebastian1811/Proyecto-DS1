/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eljho
 */
public class Funcionario extends User {
    private BD bd;
    
    Funcionario(String nombre,String apellido,String role,int dni){
        setNombre(nombre);
        setApellido(apellido);
        setRole(role);
        setDni(dni);
    }
    
    public void makeReserva(Reserva reserva){
        getBd().QueryInsert(reserva.MkValuesforFuncionario(),"reserva");
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
