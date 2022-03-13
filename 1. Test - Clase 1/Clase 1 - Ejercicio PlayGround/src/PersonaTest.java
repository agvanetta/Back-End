import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {

    Persona p = new Persona("Agustin", "Vanetta", "agustin@gmail.com", 28);

    // Un test que nos certifique que el nombre completo es correcto.
    @Test
    void mostrarNombre() {
        assertEquals("Vanetta, Agustin", p.mostrarNombre("Agustin","Vanetta"));
    }

    //Un test que nos certifique que la persona es realmente mayor a 18 años
    @Test
    void esMayor(){
        assertEquals(true, p.esMayor(28));
    }
}