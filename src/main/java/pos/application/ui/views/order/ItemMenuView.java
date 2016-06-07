package pos.application.ui.views.order;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import pos.application.ui.UIConstants;
import pos.application.ui.UIConstraints;

public class ItemMenuView extends GridPane {

    private ItemMenuButtonsView mainMenuButtonsView;
    private ItemMenuOptionButtonsView menuOptionButtonsView;

    private Pane _rootMenuButtonsView;

    private ItemMenuButtonsView _currentMenuButtonsView;
    private ItemMenuButtonsView _previousMenuButtonsView;

    private ItemMenuView(ItemMenuViewBuilder builder) {
        super();

        this.mainMenuButtonsView = builder.mainMenuButtonsView;
        this.menuOptionButtonsView = builder.menuOptionButtonsView;

        this._rootMenuButtonsView = new Pane();
        this._rootMenuButtonsView.getChildren().add(this.mainMenuButtonsView);

        this._currentMenuButtonsView = this.mainMenuButtonsView;
        this._previousMenuButtonsView = null;
    }

    public ItemMenuButtonsView getMainMenuButtonsView() {
        return this.mainMenuButtonsView;
    }

    public ItemMenuOptionButtonsView getMenuOptionButtonsView() {
        return this.menuOptionButtonsView;
    }

    public void changeMenuButtonsView(ItemMenuButtonsView view) {
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
        private ItemMenuButtonsView mainMenuButtonsView;
        private ItemMenuOptionButtonsView menuOptionButtonsView;

        public ItemMenuViewBuilder(ItemMenuButtonsView mainMenuButtonsView, ItemMenuOptionButtonsView menuOptionButtonsView) {
            this.mainMenuButtonsView = mainMenuButtonsView;
            this.menuOptionButtonsView = menuOptionButtonsView;
        }

        public ItemMenuView build() {
            ItemMenuView view = new ItemMenuView(this);

            view.setHgap(UIConstants.GAP_PANE);
            view.setVgap(UIConstants.GAP_PANE);

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