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

    public BasePage() {
        super();
        this.addHeader();
        this.addMenuLeft();
        this.addMenuRight();
        this.addContent();
    }

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

    public abstract void addHeader();

}