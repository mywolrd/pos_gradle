package pos.application.ui.views.order;

import javafx.scene.layout.GridPane;
import pos.application.ui.UIConstants;
import pos.application.ui.UIConstraints;
import pos.application.ui.views.input.ButtonPadView;

public class OrderView extends GridPane {

    private CurrentOrderView currentOrderView;
    private ItemMenuView itemMenuView;

    private OrderView(OrderViewBuilder builder) {
        super();

        this.currentOrderView = builder.currentOrderView;
        this.itemMenuView = builder.itemMenuView;
    }

    public ItemMenuView getItemMenuView() {
        return this.itemMenuView;
    }

    public CurrentOrderView getCurrentOrderView() {
        return this.currentOrderView;
    }

    public void changeItemMenuButtonsView(ButtonPadView view) {
        this.itemMenuView.changeMenuButtonsView(view);
    }

    public static class OrderViewBuilder {

        private CurrentOrderView currentOrderView;
        private ItemMenuView itemMenuView;

        public OrderViewBuilder(CurrentOrderView currentOrderView, ItemMenuView itemMenuView) {
            this.currentOrderView = currentOrderView;
            this.itemMenuView = itemMenuView;
        }

        public OrderView build() {
            OrderView view = new OrderView(this);

            view.setHgap(UIConstants.GAP_PANES);
            view.setVgap(UIConstants.GAP_PANES);

            //@formatter:off
            view.getColumnConstraints()
                .addAll(UIConstraints.widthConstraint(UIConstraints._40), 
                        UIConstraints.widthConstraint(UIConstraints._60));
            view.getRowConstraints()
                .add(UIConstraints.heightConstraint(UIConstraints._100));
            
            //TODO Remove.
            view.getItemMenuView().setStyle(UIConstants.STYLE_BLUE);
            view.getCurrentOrderView().setStyle(UIConstants.STYLE_BLACK);
            
            view.add(view.getCurrentOrderView(), 0, 0);
            view.add(view.getItemMenuView(), 1, 0);
            //@formatter:on
            return view;
        }
    }

}