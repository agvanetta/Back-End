public class Main {
    public static void main(String[] args) {


        Menuv2 caja1 = new Infantil("Infantil", 100, 3);

        System.out.println(caja1.procesoDeArmadoDeMenu());

        Menuv2 cajaVeggie = new Vegetariano("Veggie", 100,1,1,1,1);

        System.out.println(cajaVeggie.procesoDeArmadoDeMenu());
    }
}
