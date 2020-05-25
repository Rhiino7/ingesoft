package Entidad;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {
    private Sucursal sucursal;
    private Usuario usuario;
    private LocalDate fecha;
    private LocalTime hora;
    private int estado;

    public Cita(){}

    public Cita(Sucursal sucursal, Usuario usuario, LocalDate fecha, LocalTime hora, int estado) {
        this.sucursal = sucursal;
        this.usuario = usuario;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "sucursalID: " + sucursal.getId_sucursal()
                + "\nusuarioID: " + usuario.getIdentificacion()
                + "\nfecha: " + fecha.toString()
                + "\nhora: " + hora.toString();
    }
    
    
}
