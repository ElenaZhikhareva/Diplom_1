import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunParamsTest {
    private final String bunName;
    private final float bunPrice;

    public BunParamsTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getBunData() {
        return new Object[][]{
                {"black bun", 299},
                {"red bun", 99},
                {"black bun", 2.38f},
        };
    }

    @Test
    public void createBunWithAnyParamsTest() {
        Bun bun = new Bun(bunName, bunPrice);
        float actualPrice = bun.getPrice();
        Assert.assertEquals(bunPrice, actualPrice, 0);
        String actualName = bun.getName();
        Assert.assertEquals(bunName, actualName);
    }
}
