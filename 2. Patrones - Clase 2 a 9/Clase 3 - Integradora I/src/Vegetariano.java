public class Vegetariano extends Menuv2{

    private int cantEspecia1;
    private int cantEspecia2;
    private int cantSalsa1;
    private int cantSalsa2;

    public Vegetariano(String nombre, double precioBase, int cantEspecia1, int cantEspecia2, int cantSalsa1, int cantSalsa2) {
        super(nombre, precioBase);
        this.cantEspecia1 = cantEspecia1;
        this.cantEspecia2 = cantEspecia2;
        this.cantSalsa1 = cantSalsa1;
        this.cantSalsa2 = cantSalsa2;
    }

    public int getCantEspecia1() {
        return cantEspecia1;
    }

    public void setCantEspecia1(int cantEspecia1) {
        this.cantEspecia1 = cantEspecia1;
    }

    public int getCantEspecia2() {
        return cantEspecia2;
    }

    public void setCantEspecia2(int cantEspecia2) {
        this.cantEspecia2 = cantEspecia2;
    }

    public int getCantSalsa1() {
        return cantSalsa1;
    }

    public void setCantSalsa1(int cantSalsa1) {
        this.cantSalsa1 = cantSalsa1;
    }

    public int getCantSalsa2() {
        return cantSalsa2;
    }

    public void setCantSalsa2(int cantSalsa2) {
        this.cantSalsa2 = cantSalsa2;
    }

    @Override
    protected String armado() {
        return "Menu Vegetariano, Especia1: "+cantEspecia1+"| Especia2: "+cantEspecia2+"| Salsa1: "+cantSalsa1+" | Salsa2: "+cantSalsa2;

    }

    @Override
    protected double precioConRegargos() {
        int especias= cantEspecia1+cantEspecia2;
        int salsas=cantSalsa1+cantSalsa2;

        if (especias>0){
            return getPrecioBase() + especias + (2*salsas);
        } else {
            return getPrecioBase() + (2 * salsas);
        }
    }
}
