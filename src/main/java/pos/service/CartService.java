package pos.service;

import org.springframework.stereotype.Service;

import pos.model.application.Cart;
import pos.model.application.Item;
import pos.model.application.OrderDetails;
import pos.model.application.Price;

@Service
public class CartService {

    // Cart represents order in progress.
    // When a cart is finalized, an order will be placed/saved.

    public void addItem(Cart cart, Item item) {
        OrderDetails itemToAdd = new OrderDetails.OrderDetailsBuilder(item).build();
        cart.getItems().add(itemToAdd);

        // TODO Same item, same price? Add the quantity values.

        // TODO Return new or not? State changed...but it's a simple wrapper.
    }

    public void updateItem() {

    }

    public void updateItemQuantity(Item item, int quantity) {

    }

    public void updateItemPrice(Item item, Price newPrice) {

    }

    public void removeItem(Item item) {

    }

    public boolean hasItem(Cart cart, Item item) {
        boolean hasItem = false;

        for (OrderDetails orderDetail : cart.getItems()) {
            if (orderDetail.getItem().equals(item) && orderDetail.getPrice().equals(item.getPrice())) {
                hasItem = true;
                break;
            }
        }

        return hasItem;
    }
}