package pos.application.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.scene.layout.StackPane;
import pos.application.ui.UIBuilder;
import pos.application.ui.views.order.OrderView;
import pos.model.application.ItemMenu;

/**
 * Initialized at startup, destroyed at close.
 */
@Component
public class Resources {

    // Attach rootPane to the JavaFX Scene and add other panes to this root.
    private StackPane root = new StackPane();
    private OrderView orderView;

    @Autowired
    private POSCart cart;

    @Autowired
    private UIBuilder uiBuilder;

    public void initializeUI() {
        orderView = uiBuilder.buildOrderView();
        this.root.getChildren().add(uiBuilder.buildKeyPadView());
    }

    public StackPane getRootPane() {
        return this.root;
    }

    public POSCart getCart() {
        return this.cart;
    }

    public void changeItemMenuButtonsView(List<ItemMenu> itemMenuList) {
        this.orderView.changeItemMenuButtonsView(this.uiBuilder.buildItemMenuButtonsView(itemMenuList));
    }
}