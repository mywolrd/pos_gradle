package pos.javafx;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pos.javafx.button.ItemMenuButton;
import pos.model.application.ItemMenu;
import pos.service.MenuService;

@Component
public class UIElementBuilder {

    @Autowired
    private MenuService menuService;

    public List<ItemMenuButton> listItemMenuButtons() {
        return this.buildItemMenuButtonList(menuService.listItemMenuOptions());
    }

    private ItemMenuButton buildItemMenuButton(ItemMenu itemMenu) {
        if (itemMenu.hasSubmenu())
            return new ItemMenuButton.ItemMenuButtonBuilder(itemMenu).submenuButtons(this.buildItemMenuButtonList(itemMenu.getSubmenu())).build();

        return new ItemMenuButton.ItemMenuButtonBuilder(itemMenu).build();
    }

    private List<ItemMenuButton> buildItemMenuButtonList(List<ItemMenu> itemMenuList) {
        return itemMenuList.stream().map(itemMenu -> this.buildItemMenuButton(itemMenu)).collect(Collectors.toCollection(LinkedList::new));
    }
}