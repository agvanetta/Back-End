public class Clasico extends Menuv2{

    public Clasico(String nombre, double precioBase) {
        super(nombre, precioBase);
    }

    @Override
    protected String armado() {
        return "Menu Clasico, hamburgesa doble con papas";
    }

    @Override
    protected double precioConRegargos() {
       return getPrecioBase();
    }
}
