import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;
    @Mock
    Ingredient ingredient3;
    @Mock
    Ingredient ingredient4;
    @Spy
    Burger burger;

    @Before
    public void doBurger(){
        burger.setBuns(bun);
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.ingredients.add(ingredient3);
        burger.ingredients.add(ingredient4);

    }
    @Test
    public void addIngredientTest(){
        burger.addIngredient(ingredient1);
        Assert.assertEquals("Добавляется неправильное количество ингредиентов", 5,burger.ingredients.size());
    }
    @Test
    public void removeIngredientTest(){
        burger.removeIngredient(1);
        Assert.assertFalse("Удялется неверный ингредиент",burger.ingredients.contains(ingredient2));
    }

    @Test
    public void moveIngredient(){
        burger.moveIngredient(3,1);
        Assert.assertEquals("Ингредиенты неправильно меняются местами",ingredient4,burger.ingredients.get(1));
    }
    @Test
    public void getPrice(){
        Mockito.when(bun.getPrice()).thenReturn(3.5f);
        Mockito.when(ingredient1.getPrice()).thenReturn(1.0f);
        Mockito.when(ingredient2.getPrice()).thenReturn(2.0f);
        Mockito.when(ingredient3.getPrice()).thenReturn(3.0f);
        Mockito.when(ingredient4.getPrice()).thenReturn(4.0f);
        Assert.assertEquals("Сумма посчитана неверно", 17, burger.getPrice(),0);
    }
    @Test
    public void getReceipt(){
        Mockito.when(bun.getName()).thenReturn("Булочка с кунжутом");
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getName()).thenReturn("Сырный");
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getName()).thenReturn("Огурец");
        Mockito.when(ingredient3.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient3.getName()).thenReturn("Котлета");
        Mockito.when(ingredient4.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient4.getName()).thenReturn("Помидор");
        Mockito.when(burger.getPrice()).thenReturn(17f);
        String expected = "(==== Булочка с кунжутом ====)\r\n" +
                "= sauce Сырный =\r\n" +
                "= filling Огурец =\r\n" +
                "= filling Котлета =\r\n" +
                "= filling Помидор =\r\n" +
                "(==== Булочка с кунжутом ====)\r\n" +
                "\r\n" +
                "Price: 17,000000\r\n";
        Assert.assertEquals("Неправильный рецепт", expected,burger.getReceipt());
    }

}
