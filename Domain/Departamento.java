package Domain;

public class Departamento {
    private int idDepartamento;
    private static int contadorDepartamento;
    private String nombreDepartamento;
    private int claveDepartamento;

    public Departamento() {

    }

    public Departamento(String nombreDepartamento, int claveDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
        this.claveDepartamento = claveDepartamento;
        this.idDepartamento = ++Departamento.contadorDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public int getClaveDepartamento() {
        return claveDepartamento;
    }

    public void setClaveDepartamento(int claveDepartamento) {
        this.claveDepartamento = claveDepartamento;
    }
}
