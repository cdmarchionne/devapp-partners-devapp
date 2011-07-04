package ar.edu.unq.partnersdevapp.service.defaultValue;

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
import ar.edu.unq.partnersdevapp.exceptions.NoSeAsignoLicencia;
import ar.edu.unq.partnersdevapp.exceptions.PeriodoIndeterminadoException;

public class Factory {

    public static Empleado getEmpleado1() {
        Empleado empleado = new Empleado("NombreEmpleado1", "ApellidoEmpleado1", "dni1");
        empleado.setDireccion(getDireccion1());
        empleado.setFechaNacimiento(FechaUtils.crearFecha("01/01/80"));
        empleado.setFechaIngreso(FechaUtils.crearFecha("01/01/01"));
        try {
            try {
                empleado.getLicenciaManager().addLicencia(Factory.getLicencia1(), Factory.getFxc());
            } catch (NoSeAsignoLicencia e) {
                throw new UnsupportedOperationException();
            }
        } catch (NoHayResultadoException e) {
            throw new UnsupportedOperationException();
        } catch (PeriodoIndeterminadoException e) {
            throw new UnsupportedOperationException();
        }
        return empleado;
    }

    public static Empleado getEmpleado2() {
        Empleado empleado = new Empleado("NombreEmpleado2", "ApellidoEmpleado2", "dni2");
        empleado.setDireccion(getDireccion2());
        empleado.setFechaNacimiento(FechaUtils.crearFecha("02/02/82"));
        empleado.setFechaIngreso(FechaUtils.crearFecha("02/02/02"));
        return empleado;
    }

    public static Cliente getCliente() {
        return new Cliente("clientenombre1", "clienteApellido1", "clientedni", "clienteRazonSocial1");
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

    public static Direccion getDireccion1() {
        return new Direccion("calle1", 1, "piso1", "depto1", "localidad1", "codigoPostal1", "provincia1", "pais1");
    }

    public static Direccion getDireccion2() {
        return new Direccion("calle2", 2, "piso2", "depto2", "localidad2", "codigoPostal2", "provincia2", "pais2");
    }

}
