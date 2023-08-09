import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(IngredientType.FILLING,"Сыр", 2.5f);
    @Test
    public void getPriceTest(){
        Assert.assertEquals("Неправильная цена ингредиента", 2.5f, ingredient.getPrice(),0);
    }
    @Test
    public void getNameTest(){
        Assert.assertEquals("Неправильное название ингредиента", "Сыр", ingredient.getName());
    }
    @Test
    public void getTypeTest(){
        Assert.assertEquals("Неправильный тип ингредиента", "FILLING", ingredient.getType().toString());
    }
}
