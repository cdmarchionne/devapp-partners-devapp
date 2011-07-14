package ar.edu.unq.partnersdevapp.vista.panel.plan;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.partnersdevapp.service.carrera.PlanService;
import ar.edu.unq.partnersdevapp.service.dto.plandecarreradto.PlanDto;
import ar.edu.unq.partnersdevapp.vista.models.ModelTable;
import ar.edu.unq.partnersdevapp.vista.panel.FilterPanel;
import ar.edu.unq.partnersdevapp.vista.panel.SelectPanel;
import ar.edu.unq.partnersdevapp.vista.panel.TablePanel;

/**
 */
public class PlanSelectByIdPanel extends SelectPanel<PlanDto, PlanService> {

    private static final long serialVersionUID = 1L;

    @SpringBean(name = "service.planService")
    private PlanService service;

    public PlanSelectByIdPanel() {
        super("plan");
    }

    @Override
    public List<String> getAttributes() {
        List<String> list = new ArrayList<String>();
        list.add("id");
        list.add("especialidad");
        list.add("descripcion");
        return list;
    }

    @Override
    public FilterPanel<PlanDto, PlanService> createPanelFilter() {
        return new PlanFilterPanel(new PlanDto(), service);
    }

    @Override
    public TablePanel<PlanDto> createPanelTable() {
        ModelTable<PlanDto> aModelTable = new ModelTable<PlanDto>(service.findAll());
        return new PlanTablePanel("plan", aModelTable, this.getAttributes());
    }

}
