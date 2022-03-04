import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CupTest {

    @Test
    void getLiquidType() {
        Cup c = new Cup("Orange", 85.5);
        assertEquals("Orange", c.getLiquidType());
    }

    @Test
    void getPercentageFull () {
        Cup c = new Cup("Orange", 85.5);
        assertEquals(85.5, c.getPercentFull());
    }
}

