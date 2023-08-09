import org.junit.Assert;
import org.junit.Test;

import static praktikum.IngredientType.*;

public class IngredientTypeTest {
    @Test
    public void isSauceExists(){
        Assert.assertEquals("Неверное название типа игредиента","SAUCE", SAUCE.toString());
    }

    @Test
    public void isFillingExists(){
        Assert.assertEquals("Неверное название типа игредиента","FILLING", FILLING.toString());
    }
}
