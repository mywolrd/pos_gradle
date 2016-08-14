package pos.javafx.application.component.views.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pos.javafx.application.component.button.ButtonActions;
import pos.javafx.application.component.button.ItemMenuButton;
import pos.javafx.application.component.views.input.ButtonsView;
import pos.javafx.application.component.views.order.ItemMenuView;
import pos.model.application.ItemMenu;
import pos.service.MenuService;

@Component
public class ItemMenuViewBuilder {

    @Autowired
    private ButtonActions itemMenuButtonActions;

    @Autowired
    private MenuService menuService;

    public ItemMenuView buildItemMenuView() {
        return new ItemMenuView.ItemMenuViewBuilder(this.buildMainMenuView(), this.buildMenuOptionView()).build();
    }

    private ButtonsView buildMainMenuView() {
        return this.buildMainMenuView(this.menuService.listItemMenuOptions());
    }

    private ButtonsView buildMenuOptionView() {
        return this.buildMainMenuView(this.menuService.listItemMenuOptions());
    }

    private ItemMenuButton buildItemMenuButton(ItemMenu itemMenu) {
        ItemMenuButton button = new ItemMenuButton.ItemMenuButtonBuilder(itemMenu).build();
        button.setOnAction(itemMenuButtonActions.menuItemButtonAction(button));
        return button;
    }

    private List<ItemMenuButton> buildItemMenuButtons(List<ItemMenu> itemMenuList) {
        return itemMenuList.stream().map(itemMenu -> this.buildItemMenuButton(itemMenu)).collect(Collectors.toCollection(ArrayList::new));
    }

    public ButtonsView buildMainMenuView(List<ItemMenu> itemMenuList) {
        List<ItemMenuButton> buttons = this.buildItemMenuButtons(itemMenuList);
        return new ButtonsView.ButtonPadViewBuilder(buttons).build();
    }

}