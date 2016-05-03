package pos.service.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pos.model.application.ItemMenu;
import pos.service.MenuService;
import pos.ui.itemmenu.ItemMenuButton;

@Service
public class ItemMenuButtonService {

    @Autowired
    private MenuService menuService;

    public ItemMenuButton buildItemMenuButton(ItemMenu itemMenu) {
        return new ItemMenuButton.ItemMenuButtonBuilder(itemMenu).build();
    }

}