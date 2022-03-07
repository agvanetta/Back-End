public class Circulo {

    private String color; // atributo compartido

    private double radio;
    private String tamaño;

    // Constructor. Con "color" porque es compartido, no cambia
    public Circulo(String color) {
        this.color = color;
    }

    //Get y Setters de lo que cambiamos, es decir NO COLOR
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public void dibujar(){
        System.out.println("Dibujamos objeto color: "+color);
    }
}
