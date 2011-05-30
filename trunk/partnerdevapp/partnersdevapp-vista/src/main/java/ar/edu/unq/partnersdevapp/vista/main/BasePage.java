package ar.edu.unq.partnersdevapp.vista.main;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

/**
 * TODO: description
 */
public abstract class BasePage extends WebPage {
    public BasePage() {
        this.add(new BookmarkablePageLink("page1", Page1.class));
        this.add(new BookmarkablePageLink("page2", Page2.class));
        this.add(new Label("footer", "This is in the footer"));
    }
}