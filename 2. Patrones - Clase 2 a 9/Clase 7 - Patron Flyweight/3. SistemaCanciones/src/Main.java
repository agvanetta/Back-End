import java.util.List;

public class Main {


    public static void main(String[] args) {
        listaDeReproduccion topFive = new listaDeReproduccion("Top five");
        Cancion cancion = CancionFactory.obtenerCancion("Hola");
        cancion.setArtista("Diego");
        cancion.setGenero("Urbano");

        topFive.addCancion(cancion);

        System.out.println((topFive.getCanciones()));
    }
}
