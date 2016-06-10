package pos.application.ui.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import pos.application.resource.Resources;
import pos.application.ui.button.ItemMenuButton;

@Component
public class ButtonActions {

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

    public EventHandler<ActionEvent> keyPadButtonAction(Button button, final Character ch, final KeyCode code) {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String value = Character.toString(ch);
                KeyEvent keyEvent = new KeyEvent(button, resources.getInputField(), KeyEvent.KEY_TYPED, value, value, code, false, false, false, false);
                resources.getInputField().fireEvent(keyEvent);
            }
        };
    }
}