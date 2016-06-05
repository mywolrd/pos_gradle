package pos.application.resource;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import pos.model.application.Item;
import pos.model.application.OrderDetails;
import pos.model.application.Price;

/**
 * Cart used to build an order on POS platform.
 */
@Component
public class POSCart {

    private List<OrderDetails> items = new LinkedList<>();

    private ObservableList<OrderDetails> _items = FXCollections.observableList(new LinkedList<OrderDetails>());

    public void add(Item item) {
        if (this.hasItem(item)) {
            int index = this.indexAt(item);
            OrderDetails cartItem = this._items.get(index);

            int updateQuantity = cartItem.getQuantity() + 1; // TODO Defaults to 1 now. Change it to an input later.
            OrderDetails updatedItem = new OrderDetails.OrderDetailsBuilder(item).quantity(updateQuantity).newPrice(cartItem.getPrice()).build();

            this._items.set(index, updatedItem);
        } else {
            this._items.add(new OrderDetails.OrderDetailsBuilder(item).build());
        }
    }

    public void remove(Item item) {
        if (this.hasItem(item)) {
            int index = this.indexAt(item);
            this._items.remove(index);
        }
    }

    public void update(Item item) {

    }

    public void updateQuantity(Item item, int quantity) {
        if (this.hasItem(item)) {
            int index = this.indexAt(item);
            OrderDetails cartItem = this._items.get(index);

            OrderDetails updatedItem = new OrderDetails.OrderDetailsBuilder(item).quantity(quantity).newPrice(cartItem.getPrice()).build();
            this._items.set(index, updatedItem);
        }
    }

    public void updatePrice(Item item, Price newPrice) {
        if (this.hasItem(item)) {
            int index = this.indexAt(item);
            OrderDetails cartItem = this._items.get(index);

            OrderDetails updatedItem = new OrderDetails.OrderDetailsBuilder(item).newPrice(newPrice).quantity(cartItem.getQuantity()).build();
            this._items.set(index, updatedItem);
        }
    }

    public void clear() {
        this._items.clear();
    }

    public List<OrderDetails> getItems() {
        return this._items;
    }

    public boolean hasItem(Item item) {
        return this.indexAt(item) != -1;
    }

    public int indexAt(Item item) {
        int index = -1;

        for (int i = 0; i < this._items.size(); i++) {
            OrderDetails cartItem = this._items.get(i);
            if (cartItem.getItem().equals(item) && cartItem.getPrice().equals(item.getPrice())) {
                index = i;
                break;
            }
        }

        return index;
    }

    public ListView<OrderDetails> getCartView() {
        ObservableList<OrderDetails> observableItems = FXCollections.observableList(this.items);
        return new ListView<>(observableItems);
    }
}