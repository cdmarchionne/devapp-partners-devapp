package ar.edu.unq.partnersdevapp.vista.pages;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.partnersdevapp.service.defaultValue.DefaultValue;

public class Page1 extends BasePage {

    @SpringBean(name = "service.defaultValueService")
    private DefaultValue defaultValueService;

    public Page1() {
        super();
        this.add(new Label("label1", "This is in the subclass Page1"));

        defaultValueService.add();

    }

}
