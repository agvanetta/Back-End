package com.main;

import org.apache.log4j.Logger;

import java.util.List;

public class Calulador {


    private List<Integer> listaEnteros;

    private static final Logger logger = Logger.getLogger(Calulador.class);


    public void logLista () throws Exception {
        int suma = 0;

        for (int x = 0; x < listaEnteros.size(); x++) {
            suma = suma + listaEnteros.get(x);
        }
        float promedio = suma / listaEnteros.size();

        if (listaEnteros.size() > 5)
            logger.info("La lista tiene mas de 5 elementos");
        if(listaEnteros.size() > 10)
            logger.info("La lista tiene mas de 10 elementos");
        logger.info("El promedio de numeros es" + promedio);
        if (listaEnteros.size() == 0)
            throw new Exception();

    }



}
