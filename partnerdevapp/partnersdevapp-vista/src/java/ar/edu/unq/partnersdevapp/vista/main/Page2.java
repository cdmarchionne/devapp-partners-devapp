package ar.edu.unq.partnersdevapp.vista.main;

import org.apache.wicket.markup.html.basic.Label;

public class Page2 extends BasePage {
    public Page2() {
        this.add(new Label("label2", "This is in the subclass Page2"));
    }
}