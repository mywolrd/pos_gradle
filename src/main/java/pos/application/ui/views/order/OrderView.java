package pos.application.ui.views.order;

import javafx.scene.layout.GridPane;
import pos.application.ui.UIConstants;
import pos.application.ui.UIConstraints;

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

    public void changeItemMenuButtonsView(ItemMenuButtonsView view) {
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

            view.setHgap(UIConstants.GAP_PANE);
            view.setVgap(UIConstants.GAP_PANE);

            //@formatter:off
            view.getColumnConstraints()
                .addAll(UIConstraints.widthConstraint(UIConstraints._45), 
                        UIConstraints.widthConstraint(UIConstraints._55));
            
            view.getItemMenuView().setStyle("-fx-padding: 10;" + 
                      "-fx-border-style: solid inside;" + 
                      "-fx-border-width: 2;" +
                      "-fx-border-insets: 5;" + 
                      "-fx-border-radius: 5;" + 
                      "-fx-border-color: blue;");
            
            view.getCurrentOrderView().setStyle("-fx-padding: 10;" + 
                      "-fx-border-style: solid inside;" + 
                      "-fx-border-width: 2;" +
                      "-fx-border-insets: 5;" + 
                      "-fx-border-radius: 5;" + 
                      "-fx-border-color: black;");
            
            view.add(view.getCurrentOrderView(), 0, 0);
            view.add(view.getItemMenuView(), 1, 0);
            //@formatter:on
            return view;
        }
    }

}