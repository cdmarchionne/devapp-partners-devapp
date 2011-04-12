package ar.edu.unq.partnersdevapp.dominio.carrera;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO: description
 */
public class Skills {

    // private Map<Tecnologia, Categoria> skill;
    private final Map<String, Integer> skill;

    public Skills() {
        super();
        skill = new HashMap();
    }

    public void setSkill(final String tecnologia, final String categoria) {
        if (Tecnologia.esTecnologia(tecnologia)) {
            skill.put(tecnologia, Categoria.indiceCategoria(categoria));
        }

    }

    public void bajarCategoria(final String tecnologia) {

        if (skill.containsKey(tecnologia)) {
            skill.put(tecnologia, Categoria.bajarCategoria(skill.get(tecnologia)));
        }
    }

    public void subirCategoria(final String tecnologia) {

        if (skill.containsKey(tecnologia)) {
            skill.put(tecnologia, Categoria.subirCategoria(skill.get(tecnologia)));
        }
    }

    public void printSkills() {
        System.out.println(skill.toString());
    }

    public static void main(final String[] args) {
        Tecnologia.addTecnologia("JAVA");
        Tecnologia.addTecnologia("Poo");

        Categoria.addCategoria("Basico");
        Categoria.addCategoria("Medio");
        Categoria.addCategoria("Experto");

        final Skills conocimientos = new Skills();

        conocimientos.setSkill("JAVA", "Medio");
        conocimientos.setSkill("Poo", "Basico");

        conocimientos.printSkills();

        conocimientos.subirCategoria("JAVA");
        conocimientos.subirCategoria("JAVA");
        conocimientos.subirCategoria("JAVA");
        conocimientos.printSkills();

    }
}