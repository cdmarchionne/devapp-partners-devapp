package ar.edu.unq.partnersdevapp.dominio.proyecto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.edu.unq.partnersdevapp.dominio.calendario.FechasXcomprension;
import ar.edu.unq.partnersdevapp.exceptions.PeriodoIndeterminadoException;

/**
 * Maneja los Proyectos de los empleados
 */
public class ProyectoManager {

    private Set<InfoProyecto> infoProyectos;

    public ProyectoManager() {
        super();
        infoProyectos = new HashSet<InfoProyecto>();
    }

    public Set<InfoProyecto> getInfoProyectos() {
        return infoProyectos;
    }

    // protected void setInfoProyectos(final Set<InfoProyecto> infoProyectos) {
    // throw new UnsupportedOperationException();
    // }

    protected void addProyecto(final Proyecto proyecto, final List<FechasXcomprension> diasAsignados) {
        InfoProyecto infoProyectoNuevo = this.getInfoProyectoExistente(proyecto);

        if (infoProyectoNuevo == null) {
            infoProyectoNuevo = new InfoProyecto(proyecto, diasAsignados);
            infoProyectos.add(infoProyectoNuevo);
        } else {
            this.addMasDiasAsignados(infoProyectoNuevo, diasAsignados);
        }

    }

    private void addMasDiasAsignados(final InfoProyecto infoProyectoNuevo, final List<FechasXcomprension> diasAsignados) {
        List<FechasXcomprension> diasAsignadosAnteriores = infoProyectoNuevo.getDiasAsignados();
        diasAsignadosAnteriores.addAll(diasAsignados);
        infoProyectoNuevo.setDiasAsignados(diasAsignadosAnteriores);
    }

    private InfoProyecto getInfoProyectoExistente(final Proyecto proyecto) {
        InfoProyecto infoProyectoNuevo = null;

        for (InfoProyecto infoProyectoExistente : infoProyectos) {
            if (infoProyectoExistente.getProyecto().equals(proyecto)) {
                infoProyectoNuevo = infoProyectoExistente;
                break;
            }
        }

        return infoProyectoNuevo;
    }

    protected void removeProyecto(final Proyecto proyecto) {

        for (InfoProyecto infoProyecto : infoProyectos) {
            if (infoProyecto.getProyecto().equals(proyecto)) {
                infoProyectos.remove(infoProyecto);
                break;
            }
        }
    }

    /** Dias que tiene solicitados licencia */
    public List<FechasXcomprension> diasOcupados() {
        List<FechasXcomprension> diasOcupados = new ArrayList<FechasXcomprension>();

        for (InfoProyecto infoProyecto : infoProyectos) {
            diasOcupados.addAll(infoProyecto.getDiasAsignados());
        }
        return diasOcupados;
    }

    /** Dias que tiene solicitados licencia que coinciden con una fecha dada */
    public List<FechasXcomprension> diasOcupados(final FechasXcomprension fechaProyecto)
            throws PeriodoIndeterminadoException {
        List<FechasXcomprension> diasOcupados = new ArrayList<FechasXcomprension>();

        for (InfoProyecto infoProyecto : infoProyectos) {
            for (FechasXcomprension diasAsignado : infoProyecto.getDiasAsignados()) {
                if (fechaProyecto.seSuperpone(diasAsignado)) {
                    diasOcupados.add(diasAsignado);
                }
            }
        }
        return diasOcupados;
    }

    // public Set<Gannt> generarGannt();
}
