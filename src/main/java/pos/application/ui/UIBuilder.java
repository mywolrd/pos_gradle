package pos.application.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pos.application.ui.action.ItemButtonActions;
import pos.application.ui.button.ItemMenuButton;
import pos.application.ui.pane.ItemMenuPane;
import pos.model.application.ItemMenu;
import pos.service.MenuService;

@Component
public class UIBuilder {

    @Autowired
    private MenuService menuService;

    @Autowired
    private ItemButtonActions itemMenuButtonActions;

    public List<ItemMenuButton> listItemMenuButtons() {
        return this.buildItemMenuButtons(menuService.listItemMenuOptions());
    }

    public ItemMenuButton buildItemMenuButton(ItemMenu itemMenu) {
        ItemMenuButton button = new ItemMenuButton.ItemMenuButtonBuilder(itemMenu).build();
        button.setOnAction(itemMenuButtonActions.menuItemButtonAction(button));
        return button;
    }

    public List<ItemMenuButton> buildItemMenuButtons(List<ItemMenu> itemMenuList) {
        return itemMenuList.stream().map(itemMenu -> this.buildItemMenuButton(itemMenu)).collect(Collectors.toCollection(ArrayList::new));
    }

    public ItemMenuPane buildItemMenuPane(List<ItemMenu> itemMenuList) {
        List<ItemMenuButton> itemMenuButtons = this.buildItemMenuButtons(itemMenuList);
        return new ItemMenuPane.ItemMenuPaneBuilder(itemMenuButtons).build();
    }
}