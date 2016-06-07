package pos.application.ui.views.order;

import java.util.List;

import javafx.scene.layout.GridPane;
import pos.application.ui.UIConstants;
import pos.application.ui.button.ItemMenuButton;

public class ItemMenuButtonsView extends GridPane {

    private static int ITEMS_PER_ROW = 5;

    private List<ItemMenuButton> buttons;
    private int rows;
    private int itemsPerRow;

    public List<ItemMenuButton> getButtons() {
        return this.buttons;
    }

    public int getNumberOfRows() {
        return this.rows;
    }

    public int getItemsPerRow() {
        return this.itemsPerRow;
    }

    private ItemMenuButtonsView(ItemMenuPaneBuilder builder) {
        super();

        this.buttons = builder.buttons;
        this.itemsPerRow = builder.itemsPerRow;

        this.rows = buttons.size() / itemsPerRow;
    }

    public static class ItemMenuPaneBuilder {

        private List<ItemMenuButton> buttons;
        private int itemsPerRow = ITEMS_PER_ROW;

        public ItemMenuPaneBuilder(List<ItemMenuButton> buttons) {
            this.buttons = buttons;
        }

        public ItemMenuPaneBuilder itemsPerRow(int itemsPerRow) {
            this.itemsPerRow = itemsPerRow;
            return this;
        }

        public ItemMenuButtonsView build() {

            ItemMenuButtonsView itemMenuPane = new ItemMenuButtonsView(this);
            itemMenuPane.setVgap(UIConstants.GAP_BUTTONS);
            itemMenuPane.setHgap(UIConstants.GAP_BUTTONS);

            int c = 0;
            int r = 0;
            int itemsPerRow = itemMenuPane.getItemsPerRow();

            for (ItemMenuButton button : itemMenuPane.getButtons()) {
                itemMenuPane.add(button, c, r);
                c++;
                if (c == itemsPerRow) {
                    c = 0;
                    r++;
                }
            }
            return itemMenuPane;
        }
    }
}