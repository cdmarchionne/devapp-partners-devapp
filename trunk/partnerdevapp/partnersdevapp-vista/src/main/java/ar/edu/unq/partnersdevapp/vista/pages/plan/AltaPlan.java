package ar.edu.unq.partnersdevapp.vista.pages.plan;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.partnersdevapp.service.carrera.PlanService;
import ar.edu.unq.partnersdevapp.service.dto.plandecarreradto.PlanDto;
import ar.edu.unq.partnersdevapp.vista.pages.BasePage;
import ar.edu.unq.partnersdevapp.vista.panel.InputPanel;
import ar.edu.unq.partnersdevapp.vista.panel.plan.PlanMenuRightPanel;

/**
 * 
 */
public class AltaPlan extends BasePage {
    @SpringBean(name = "service.planService")
    private PlanService service;

    private Form<PlanDto> form;

    private PlanDto model;

    public AltaPlan() {
        /**
         * TODO : primero agrega el panel con model null y despues setea el
         * model
         */
        model = new PlanDto();
    }

    @Override
    public void addMenuRight() {
        this.add(new PlanMenuRightPanel());
    }

    @Override
    public void addContent() {
        form = new Form<PlanDto>("planForm");
        form.add(new InputPanel(this.getModel(), "especialidad", true));
        form.add(new InputPanel(this.getModel(), "descripcion", true));

        form.add(new Button("button") {
            private static final long serialVersionUID = 1L;

            @Override
            public void onSubmit() {
                AltaPlan.this.getService().save(AltaPlan.this.getModel());
            }
        });
        this.add(form);
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

    @Override
    public void addHeader() {
        //
    }

}
