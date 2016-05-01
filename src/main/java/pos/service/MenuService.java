package pos.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import pos.model.application.Item;
import pos.model.application.ItemType;
import pos.model.application.ItemMenu;
import pos.model.application.Price;

public class MenuService {

    @Autowired
    private ItemService itemService;

    public List<ItemMenu> listItemMenuOptions() {
        List<Item> items = itemService.listActiveItems();
        return this.groupItemMenuByType(items);
    }

    private List<ItemMenu> groupItemMenuByType(List<Item> items) {

        List<ItemMenu> itemMenuList = new LinkedList<>();
        Map<ItemType, List<Item>> groups = this.groupItemsByType(items);

        for (Entry<ItemType, List<Item>> entry : groups.entrySet()) {

            ItemType type = entry.getKey();
            List<ItemMenu> submenu = this.listItemMenu(entry.getValue());

            Item tempItem = new Item.ItemBuilder(type, Price.nothing()).build();
            ItemMenu itemMenu = new ItemMenu.MenuBuilder().item(tempItem)
                    .submenu(submenu).build();
            itemMenuList.add(itemMenu);
        }
        return itemMenuList;
    }

    private List<ItemMenu> listItemMenu(List<Item> items) {
    	return items.stream().map(p -> new ItemMenu.MenuBuilder().item(p).build()).collect(Collectors.toCollection(LinkedList::new));
    }
    
    private Map<ItemType, List<Item>> groupItemsByType(List<Item> items) {
        return items.stream().collect(Collectors.groupingBy(Item::getType));
    }
}