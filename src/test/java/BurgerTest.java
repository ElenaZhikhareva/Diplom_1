import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bunMock;
    @Mock
    Ingredient ingredientMock;
    @Mock
    Ingredient ingredientMockTwo;
    Burger burger = new Burger();
    List<Ingredient> ingredients = burger.ingredients;

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredientMock);
        Assert.assertEquals(1, ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredientMockTwo);
        Assert.assertEquals(1, ingredients.size());
        burger.removeIngredient(0);
        Assert.assertTrue(ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredientMockTwo);
        Assert.assertEquals(2, ingredients.size());
        burger.moveIngredient(1, 0);
        Assert.assertEquals(ingredientMockTwo, ingredients.get(0));
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        Mockito.when(bunMock.getPrice()).thenReturn(200F);
        Mockito.when(ingredientMock.getPrice()).thenReturn(300F);
        assertEquals("Стоимость: 700 руб.", 700, burger.getPrice(), 0);
        System.out.println(burger.getPrice());
    }

    @Test
    public void getReceiptBurgerTest() {
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        when(bunMock.getName()).thenReturn("black bun");
        when(bunMock.getPrice()).thenReturn(200F);
        when(ingredientMock.getType()).thenReturn(IngredientType.FILLING);
        when(ingredientMock.getName()).thenReturn("sausage");
        when(ingredientMock.getPrice()).thenReturn(300F);
        String receipt = String.format("(==== %s ====)%n", bunMock.getName()) + String.format("= %s %s =%n", ingredientMock.getType().toString().toLowerCase(), ingredientMock.getName()) +
                String.format("(==== %s ====)%n", bunMock.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());
        System.out.println(receipt);
        System.out.println(burger.getReceipt());
        assertEquals(burger.getReceipt(), receipt);
    }
}
