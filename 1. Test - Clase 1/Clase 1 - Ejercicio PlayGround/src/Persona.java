public class Persona {
    // atributos: Nombre, Apellido, Email y Edad.

    private String nombre;
    private String apellido;
    private String email;
    private int edad;

    // Un método que muestre el nombre completo de la siguiente manera: Apellido, Nombre.
    public String mostrarNombre (String nombre, String apellido){
        return apellido+", "+nombre;
    }

    // Un método para calcular si la persona es mayor de 18 años.
    public boolean esMayor(int edad){
        if (edad>18){
            return true;
        } else {
            return false;
        }
    }

    public Persona(String nombre, String apellido, String email, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.edad = edad;
    }

    // Getters y Setters

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
