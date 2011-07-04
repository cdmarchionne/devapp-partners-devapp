package ar.edu.unq.partnersdevapp.service.dto.plandecarreradto;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.partnersdevapp.service.dto.Dto;

/**
 * Para transferir lista de niveles
 */
public class NivelListaDto implements Dto {

    private static final long serialVersionUID = 1L;

    private List<NivelDto> opciones = new ArrayList<NivelDto>();

    private NivelDto seleccion;

    public void setOpciones(final List<NivelDto> opciones) {
        this.opciones = opciones;
    }

    public List<NivelDto> getOpciones() {
        return opciones;
    }

    public NivelDto getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(final NivelDto seleccion) {
        this.seleccion = seleccion;
    }
}
