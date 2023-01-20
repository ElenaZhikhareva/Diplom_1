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
    Burger burgerMock;

    @Test
    public void addIngredientTest() {
        Database database = new Database();
        List<Ingredient> ingredients = database.availableIngredients();
        burgerMock.addIngredient(ingredients.get(2));
        Mockito.verify(burgerMock).addIngredient(Mockito.any());
    }

    @Test
    public void removeIngredientTest() {
        burgerMock.removeIngredient(1);
        burgerMock.removeIngredient(2);
        Mockito.verify(burgerMock, Mockito.times(2)).removeIngredient(Mockito.anyInt());
    }

    @Test
    public void moveIngredientTest() {
        burgerMock.moveIngredient(1, 3);
        Mockito.verify(burgerMock, Mockito.times(1)).moveIngredient(1, 3);
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
        String receipt = burger.getReceipt();
        assertFalse(receipt.isEmpty());
    }
}
