package pos.application.ui.views.input;

import java.util.stream.IntStream;

import com.google.common.primitives.Chars;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import pos.application.ui.UIConstants;
import pos.application.ui.UIConstraints;

public class LetterPadView extends GridPane {

    private LetterPadView() {
        super();
    }

    public static class LetterPadViewBuilder {

        public LetterPadViewBuilder() {
        }

        public LetterPadView build() {
            LetterPadView view = new LetterPadView();

            view.setVgap(UIConstants.GAP_BUTTONS);
            view.setHgap(UIConstants.GAP_BUTTONS);

            int c = 0;
            int r = 0;
            int buttonsPerRow = 5;

            for (Character letter : Chars.asList(UIConstants.ALPHABETS)) {
                Button button = new Button();
                button.setText(Character.toString(letter));
                StackPane stack = new StackPane();
                stack.getChildren().add(button);
                stack.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;" + "-fx-border-insets: 5;" + "-fx-border-radius: 5;"
                        + "-fx-border-color: blue;");
                view.add(stack, c, r);
                c++;
                if (c == buttonsPerRow) {
                    c = 0;
                    r++;
                }
            }
            double perc = 100f / (r + 1);
            IntStream.range(0, buttonsPerRow).forEach(num -> view.getColumnConstraints().add(UIConstraints.widthConstraint(UIConstraints._20)));
            IntStream.range(0, r + 1).forEach(num -> view.getRowConstraints().add(UIConstraints.heightConstraint(perc)));
            view.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;" + "-fx-border-insets: 5;" + "-fx-border-radius: 5;"
                    + "-fx-border-color: black;");
            return view;
        }
    }
}