/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.CitaDAO;
import Entidad.Cita;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class ValidarSolicitarCita {
    private CitaDAO cdao = new CitaDAO();

    public ValidarSolicitarCita() {
    }
    
    public int verificarSolicitarCita(Cita cita) {
        
//        List<Cita> citas = cdao.obtener();
//        for (Cita c : citas){
//            System.out.println(c.toString());
//        }
        
        if (cita.getFecha().equals("")){
            System.out.println("Fecha nula");
            return 1;
        }
        if (cita.getHora().equals("")){
            System.out.println("Hora nula");
            return 2;
        }
        LocalDate testFecha = LocalDate.parse("3800-02-01");
        if (cita.getFecha().equals(testFecha)){
            System.out.println("No ingreso ninguna fecha");
            return 3;
        }
        if (cita.getFecha().isBefore(LocalDate.now())){
            System.out.println("La fecha es anterior a la fecha actual");
            return 4;
        }
        if (cdao.verificarDisponibilidad(cita)) {
            return 5;
        }
        if (cdao.verificarTengaMasCitasSucursal(cita)) {
            return 6;
        }

        for (Cita a : cdao.obtener()){
            if (a.getUsuario().getIdentificacion()==cita.getUsuario().getIdentificacion()) {
                return 7;
            }
        }
        return 0;
    }
    
//    public int verificarSolicitarCita() {
//        
////        List<Cita> citas = cdao.obtener();
////        for (Cita c : citas){
////            System.out.println(c.toString());
////        }
//        
//        if (cita.getFecha().equals("")){
//            System.out.println("Fecha nula");
//            return 1;
//        }
//        if (cita.getHora().equals("")){
//            System.out.println("Hora nula");
//            return 2;
//        }
//        LocalDate testFecha = LocalDate.parse("3800-02-01");
//        if (cita.getFecha().equals(testFecha)){
//            System.out.println("No ingreso ninguna fecha");
//            return 3;
//        }
//        if (cita.getFecha().isBefore(LocalDate.now())){
//            System.out.println("La fecha es anterior a la fecha actual");
//            return 4;
//        }
//        if (!cdao.verificarDisponibilidad(cita)) {
//            return 5;
//        }
//        if (cdao.verificarTengaMasCitasSucursal(cita)) {
//            return 6;
//        }
//
//        for (Cita a : cdao.obtener()){
//            if (a.getUsuario().getIdentificacion()==cita.getUsuario().getIdentificacion()) {
//                return 7;
//            }
//        }
//        return 0;
//    }
}
