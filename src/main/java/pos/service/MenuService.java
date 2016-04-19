package pos.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import pos.model.application.Item;
import pos.model.application.ItemType;
import pos.model.application.MenuItem;
import pos.model.application.Price;

public class MenuService {

    @Autowired
    private ItemService itemService;

    public List<MenuItem> listMainMenuOptions() {
        List<Item> items = itemService.listActiveItems();
        return this.groupMenuItemsByType(items);
    }

    private List<MenuItem> groupMenuItemsByType(List<Item> items) {

        List<MenuItem> menuItems = new LinkedList<>();
        Map<ItemType, List<Item>> groups = this.groupItemsByType(items);

        for (Entry<ItemType, List<Item>> entry : groups.entrySet()) {

            ItemType type = entry.getKey();
            List<MenuItem> submenu = entry.getValue().stream()
                    .map(p -> new MenuItem.MenuBuilder().item(p).build())
                    .collect(Collectors.toCollection(LinkedList::new));

            Item tempItem = new Item.ItemBuilder(type, Price.nothing()).build();
            MenuItem menuItem = new MenuItem.MenuBuilder().item(tempItem)
                    .submenu(submenu).build();
            menuItems.add(menuItem);
        }
        return menuItems;
    }

    private Map<ItemType, List<Item>> groupItemsByType(List<Item> items) {
        return items.stream().collect(Collectors.groupingBy(Item::getType));
    }
}