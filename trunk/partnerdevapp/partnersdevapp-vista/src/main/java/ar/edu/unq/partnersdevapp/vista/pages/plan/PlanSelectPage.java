package ar.edu.unq.partnersdevapp.vista.pages.plan;

import ar.edu.unq.partnersdevapp.vista.pages.BasePage;
import ar.edu.unq.partnersdevapp.vista.panel.plan.PlanHeaderPanel;
import ar.edu.unq.partnersdevapp.vista.panel.plan.PlanMenuRightPanel;
import ar.edu.unq.partnersdevapp.vista.panel.plan.PlanSelectByIdPanel;

/**
 * Consulta basica sobre plan de carrera.
 * 
 * @param <T>
 * @param <S>
 */
public class PlanSelectPage extends BasePage {

    private static final long serialVersionUID = 1L;

    @Override
    public void addMenuRight() {
        this.add(new PlanMenuRightPanel());
    }

    @Override
    public void addContent() {
        this.add(new PlanSelectByIdPanel());
    }

    @Override
    public void addHeader() {
        this.add(new PlanHeaderPanel());
    }

}
