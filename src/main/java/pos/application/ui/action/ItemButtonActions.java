package pos.application.ui.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import pos.application.resource.Resources;
import pos.application.ui.UIElementBuilder;
import pos.application.ui.button.ItemMenuButton;
import pos.application.ui.pane.ItemMenuPane;

@Component
public class ItemButtonActions {

    @Autowired
    private UIElementBuilder uiBuilder;

    @Autowired
    private Resources resources;

    public EventHandler<ActionEvent> menuItemButtonAction(ItemMenuButton button) {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (button.getItemMenu().hasSubmenu()) {
                    List<ItemMenuButton> itemMenuButtons = uiBuilder.buildItemMenuButtonList(button.getItemMenu().getSubmenu());
                    for (ItemMenuButton button : itemMenuButtons)
                        button.setOnAction(menuItemButtonAction(button));

                    ItemMenuPane submenuPane = new ItemMenuPane.ItemMenuPaneBuilder(itemMenuButtons).build();

                    resources.setItemMenuPane(submenuPane);
                } else {
                    resources.getCart().add(button.getItemMenu().getItem());
                }
            }
        };
    }
}