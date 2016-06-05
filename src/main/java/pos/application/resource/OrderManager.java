package pos.application.resource;
// TODO Change package name later?

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pos.model.application.Cart;
import pos.model.application.Item;
import pos.service.CartService;

@Component
public class OrderManager {

    @Autowired
    private CartService cartService;

    private Cart cart = new Cart.CartBuilder().build();

    public void addItemToCart(Item item) {
    }

}