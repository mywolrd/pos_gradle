package pos.application.ui.views.builder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import pos.application.resource.POSCart;
import pos.application.ui.UIConstraints;
import pos.application.ui.views.BaseVgrid;
import pos.application.ui.views.input.ButtonPadView;
import pos.application.ui.views.order.OrderView;
import pos.model.application.ItemMenu;

@Component
public class OrderViewBuilder {

    @Autowired
    private ItemMenuViewBuilder itemMenuViewBuilder;

    public OrderView buildOrderView(POSCart cart) {
        return new OrderView.OrderViewBuilder(this.buildCurrentOrderView(this.placeItOnStackPane(cart.getCartView())), itemMenuViewBuilder.buildItemMenuView()).build();
    }

    public GridPane buildCurrentOrderView(StackPane cartView) {
        BaseVgrid view = new BaseVgrid(UIConstraints._30, UIConstraints._70);
        view.add(new StackPane(), 0, 0);
        view.add(cartView, 0, 1);
        return view;
    }

    public StackPane placeItOnStackPane(Node node) {
        StackPane view = new StackPane();
        view.getChildren().add(node);
        return view;
    }

    public ButtonPadView buildItemMenuButtonPadView(List<ItemMenu> itemMenuList) {
        return this.itemMenuViewBuilder.buildItemMenuButtonPadView(itemMenuList);
    }
}