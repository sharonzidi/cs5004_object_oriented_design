import org.junit.Before;
import org.junit.Test;
import sun.security.krb5.internal.crypto.Aes128;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FoodOrderingSystemTest {

    @Test
    public void all_kind() {
        FoodOrderingSystem fos = new FoodOrderingSystem();
        fos.addFood(new Meat("beef", 10.0, 500, 20201212, 20210101));
        fos.addFood(new Fruit("apple", 10.0, 500, 20201212, 20210101));
        fos.addFood(new Vegatable("tomato", 10.0, 500, 20201212, 20210101));
        fos.addFood(new Rice("brown rice", 10.0, 500));
        fos.addFood(new Pasta("Italian Pasta", 10.0, 500));
        List<IFood> list = fos.getFoodList();
        assertEquals(5, list.size());
        assertEquals("beef", list.get(0).getName());
        assertEquals("apple", list.get(1).getName());
        assertEquals("tomato", list.get(2).getName());
        assertEquals("brown rice", list.get(3).getName());
        assertEquals("Italian Pasta", list.get(4).getName());

        for (int i = 0; i < 5; i++) {
            assertEquals(10.0, list.get(0).getCurrentPricePerUnit(), 0.0001);
            assertEquals(500, list.get(0).getCurrentlyAvailableQuantity().intValue());
            if (i < 3) {
                assertEquals(20201212, ((PerishableFood) list.get(0)).getOrderDate().intValue());
                assertEquals(20210101, ((PerishableFood) list.get(0)).getExpirationDate().intValue());
            }
        }
    }
}