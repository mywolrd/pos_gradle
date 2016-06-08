package pos.application.ui.views.input;

import com.google.common.primitives.Chars;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import pos.application.ui.UIConstants;

public class NumberPadView extends GridPane {

    private NumberPadView() {
        super();
    }

    public static class NumberPadViewBuilder {

        public NumberPadViewBuilder() {
        }

        public NumberPadView build() {
            NumberPadView view = new NumberPadView();

            view.setVgap(UIConstants.GAP_BUTTONS);
            view.setHgap(UIConstants.GAP_BUTTONS);

            int c = 0;
            int r = 0;
            int buttonsPerRow = 5;

            for (Character number : Chars.asList(UIConstants.NUMBERS)) {
                Button button = new Button();
                button.setText(Character.toString(number));

                view.add(button, c, r);
                c++;
                if (c == buttonsPerRow) {
                    c = 0;
                    r++;
                }
            }
            view.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;" + "-fx-border-insets: 5;" + "-fx-border-radius: 5;"
                    + "-fx-border-color: black;");
            return view;
        }
    }
}