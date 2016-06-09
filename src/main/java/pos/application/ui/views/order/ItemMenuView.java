package pos.application.ui.views.order;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import pos.application.ui.UIConstants;
import pos.application.ui.UIConstraints;
import pos.application.ui.views.input.ButtonPadView;

public class ItemMenuView extends GridPane {

    private ButtonPadView mainMenuButtonsView;
    private ItemMenuOptionButtonsView menuOptionButtonsView;

    private Pane _rootMenuButtonsView;

    private ButtonPadView _currentMenuButtonsView;
    private ButtonPadView _previousMenuButtonsView;

    private ItemMenuView(ItemMenuViewBuilder builder) {
        super();

        this.mainMenuButtonsView = builder.mainMenuButtonsView;
        this.menuOptionButtonsView = builder.menuOptionButtonsView;

        this._rootMenuButtonsView = new Pane();
        this._rootMenuButtonsView.getChildren().add(this.mainMenuButtonsView);

        this._currentMenuButtonsView = this.mainMenuButtonsView;
        this._previousMenuButtonsView = null;
    }

    public ButtonPadView getMainMenuButtonsView() {
        return this.mainMenuButtonsView;
    }

    public ItemMenuOptionButtonsView getMenuOptionButtonsView() {
        return this.menuOptionButtonsView;
    }

    public void changeMenuButtonsView(ButtonPadView view) {
        _previousMenuButtonsView = _currentMenuButtonsView;

        _rootMenuButtonsView.getChildren().remove(_currentMenuButtonsView);
        _currentMenuButtonsView = view;
        _rootMenuButtonsView.getChildren().add(_currentMenuButtonsView);
    }

    public void showPreviousMenuButtonsView() {
        this.changeMenuButtonsView(this._previousMenuButtonsView);
    }

    private Pane getRootMenuButtonsView() {
        return this._rootMenuButtonsView;
    }

    public static class ItemMenuViewBuilder {
        private ButtonPadView mainMenuButtonsView;
        private ItemMenuOptionButtonsView menuOptionButtonsView;

        public ItemMenuViewBuilder(ButtonPadView mainMenuButtonsView, ItemMenuOptionButtonsView menuOptionButtonsView) {
            this.mainMenuButtonsView = mainMenuButtonsView;
            this.menuOptionButtonsView = menuOptionButtonsView;
        }

        public ItemMenuView build() {
            ItemMenuView view = new ItemMenuView(this);

            view.setHgap(UIConstants.GAP_PANES);
            view.setVgap(UIConstants.GAP_PANES);

            //@formatter:off
            view.getRowConstraints()
                .addAll(UIConstraints.heightConstraint(UIConstraints._55), 
                        UIConstraints.heightConstraint(UIConstraints._45));
            
            view.add(view.getRootMenuButtonsView(), 0, 0);
            view.add(view.getMenuOptionButtonsView(), 0, 1);            
            //@formatter:on
            return view;
        }
    }

}