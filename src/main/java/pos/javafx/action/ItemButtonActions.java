package pos.javafx.action;

import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import pos.javafx.button.ItemMenuButton;

@Component
public class ItemButtonActions {

    EventHandler<ActionEvent> menuItemButtonAction(ItemMenuButton button) {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (button.getItemMenu().hasSubmenu()) {
                    // Build menu pane
                    //
                    //
                } else {
                    // Add this item to the current item queue.? What am I going to use?
                    //
                }
            }
        };
    }
}