package ar.edu.unq.partnersdevapp.vista.pages;

import org.apache.wicket.markup.html.basic.Label;

import ar.edu.unq.partnersdevapp.vista.panel.login.LogInHeaderPanel;

public class LogInApp extends BasePage {

    public LogInApp() {
        super();

    }

    @Override
    public void addMenuRight() {
    }

    @Override
    public void addHeader() {
        this.add(new LogInHeaderPanel());
    }

    @Override
    public void addContent() {
        this.add(new Label("label1", "pantalla de logeo"));
    }

}
