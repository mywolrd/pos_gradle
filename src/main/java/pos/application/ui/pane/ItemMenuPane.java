package pos.application.ui.pane;

import java.util.List;

import javafx.scene.layout.GridPane;
import pos.application.ui.button.ItemMenuButton;

//  ItemMenuPane
//      MenuButtons -> forEach Button -> Submenu ItemMenuPane if exists.
public class ItemMenuPane extends GridPane {

    private static int ITEMS_PER_ROW = 5;
    private static int DEFAULT_GAP = 5;

    private List<ItemMenuButton> buttons;
    private int rows;
    private int itemsPerRow;
    private int defaultGap;

    public List<ItemMenuButton> getButtons() {
        return this.buttons;
    }

    public int getNumberOfRows() {
        return this.rows;
    }

    public int getItemsPerRow() {
        return this.itemsPerRow;
    }

    private ItemMenuPane(ItemMenuPaneBuilder builder) {
        super();

        this.buttons = builder.buttons;
        this.itemsPerRow = builder.itemsPerRow;
        this.defaultGap = builder.defaultGap;

        this.rows = buttons.size() / itemsPerRow;
    }

    public static class ItemMenuPaneBuilder {

        private List<ItemMenuButton> buttons;
        private int itemsPerRow = ITEMS_PER_ROW;
        private int defaultGap = DEFAULT_GAP;

        public ItemMenuPaneBuilder(List<ItemMenuButton> buttons) {
            this.buttons = buttons;
        }

        public ItemMenuPaneBuilder defaultGap(int defaultGap) {
            this.defaultGap = defaultGap;
            return this;
        }

        public ItemMenuPaneBuilder itemsPerRow(int itemsPerRow) {
            this.itemsPerRow = itemsPerRow;
            return this;
        }

        public ItemMenuPane build() {

            ItemMenuPane itemMenuPane = new ItemMenuPane(this);

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