package ar.edu.unq.partnersdevapp.vista.components;

import java.util.List;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.partnersdevapp.service.carrera.NivelService;
import ar.edu.unq.partnersdevapp.service.dto.Dto;
import ar.edu.unq.partnersdevapp.service.dto.plandecarreradto.NivelDto;
import ar.edu.unq.partnersdevapp.service.dto.plandecarreradto.NivelListaDto;
import ar.edu.unq.partnersdevapp.vista.pages.BasePage;

/**
 * 
 * Página en la que se puede dar de alta,editar o borra un Nivel
 * 
 */
public class AltaNivel<T extends Dto> extends BasePage {

    private Form<NivelDto> form;

    @SpringBean(name = "service.nivelService")
    private NivelService service;

    private NivelDto model = new NivelDto("", 0, 0, 0);

    private NivelListaDto modelLista = new NivelListaDto();

    private DropDownChoice<NivelDto> comboNiveles;

    public AltaNivel() {
        super();
        modelLista.setNivelesDto(service.findAll());
        this.iniciar();
    }

    public void iniciar() {
        form = new Form<NivelDto>("nivelForm");

        form.add(new TextFieldWithLabel(this.getModel(), "nombre", true));
        form.add(new TextFieldWithLabel(this.getModel(), "banda", true));
        form.add(new TextFieldWithLabel(this.getModel(), "sueldoMaximo", true));
        form.add(new TextFieldWithLabel(this.getModel(), "sueldoMinimo", true));
        form.add(this.getComboNivelesComponent());

        form.add(new Button("button") {
            private static final long serialVersionUID = 1L;

            @Override
            public void onSubmit() {
                AltaNivel.this.getService().save(model);

            }
        });

        this.add(form);

    }

    // private TextField<NivelDto> crearTextField(final String campo, final
    // boolean esRequerido) {
    // PropertyModel<NivelDto> pm = new PropertyModel<NivelDto>(this.getModel(),
    // campo);
    // TextField<NivelDto> textField = new TextField<NivelDto>(campo.toString()
    // + "Field", pm);
    // if (esRequerido) {
    // textField.setRequired(true);
    // }
    // return textField;
    // }

    private DropDownChoice<NivelDto> getComboNivelesComponent() {
        PropertyModel<NivelDto> pmp = new PropertyModel<NivelDto>(this.getModelLista(), "seleccion");
        PropertyModel<List<NivelDto>> pml = new PropertyModel<List<NivelDto>>(this.getModelLista(), "nivelesDto");
        return new DropDownChoice<NivelDto>("nivelCombo", pmp, pml);
    }

    public Form<NivelDto> getForm() {
        return form;
    }

    public void setForm(final Form<NivelDto> form) {
        this.form = form;
    }

    public NivelService getService() {
        return service;
    }

    public void setService(final NivelService service) {
        this.service = service;
    }

    public NivelDto getModel() {
        return model;
    }

    public void setModel(final NivelDto model) {
        this.model = model;
    }

    public DropDownChoice<NivelDto> getComboNiveles() {
        return comboNiveles;
    }

    public void setComboNiveles(final DropDownChoice<NivelDto> comboNiveles) {
        this.comboNiveles = comboNiveles;
    }

    public NivelListaDto getModelLista() {
        return modelLista;
    }

    public void setModelLista(final NivelListaDto modelLista) {
        this.modelLista = modelLista;
    }

}
