package ar.edu.unq.partnersdevapp.service.dto.plandecarreradto;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.partnersdevapp.service.dto.Dto;

/**
 * TODO: description
 */
public class PlanListaDto implements Dto {

    private static final long serialVersionUID = 1L;

    private List<PlanDto> opciones = new ArrayList<PlanDto>();

    private PlanDto seleccion;

    public void setOpciones(final List<PlanDto> opciones) {
        this.opciones = opciones;
    }

    public List<PlanDto> getOpciones() {
        return opciones;
    }

    public PlanDto getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(final PlanDto seleccion) {
        this.seleccion = seleccion;
    }

}
