/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eljho
 */
public class Reserva {
    private String cod_reserva;
    private String fecha_inicio;
    private String hora_inicio;
    private String hora_fin;
    private String fecha_fin;
    private String dni_funcionario;
    private String cod_evento;
    private String cod_ambiente;
    private boolean llego;
    private String observacion_guarda;
    private String hora_entrega;
    private String hora_salida;
    private String dni_guarda;
    private String observacion_salida;
    
    Reserva(String codReserva,String fechaInicio,String horaInicio,String horaFin,String fechaFin,String dniFuncionario,String codEvento,String codAmbiente){
        cod_reserva = codReserva;
        fecha_inicio = fechaInicio;
        hora_inicio = horaInicio;
        hora_fin = horaFin;
        fecha_fin = fechaFin;
        dni_funcionario = dniFuncionario;
        cod_evento = codEvento;
        cod_ambiente = codAmbiente;
    }
    Reserva(String codReserva,String observacionGuarda,String horaSalida ){
        cod_reserva = codReserva;
        observacion_salida = observacionGuarda;
        hora_salida = horaSalida;
    }
     Reserva(String codReserva,String observacionGuarda,String horaEntrega,String dniGuarda,boolean llego){
        cod_reserva = codReserva;
        observacion_guarda = observacionGuarda;
        hora_entrega = horaEntrega;
        dni_guarda = dniGuarda;
        this.llego = llego;
    }
    public String MkValuesforFuncionario(){
        return cod_reserva+",'"+fecha_inicio+"','"+hora_inicio+"','"+hora_fin+"','"+fecha_fin+"',"
                +dni_funcionario+","+cod_evento+","+cod_ambiente;
    }
    public String MkValuesforGuarda(int Opcion){
        String Resultado="";
        switch(Opcion){
            case 1:
                Resultado = cod_reserva+",'"+observacion_guarda+"','"+hora_entrega+"',"+dni_guarda+","+llego;
                break;
            case 2:
                Resultado = "'"+getObservacion_salida()+"','"+hora_salida+"'";
                break;
            default:
                System.out.println("todo fallo");
                break;
        }
        return Resultado;
    }
    /**
     * @return the cod_ambiente
     */
    public String getCod_ambiente() {
        return cod_ambiente;
    }

    /**
     * @param cod_ambiente the cod_ambiente to set
     */
    public void setCod_ambiente(String cod_ambiente) {
        this.cod_ambiente = cod_ambiente;
    }

   
    /**
     * @return the cod_reserva
     */
    public String getCod_reserva() {
        return cod_reserva;
    }

    /**
     * @param cod_reserva the cod_reserva to set
     */
    public void setCod_reserva(String cod_reserva) {
        this.cod_reserva = cod_reserva;
    }

    /**
     * @return the cod_evento
     */
    public String getCod_evento() {
        return cod_evento;
    }

    /**
     * @param cod_evento the cod_evento to set
     */
    public void setCod_evento(String cod_evento) {
        this.cod_evento = cod_evento;
    }

   

    /**
     * @return the dni_funcionario
     */
    public String getDni_funcionario() {
        return dni_funcionario;
    }

    /**
     * @param dni_funcionario the dni_funcionario to set
     */
    public void setDni_funcionario(String dni_funcionario) {
        this.dni_funcionario = dni_funcionario;
    }

    /**
     * @return the dni_guarda
     */
    public String getDni_guarda() {
        return dni_guarda;
    }

    /**
     * @param dni_guarda the dni_guarda to set
     */
    public void setDni_guarda(String dni_guarda) {
        this.dni_guarda = dni_guarda;
    }

    /**
     * @return the observacion_guarda
     */
    public String getObservacion_guarda() {
        return observacion_guarda;
    }

    /**
     * @param observacion_guarda the observacion_guarda to set
     */
    public void setObservacion_guarda(String observacion_guarda) {
        this.observacion_guarda = observacion_guarda;
    }

    /**
     * @return the hora_entrega
     */
    public String getHora_entrega() {
        return hora_entrega;
    }

    /**
     * @param hora_entrega the hora_entrega to set
     */
    public void setHora_entrega(String hora_entrega) {
        this.hora_entrega = hora_entrega;
    }

    /**
     * @return the hora_salida
     */
    public String getHora_salida() {
        return hora_salida;
    }

    /**
     * @param hora_salida the hora_salida to set
     */
    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    /**
     * @return the observacion_salida
     */
    public String getObservacion_salida() {
        return observacion_salida;
    }

    /**
     * @param observacion_salida the observacion_salida to set
     */
    public void setObservacion_salida(String observacion_salida) {
        this.observacion_salida = observacion_salida;
    }
    
}
