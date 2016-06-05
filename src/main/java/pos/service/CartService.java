package pos.service;

import org.springframework.stereotype.Service;

import pos.model.application.Cart;
import pos.model.application.Item;
import pos.model.application.Price;

/**
 * Not sure what to do with this. TODO CartDao should connect to mongoDB and save a cart.
 */

@Service
public class CartService {

    // Cart represents order in progress.
    // When a cart is finalized, an order will be placed/saved.

    public void addItem(Cart cart, Item item) {

    }

    public void updateItem() {

    }

    public void updateItemQuantity(Item item, int quantity) {

    }

    public void updateItemPrice(Item item, Price newPrice) {

    }

    public void removeItem(Item item) {

    }
}