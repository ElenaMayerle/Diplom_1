import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    Bun bun = new Bun("Обычная булочка",135.5f);
    @Test
    public void getNameTest(){
       Assert.assertEquals("Неправильная модель булочки", "Обычная булочка", bun.getName());
    }
    @Test
    public void getPriceTest(){
        Assert.assertEquals("Неправильная цена булочки", 135.5f, bun.getPrice(), 0);
    }

}
