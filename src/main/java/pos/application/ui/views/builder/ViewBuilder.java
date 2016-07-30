package pos.application.ui.views.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.scene.layout.Pane;
import pos.application.resource.POSCart;
import pos.application.ui.views.order.CartView;
import pos.application.ui.views.order.CartView.CartViewBuilder;
import pos.application.ui.views.order.CurrentOrderView.CurrentOrderViewBuilder;

@Component
public class ViewBuilder {

    @Autowired
    private ItemMenuViewBuilder itemMenuViewBuilder;

    @Autowired
    private KeyboardViewBuilder keyboardViewBuilder;

    public Pane buildCurrentOrderView(POSCart cart) {
        return new CurrentOrderViewBuilder(this.buildCartView(cart)).build();
    }

    public Pane buildItemMenuView() {
        return this.itemMenuViewBuilder.buildItemMenuView();
    }

    public Pane buildKeyboardView() {
        return this.keyboardViewBuilder.buildKeyboardView();
    }

    private CartView buildCartView(POSCart cart) {
        return new CartViewBuilder(cart.getCartView()).build();
    }

}