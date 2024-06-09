import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSoundTest() {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);

        String actual = cat.getSound();
        String expected = "Мяу";

        assertEquals(expected, actual);
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> foodExpected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(foodExpected);

        Cat cat = new Cat(feline);

        List <String> foodActual = cat.getFood();

        Assert.assertEquals(foodExpected, foodActual);

    }

}
