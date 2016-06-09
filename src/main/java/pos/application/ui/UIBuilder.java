package pos.application.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pos.application.ui.views.builder.KeyPadViewBuilder;
import pos.application.ui.views.builder.OrderViewBuilder;
import pos.application.ui.views.input.ButtonPadView;
import pos.application.ui.views.input.KeyPadView;
import pos.application.ui.views.order.OrderView;
import pos.model.application.ItemMenu;

@Component
public class UIBuilder {

    @Autowired
    private OrderViewBuilder orderViewBuilder;

    @Autowired
    private KeyPadViewBuilder keyPadViewBuilder;

    public OrderView buildOrderView() {
        return this.orderViewBuilder.buildOrderView();
    }

    public KeyPadView buildKeyPadView() {
        return this.keyPadViewBuilder.buildKeyPadView();
    }

    public ButtonPadView buildItemMenuButtonPadView(List<ItemMenu> itemMenuList) {
        System.out.println(itemMenuList.size());
        return orderViewBuilder.buildItemMenuButtonPadView(itemMenuList);
    }
}