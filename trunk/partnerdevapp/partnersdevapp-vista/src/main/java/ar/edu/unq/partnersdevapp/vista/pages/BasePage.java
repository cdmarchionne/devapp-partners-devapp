package ar.edu.unq.partnersdevapp.vista.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.partnersdevapp.vista.components.AltaPlan;
import ar.edu.unq.partnersdevapp.vista.service.BeanEjemplo;
import ar.edu.unq.partnersdevapp.vista.service.LogService;

/**
 * TODO: description
 */

public abstract class BasePage extends WebPage {

    @SpringBean(name = "unBean")
    private BeanEjemplo beanEjemplo;

    @SpringBean(name = "service.log")
    private LogService logService;

    public BasePage() {
        logService.log("Se inicio BasepPage");
        this.iniciar();
    }

    private void iniciar() {
        this.add(new BookmarkablePageLink("page1", Page1.class));

        this.add(new BookmarkablePageLink("AltaPlan", AltaPlan.class));
        this.add(new Label("footer", "This is in the footer"));

        Label markupLabel = new Label("markupLabel", "esto es un <b>" + beanEjemplo.getShow() + " !!!! </b>");
        markupLabel.setEscapeModelStrings(false);
        this.add(markupLabel);
    }
}