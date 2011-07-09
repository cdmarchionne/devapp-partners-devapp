package ar.edu.unq.partnersdevapp.vista.pages.plan;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.partnersdevapp.service.carrera.PlanService;
import ar.edu.unq.partnersdevapp.service.dto.plandecarreradto.PlanDto;
import ar.edu.unq.partnersdevapp.vista.components.TextFieldWithLabel;
import ar.edu.unq.partnersdevapp.vista.components.plan.PlanMenuRight;
import ar.edu.unq.partnersdevapp.vista.pages.BasePage;

/**
 * 
 */
public class AltaPlan extends BasePage {
    @SpringBean(name = "service.planService")
    private PlanService service;

    private Form<PlanDto> form;

    private PlanDto model = new PlanDto();

    public AltaPlan() {
        super();
        this.iniciar();
    }

    @Override
    public void iniciar() {
        this.setModels();
        this.addMenuRight();
        this.addContent();
    }

    @Override
    public void addMenuRight() {
        this.add(new PlanMenuRight());
    }

    @Override
    public void addContent() {
        form = new Form<PlanDto>("planForm");
        form.add(new TextFieldWithLabel(this.getModel(), "especialidad", true));
        form.add(new TextFieldWithLabel(this.getModel(), "descripcion", true));

        form.add(new Button("button") {
            private static final long serialVersionUID = 1L;

            @Override
            public void onSubmit() {
                AltaPlan.this.getService().save(AltaPlan.this.getModel());
            }
        });
        this.add(form);
    }

    @Override
    public void setModels() {
        // throw new UnsupportedOperationException();
    }

    // -----------------------
    // -----Gets & Sets ------

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
