import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    void addItem() {
        Cart cart = new Cart(3);
        cart.addItem(10, 3);
        cart.addItem(20, 1);
        cart.addItem(2, 5);
        assertEquals(60, cart.getTotal(), 0.1);
    }

    @Test
    void getTotal() {
        Cart cart = new Cart(3);
        cart.addItem(10, 3);
        cart.addItem(20, 1);
        cart.addItem(2, 5);
        assertEquals(60, cart.getTotal(), 0.1);
    }

    @Test
    void getItems() {
        Cart cart = new Cart(5);
        assertEquals(5, cart.getItems());
    }
}