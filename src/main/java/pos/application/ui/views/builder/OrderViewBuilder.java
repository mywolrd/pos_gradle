package pos.application.ui.views.builder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pos.application.ui.views.input.ButtonPadView;
import pos.application.ui.views.order.OrderView;
import pos.model.application.ItemMenu;

@Component
public class OrderViewBuilder {

    @Autowired
    private ItemMenuViewBuilder itemMenuViewBuilder;

    @Autowired
    private CurrentOrderViewBuilder currentOrderViewBuilder;

    public OrderView buildOrderView() {
        return new OrderView.OrderViewBuilder(currentOrderViewBuilder.buildCurrentOrderView(), itemMenuViewBuilder.buildItemMenuView()).build();
    }

    public ButtonPadView buildItemMenuButtonPadView(List<ItemMenu> itemMenuList) {
        return this.itemMenuViewBuilder.buildItemMenuButtonPadView(itemMenuList);
    }
}