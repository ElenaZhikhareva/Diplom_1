import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private IngredientType type;
    private Ingredient ingredient;


    public IngredientTypeTest(IngredientType type) {
        this.type = type;
    }

    @Parameterized.Parameters(name = " IngredientType: {0}")
    public static Object[] params() {
        return new Object[]
                {IngredientType.FILLING, IngredientType.SAUCE};
    }

    @Test
    public void getIngredientTypeTest(){
        ingredient = new Ingredient(type,"батон", 12);
        assertEquals(type, ingredient.getType());
    }
}
