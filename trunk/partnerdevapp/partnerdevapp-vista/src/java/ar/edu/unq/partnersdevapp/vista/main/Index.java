package ar.edu.unq.partnersdevapp.vista.main;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

/**
 * TODO: description
 */
public class Index extends WebPage {
    private static final long serialVersionUID = 1L;

    public Index() {
        this.add(new Label("message", "el Main de devapp"));
    }
}
