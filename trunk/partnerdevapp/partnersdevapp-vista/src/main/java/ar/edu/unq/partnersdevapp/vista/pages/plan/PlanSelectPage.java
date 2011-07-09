package ar.edu.unq.partnersdevapp.vista.pages.plan;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.partnersdevapp.service.carrera.PlanService;
import ar.edu.unq.partnersdevapp.service.dto.plandecarreradto.PlanDto;
import ar.edu.unq.partnersdevapp.vista.components.PanelFilter;
import ar.edu.unq.partnersdevapp.vista.components.PanelTable;
import ar.edu.unq.partnersdevapp.vista.components.SelectPage;
import ar.edu.unq.partnersdevapp.vista.components.plan.PlanById;
import ar.edu.unq.partnersdevapp.vista.models.ModelTable;

/**
 * Consulta basica sobre plan de carrera.
 * 
 * @param <T>
 * @param <S>
 */
public class PlanSelectPage<T, S> extends SelectPage<PlanDto, PlanService> {

    private static final long serialVersionUID = 1L;

    @SpringBean(name = "service.planService")
    private PlanService service;

    @Override
    public List<String> getAttributes() {
        List<String> list = new ArrayList<String>();
        list.add("id");
        list.add("especialidad");
        list.add("descripcion");
        return list;
    }

    @Override
    public PanelTable<PlanDto> getPanelTable() {
        return new PanelTable<PlanDto>(this.getModelTable(), this.getAttributes());
    }

    @Override
    public PanelFilter<PlanDto, PlanService> getPanelFilter(final List<Component> componentList) {
        return new PlanById(this.getModelTable(), this.getService(), componentList);
    }

    @Override
    public void setModels() {
        this.setModelTable(new ModelTable<PlanDto>());
        this.getModelTable().setFilas(this.getService().findAll());
    }

    public void setService(final PlanService service) {
        this.service = service;
    }

    public PlanService getService() {
        return service;
    }

}
