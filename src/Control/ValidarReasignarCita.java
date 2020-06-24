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
public class ValidarReasignarCita {
    
    public int verificarCitaReasignadaPendiente(Cita cita){
        if(cita.getEstado() == 6){
            return 6;
        }else{
            return 0;
        }
    }
        
    public int verificarCitaReasignadaAprobada(Cita cita){
        if(cita.getEstado() == 6){
            return 6;
        } else {
            return 1;
        }
    }
        
    public int verificarCitaReasignadaRechazada(Cita cita){
        if(cita.getEstado() == 6){
            return 6;
        } else {
            return 3;
        }
    }
    
    public int verificarCitaReasignadaCumplida(Cita cita){
        if(cita.getEstado() == 6){
            return 6;
        } else {
            return 4;
        }
    }
    
    public int verificarCitaReasignadaNoCumplida(Cita cita){
        if(cita.getEstado() == 6){
            return 6;
        } else {
            return 5;
        }
    }
}
