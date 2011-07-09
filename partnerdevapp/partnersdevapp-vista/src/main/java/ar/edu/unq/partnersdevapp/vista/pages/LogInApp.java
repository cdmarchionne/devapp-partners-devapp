package ar.edu.unq.partnersdevapp.vista.pages;

import org.apache.wicket.markup.html.basic.Label;

public class LogInApp extends BasePage {

    public LogInApp() {
        super();
        this.iniciar();
    }

    @Override
    public void iniciar() {
        this.addMenuRight();
        this.addContent();
        this.setModels();
    }

    @Override
    public void addMenuRight() {
    }

    @Override
    public void addContent() {
        this.add(new Label("label1", "This is in the subclass Page1"));
    }

    @Override
    public void setModels() {
    }

}
