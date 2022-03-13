import java.util.HashMap;
import java.util.List;

public class CancionFactory {

    // Creamos un map (referencia static final)
    private static final HashMap<String, Cancion> cancionMap = new HashMap<>();

    // Fabrica de objeto Cancion
    public static Cancion obtenerCancion(String nombre){
        Cancion cancion = cancionMap.get(nombre); // Lo busca en Map si no esta lo crea en la sentencia IF
        if(cancion == null){
            cancion = new Cancion(nombre);
            cancionMap.put(nombre, cancion); // Lo agregego al mapa para la proxima ejecucion
            System.out.println("Se creo una cancion :"+nombre);
        }
        return cancion;
    }
}
