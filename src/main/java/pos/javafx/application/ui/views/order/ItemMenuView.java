package pos.javafx.application.ui.views.order;

import javafx.scene.layout.StackPane;
import pos.javafx.application.ui.UIConstants;
import pos.javafx.application.ui.views.BaseVgrid;
import pos.javafx.application.ui.views.input.ButtonsView;

public class ItemMenuView extends BaseVgrid {

    private ButtonsView mainMenuView;
    private ButtonsView menuOptionView;

    private StackPane _rootButtonsView = new StackPane();

    private ButtonsView _currentMainMenuView;
    private ButtonsView _previousMainMenuView;
    private ButtonsView _startingMainMenuView;
    private ButtonsView _startingMenuOptionView;

    private ItemMenuView(ItemMenuViewBuilder builder, double... heights) {
        super(heights);

        this.mainMenuView = builder.mainMenuView;
        this.menuOptionView = builder.menuOptionView;

        this._rootButtonsView.getChildren().add(this.mainMenuView);

        this._currentMainMenuView = this.mainMenuView;
        this._previousMainMenuView = null;

        this._startingMainMenuView = builder.mainMenuView;
        this._startingMenuOptionView = builder.menuOptionView;
    }

    public ButtonsView getMainButtonsView() {
        return this.mainMenuView;
    }

    public ButtonsView getSideButtonsView() {
        return this.menuOptionView;
    }

    public void changeMainMenuView(ButtonsView view) {
        _previousMainMenuView = _currentMainMenuView;
        _currentMainMenuView = view;

        _rootButtonsView.getChildren().clear();
        _rootButtonsView.getChildren().add(_currentMainMenuView);
    }

    public void reset() {
        _previousMainMenuView = null;
        _currentMainMenuView = _startingMainMenuView;

        _rootButtonsView.getChildren().clear();
        _rootButtonsView.getChildren().add(_startingMainMenuView);
    }

    public void showPreviousMainMenuView() {
        this.changeMainMenuView(this._previousMainMenuView);
    }

    public static class ItemMenuViewBuilder {
        private ButtonsView mainMenuView;
        private ButtonsView menuOptionView;

        public ItemMenuViewBuilder(ButtonsView mainMenuView, ButtonsView menuOptionView) {
            this.mainMenuView = mainMenuView;
            this.menuOptionView = menuOptionView;
        }

        public ItemMenuView build() {
            ItemMenuView view = new ItemMenuView(this, UIConstants._55, UIConstants._45);

            view.add(view._rootButtonsView, 0, 0);
            view.add(view.menuOptionView, 0, 1);

            return view;
        }
    }

}