package ar.edu.unq.partnersdevapp.vista.main;

import org.apache.wicket.markup.html.basic.Label;

public class Page1 extends BasePage {
    public Page1() {
        this.add(new Label("label1", "This is in the subclass Page1"));
    }
}