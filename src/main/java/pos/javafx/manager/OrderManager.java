package pos.javafx.manager;
// TODO Change package name later?

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pos.model.application.Cart;
import pos.model.application.Item;
import pos.service.CartService;

@Component
public class OrderManager {

    @Autowired
    private Cart cart;
    // Single cart for POS.

    @Autowired
    private CartService cartService;

    public Cart getCart() {
        return this.cart;
    }

    public void addItemToCart(Item item) {
        cartService.addItem(this.cart, item);
    }

}