import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun = new Bun("Ржаная", 111);

    @Test
    public void getNameTest() {
        assertEquals("Ржаная", bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(111, bun.getPrice(), 0.0);
    }
}
