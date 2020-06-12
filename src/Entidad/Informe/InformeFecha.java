package Entidad.Informe;

import DAO.CitaDAO;
import DAO.ComplimentDAO;
import Entidad.Cita;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InformeFecha extends Informe {

    private final LocalDate filtro;

    public InformeFecha(LocalDate filtroFecha) {
        this.genFecha = LocalDate.now();
        this.filtro = filtroFecha;
        this.citas = new ArrayList<>();
        this.setCitas();
    }

    @Override
    protected void setCitas() {
        List<Cita> citaList = new CitaDAO().obtener();
        citaList.addAll(new ComplimentDAO().obtener());

        for (Cita cita : citaList) {
            if (cita.getFecha() == this.filtro) this.citas.add(cita);
        }
    }

    @Override
    public void setCitas(ArrayList<Cita> citaList) {
        citas.clear();

        for (Cita cita : citaList) {
            if (cita.getFecha() == this.filtro) this.citas.add(cita);
        }
    }

    public LocalDate getFiltro() { return filtro; }
}
