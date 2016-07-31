package pos.javafx.application.ui.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import pos.javafx.application.ui.button.ItemMenuButton;

@Component
public class ButtonActionManager {

    @Autowired
    private ButtonActions buttonActions;

    public void assignItemMenuButtonAction(ItemMenuButton button) {
        button.setOnAction(buttonActions.menuItemButtonAction(button));
    }

    public void assignKeyPadButtonAction(Button button, Character ch) {
        button.setOnAction(buttonActions.keyPadButtonAction(button, ch, KeyCode.valueOf(Character.toString(ch))));
    }
}