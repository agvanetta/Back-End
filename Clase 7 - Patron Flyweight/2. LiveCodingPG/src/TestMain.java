public class TestMain {
    // Por fuera del main
    private static String colores[] = {"Rojo","Azul", "Verde","Negro"};

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            Circulo circulo = FlyweightFactory.obtenerCirculo(colorAleatorio()); // No lo creamos nosotros, lo crea la factory
            circulo.setRadio(i + 5);
            circulo.setTamaño("tamaño : "+ i * 2);
            circulo.dibujar();
        }
    }

    // Para obtener colores de forma aleatoria, sirve para testear el main en este caso.
    private static String colorAleatorio(){
        return colores[(int)(Math.random()*colores.length)];
    }
}
