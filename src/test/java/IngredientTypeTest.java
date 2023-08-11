import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final String expected;
    public IngredientTypeTest(String expected){
        this.expected=expected;
    }
    @Parameterized.Parameters
    public static Object[][] getType() {
        return new Object[][] {
                {"SAUCE"},
                {"FILLING"},
        };
    }
    @Test
    public void isTypeExists(){
        Assert.assertEquals("Неверное название типа игредиента",expected,IngredientType.valueOf(expected).toString());
    }

}
