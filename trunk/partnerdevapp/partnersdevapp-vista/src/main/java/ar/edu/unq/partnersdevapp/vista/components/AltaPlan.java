package ar.edu.unq.partnersdevapp.vista.components;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

import ar.edu.unq.partnersdevapp.dominio.carrera.PlanDeCarrera;
import ar.edu.unq.partnersdevapp.vista.pages.BasePage;
import ar.edu.unq.partnersdevapp.vista.service.AddPlan;

/**
 * @author leo
 */
public class AltaPlan extends BasePage {

    private Form<PlanDeCarrera> form;

    private AddPlan addPlan = new AddPlan();

    private TextField<AddPlan> field;

    private TextField<AddPlan> field2;

    static final String FORMPLAN = "formPlan";

    public AltaPlan() {
        super();
        this.iniciar();
    }

    public void iniciar() {
        form = new Form<PlanDeCarrera>(FORMPLAN);
        field = new TextField<AddPlan>("descripcionText", new PropertyModel<AddPlan>(this.getAddPlan(), "descripcion"));
        field2 = new TextField<AddPlan>("especialidadText", new PropertyModel<AddPlan>(this.getAddPlan(),
                "especialidad"));
        form.add(field);
        form.add(field2);

        form.add(new Button("button") {
            private static final long serialVersionUID = 1L;

            @Override
            public void onSubmit() {
                // String value = (String) field.getModelObject();
                // Component label;
                // label.setDefaultModelObject(value);
                // field.setModelObject("");
                AltaPlan.this.getAddPlan().add();
            }
        });

        this.add(form);
        // this.add(label = new Label("message", new Model("")));
    }

    public void setAddPlan(final AddPlan addPlan) {
        this.addPlan = addPlan;
    }

    public AddPlan getAddPlan() {
        return addPlan;
    }
}
