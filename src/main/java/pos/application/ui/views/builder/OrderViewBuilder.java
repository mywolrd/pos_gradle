package pos.application.ui.views.builder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pos.application.ui.views.order.CurrentOrderView;
import pos.application.ui.views.order.ItemMenuButtonsView;
import pos.application.ui.views.order.OrderView;
import pos.model.application.ItemMenu;

@Component
public class OrderViewBuilder {

    @Autowired
    private ItemMenuViewBuilder itemMenuViewBuilder;

    public OrderView buildOrderView() {
        return new OrderView.OrderViewBuilder(new CurrentOrderView(), itemMenuViewBuilder.buildItemMenuView()).build();
    }

    public ItemMenuButtonsView buildItemMenuButtonsView(List<ItemMenu> itemMenuList) {
        return this.itemMenuViewBuilder.buildItemMenuView(itemMenuList);
    }
}