import java.io.*;
import java.util.ArrayList;

public class Paseo {
    public static void main(String[] args) {


        Perro p1 = new Perro("Apollo", "Cocker", 5, "Guemes 490");
        Perro p2 = new Perro("Nei", "Mestizo", 9, "Parga 3675");
        Perro p3 = new Perro("Mini", "Caniche", 8, "Manuel P2");
        Perro p4 = new Perro("Rominski", "Maltes", 6, "Roma 22");

        ArrayList<Perro> lunes = new ArrayList<Perro>();
        ArrayList<Perro> martes = new ArrayList<Perro>();
        ArrayList<Perro> miercoles = new ArrayList<Perro>();
        ArrayList<Perro> jueves = new ArrayList<Perro>();
        ArrayList<Perro> viernes = new ArrayList<Perro>();
        // p1
        lunes.add(p1);
        miercoles.add(p1);
        viernes.add(p1);
        // p2
        lunes.add(p2);
        martes.add(p2);
        miercoles.add(p2);
        jueves.add(p2);
        // p3
        miercoles.add(p3);
        jueves.add(p3);
        viernes.add(p3);
        // p4
        lunes.add(p4);
        martes.add(p4);
        miercoles.add(p4);
        jueves.add(p4);
        viernes.add(p4);

        // Grabar array list en un archivo
        try {
            FileOutputStream fil = new FileOutputStream("perros.dat");
            ObjectOutputStream archi = new ObjectOutputStream(fil);

            archi.writeObject(lunes);
            archi.writeObject(martes);
            archi.writeObject(miercoles);
            archi.writeObject(jueves);
            archi.writeObject(viernes);

            archi.close();

            // Leer
            FileInputStream filInput = new FileInputStream("perros.dat");
            ObjectInputStream archiInput = new ObjectInputStream(filInput);

            ArrayList<Perro> dia;

            for (int i = 0; i < 5; i++) {
                System.out.println("Dia: "+(i+1));
                System.out.println("==================");
                dia = (ArrayList<Perro>) archiInput.readObject();
                for (Perro p: dia
                     ) {
                    System.out.println(p);
                }
            }

            archiInput.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}