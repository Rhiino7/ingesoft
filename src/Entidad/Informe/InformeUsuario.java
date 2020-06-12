package Entidad.Informe;

import DAO.CitaDAO;
import DAO.ComplimentDAO;
import Entidad.Cita;
import Entidad.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InformeUsuario extends Informe{

    private final Usuario filtro;

    public InformeUsuario(Usuario usuarioFiltro){
        this.genFecha = LocalDate.now();
        this.filtro = usuarioFiltro;
        this.citas = new ArrayList<>();
        this.setCitas();
    }

    @Override
    protected void setCitas(){
        List<Cita> citaList = new CitaDAO().obtener();
        citaList.addAll(new ComplimentDAO().obtener());

        for (Cita cita : citaList) {
            if (cita.getUsuario().getIdentificacion() == this.filtro.getIdentificacion()) this.citas.add(cita);
        }
    }

    @Override
    public void setCitas(ArrayList<Cita> citaList){
        citas.clear();

        for (Cita cita : citaList) {
            if (cita.getUsuario().getIdentificacion() == this.filtro.getIdentificacion()) this.citas.add(cita);
        }
    }

    public Usuario getUsuarioFiltro(){ return filtro; }
}
