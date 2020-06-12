package Entidad.Informe;

import DAO.CitaDAO;
import DAO.ComplimentDAO;
import Entidad.Cita;
import Entidad.Sucursal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InformeSucursal extends Informe {

    private final Sucursal filtro;

    public InformeSucursal(Sucursal filtroSucursal) {
        this.genFecha = LocalDate.now();
        this.filtro = filtroSucursal;
        this.citas = new ArrayList<>();
        this.setCitas();
    }

    @Override
    protected void setCitas(){
        List<Cita> citaList = new CitaDAO().obtener();
        citaList.addAll(new ComplimentDAO().obtener());

        for (Cita cita : citaList) {
            if (cita.getSucursal().getId_sucursal() == this.filtro.getId_sucursal()) this.citas.add(cita);
        }
    }

    @Override
    public void setCitas(ArrayList<Cita> citaList) {
        for (Cita cita : citaList) {
            if (cita.getSucursal().getId_sucursal() == this.filtro.getId_sucursal()) this.citas.add(cita);
        }
    }

    public Sucursal getFiltro() { return filtro; }
}
