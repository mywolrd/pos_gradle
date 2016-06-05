package pos.application.ui.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pos.application.ui.button.ItemMenuButton;

@Component
public class ItemButtonActionManager {

    @Autowired
    private ItemButtonActions itemButtonActions;

    // 1. current order queue ? list?
    // 2. named or anonymously
    // 3. current order list highlighter moves to this menu.
    // 4.
    public void assignMenuButtionAction(ItemMenuButton button) {
        button.setOnAction(itemButtonActions.menuItemButtonAction(button));//
    }

}