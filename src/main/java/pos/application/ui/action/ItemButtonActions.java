package pos.application.ui.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import pos.application.resource.Resources;
import pos.application.ui.button.ItemMenuButton;

@Component
public class ItemButtonActions {

    @Autowired
    private Resources resources;

    public EventHandler<ActionEvent> menuItemButtonAction(ItemMenuButton button) {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (button.getItemMenu().hasSubmenu()) {
                    resources.changeItemMenuButtonsView(button.getItemMenu().getSubmenu());
                } else {
                    resources.getCart().add(button.getItemMenu().getItem());
                }
            }
        };
    }
}