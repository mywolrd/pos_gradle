package pos.application.ui.views.builder;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.primitives.Chars;

import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import pos.application.ui.UIConstants;
import pos.application.ui.action.ButtonActions;
import pos.application.ui.views.input.ButtonPadView;
import pos.application.ui.views.input.KeyPadView;

@Component
public class KeyPadViewBuilder {

    @Autowired
    private ButtonActions buttonActions;

    public KeyPadView buildKeyPadView() {
        ButtonPadView lView = buildLetterPadView();
        ButtonPadView nView = buildNumberPadView();
        return new KeyPadView.KeyPadViewBuilder(lView, nView).build();
    }

    private ButtonPadView buildLetterPadView() {
        return new ButtonPadView.ButtonPadViewBuilder(buildButtons(UIConstants.ALPHABETS)).build();
    }

    private ButtonPadView buildNumberPadView() {
        return new ButtonPadView.ButtonPadViewBuilder(buildButtons(UIConstants.NUMBERS)).build();
    }

    private List<Button> buildButtons(char[] chars) {
        List<Button> buttons = new LinkedList<>();

        for (Character c : Chars.asList(chars)) {
            KeyCode keyCode = Character.isDigit(c) ? KeyCode.valueOf("DIGIT" + c) : KeyCode.valueOf(Character.toString(c));

            Button button = new Button();
            button.setText(Character.toString(c));
            button.setOnAction(buttonActions.keyPadButtonAction(button, c, keyCode));
            buttons.add(button);
        }

        return buttons;
    }
}