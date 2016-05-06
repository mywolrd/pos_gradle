package pos.javafx.button;

import javafx.scene.control.Button;

public class CharacterInputButton extends Button {

    private char inputChar;

    private CharacterInputButton(CharacterInputButtonBuilder builder) {
        super();
        this.inputChar = builder.inputChar;
        this.setText(Character.toString(inputChar).toUpperCase());
    }

    public static class CharacterInputButtonBuilder {

        private char inputChar;

        public CharacterInputButtonBuilder(char inputChar) {
            this.inputChar = inputChar;
        }

        public CharacterInputButton build() {
            return new CharacterInputButton(this);
        }
    }

}