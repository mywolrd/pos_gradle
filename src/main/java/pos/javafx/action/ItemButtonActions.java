package pos.javafx.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import pos.javafx.button.ItemMenuButton;
import pos.javafx.manager.OrderManager;

@Component
public class ItemButtonActions {

    @Autowired
    private OrderManager orderManager;

    EventHandler<ActionEvent> menuItemButtonAction(ItemMenuButton button) {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (button.getItemMenu().hasSubmenu()) {
                    // Build menu pane
                    //
                    //
                } else {
                    orderManager.addItemToCart(button.getItemMenu().getItem());
                }
            }
        };
    }
}