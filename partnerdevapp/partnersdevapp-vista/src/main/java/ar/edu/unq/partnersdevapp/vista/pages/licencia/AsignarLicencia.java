package ar.edu.unq.partnersdevapp.vista.pages.licencia;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.partnersdevapp.dominio.licencia.LicenciaTipo;
import ar.edu.unq.partnersdevapp.dominio.personal.Empleado;
import ar.edu.unq.partnersdevapp.exceptions.NoHayResultadoException;
import ar.edu.unq.partnersdevapp.exceptions.NoSeAsignoLicencia;
import ar.edu.unq.partnersdevapp.exceptions.PeriodoIndeterminadoException;
import ar.edu.unq.partnersdevapp.service.empleado.EmpleadoService;
import ar.edu.unq.partnersdevapp.service.empleado.LicenciaService;
import ar.edu.unq.partnersdevapp.vista.components.Combo;
import ar.edu.unq.partnersdevapp.vista.models.ModelCombo;
import ar.edu.unq.partnersdevapp.vista.pages.BasePage;

/**
 
 */
public class AsignarLicencia extends BasePage {

    @SpringBean(name = "service.empleadoService")
    private EmpleadoService empleadoService;

    @SpringBean(name = "service.licenciaService")
    private LicenciaService licenciaService;

    private ModelCombo<Empleado> modelEmpleado = new ModelCombo<Empleado>();

    private ModelCombo<LicenciaTipo> modelLicencia = new ModelCombo<LicenciaTipo>();

    public AsignarLicencia() {
        super();
        this.setModels();
    }

    @Override
    public void addMenuRight() {
        // throw new UnsupportedOperationException();
    }

    @Override
    public void addContent() {
        @SuppressWarnings("rawtypes")
        Form form = new Form("asignarForm");
        form.add(this.getEmpleadoCombo());
        form.add(this.getLicenciaCombo());
        form.add(this.getAsignarButton());
        this.add(form);
    }

    public void setModels() {
        modelEmpleado.setOpciones(empleadoService.findAll());

        modelLicencia.setOpciones(licenciaService.findAll());
    }

    public Button getAsignarButton() {
        Button button1 = new Button("asignarButton") {
            private static final long serialVersionUID = 1L;

            @SuppressWarnings("synthetic-access")
            @Override
            public void onSubmit() {
                try {
                    AsignarLicencia.this.getEmpleadoService().asignar(
                            AsignarLicencia.this.getModelEmpleado().getSeleccion(),
                            AsignarLicencia.this.getModelLicencia().getSeleccion()); // NOPMD
                    this.info("Se asigno Licencia");
                } catch (NoHayResultadoException e) {
                    this.info(e.getMessage());
                } catch (PeriodoIndeterminadoException e) {
                    this.info(e.getMessage());
                } catch (NoSeAsignoLicencia e) {
                    this.info(e.getMessage());
                }

            }
        };

        return button1;
    }

    private DropDownChoice<Empleado> getEmpleadoCombo() {
        DropDownChoice<Empleado> ddc = new Combo<Empleado>("empleado", this.getModelEmpleado());
        ddc.setRequired(true);
        return ddc;
    }

    private DropDownChoice<LicenciaTipo> getLicenciaCombo() {
        DropDownChoice<LicenciaTipo> ddc = new Combo<LicenciaTipo>("licencia", this.getModelLicencia());
        ddc.setRequired(true);
        return ddc;
    }

    // -----------------------
    // -----Gets & Sets ------

    private ModelCombo<Empleado> getModelEmpleado() {
        return modelEmpleado;
    }

    ModelCombo<LicenciaTipo> getModelLicencia() {
        return modelLicencia;
    }

    public EmpleadoService getEmpleadoService() {
        return empleadoService;
    }

    public void setEmpleadoService(final EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    public LicenciaService getLicenciaService() {
        return licenciaService;
    }

    public void setLicenciaService(final LicenciaService licenciaService) {
        this.licenciaService = licenciaService;
    }

    public void setModelEmpleado(final ModelCombo<Empleado> modelEmpleado) {
        this.modelEmpleado = modelEmpleado;
    }

    public void setModelLicencia(final ModelCombo<LicenciaTipo> modelLicencia) {
        this.modelLicencia = modelLicencia;
    }

    @Override
    public void addHeader() {
        throw new UnsupportedOperationException();
    }

}
