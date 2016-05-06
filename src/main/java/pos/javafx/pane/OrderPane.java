package pos.javafx.pane;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class OrderPane extends GridPane {

    private Pane itemMenuPane;

    private OrderPane(OrderPaneBuilder builder) {
        this.itemMenuPane = builder.itemMenuPane;
    }

    public Pane getItemMenuPane() {
        return this.itemMenuPane;
    }

    public static class OrderPaneBuilder {
        private Pane itemMenuPane;

        public OrderPaneBuilder itemMenuPane(ItemMenuPane itemMenuPane) {
            this.itemMenuPane = itemMenuPane;
            return this;
        }

        public OrderPane build() {
            OrderPane pane = new OrderPane(this);
            pane.add(pane.getItemMenuPane(), 1, 0, 5, 4);
            return pane;
        }
    }

}