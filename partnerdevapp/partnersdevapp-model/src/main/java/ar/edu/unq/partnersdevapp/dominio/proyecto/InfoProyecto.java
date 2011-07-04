package ar.edu.unq.partnersdevapp.dominio.proyecto;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.partnersdevapp.dominio.calendario.FechasXcomprension;
import ar.edu.unq.partnersdevapp.dominio.entidad.Entidad;

/**
 * Administra la informacion que asocia al Empleado con un Proyecto dado
 * indicando los dias que el se encuantra asignado a este.
 */

public class InfoProyecto extends Entidad {

    private static final long serialVersionUID = 1L;

    private Proyecto proyecto;

    private List<FechasXcomprension> diasAsignados;

    public InfoProyecto(final Proyecto proyecto) {
        super();
        this.proyecto = proyecto;
        diasAsignados = new ArrayList<FechasXcomprension>();
    }

    public InfoProyecto(final Proyecto proyecto, final List<FechasXcomprension> diasAsignados) {
        super();
        this.proyecto = proyecto;
        this.diasAsignados = diasAsignados;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    // protected void setProyecto(final Proyecto proyecto) {
    // throw new UnsupportedOperationException();
    // }

    public List<FechasXcomprension> getDiasAsignados() {
        return diasAsignados;
    }

    public void setDiasAsignados(final List<FechasXcomprension> diasAsignados) {
        this.diasAsignados = diasAsignados;
    }

    public void addDiasAsignados(final FechasXcomprension dias) {
        diasAsignados.add(dias);
    }

    public void removeDiasAsignados(final FechasXcomprension dias) {
        diasAsignados.remove(dias);
    }

    public void setProyecto(final Proyecto proyecto) {
        this.proyecto = proyecto;
    }

}
