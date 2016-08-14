package pos.javafx.application.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import pos.javafx.application.component.button.ButtonActions;
import pos.javafx.application.component.button.ItemMenuButton;

@Component
public class ButtonManager {

    @Autowired
    private ButtonActions buttonActions;

    public void assignItemMenuButtonAction(ItemMenuButton button) {
        button.setOnAction(buttonActions.menuItemButtonAction(button));
    }

    public void assignKeyboardButtonAction(Button button, Character ch) {
        button.setOnAction(buttonActions.keyboardButtonAction(button, ch, KeyCode.valueOf(Character.toString(ch))));
    }
}