package ar.edu.unq.partnersdevapp.vista.pages.nivel;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.partnersdevapp.service.carrera.NivelService;
import ar.edu.unq.partnersdevapp.service.carrera.PlanService;
import ar.edu.unq.partnersdevapp.service.dto.Dto;
import ar.edu.unq.partnersdevapp.service.dto.plandecarreradto.NivelDto;
import ar.edu.unq.partnersdevapp.service.dto.plandecarreradto.NivelListaDto;
import ar.edu.unq.partnersdevapp.service.dto.plandecarreradto.PlanDto;
import ar.edu.unq.partnersdevapp.service.dto.plandecarreradto.PlanListaDto;
import ar.edu.unq.partnersdevapp.vista.pages.BasePage;
import ar.edu.unq.partnersdevapp.vista.panel.InputPanel;

/**
 * 
 * Página en la que se puede dar de alta,editar o borra un Nivel
 * 
 */
public class AltaNivel<T extends Dto> extends BasePage {

    @SpringBean(name = "service.nivelService")
    private NivelService nivelService;

    @SpringBean(name = "service.planService")
    private PlanService planService;

    private Form<NivelDto> form;

    private NivelDto modelNivel;

    private NivelListaDto modelNivelLista;

    private PlanListaDto modelPlanLista;

    private DropDownChoice<NivelDto> niveleCombo;

    private DropDownChoice<PlanDto> planCombo;

    private RadioChoice<String> radio;

    public AltaNivel() {
        super();
        this.setModels();
    }

    public void setModels() {
        modelNivel = new NivelDto("", 0, 0, 0);
        modelNivelLista = new NivelListaDto();
        modelPlanLista = new PlanListaDto();
        modelPlanLista.setOpciones(planService.findAll());
    }

    @Override
    public void addMenuRight() {
        // throw new UnsupportedOperationException();
    }

    @Override
    public void addHeader() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addContent() {
        form = new Form<NivelDto>("nivelForm");

        form.add(new InputPanel(this.getModelNivel(), "nombre", true));
        form.add(new InputPanel(this.getModelNivel(), "banda", true));
        form.add(new InputPanel(this.getModelNivel(), "sueldoMaximo", true));
        form.add(new InputPanel(this.getModelNivel(), "sueldoMinimo", true));
        form.add(this.getNivelComboWithLabel());
        form.add(this.getPlanComboWithLabel());
        form.add(this.getLugarRadioComponent());

        form.add(new Button("button") {
            private static final long serialVersionUID = 1L;

            @Override
            public void onSubmit() {
                AltaNivel.this.getPlanService().agregarNivel(AltaNivel.this.getModelPlanLista().getSeleccion(),
                        AltaNivel.this.getModelNivel(), AltaNivel.this.getRadio().getInput(),
                        AltaNivel.this.getModelNivelLista().getSeleccion());

                this.getForm().clearInput();

            }
        });

        this.add(form);
    }

    private MarkupContainer getLugarRadioComponent() {
        List<String> opcionesRadio = Arrays.asList(new String[] { "antes", "despues" });
        radio = new RadioChoice<String>("lugarRadio", opcionesRadio);
        radio.setDefaultModel(new PropertyModel<NivelDto>(this.getModelNivel(), "lugar"));
        radio.setRequired(true);
        return radio;
    }

    private MarkupContainer getPlanComboWithLabel() {
        MarkupContainer mkc = new MarkupContainer("planComboContainer") {
            private static final long serialVersionUID = 1L;
        };
        mkc.add(this.getPlanComboComponent());
        mkc.add(new Label("planLabelCombo", "Para el plan de carrera."));
        return mkc;
    }

    private MarkupContainer getNivelComboWithLabel() {
        MarkupContainer mkc = new MarkupContainer("nivelComboContainer") {
            private static final long serialVersionUID = 1L;
        };
        mkc.add(this.getNivelComboComponent());
        mkc.add(new Label("nivelLabelCombo", "del nivel"));
        return mkc;
    }

    private DropDownChoice<PlanDto> getPlanComboComponent() {
        PropertyModel<PlanDto> pmp = new PropertyModel<PlanDto>(this.getModelPlanLista(), "seleccion");
        PropertyModel<List<PlanDto>> pml = new PropertyModel<List<PlanDto>>(this.getModelPlanLista(), "opciones");
        this.setPlanCombo(new DropDownChoice<PlanDto>("planCombo", pmp, pml));

        AjaxFormComponentUpdatingBehavior updateBehavior = new AjaxFormComponentUpdatingBehavior("onchange") {
            private static final long serialVersionUID = 1L;

            @Override
            protected void onUpdate(final AjaxRequestTarget target) {
                AltaNivel.this.getModelNivelLista().setOpciones(
                        AltaNivel.this.getNivelService().findByPlanid(
                                AltaNivel.this.getModelPlanLista().getSeleccion().getId()));
                target.addComponent(AltaNivel.this.getNiveleCombo());
            }

        };
        this.getPlanCombo().add(updateBehavior);
        this.getPlanCombo().setRequired(true);
        return this.getPlanCombo();
    }

    private DropDownChoice<NivelDto> getNivelComboComponent() {
        PropertyModel<NivelDto> pmp = new PropertyModel<NivelDto>(this.getModelNivelLista(), "seleccion");
        PropertyModel<List<NivelDto>> pml = new PropertyModel<List<NivelDto>>(this.getModelNivelLista(), "opciones");
        this.setNiveleCombo(new DropDownChoice<NivelDto>("nivelCombo", pmp, pml));
        this.getNiveleCombo().setOutputMarkupId(true);

        return this.getNiveleCombo();
    }

    // -----------------------
    // -----Gets & Sets ------

    public Form<NivelDto> getForm() {
        return form;
    }

    public void setForm(final Form<NivelDto> form) {
        this.form = form;
    }

    public NivelService getNivelService() {
        return nivelService;
    }

    public void setNivelService(final NivelService nivelService) {
        this.nivelService = nivelService;
    }

    public PlanService getPlanService() {
        return planService;
    }

    public void setPlanService(final PlanService planService) {
        this.planService = planService;
    }

    public NivelDto getModelNivel() {
        return modelNivel;
    }

    public void setModelNivel(final NivelDto modelNivel) {
        this.modelNivel = modelNivel;
    }

    public NivelListaDto getModelNivelLista() {
        return modelNivelLista;
    }

    public void setModelNivelLista(final NivelListaDto modelNivelLista) {
        this.modelNivelLista = modelNivelLista;
    }

    public PlanListaDto getModelPlanLista() {
        return modelPlanLista;
    }

    public void setModelPlanLista(final PlanListaDto modelPlanLista) {
        this.modelPlanLista = modelPlanLista;
    }

    public DropDownChoice<NivelDto> getNiveleCombo() {
        return niveleCombo;
    }

    public void setNiveleCombo(final DropDownChoice<NivelDto> niveleCombo) {
        this.niveleCombo = niveleCombo;
    }

    public DropDownChoice<PlanDto> getPlanCombo() {
        return planCombo;
    }

    public void setPlanCombo(final DropDownChoice<PlanDto> planCombo) {
        this.planCombo = planCombo;
    }

    public RadioChoice<String> getRadio() {
        return radio;
    }

    public void setRadio(final RadioChoice<String> radio) {
        this.radio = radio;
    }

}
