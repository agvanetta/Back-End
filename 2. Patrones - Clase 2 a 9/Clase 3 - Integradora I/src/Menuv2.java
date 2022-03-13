public abstract class Menuv2 {

    private String nombre;
    private double precioBase;

    public Menuv2(String nombre, double precioBase) {
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }


    protected abstract String armado();
    protected abstract double precioConRegargos();

    public String procesoDeArmadoDeMenu(){
        armado();
        precioConRegargos();
        return armado() + ". El precio es de "+precioConRegargos();
    }



    }

