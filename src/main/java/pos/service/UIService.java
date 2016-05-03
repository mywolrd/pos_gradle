package pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javafx.scene.layout.Pane;
import pos.model.application.ItemMenu;
import pos.ui.itemmenu.ItemMenuButton;

@Service
public class UIService {

    @Autowired
    private MenuService menuService;

    public Pane getMainItemMenuPane() {

        List<ItemMenu> itemMenuList = this.menuService.listItemMenuOptions();

        List<ItemMenuButton> itemMenuButtons = itemMenuList.stream()
        
        return null;
    }

    private List<ItemMenuButton> buildItemMenuButton(List<ItemMenu> itemMenuList) {
        return itemMenuList.stream().map(mapper)
    }

}