package pos.javafx.application.ui.views.order;

import pos.javafx.application.ui.UIConstants;
import pos.javafx.application.ui.views.BaseVgrid;

public class CurrentOrderView extends BaseVgrid {

    private CartView cartView;

    private CurrentOrderView(CurrentOrderViewBuilder builder, double... widths) {
        super(widths);

        this.cartView = builder.cartView;
    }

    public static class CurrentOrderViewBuilder {

        private CartView cartView;

        public CurrentOrderViewBuilder(CartView cartView) {
            this.cartView = cartView;
        }

        public CurrentOrderView build() {
            CurrentOrderView view = new CurrentOrderView(this, UIConstants._30, UIConstants._70);

            view.add(view.cartView, 0, 1);
            //@formatter:on
            return view;
        }
    }

}