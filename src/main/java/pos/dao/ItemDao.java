package pos.dao;

import java.util.List;

import pos.model.db._Item;

public interface ItemDao {

    _Item uniqueByNameAndType(String name, String type);

    List<_Item> listItems();

    List<_Item> listItemsByType(String type);

    void save(_Item item);

    void update(_Item item);

    void deactivateById(long id);

    void deactivate(_Item item);
}