package pos.application.ui.views.order;

import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import pos.application.ui.UIConstants;
import pos.application.ui.UIConstraints;
import pos.model.application.OrderDetails;

public class CurrentOrderView extends GridPane {

    private ListView<OrderDetails> cartView;

    private CurrentOrderView(CurrentOrderViewBuilder builder) {
        super();

        this.cartView = builder.cartView;
    }

    public ListView<OrderDetails> getCartView() {
        return this.cartView;
    }

    public static class CurrentOrderViewBuilder {

        private ListView<OrderDetails> cartView;

        public CurrentOrderViewBuilder(ListView<OrderDetails> cartView) {
            this.cartView = cartView;
        }

        public CurrentOrderView build() {
            CurrentOrderView view = new CurrentOrderView(this);

            view.setHgap(UIConstants.GAP_PANE);
            view.setVgap(UIConstants.GAP_PANE);

            //@formatter:off
            view.getRowConstraints()
                .addAll(UIConstraints.heightConstraint(UIConstraints._35), 
                        UIConstraints.heightConstraint(UIConstraints._65));
            
            view.add(new StackPane(), 0, 0);
            view.add(view.getCartView(), 0, 1);
            //@formatter:on

            return view;
        }
    }
}