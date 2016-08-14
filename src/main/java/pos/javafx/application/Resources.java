package pos.javafx.application;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.scene.control.TextField;
import pos.javafx.application.component.views.BaseGrid;
import pos.javafx.application.component.views.RootView;
import pos.javafx.application.component.views.builder.ViewBuilder;
import pos.javafx.application.component.views.order.CurrentOrderView;
import pos.javafx.application.component.views.search.SearchView;
import pos.model.application.ItemMenu;
import pos.model.application.Order;

/**
 * Initialized at startup, destroyed at close. I think I need to rename this.
 */
@Component
public class Resources {

    private Logger logger = LogManager.getLogger(this);

    // Attach rootPane to the JavaFX Scene and add other panes to this root.
    private CurrentOrderView orderView;
    private RootView rootView;
    private SearchView<Order> orderSearchView;
    private BaseGrid leftView;
    private BaseGrid rightView;

    @Autowired
    private POSCart cart;

    @Autowired
    private ViewBuilder viewBuilder;

    public void initializeUI() {
        this.rootView = new RootView.RootViewBuilder().build();

        // Move this to another component
        this.rootView.setLeftView(viewBuilder.buildNewCustomerView());
        this.rootView.setRightView(viewBuilder.buildKeyboardView());
    }

    public TextField getCurrentInputField() {
        if (null != this.leftView) {
            if (this.leftView.hasTextField()) {
                return this.leftView.getCurrentTextField();
            }
        }
        return null;
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