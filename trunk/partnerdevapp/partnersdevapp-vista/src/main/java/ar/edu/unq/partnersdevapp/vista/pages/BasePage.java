package ar.edu.unq.partnersdevapp.vista.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

import ar.edu.unq.partnersdevapp.vista.pages.empleado.EmpleadoSelect;
import ar.edu.unq.partnersdevapp.vista.pages.licencia.AltaLicencia;
import ar.edu.unq.partnersdevapp.vista.pages.licencia.AsignarLicencia;
import ar.edu.unq.partnersdevapp.vista.pages.nivel.AltaNivel;
import ar.edu.unq.partnersdevapp.vista.pages.plan.PlanSelectPage;

/**
 * Pagina Basico Principal
 */

public abstract class BasePage extends WebPage {
    // -----------------------
    // ----- BEANS ----------
    // -- los servicios para comunicarse a la base estan agrupados en el bien de
    // dicha entidad
    // @SpringBean(name = "service.entidadService")
    // private EmpleadoService entidadService;

    // -----------------------
    // ----- DTO -------------
    // -- Cada entidad y modelo utilizada en la pagina tendra su dto
    // -- private List<EntidadDto> modelDeCombo;
    // -- private EntidadDto emplDto;

    // ----------------------
    // ---- Modelos ---------
    // - Por componente ( combo , text , form , etc )
    // - en algunos casos puede ser el dto.

    // ----------------------
    // ---- Atributos ---------
    // --

    public BasePage() {
        super();
        this.addMenuLeft();
    }

    public abstract void iniciar();

    // --------------------------------------------
    // ---- Definicion de los cuerpos de la pagina

    private void addMenuLeft() {
        this.add(new BookmarkablePageLink<String>("LogInApp", LogInApp.class));
        this.add(new BookmarkablePageLink<String>("Plan", PlanSelectPage.class));
        this.add(new BookmarkablePageLink<String>("AltaNivel", AltaNivel.class));
        this.add(new BookmarkablePageLink<String>("Empleado", EmpleadoSelect.class));
        this.add(new BookmarkablePageLink<String>("Licencia", AltaLicencia.class));
        this.add(new BookmarkablePageLink<String>("AsignarLicencia", AsignarLicencia.class));
        this.add(new Label("footer", "This is in the footer"));
        this.add(new FeedbackPanel("feedback"));
    }

    public abstract void addMenuRight();

    public abstract void addContent();

    // --------------------------------------------------------------------
    // -- Los modelos de algunos componentes nesecitaran datos de la base
    public abstract void setModels();

    // ------------------------------------
    // ---- Metodos para crear componentes

    // -----------------------
    // -----Gets & Sets ------

}