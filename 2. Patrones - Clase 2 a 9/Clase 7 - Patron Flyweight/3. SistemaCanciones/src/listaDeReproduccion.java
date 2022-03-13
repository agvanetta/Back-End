import java.util.ArrayList;
import java.util.List;

public class listaDeReproduccion {

    private String nombre;
    private List<Cancion> canciones;

    public void addCancion(Cancion c){ // importante para agregar a una lista.
        // agregar una cancion a canciones
        canciones.add(c);
    }


    public listaDeReproduccion(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }
}

