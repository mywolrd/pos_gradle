package pos.application.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import pos.application.ui.UIBuilder;
import pos.application.ui.views.order.OrderView;
import pos.application.ui.views.search.SearchView;
import pos.model.application.ItemMenu;
import pos.model.application.Order;

/**
 * Initialized at startup, destroyed at close.
 */
@Component
public class Resources {

    // Attach rootPane to the JavaFX Scene and add other panes to this root.
    private StackPane root = new StackPane();
    private OrderView orderView;
    private SearchView<Order> orderSearchView;

    @Autowired
    private POSCart cart;

    @Autowired
    private UIBuilder uiBuilder;

    public void initializeUI() {
        orderView = uiBuilder.buildOrderView();
        orderSearchView = uiBuilder.buildSearchView();
        this.root.getChildren().add(orderSearchView);
    }

    public TextField getInputField() {
        return this.orderSearchView.getInputField();
    }

    public StackPane getRootPane() {
        return this.root;
    }

    public POSCart getCart() {
        return this.cart;
    }

    public void changeItemMenuButtonsView(List<ItemMenu> itemMenuList) {
        this.orderView.changeItemMenuButtonsView(this.uiBuilder.buildItemMenuButtonPadView(itemMenuList));
    }
}