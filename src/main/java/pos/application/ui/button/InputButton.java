package pos.application.ui.button;

import javafx.scene.control.Button;

public class InputButton extends Button {

    private char inputChar;

    private InputButton(InputButtonBuilder builder) {
        super();
        this.inputChar = builder.inputChar;
        this.setText(Character.toString(inputChar).toUpperCase());
    }

    public static class InputButtonBuilder {

        private char inputChar;

        public InputButtonBuilder(char inputChar) {
            this.inputChar = inputChar;
        }

        public InputButton build() {
            return new InputButton(this);
        }
    }

}