package ar.edu.unq.partnersdevapp.vista.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import ar.edu.unq.partnersdevapp.vista.components.AltaPlan;

/**
 * TODO: description
 */

public abstract class BasePage extends WebPage {

    public BasePage() {

        this.iniciar();
    }

    private void iniciar() {
        this.add(new BookmarkablePageLink<String>("page1", Page1.class));

        this.add(new BookmarkablePageLink<String>("AltaPlan", AltaPlan.class));
        this.add(new Label("footer", "This is in the footer"));

    }
}