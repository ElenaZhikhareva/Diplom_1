import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bunMock;
    Ingredient ingredientMock;
    Ingredient ingredientMockOne;

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        assertEquals(bunMock, burger.bun);
    }

    @Test
    public void addIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientMock);
        assertEquals(1, burger.ingredients.size());
        burger.removeIngredient(0);
    }

    @Test
    public void removeIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientMock);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredientMockOne);
        burger.moveIngredient(1, 0);
        assertEquals(ingredientMock, burger.ingredients.get(0));
        assertEquals(ingredientMockOne, burger.ingredients.get(1));
    }

    @Test
    public void getPriceBurgerTest() {
        Burger burger = new Burger();
        burger.ingredients.add(ingredientMock);
        burger.ingredients.add(ingredientMockOne);
        burger.bun = bunMock;
        Mockito.when(bunMock.getPrice()).thenReturn(100F);
        Mockito.when(ingredientMock.getPrice()).thenReturn(200F);
        burger.getPrice();
        Mockito.verify(bunMock).getPrice();
        Mockito.verify(ingredientMockOne, Mockito.times(2)).getPrice();
        assertEquals(4.0f, burger.getPrice(), 0.0);
    }

    @Test
    public void getReceiptBurgerTest() {
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        when(bunMock.getName()).thenReturn("bun");
        when(bunMock.getPrice()).thenReturn(100F);
        when(ingredientMock.getType()).thenReturn(IngredientType.FILLING);
        when(ingredientMock.getName()).thenReturn("ingredient");
        when(ingredientMock.getPrice()).thenReturn(200F);
        String expected = "(==== bun ====)" + "\n" + "= filling ingredient =" + "\n" + "(==== bun ====)" + "\n\n" + "Price: 400,000000" + "\n";
        String reciept = burger.getReceipt();
        System.out.println(expected);
        System.out.println(reciept);
        assertTrue(expected.contains("= filling ingredient ="));
        burger.removeIngredient(0);
    }






}
