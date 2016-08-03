package pos.javafx.application.ui.views;

import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class BaseGrid extends GridPane {

    public BaseGrid() {
        super();
    }

    public boolean hasTextField() {
        boolean hasTextField = false;
        for (Node node : this.getChildren()) {
            if (node instanceof TextField) {
                hasTextField = true;
                break;
            }
        }
        return hasTextField;
    }

    public TextField getCurrentTextField() {
        return null;
    }
}