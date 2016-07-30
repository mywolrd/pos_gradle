package pos.application.ui.views.order;

import pos.application.ui.UIConstraints;
import pos.application.ui.views.BaseVgrid;

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
            CurrentOrderView view = new CurrentOrderView(this, UIConstraints._30, UIConstraints._70);

            view.add(view.cartView, 0, 1);
            //@formatter:on
            return view;
        }
    }

}