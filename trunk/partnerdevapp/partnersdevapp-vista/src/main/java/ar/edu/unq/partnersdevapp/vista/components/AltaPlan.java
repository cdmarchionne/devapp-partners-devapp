package ar.edu.unq.partnersdevapp.vista.components;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.partnersdevapp.service.carrera.PlanService;
import ar.edu.unq.partnersdevapp.service.dto.plandecarreradto.PlanDto;
import ar.edu.unq.partnersdevapp.vista.pages.BasePage;

/**
 * 
 */
public class AltaPlan extends BasePage {

    private Form<PlanDto> form;

    @SpringBean(name = "service.planService")
    private PlanService service;

    private PlanDto model = new PlanDto();

    public AltaPlan() {
        super();
        this.iniciar();
    }

    public void iniciar() {
        form = new Form<PlanDto>("planForm");

        form.add(new TextFieldWithLabel(this.getModel(), "especialidad", true));
        form.add(new TextFieldWithLabel(this.getModel(), "descripcion", true));

        form.add(new Button("button") {
            private static final long serialVersionUID = 1L;

            @Override
            public void onSubmit() {
                service.save(model);
            }
        });

        this.add(form);

    }

    public void setModel(final PlanDto model) {
        this.model = model;
    }

    public PlanDto getModel() {
        return model;
    }

    public Form<PlanDto> getForm() {
        return form;
    }

    public void setForm(final Form<PlanDto> form) {
        this.form = form;
    }

    public PlanService getService() {
        return service;
    }

    public void setService(final PlanService service) {
        this.service = service;
    }

}
