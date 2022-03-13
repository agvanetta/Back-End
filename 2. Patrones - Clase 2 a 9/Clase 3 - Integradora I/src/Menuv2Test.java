import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Menuv2Test {

    @Test
    public void caso1(){
        Menuv2 prueba1 = new Infantil("Infantilito", 100,2);
        String resultadoEsperado = "Menu Infantil contiene hamburguesa simple, papas y 3 juguetes. El precio es de 109.0";
        String ingresando = prueba1.procesoDeArmadoDeMenu();

        assertEquals(resultadoEsperado,ingresando);
    }

}