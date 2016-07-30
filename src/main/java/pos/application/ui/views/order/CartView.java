package pos.application.ui.views.order;

import javafx.scene.control.ListView;
import pos.application.ui.UIConstraints;
import pos.application.ui.views.BaseVgrid;
import pos.model.application.OrderDetails;

public class CartView extends BaseVgrid {

    private ListView<OrderDetails> cartView;

    private CartView(CartViewBuilder builder, double... widths) {

        super(widths);

        this.cartView = builder.cartView;
    }

    public static class CartViewBuilder {

        ListView<OrderDetails> cartView;

        public CartViewBuilder(ListView<OrderDetails> cartView) {
            this.cartView = cartView;
        }

        public CartView build() {

            CartView view = new CartView(this, UIConstraints._90, UIConstraints._10);

            view.add(view.cartView, 0, 0);
            return view;
        }
    }
}
