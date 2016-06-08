package pos.application.ui.views.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pos.application.resource.POSCart;
import pos.application.ui.views.order.CurrentOrderView;

@Component
public class CurrentOrderViewBuilder {

    @Autowired
    private POSCart cart;

    public CurrentOrderView buildCurrentOrderView() {
        return new CurrentOrderView.CurrentOrderViewBuilder(cart.getCartView()).build();
    }
}