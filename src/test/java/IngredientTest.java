import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private final String name = "Курица";
    private final float price = 111;
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, name, price);

    @Test
    public void getPriceTest() {
        assertEquals(price, ingredient.getPrice(), 0.0);
    }

    @Test
    public void getNameTest() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}
