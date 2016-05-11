package pos.javafx.button;

import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import pos.model.application.ItemMenu;

public class ItemMenuButton extends Button {

    private ItemMenu itemMenu;

    private ItemMenuButton(ItemMenuButtonBuilder builder) {
        super();

        this.itemMenu = builder.itemMenu;
    }

    public ItemMenu getItemMenu() {
        return this.itemMenu;
    }

    public static class ItemMenuButtonBuilder {

        private ItemMenu itemMenu;
        private List<ItemMenuButton> submenuButtons;

        public ItemMenuButtonBuilder(ItemMenu itemMenu) {
            this.itemMenu = itemMenu;
        }

        public ItemMenuButtonBuilder submenuButtons(List<ItemMenuButton> submenuButtons) {
            this.submenuButtons = submenuButtons;
            return this;
        }

        public ItemMenuButton build() {
            ItemMenuButton itemMenuButton = new ItemMenuButton(this);

            itemMenuButton.setText(itemMenu.getName());
            itemMenuButton.setFont(Font.font("Arial", FontWeight.BOLD, 15));

            return itemMenuButton;
        }
    }

}