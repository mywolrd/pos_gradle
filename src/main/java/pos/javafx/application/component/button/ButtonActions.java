package pos.javafx.application.component.button;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import pos.javafx.application.Resources;

@Component
public class ButtonActions {

    // Need to replace this with something else.
    @Autowired
    private Resources resources;

    @Autowired
    private ViewManager viewManager;

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

    public EventHandler<ActionEvent> keyboardButtonAction(Button button, final Character ch, final KeyCode code) {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String value = Character.toString(ch);

                TextField inputField = resources.getCurrentInputField();
                if (null != inputField) {
                    inputField.positionCaret(inputField.getText().length());

                    KeyEvent keyEvent = new KeyEvent(button, inputField, KeyEvent.KEY_TYPED, value, value, code, false, false, false, false);
                    inputField.fireEvent(keyEvent);
                }
            }
        };
    }
}