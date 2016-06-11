package pos.application.ui.views.order;

import javafx.scene.layout.GridPane;
import pos.application.ui.UIConstants;
import pos.application.ui.UIConstraints;
import pos.application.ui.views.BaseHgrid;
import pos.application.ui.views.input.ButtonPadView;

public class OrderView extends BaseHgrid {

    private GridPane currentOrderView;
    private ItemMenuView itemMenuView;

    private OrderView(OrderViewBuilder builder, double... widths) {
        super(widths);

        this.currentOrderView = builder.currentOrderView;
        this.itemMenuView = builder.itemMenuView;
    }

    public ItemMenuView getItemMenuView() {
        return this.itemMenuView;
    }

    public GridPane getCurrentOrderView() {
        return this.currentOrderView;
    }

    public void changeItemMenuButtonsView(ButtonPadView view) {
        this.itemMenuView.changeMenuButtonsView(view);
    }

    public static class OrderViewBuilder {

        private GridPane currentOrderView;
        private ItemMenuView itemMenuView;

        public OrderViewBuilder(GridPane currentOrderView, ItemMenuView itemMenuView) {
            this.currentOrderView = currentOrderView;
            this.itemMenuView = itemMenuView;
        }

        public OrderView build() {
            OrderView view = new OrderView(this, UIConstraints._40, UIConstraints._60);

            // TODO Remove.
            view.getItemMenuView().setStyle(UIConstants.STYLE_BLUE);
            view.getCurrentOrderView().setStyle(UIConstants.STYLE_BLACK);

            view.add(view.getCurrentOrderView(), 0, 0);
            view.add(view.getItemMenuView(), 1, 0);
            //@formatter:on
            return view;
        }
    }

}