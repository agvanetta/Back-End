import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTest {

    @Test
    public void caso1DocumentoDigital() {
        //DADO
        Empleado tincho = new EmpleadoEfectivo("Martin Martini", 123446, 02154, 400);
        ((EmpleadoEfectivo) tincho).setPremios(60);
        ((EmpleadoEfectivo) tincho).setDescuentos(40);

        // Se espera :
        String resultadoEsperado = "La liquidación generada es un documento digital. Saldo a liquidar: 420.0";

        //CUANDO
        String ingresando = tincho.liquidarSueldo();

        //ENTONCES
        assertEquals(resultadoEsperado, ingresando);
    }

    @Test
    public void caso2MensajeDeError(){
    //Dado
        Empleado tincho2 = new EmpleadoEfectivo("Martin Martini", 123446, 02154, 0);
        ((EmpleadoEfectivo) tincho2).setPremios(0);
        ((EmpleadoEfectivo) tincho2).setDescuentos(0);
    String resultadoEsperado=  "La liquidación no pudo ser calculada.";

    //Cuando
    String ingresando= tincho2.liquidarSueldo();

    // Test
    assertEquals(resultadoEsperado,ingresando);
    }

}