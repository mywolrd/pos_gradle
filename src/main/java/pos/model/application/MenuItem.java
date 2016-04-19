package pos.model.application;

import java.util.List;

public class MenuItem {

    private Item item;
    private List<MenuItem> submenu;

    public static class MenuBuilder {

        private Item item;
        private List<MenuItem> submenu;

        public MenuBuilder item(Item item) {
            this.item = item;
            return this;
        }

        public MenuBuilder submenu(List<MenuItem> item) {
            this.submenu = item;
            return this;
        }

        public MenuItem build() {
            return new MenuItem(this);
        }
    }

    private MenuItem(MenuBuilder builder) {
        this.item = builder.item;
        this.submenu = builder.submenu;
    }

    public Item getItem() {
        return item;
    }

    public List<MenuItem> getSubmenu() {
        return this.submenu;
    }
}