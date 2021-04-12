/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eljho
 */
public class Administrador extends User{
 
    Administrador(String nombre,String apellido,String role,int dni){
        setNombre(nombre);
        setApellido(apellido);
        setRole(role);
        setDni(dni);
    }
    public void RegistrarPrograma(Programa prog){
        getBd().QueryInsert(prog.MkValues(),"programa");
    }
    public void RegistrarSede(Sede sede){
        getBd().QueryInsert(sede.MkValues(),"sede");
    }
    public void RegistrarAmbiente(Ambiente amb){
        getBd().QueryInsert(amb.Mkvalues(),"ambiente");
    }
    public void RegistrarUser(User usuario){
        getBd().QueryInsert(usuario.Mkvalues(),"users");
        getBd().QueryInsert(usuario.MkvaluesforRole(),"roles");
    }
    public void RegistrarAsignatura(Evento event,String codProg){
        getBd().QueryInsert(event.MkvaluesforActividad(),"actividad");
        getBd().QueryInsert(event.MkvaluesforAsignatura(),"asignatura");
        getBd().QueryInsert(event.MkvaluesforAsociado(codProg),"asociado");
    }
    public void RegistrarEvento(Evento event){
        getBd().QueryInsert(event.MkvaluesforActividad(),"actividad");
        getBd().QueryInsert(event.MkvaluesforEvent(),"evento");
    }
    public String Consulta(int consulta){
        String resultadoConsulta = "";
        switch(consulta){
            case 1:
                resultadoConsulta = getBd().getAllusers("users","roles");
                break;
            case 2:
                resultadoConsulta = getBd().getAllfromTable("sede");
                break;
            case 3:
                resultadoConsulta =  getBd().getAllfromTable("programa");
                break;
            case 4:
                resultadoConsulta = getBd().getAllofTablasJoinned("Asignatura", "Actividad","Asignatura.codigoasignatura,nombre", "codigoasignatura", "codigoactividad");
                break;
            case 5:
                resultadoConsulta = getBd().getAllofTablasJoinned("evento", "Actividad","evento.codigoevento,nombre,tipo", "codigoevento ", "codigoactividad");
                break;
            case 6:
                resultadoConsulta = getBd().getAllfromTable("Ambiente");
                break;
            default:
                resultadoConsulta = "Todo fallo, retirada tactica al norte";
                break;
        }
        return resultadoConsulta;
    }
    
}
