package pos.utils;

import java.util.ArrayList;
import java.util.List;

import pos.model.application.Item;
import pos.model.application.ItemType;
import pos.model.application.Order;
import pos.model.application.Price;
import pos.model.db._Item;
import pos.model.db._Order;

public class ModelConversionUtils {

    public static Item _transformFromdbModel(_Item dbItem) {
        Price itemPrice = new Price.PriceBuilder().dollar(dbItem.getDollar())
                .cent(dbItem.getCent()).build();

        Item item = new Item.ItemBuilder(new ItemType(dbItem.getType()),
                itemPrice).id(dbItem.getId()).name(dbItem.getName())
                        .active(dbItem.isActive()).build();

        return item;
    }

    public static List<Item> _transformFromdbModel(List<_Item> dbItems) {
        List<Item> transformedItems = new ArrayList<>();

        for (_Item dbItem : dbItems) {
            transformedItems
                    .add(ModelConversionUtils._transformFromdbModel(dbItem));
        }
        return transformedItems;
    }

    public static Order _convertFromdbModel(_Order dbOrder) {

        Order order = new Order.OrderBuilder().build();

        return null;
    }

}