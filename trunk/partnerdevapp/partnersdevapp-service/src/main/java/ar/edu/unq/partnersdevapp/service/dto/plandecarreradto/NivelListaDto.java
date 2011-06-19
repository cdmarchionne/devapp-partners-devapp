package ar.edu.unq.partnersdevapp.service.dto.plandecarreradto;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.partnersdevapp.service.dto.Dto;

/**
 * Para transferir lista de niveles
 */
public class NivelListaDto implements Dto {

    private static final long serialVersionUID = 1L;

    private List<NivelDto> nivelesDto;

    private NivelDto seleccion;

    public NivelListaDto() {
        super();
        nivelesDto = new ArrayList<NivelDto>();
    }

    public void setNivelesDto(final List<NivelDto> nivelesDto) {
        this.nivelesDto = nivelesDto;
    }

    public List<NivelDto> getNivelesDto() {
        return nivelesDto;
    }

    public NivelDto getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(final NivelDto seleccion) {
        this.seleccion = seleccion;
    }
}
