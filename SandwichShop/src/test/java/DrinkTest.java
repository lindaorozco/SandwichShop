import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DrinkTest {

    @Test
    public void getPriceTestLargeDrink(){
        Drink drink = new Drink("L", "Cola");
        assertEquals(3.00,drink.getPrice());
    }
    @Test
    public void getPriceTestSmallDrink(){
        Drink drink = new Drink("S", "Cola");
        assertEquals(2.00,drink.getPrice());
    }
}
