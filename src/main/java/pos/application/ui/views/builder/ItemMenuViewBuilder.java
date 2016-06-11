package pos.application.ui.views.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pos.application.ui.UIConstraints;
import pos.application.ui.action.ButtonActions;
import pos.application.ui.button.ItemMenuButton;
import pos.application.ui.views.BaseVgrid;
import pos.application.ui.views.input.ButtonPadView;
import pos.application.ui.views.order.ItemMenuView;
import pos.model.application.ItemMenu;
import pos.service.MenuService;

@Component
public class ItemMenuViewBuilder {

    @Autowired
    private ButtonActions itemMenuButtonActions;

    @Autowired
    private MenuService menuService;

    public ItemMenuView buildItemMenuView() {
        return new ItemMenuView.ItemMenuViewBuilder(this.buildItemMenuButtonPadView(), this.buildMenuOptionsButtonPadView()).build();
    }

    public BaseVgrid buildItemMenuView(boolean hello) {
        BaseVgrid view = new BaseVgrid(UIConstraints._55, UIConstraints._45);
        view.add(this.buildItemMenuButtonPadView(), 0, 0);
        view.add(this.buildMenuOptionsButtonPadView(), 0, 1);
        return view;
    }

    private ButtonPadView buildItemMenuButtonPadView() {
        return this.buildItemMenuButtonPadView(this.menuService.listItemMenuOptions());
    }

    private ButtonPadView buildMenuOptionsButtonPadView() {
        return this.buildItemMenuButtonPadView(this.menuService.listItemMenuOptions());
    }

    private ItemMenuButton buildItemMenuButton(ItemMenu itemMenu) {
        ItemMenuButton button = new ItemMenuButton.ItemMenuButtonBuilder(itemMenu).build();
        button.setOnAction(itemMenuButtonActions.menuItemButtonAction(button));
        return button;
    }

    private List<ItemMenuButton> buildItemMenuButtons(List<ItemMenu> itemMenuList) {
        return itemMenuList.stream().map(itemMenu -> this.buildItemMenuButton(itemMenu)).collect(Collectors.toCollection(ArrayList::new));
    }

    public ButtonPadView buildItemMenuButtonPadView(List<ItemMenu> itemMenuList) {
        List<ItemMenuButton> buttons = this.buildItemMenuButtons(itemMenuList);
        return new ButtonPadView.ButtonPadViewBuilder(buttons).build();
    }

}