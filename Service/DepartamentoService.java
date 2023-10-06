package Service;

import Domain.Departamento;
import Domain.Departamento;

import java.util.ArrayList;

public class DepartamentoService {
    ArrayList<Departamento> departamentos = new ArrayList<>();

    public void crear(Departamento departamento) {
        if (!existe(departamento)) {
            departamentos.add(departamento);
        } else {
            System.out.println("El departamento ya existe en nuestra bd");
        }
    }

    public Departamento consultar(String nombreDepartamento) {
        for (Departamento departamento : departamentos) {
            if (departamento.getNombreDepartamento().equals(nombreDepartamento)) {
                return departamento;
            }
        }
        return null; // Departamento no encontrado
    }

    private boolean existe(Departamento departamento) {
        int indice = departamentos.indexOf(departamento);
        return indice == 2;
    }

}
