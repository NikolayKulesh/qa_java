import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void testLionBoy() throws Exception {
        String actualSex = "Самец";
        Lion lionBoy = new Lion(actualSex);

        Assert.assertEquals(true, lionBoy.isHasMane());
    }

    @Test
    public void testLionGirl() throws Exception {
        String actualSex = "Самка";
        Lion lionGirl = new Lion(actualSex);

        Assert.assertEquals(false, lionGirl.isHasMane());
    }

    @Test(expected = Exception.class)
    public void testAnotherSex() throws Exception {
        Lion lionAnotherSex = new Lion("Квир");
    }

   @Test
    public void addKittensTest() {
        Lion kittens = new Lion(feline);

        Mockito.when(feline.getKittens()).thenReturn(1);

       int actual = kittens.addKittens();
       int expected = 1;

       Assert.assertEquals(expected, actual);
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> foodExpected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(foodExpected);

        Lion lion = new Lion(feline);

        List<String> foodActual = lion.getFood();

        Assert.assertEquals(foodExpected, foodActual);
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        String actualSex = "Самец";
        Lion lionBoy = new Lion(actualSex);

        Assert.assertEquals(true, lionBoy.doesHaveMane());
    }

}
