import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline;

    @Parameterized.Parameter
    public int actualCount;

    @Parameterized.Parameter
    public int expectedCount;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {1, 1},
                {2, 2},
                {3, 3}
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getKittensTestWithParameter() {
        feline.getKittens(actualCount);
        Assert.assertEquals(expectedCount, feline.getKittens(actualCount));
    }

    @Test
    public void getKittensTestWithoutParameter() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();

        String actual = feline.getFamily();
        String expected = "Кошачьи";

        assertEquals(expected, actual);
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> foodExpected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(foodExpected);

        List<String> foodActual = feline.eatMeat();

        Assert.assertEquals(foodExpected, foodActual);
    }

}
