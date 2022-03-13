public class Infantil extends Menuv2{

    private int juguetes;

    public Infantil(String nombre, double precioBase, int juguetes) {
        super(nombre, precioBase);
        this.juguetes = juguetes;
    }

    public int getJuguetes() {
        return juguetes;
    }

    public void setJuguetes(int juguetes) {
        this.juguetes = juguetes;
    }

    @Override
    protected String armado() {
        return "Menu Infantil contiene hamburguesa simple, papas y "+ juguetes+" juguetes";
    }

    @Override
    protected double precioConRegargos() {
        return getPrecioBase() + (3*juguetes);

    }
}
