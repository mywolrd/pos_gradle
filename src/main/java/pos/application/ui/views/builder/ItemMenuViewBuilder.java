package pos.application.ui.views.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pos.application.ui.action.ItemButtonActions;
import pos.application.ui.button.ItemMenuButton;
import pos.application.ui.views.order.ItemMenuButtonsView;
import pos.application.ui.views.order.ItemMenuOptionButtonsView;
import pos.application.ui.views.order.ItemMenuView;
import pos.model.application.ItemMenu;
import pos.service.MenuService;

@Component
public class ItemMenuViewBuilder {

    @Autowired
    private ItemButtonActions itemMenuButtonActions;

    @Autowired
    private MenuService menuService;

    public ItemMenuView buildItemMenuView() {
        return new ItemMenuView.ItemMenuViewBuilder(this.buildMainItemMenuView(), this.buildMenuOptionsButtonsView()).build();
    }

    private ItemMenuButtonsView buildMainItemMenuView() {
        return this.buildItemMenuView(this.menuService.listItemMenuOptions());
    }

    private ItemMenuOptionButtonsView buildMenuOptionsButtonsView() {
        return new ItemMenuOptionButtonsView();
    }

    private ItemMenuButton buildItemMenuButton(ItemMenu itemMenu) {
        ItemMenuButton button = new ItemMenuButton.ItemMenuButtonBuilder(itemMenu).build();
        button.setOnAction(itemMenuButtonActions.menuItemButtonAction(button));
        return button;
    }

    private List<ItemMenuButton> buildItemMenuButtons(List<ItemMenu> itemMenuList) {
        return itemMenuList.stream().map(itemMenu -> this.buildItemMenuButton(itemMenu)).collect(Collectors.toCollection(ArrayList::new));
    }

    public ItemMenuButtonsView buildItemMenuView(List<ItemMenu> itemMenuList) {
        List<ItemMenuButton> itemMenuButtons = this.buildItemMenuButtons(itemMenuList);
        return new ItemMenuButtonsView.ItemMenuPaneBuilder(itemMenuButtons).build();
    }

}