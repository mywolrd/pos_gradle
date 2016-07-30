package pos.application.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.scene.control.TextField;
import pos.application.ui.views.RootView;
import pos.application.ui.views.builder.ViewBuilder;
import pos.application.ui.views.order.CurrentOrderView;
import pos.application.ui.views.search.SearchView;
import pos.model.application.ItemMenu;
import pos.model.application.Order;

/**
 * Initialized at startup, destroyed at close.
 */
@Component
public class Resources {

    // Attach rootPane to the JavaFX Scene and add other panes to this root.
    private CurrentOrderView orderView;
    private RootView rootView;
    private SearchView<Order> orderSearchView;

    @Autowired
    private POSCart cart;

    @Autowired
    private ViewBuilder viewBuilder;

    public void initializeUI() {
        this.rootView = new RootView.RootViewBuilder().build();

        // Move this to another component
        this.rootView.setLeftView(viewBuilder.buildCurrentOrderView(this.cart));
        this.rootView.setRightView(viewBuilder.buildItemMenuView());
    }

    public TextField getInputField() {
        return this.orderSearchView.getInputField();
    }

    public RootView getRootView() {
        return this.rootView;
    }

    public POSCart getCart() {
        return this.cart;
    }

    public void changeItemMenuButtonsView(List<ItemMenu> itemMenuList) {
    }
}