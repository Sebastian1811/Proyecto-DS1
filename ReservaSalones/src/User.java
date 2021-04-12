/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eljho
 */
public class User {
    private String Role;
    private String Nombre;
    private String Apellido;
    private String email;
    private int dni;
    private String Contraseña;
    private BD bd;
   
    User(){
    }
    
    User (String dni,String nombre,String apellido,String pass,String correo,String role){
        Nombre = nombre;
        Apellido = apellido;
        this.dni = Integer.parseInt(dni);
        Contraseña = pass;
        Role = role;
        email = correo;
    }

    /**
     * @return the Role
     */
    public String getRole() {
        return Role;
    }

    /**
     * @param Role the Role to set
     */
    public void setRole(String Role) {
        this.Role = Role;
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
     * @return the Apellido
     */
    public String getApellido() {
        return Apellido;
    }

    /**
     * @param Apellido the Apellido to set
     */
    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    /**
     * @return the dni
     */
    public int getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(int dni) {
        this.dni = dni;
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
    
    public String Mkvalues(){
        return dni+","+"'"+Nombre+"'"+","+"'"+Apellido+"'" +","+"'"+Contraseña+
                "'"+","+"'"+email+"'";
    }
    public String MkvaluesforRole(){
        return dni+","+"'"+Role+"'";
    }
    
}
