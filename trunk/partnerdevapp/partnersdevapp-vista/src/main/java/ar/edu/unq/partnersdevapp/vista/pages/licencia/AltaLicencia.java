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

    @SpringBean(name = "service.licenciaService")
    private LicenciaService service;

    private LicenciaTipo model = new LicenciaTipo();

    public AltaLicencia() {
        super();
        this.iniciar();
    }

    @Override
    public void iniciar() {
        this.addMenuRight();
        this.addContent();
        this.setModels();
    }

    @Override
    public void addMenuRight() {
        // throw new UnsupportedOperationException();
    }

    @Override
    public void addContent() {
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
                AltaLicencia.this.getService().save(AltaLicencia.this.getModel());
                this.info("se agrego nuevo tipo de licencia");
                form.clearInput();
            }
        });

        this.add(form);
    }

    @Override
    public void setModels() {
        // throw new UnsupportedOperationException();
    }

    private MarkupContainer getRadioComponent() {
        MarkupContainer mkc = new MarkupContainer("remunerableContainer") {
            private static final long serialVersionUID = 1L;
        };

        CheckBox check = new CheckBox("remunerableCheck", new PropertyModel<Boolean>(model, "remunerable"));

        mkc.add(new Label("remunerableLabel", "Es remunerable?"));
        mkc.add(check);
        return mkc;
    }

    // -----------------------
    // -----Gets & Sets ------

    public LicenciaService getService() {
        return service;
    }

    public void setService(final LicenciaService service) {
        this.service = service;
    }

    public LicenciaTipo getModel() {
        return model;
    }

    public void setModel(final LicenciaTipo model) {
        this.model = model;
    }

}
