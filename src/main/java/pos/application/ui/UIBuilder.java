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
        List<ItemMenuButton> buttons = this.buildItemMenuButtons(menuService.listItemMenuOptions());
        for (ItemMenuButton button : buttons)
            button.setOnAction(itemMenuButtonActions.menuItemButtonAction(button));
        return buttons;
    }

    public ItemMenuButton buildItemMenuButton(ItemMenu itemMenu) {
        return new ItemMenuButton.ItemMenuButtonBuilder(itemMenu).build();
    }

    public List<ItemMenuButton> buildItemMenuButtons(List<ItemMenu> itemMenuList) {
        return itemMenuList.stream().map(itemMenu -> this.buildItemMenuButton(itemMenu)).collect(Collectors.toCollection(ArrayList::new));
    }

    public ItemMenuPane buildItemMenuPane(List<ItemMenu> itemMenuList) {
        List<ItemMenuButton> itemMenuButtons = this.buildItemMenuButtons(itemMenuList);
        for (ItemMenuButton button : itemMenuButtons)
            button.setOnAction(itemMenuButtonActions.menuItemButtonAction(button));

        return new ItemMenuPane.ItemMenuPaneBuilder(itemMenuButtons).build();
    }
}