package ar.edu.unq.partnersdevapp.service.defaultvalue;

import ar.edu.unq.partnersdevapp.dominio.calendario.FechasXcomprension;
import ar.edu.unq.partnersdevapp.dominio.calendario.Intervalo;
import ar.edu.unq.partnersdevapp.dominio.carrera.Nivel;
import ar.edu.unq.partnersdevapp.dominio.carrera.PlanDeCarrera;
import ar.edu.unq.partnersdevapp.dominio.licencia.LicenciaTipo;
import ar.edu.unq.partnersdevapp.dominio.personal.Cliente;
import ar.edu.unq.partnersdevapp.dominio.personal.Direccion;
import ar.edu.unq.partnersdevapp.dominio.personal.Empleado;
import ar.edu.unq.partnersdevapp.dominio.utils.FechaUtils;
import ar.edu.unq.partnersdevapp.exceptions.NoHayResultadoException;

public class Factory {

    private Factory() {
    }

    public static Empleado getEmpleado(final int numero) {
        Empleado empleado = new Empleado("NombreEmpleado" + numero, "ApellidoEmpleado" + numero, "dni" + numero);
        empleado.setDireccion(getDireccion(numero));
        empleado.setFechaNacimiento(FechaUtils.crearFecha("01/01/80"));
        empleado.setFechaIngreso(FechaUtils.crearFecha("01/01/01"));

        return empleado;
    }

    public static Cliente getCliente(final int numero) {
        return new Cliente("clientenombre" + numero, "clienteApellido" + numero, "clientedni" + numero,
                "clienteRazonSocial" + numero);
    }

    /** plan con dos niveles */
    public static PlanDeCarrera getPlan() throws NoHayResultadoException {
        PlanDeCarrera plan = new PlanDeCarrera("Diseño", "cosas de deseñador");
        Nivel nivel = new Nivel("nivel1Dis", 3, 10, 10);
        plan.addNivelAnterior(nivel, null);
        plan.addNivelPosterior(new Nivel("nivel2Dis", 5, 11, 50), nivel);
        return plan;
    }

    public static PlanDeCarrera getPlan2() throws NoHayResultadoException {
        PlanDeCarrera plan = new PlanDeCarrera("tecnico", "cosas de tecnico");
        Nivel nivel = new Nivel("nivel1Tec", 3, 10, 10);
        plan.addNivelAnterior(nivel, null);
        plan.addNivelPosterior(new Nivel("nivel2Tec", 5, 11, 50), nivel);
        return plan;
    }

    public static FechasXcomprension getFxc() {
        FechasXcomprension fxc = new FechasXcomprension();
        fxc.set(FechaUtils.crearFecha("04/06/2011"), FechaUtils.getDiasHabiles(), Intervalo.getUnaSemana(),
                FechaUtils.crearFecha("08/06/2011"));
        return fxc;
    }

    public static FechasXcomprension getFxc2() {
        FechasXcomprension fxc = new FechasXcomprension();
        fxc.set(FechaUtils.crearFecha("04/06/2011"), FechaUtils.getDiasHabiles(), Intervalo.getUnaSemana(),
                FechaUtils.crearFecha("06/06/2011"));
        return fxc;
    }

    public static LicenciaTipo getLicencia1() {
        return new LicenciaTipo("licTipo1", true, 3, 3);
    }

    public static LicenciaTipo getLicencia2() {
        return new LicenciaTipo("licTipo2", true, 2, 1);
    }

    public static Direccion getDireccion(final int numero) {
        return new Direccion("calle" + numero, numero, "piso" + numero, "depto" + numero, "localidad" + numero,
                "codigoPostal" + numero, "provincia" + numero, "pais" + numero);
    }

}
