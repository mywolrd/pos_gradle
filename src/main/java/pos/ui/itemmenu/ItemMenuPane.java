package pos.ui.itemmenu;

import java.util.List;

import javafx.scene.layout.GridPane;

public class ItemMenuPane extends GridPane {

    private static int ITEMS_PER_ROW = 5;
    private static int DEFAULT_GAP = 5;

    private List<ItemMenuButton> buttons;
    private int rows;
    private int itemsPerRow;
    private int defaultGap;

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
            return new ItemMenuPane(this);
        }
    }
}