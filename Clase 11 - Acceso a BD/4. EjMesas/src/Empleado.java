import org.apache.log4j.Logger;

public class Empleado {
    private int ID;
    private String nombre;
    private int edad;
    private String empresa;
    private String fechaIngreso;

    private final static Logger logger = Logger.getLogger(Test.class);

    public Empleado(int ID, String nombre, int edad, String empresa, String fechaIngreso) {
        this.ID = ID;
        this.nombre = nombre;
        this.edad = edad;
        this.empresa = empresa;
        this.fechaIngreso = fechaIngreso;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
