package pos.javafx.application.ui.views.builder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.scene.layout.Pane;
import pos.javafx.application.resource.POSCart;
import pos.javafx.application.ui.views.RootView;
import pos.javafx.application.ui.views.customer.NewCustomerView.NewCustomerViewBuilder;
import pos.javafx.application.ui.views.order.CartView;
import pos.javafx.application.ui.views.order.CartView.CartViewBuilder;
import pos.javafx.application.ui.views.order.CurrentOrderView.CurrentOrderViewBuilder;
import pos.model.application.ItemMenu;

@Component
public class ViewBuilder {

    @Autowired
    private ItemMenuViewBuilder itemMenuViewBuilder;

    @Autowired
    private KeyboardViewBuilder keyboardViewBuilder;

    public Pane buildCurrentOrderView(POSCart cart) {
        return new CurrentOrderViewBuilder(this.buildCartView(cart)).build();
    }

    public Pane buildRootView() {
        return new RootView.RootViewBuilder().build();
    }

    public Pane buildItemMenuView() {
        return this.itemMenuViewBuilder.buildItemMenuView();
    }

    public Pane buildKeyboardView() {
        return this.keyboardViewBuilder.buildKeyboardView();
    }

    public Pane buildNewCustomerView() {
        return new NewCustomerViewBuilder().build();
    }

    public Pane buildMainMenuView(List<ItemMenu> itemMenuList) {
        return this.itemMenuViewBuilder.buildMainMenuView(itemMenuList);
    }

    private CartView buildCartView(POSCart cart) {
        return new CartViewBuilder(cart.getCartView()).build();
    }

}