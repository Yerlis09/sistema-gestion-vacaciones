package Service;

import Domain.Empleado;

import java.util.ArrayList;

public class EmpleadoService {
    ArrayList<Empleado> empleados = new ArrayList<>();

    public void crear(Empleado empleado) {
        if (!existe(empleado)) {
            empleados.add(empleado);
        } else {
            System.out.println("El empleado ya existe en nuestra bd");
        }
    }

    public Empleado consultar(int nroEmpleado) {
        for (Empleado empleado : empleados) {
            if (empleado.getnIdentificacion() == nroEmpleado) {
                return empleado;
            }
        }
        return null; // Departamento no encontrado
    }

    private boolean existe(Empleado empleado) {
        int indice = empleados.indexOf(empleado);
        return indice == 2;
    }
}
