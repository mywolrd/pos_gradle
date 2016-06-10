package pos.application.ui.views.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pos.application.resource.Resources;
import pos.application.ui.views.order.CurrentOrderView;

@Component
public class CurrentOrderViewBuilder {

    @Autowired
    private Resources resources;

    public CurrentOrderView buildCurrentOrderView() {
        return new CurrentOrderView.CurrentOrderViewBuilder(resources.getCart().getCartView()).build();
    }
}