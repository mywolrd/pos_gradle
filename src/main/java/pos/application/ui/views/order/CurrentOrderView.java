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

            view.setHgap(UIConstants.GAP_PANES);
            view.setVgap(UIConstants.GAP_PANES);

            //@formatter:off
            view.getRowConstraints()
                .addAll(UIConstraints.heightConstraint(UIConstraints._30), 
                        UIConstraints.heightConstraint(UIConstraints._70));
            view.getColumnConstraints()
                .add(UIConstraints.widthConstraint(UIConstraints._100));
            
            GridPane rootCartPane = new GridPane();
            
            rootCartPane.getColumnConstraints().add(UIConstraints.widthConstraint(UIConstraints._100));
            rootCartPane.getRowConstraints().add(UIConstraints.heightConstraint(UIConstraints._100));
            
            // TODO Remove.
            rootCartPane.setStyle(UIConstants.STYLE_BLUE);
            view.getCartView().setStyle(UIConstants.STYLE_BLACK);
            
            rootCartPane.add(view.getCartView(), 0, 0);
            
            view.add(new StackPane(), 0, 0);
            view.add(rootCartPane, 0, 1);
            //@formatter:on

            return view;
        }
    }
}