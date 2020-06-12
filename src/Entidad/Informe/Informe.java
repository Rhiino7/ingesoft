package Entidad.Informe;

import Entidad.Cita;

import java.time.LocalDate;
import java.util.ArrayList;

//Clase diseñada para que cada uno de los tipos de informes la implementen

public abstract class Informe {

    protected ArrayList<Cita> citas;
    protected LocalDate genFecha;

    protected abstract void setCitas();

}