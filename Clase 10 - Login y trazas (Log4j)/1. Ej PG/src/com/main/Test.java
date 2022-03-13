package com.main;

public class Test {

    public static void main(String[] args) throws Exception {

        Leon estudiantes = new Leon("Picharata",22,true);
        Leon lobo = new Leon("Lobito",-1,true);

        estudiantes.correr();
        lobo.correr();

        estudiantes.esMayorA10();
        lobo.esMayorA10();


    }
}
