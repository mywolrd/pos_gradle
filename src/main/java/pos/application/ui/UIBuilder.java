package pos.application.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pos.application.ui.views.builder.KeyPadViewBuilder;
import pos.application.ui.views.builder.OrderViewBuilder;
import pos.application.ui.views.builder.SearchViewBuilder;
import pos.application.ui.views.input.ButtonPadView;
import pos.application.ui.views.input.KeyPadView;
import pos.application.ui.views.order.OrderView;
import pos.application.ui.views.search.SearchView;
import pos.model.application.ItemMenu;

@Component
public class UIBuilder {

    @Autowired
    private OrderViewBuilder orderViewBuilder;

    @Autowired
    private KeyPadViewBuilder keyPadViewBuilder;

    @Autowired
    private SearchViewBuilder searchViewBuilder;

    public OrderView buildOrderView() {
        return this.orderViewBuilder.buildOrderView();
    }

    public <T> SearchView<T> buildSearchView() {
        return searchViewBuilder.buildSearchView();
    }

    public KeyPadView buildKeyPadView() {
        return this.keyPadViewBuilder.buildKeyPadView();
    }

    public ButtonPadView buildItemMenuButtonPadView(List<ItemMenu> itemMenuList) {
        return orderViewBuilder.buildItemMenuButtonPadView(itemMenuList);
    }
}