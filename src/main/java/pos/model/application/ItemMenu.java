package pos.model.application;

import java.util.List;

public class ItemMenu {

    private Item item;
    private List<ItemMenu> submenu;

    public static class MenuBuilder {

        private Item item;
        private List<ItemMenu> submenu;

        public MenuBuilder item(Item item) {
            this.item = item;
            return this;
        }

        public MenuBuilder submenu(List<ItemMenu> item) {
            this.submenu = item;
            return this;
        }

        public ItemMenu build() {
            return new ItemMenu(this);
        }
    }

    private ItemMenu(MenuBuilder builder) {
        this.item = builder.item;
        this.submenu = builder.submenu;
    }

    public Item getItem() {
        return item;
    }

    public String getName() {
        if (null == this.item.getName() || this.item.getName().isEmpty())
            return this.item.getItemType().getName();
        return this.item.getName();
    }

    public List<ItemMenu> getSubmenu() {
        return this.submenu;
    }

    public boolean hasSubmenu() {
        return this.submenu != null && !this.submenu.isEmpty();
    }
}