import Domain.Departamento;
import Domain.Empleado;
import Service.DepartamentoService;
import Service.EmpleadoService;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class SistemaVacaciones {
    public static void main(String[] args) {
        Menu();
    }

    public static void Menu() {
        Scanner sc = new Scanner(System.in);
        EmpleadoService empleadoService = new EmpleadoService();
        DepartamentoService departamentoService = new DepartamentoService();
        crearEmpleados(empleadoService);
        crearDepartamento(departamentoService);
        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    consultarTiempoVacaciones(empleadoService, departamentoService, sc);
                    break;
                case 2:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Introduce una opción válida.");
            }
        } while (opcion != 2);
    }

    public static void mostrarMenuPrincipal() {
        System.out.println("******* Sistema de Gestión de Vacaciones S.A *******");
        System.out.println("1. Consultar tiempo de vacaciones");
        System.out.println("2. Salir");
        System.out.print("Selecciona una opción: ");
    }

    public static void consultarTiempoVacaciones(EmpleadoService empleadoService, DepartamentoService departamentoService, Scanner sc) {
        System.out.println("Ingrese el número de documento del empleado, por favor");
        int nroIdentificacion = sc.nextInt();
        Empleado empleado = empleadoService.consultar(nroIdentificacion);
        if (empleado == null) {
            System.out.println("Empleado no encontrado.");
            return;
        }
        Departamento departamento = departamentoService.consultar(empleado.getTipoCargo());
        if (departamento == null) {
            System.out.println("Departamento no encontrado.");
            return;
        }
        int tiempoVacaciones = calcularTiempoVacaciones(empleado.getFechaInicioContrato(), departamento.getClaveDepartamento());
        System.out.println("El empleado " + empleado.getNombre() + " " + empleado.getApellido() + " tiene derecho a " + tiempoVacaciones + " días de vacaciones.");
        System.out.println("¿Desea regresar al menú principal? (1 para sí, 2 para no)");
        int op = sc.nextInt();
        if (op == 1) {
            Menu();
        } else {
            System.out.println("Saliendo del programa.");
            System.exit(0); // Salir del programa
        }

    }

    public static int calcularTiempoVacaciones(LocalDate fechaInicioContrato, int claveDepartamento) {
        int anosTrabajados = calcularAniosDeServicio(fechaInicioContrato);
        int tiempoVacaciones = 0;
        switch (claveDepartamento) {
            case 1: // Atención al Cliente
                if (anosTrabajados == 1) {
                    tiempoVacaciones = 6;
                } else if (anosTrabajados >= 2 && anosTrabajados <= 6) {
                    tiempoVacaciones = 14;
                } else if (anosTrabajados > 7) {
                    tiempoVacaciones = 20;
                }
                break;
            case 2: // Logística
                if (anosTrabajados == 1) {
                    tiempoVacaciones = 7;
                } else if (anosTrabajados >= 2 && anosTrabajados <= 6) {
                    tiempoVacaciones = 15;
                } else if (anosTrabajados > 7) {
                    tiempoVacaciones = 22;
                }
                break;
            case 3: // Gerencia
                if (anosTrabajados == 1) {
                    tiempoVacaciones = 10;
                } else if (anosTrabajados >= 2 && anosTrabajados <= 6) {
                    tiempoVacaciones = 20;
                } else if (anosTrabajados > 7) {
                    tiempoVacaciones = 30;
                }
                break;
            default:
                System.out.println("Clave de departamento no válida.");
        }
        return tiempoVacaciones;
    }

    public static int calcularAniosDeServicio(LocalDate fechaInicio) {
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaInicio, fechaActual);
        return periodo.getYears();
    }

    public static void crearEmpleados(EmpleadoService empleadoService) {
        LocalDate fechaInicioEmpleado1 = LocalDate.of(2019, 7, 15);
        Empleado empleado1 = new Empleado("Yerlys", "Castellar", 20, 1192384994, fechaInicioEmpleado1, "Atención al Cliente");

        LocalDate fechaInicioEmpleado2 = LocalDate.of(2022, 7, 15);
        Empleado empleado2 = new Empleado("Maria", "Julio", 24, 1176300484, fechaInicioEmpleado2, "Logística");

        LocalDate fechaInicioEmpleado3 = LocalDate.of(2000, 7, 15);
        Empleado empleado3 = new Empleado("Auri", "Perez", 50, 11638485, fechaInicioEmpleado3, "Gerencia");

        empleadoService.crear(empleado1);
        empleadoService.crear(empleado2);
        empleadoService.crear(empleado3);
    }

    public static void crearDepartamento(DepartamentoService departamentoService) {
        Departamento departamento1 = new Departamento("Atención al Cliente", 1);
        Departamento departamento2 = new Departamento("Logística", 2);
        Departamento departamento3 = new Departamento("Gerencia", 3);

        departamentoService.crear(departamento1);
        departamentoService.crear(departamento2);
        departamentoService.crear(departamento3);
    }
}
