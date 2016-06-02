package pos.model.application;

import java.util.LinkedList;
import java.util.List;

public class Cart {

    // TODO LATE: customerId
    // TODO LATE: storeClerkId

    private List<OrderDetails> items;

    private Cart(CartBuilder builder) {
        this.items = builder.items;
    }

    public List<OrderDetails> getItems() {
        return this.items;
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    public static class CartBuilder {

        private List<OrderDetails> items = new LinkedList<>();

        public CartBuilder() {
        }

        public CartBuilder(List<OrderDetails> items) {
            this.items.addAll(items);
        }

        public CartBuilder(Cart cart) {
            this.items.addAll(cart.items);
        }

        public Cart build() {
            return new Cart(this);
        }
    }
}