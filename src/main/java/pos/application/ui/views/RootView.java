package pos.application.ui.views;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import pos.application.ui.UIConstants;
import pos.application.ui.UIConstraints;

/**
 * Possible left side views : current order view, search views, new or update customer Right side views :
 * 
 */
public class RootView extends BaseHgrid {

    private StackPane left;
    private StackPane right;

    private RootView(RootViewBuilder builder, double... widths) {
        super(widths);

        this.left = new StackPane();
        this.right = new StackPane();
    }

    public void setRightView(Pane rightView) {
        this.right.getChildren().clear();
        this.right.getChildren().add(rightView);
    }

    public void setLeftView(Pane leftView) {
        this.left.getChildren().clear();
        this.left.getChildren().add(leftView);
    }

    public static class RootViewBuilder {

        public RootViewBuilder() {

        }

        public RootView build() {

            RootView view = new RootView(this, UIConstraints._40, UIConstraints._60);

            view.left.setStyle(UIConstants.STYLE_BLUE);
            view.right.setStyle(UIConstants.STYLE_BLACK);

            view.add(view.left, 0, 0);
            view.add(view.right, 1, 0);

            return view;
        }
    }
}