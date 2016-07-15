package pos.application.ui.views.order;

import javafx.scene.layout.StackPane;
import pos.application.ui.UIConstants;
import pos.application.ui.UIConstraints;
import pos.application.ui.views.BaseVgrid;
import pos.application.ui.views.input.ButtonPadView;

public class ItemMenuView extends BaseVgrid {

    private ButtonPadView mainButtonPadView;
    private ButtonPadView sideButtonPadView;

    private StackPane _rootButtonPadView;

    private ButtonPadView _currentButtonPadView;
    private ButtonPadView _previousButtonPadView;

    private ItemMenuView(ItemMenuViewBuilder builder, double... heights) {
        super(heights);

        this.mainButtonPadView = builder.mainButtonPadView;
        this.mainButtonPadView.setStyle(UIConstants.STYLE_BLACK);
        this.sideButtonPadView = builder.sideButtonPadView;
        this.sideButtonPadView.setStyle(UIConstants.STYLE_BLACK);

        this._rootButtonPadView = new StackPane();
        this._rootButtonPadView.getChildren().add(this.mainButtonPadView);
        this._rootButtonPadView.setStyle(UIConstants.STYLE_BLUE);

        this._currentButtonPadView = this.mainButtonPadView;
        this._previousButtonPadView = null;
    }

    public ButtonPadView getMainButtonPadView() {
        return this.mainButtonPadView;
    }

    public ButtonPadView getSideButtonPadView() {
        return this.sideButtonPadView;
    }

    public void changeMenuButtonsView(ButtonPadView view) {
        _previousButtonPadView = _currentButtonPadView;

        _rootButtonPadView.getChildren().remove(_currentButtonPadView);

        _currentButtonPadView = view;
        _rootButtonPadView.getChildren().add(_currentButtonPadView);
    }

    public void showPreviousButtonPadView() {
        this.changeMenuButtonsView(this._previousButtonPadView);
    }

    private StackPane getRootButtonPadView() {
        return this._rootButtonPadView;
    }

    public static class ItemMenuViewBuilder {
        private ButtonPadView mainButtonPadView;
        private ButtonPadView sideButtonPadView;

        public ItemMenuViewBuilder(ButtonPadView mainButtonPadView, ButtonPadView sideButtonPadView) {
            this.mainButtonPadView = mainButtonPadView;
            this.sideButtonPadView = sideButtonPadView;
        }

        public ItemMenuView build() {
            ItemMenuView view = new ItemMenuView(this, UIConstraints._55, UIConstraints._45);

            view.add(view.getRootButtonPadView(), 0, 0);
            view.add(view.getSideButtonPadView(), 0, 1);

            return view;
        }
    }

}