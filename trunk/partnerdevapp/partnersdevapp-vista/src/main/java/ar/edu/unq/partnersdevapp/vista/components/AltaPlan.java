package ar.edu.unq.partnersdevapp.vista.components;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.partnersdevapp.dominio.carrera.PlanDeCarrera;
import ar.edu.unq.partnersdevapp.vista.pages.BasePage;
import ar.edu.unq.partnersdevapp.vista.service.PlanBean;

/**
 * @author leo
 * @param <T>
 */
public class AltaPlan<T> extends BasePage {

    private Form<PlanDeCarrera> form;

    @SpringBean(name = "planBean")
    private PlanBean planBean;

    private TextField<PlanBean> field;

    private TextField<PlanBean> field2;

    private DropDownChoice<?> combo;

    public AltaPlan() {
        super();
        this.iniciar();
    }

    public void iniciar() {
        form = new Form<PlanDeCarrera>("formPlan");
        field = new TextField<PlanBean>("descripcionText", new PropertyModel<PlanBean>(planBean, "descripcion"));
        field2 = new TextField<PlanBean>("especialidadText", new PropertyModel<PlanBean>(planBean, "especialidad"));
        PropertyModel<PlanBean> model = new PropertyModel<PlanBean>(planBean, "nivelList");
        combo = new DropDownChoice("nivelCombo", model);
        form.add(combo);
        form.add(field);
        form.add(field2);

        form.add(new Button("button") {
            private static final long serialVersionUID = 1L;

            @Override
            public void onSubmit() {
                AltaPlan.this.getPlanBean().insert();
            }
        });

        this.add(form);
        // this.add(label = new Label("message", new Model("")));
    }

    public Form<PlanDeCarrera> getForm() {
        return form;
    }

    public void setForm(final Form<PlanDeCarrera> form) {
        this.form = form;
    }

    public PlanBean getPlanBean() {
        return planBean;
    }

    public void setPlanBean(final PlanBean planBean) {
        this.planBean = planBean;
    }

    public TextField<PlanBean> getField() {
        return field;
    }

    public void setField(final TextField<PlanBean> field) {
        this.field = field;
    }

    /**
     * XXX no es un nombre apropiado
     */
    public TextField<PlanBean> getField2() {
        return field2;
    }

    public void setField2(final TextField<PlanBean> field2) {
        this.field2 = field2;
    }

    public DropDownChoice<?> getCombo() {
        return combo;
    }

    public void setCombo(final DropDownChoice<?> combo) {
        this.combo = combo;
    }

}
