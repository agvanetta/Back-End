import java.util.HashMap;

public class FlyweightFactory {

    // Creamos un map (referencia static final)
    private static final HashMap<String, Circulo> circuloMap = new HashMap<>();

    // Fabrica de objeto Circulo
    public static Circulo obtenerCirculo(String color){
        Circulo circulo = circuloMap.get(color); // Lo busca en Map si no esta lo crea en la sentencia IF
        if(circulo == null){
            circulo = new Circulo(color);
            circuloMap.put(color, circulo); // Lo agregego al mapa para la proxima ejecucion
            System.out.println("Creo un circulo de color :"+color);
        }
        return circulo;
    }
}
