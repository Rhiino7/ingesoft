package Entidad.Informe;

import Entidad.Cita;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//Clase diseñada para que cada uno de los tipos de informes la implementen

//Para usar múltiples filtros crear un informe con el primero filtro
//Luego crear otro con el segundo filtro y aplicar segundoInforme.setCitas(primerInforme.getCitas())

public abstract class Informe {

    protected ArrayList<Cita> citas;
    protected LocalDate genFecha;

    protected abstract void setCitas();
    public abstract void setCitas(ArrayList<Cita> citaList);

    public ArrayList<Cita> getCitas() { return citas; }
    public LocalDate getGenFecha() { return genFecha; }
}