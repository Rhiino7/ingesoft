/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Cita;

/**
 *
 * @author rhino
 */
public class ValidarAutorizarCita {
    
    public int verificarCitaAprobadaPendiente(Cita cita){
        if(cita.getEstado() == 1){
            return 1;
        }else{
            return 0;
        }
    }
    
    
    public int verificarCitaRechazadaPendiente(Cita cita){
        if (cita.getEstado() == 3) {
            return 3;
        } else {
            return 0;
        }
    }
    
    public int verificarCitaRechazadaAprobada(Cita cita){
        if (cita.getEstado() == 3) {
            return 3;
        } else {
            return 1;
        }
    }
    
    public int verificarCitaCumplidaAprobada(Cita cita){
        if (cita.getEstado() == 4) {
            return 4;
        } else {
            return 1;
        }
    }
    
    public int verificarCitaCumplidaPendiente(Cita cita){
        if (cita.getEstado() == 4) {
            return 4;
        } else {
            return 0;
        }
    }
    
    public int verificarCitaAprobadaRechazada(Cita cita){
        if (cita.getEstado() == 1) {
            return 1;
        } else {
            return 3;
        }
    }
    
    public int verificarCitaAprobadaCumplida(Cita cita){
        if (cita.getEstado() == 1) {
            return 1;
        } else {
            return 4;
        }
    }
}
