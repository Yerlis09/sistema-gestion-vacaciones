package Domain;

public class Persona {
    private int idPersona;
    private static int contadorPersona;
    private String nombre;
    private String apellido;
    private int edad;
    private int nIdentificacion;

    public Persona() {
    }

    public Persona(String nombre, String apellido, int edad, int nIdentificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.nIdentificacion = nIdentificacion;
        this.idPersona = ++Persona.contadorPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getnIdentificacion() {
        return nIdentificacion;
    }

    public void setnIdentificacion(int nIdentificacion) {
        this.nIdentificacion = nIdentificacion;
    }

    public int getIdPersona() {
        return idPersona;
    }
}
