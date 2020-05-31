package Entidad;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {

    private int id_cita;
    private Sucursal sucursal;
    private Usuario usuario;
    private LocalDate fecha;
    private LocalTime hora;
    private int motivo;
    private int estado;

    public Cita(){}

    public Cita(int id_cita, Sucursal sucursal, Usuario usuario, LocalDate fecha, LocalTime hora, int estado) {

        this.id_cita = id_cita;
        this.sucursal = sucursal;
        this.usuario = usuario;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    public Cita(int id_cita, Sucursal sucursal, Usuario usuario, LocalDate fecha, LocalTime hora, int motivo, int estado) {
        this.id_cita = id_cita;
        this.sucursal = sucursal;
        this.usuario = usuario;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.estado = estado;
    }
    
    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getMotivo() {
        return motivo;
    }

    public void setMotivo(int motivo) {
        this.motivo = motivo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString()
    {
        return "id_cita: " + Integer.toString(id_cita)
                + "\nsucursalID: " + sucursal.getId_sucursal()
                + "\nusuarioID: " + usuario.getIdentificacion()
                + "\nfecha: " + fecha.toString()
                + "\nhora: " + hora.toString();
    }
    
    
}
