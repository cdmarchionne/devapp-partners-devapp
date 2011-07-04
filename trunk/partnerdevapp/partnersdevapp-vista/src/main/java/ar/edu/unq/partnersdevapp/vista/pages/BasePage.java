package ar.edu.unq.partnersdevapp.vista.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

import ar.edu.unq.partnersdevapp.vista.components.AltaNivel;
import ar.edu.unq.partnersdevapp.vista.components.AltaPlan;
import ar.edu.unq.partnersdevapp.vista.components.EmpleadoSelect;
import ar.edu.unq.partnersdevapp.vista.pages.licencia.AltaLicencia;
import ar.edu.unq.partnersdevapp.vista.pages.licencia.AsignarLicencia;

/**
 * Pagina Basico Principal
 */

public abstract class BasePage extends WebPage {

    public BasePage() {
        super();
        this.iniciar();
    }

    private void iniciar() {
        this.add(new BookmarkablePageLink<String>("page1", Page1.class));
        this.add(new BookmarkablePageLink<String>("AltaPlan", AltaPlan.class));
        this.add(new BookmarkablePageLink<String>("AltaNivel", AltaNivel.class));
        this.add(new BookmarkablePageLink<String>("Empleado", EmpleadoSelect.class));
        this.add(new BookmarkablePageLink<String>("Licencia", AltaLicencia.class));
        this.add(new BookmarkablePageLink<String>("AsignarLicencia", AsignarLicencia.class));
        this.add(new Label("footer", "This is in the footer"));
        this.add(new FeedbackPanel("feedback"));
    }
}