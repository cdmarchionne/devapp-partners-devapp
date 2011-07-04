package ar.edu.unq.partnersdevapp.vista.pages.licencia;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.partnersdevapp.dominio.licencia.LicenciaTipo;
import ar.edu.unq.partnersdevapp.service.empleado.LicenciaService;
import ar.edu.unq.partnersdevapp.vista.components.TextFieldWithLabel;
import ar.edu.unq.partnersdevapp.vista.pages.BasePage;

/**
 */
public class AltaLicencia extends BasePage {

    LicenciaTipo model = new LicenciaTipo();

    @SpringBean(name = "service.licenciaService")
    LicenciaService service;

    public AltaLicencia() {
        this.iniciar();
    }

    public void iniciar() {

        final Form<LicenciaTipo> form = new Form<LicenciaTipo>("licenciaForm");

        form.add(new TextFieldWithLabel(this.getModel(), "tipo", true));
        form.add(new TextFieldWithLabel(this.getModel(), "descripcion", true));
        form.add(new TextFieldWithLabel(this.getModel(), "diasConsecutivos", true));
        form.add(new TextFieldWithLabel(this.getModel(), "diasCantidadAnuales", true));
        form.add(this.getRadioComponent());

        form.add(new Button("button") {
            private static final long serialVersionUID = 1L;

            @Override
            public void onSubmit() {
                service.save(model);
                this.info("se agrego nuevo tipo de licencia");
                form.clearInput();
            }
        });

        this.add(form);
    }

    private MarkupContainer getRadioComponent() {
        MarkupContainer mkc = new MarkupContainer("remunerableContainer") {
            private static final long serialVersionUID = 1L;
        };

        CheckBox check = new CheckBox("remunerableCheck", new PropertyModel<Boolean>(model, "remunerable")) {
            private static final long serialVersionUID = 1L;

            @Override
            protected boolean wantOnSelectionChangedNotifications() {
                return true;
            }

            @Override
            protected void onSelectionChanged(final Object newSelection) {
                Boolean value = (Boolean) newSelection;
                if (value.booleanValue()) {
                    // do something
                }
            }
        };

        mkc.add(new Label("remunerableLabel", "Es remunerable?"));
        mkc.add(check);
        return mkc;
    }

    public void setModel(final LicenciaTipo model) {
        this.model = model;
    }

    public LicenciaTipo getModel() {
        return model;
    }
}
