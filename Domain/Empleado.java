package Domain;

import java.time.LocalDate;

public class Empleado extends Persona{
    private int idEmpleado;
    private static int contadorEmpleado;
    private LocalDate fechaInicioContrato;
    private String tipoCargo;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, int edad, int nIdentificacion, LocalDate fechaInicioContrato, String tipoCargo) {
        super(nombre, apellido, edad, nIdentificacion);
        this.fechaInicioContrato = fechaInicioContrato;
        this.tipoCargo = tipoCargo;
        this.idEmpleado = ++Empleado.contadorEmpleado;
    }

    public LocalDate getFechaInicioContrato() {
        return fechaInicioContrato;
    }

    public void setFechaInicioContrato(LocalDate fechaInicioContrato) {
        this.fechaInicioContrato = fechaInicioContrato;
    }

    public String getTipoCargo() {
        return tipoCargo;
    }

    public void setTipoCargo(String tipoCargo) {
        this.tipoCargo = tipoCargo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }
}
