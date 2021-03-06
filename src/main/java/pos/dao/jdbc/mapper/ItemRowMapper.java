package pos.dao.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import pos.dao.jdbc.DBNames;
import pos.model.application.Item;
import pos.model.application.ItemType;
import pos.model.application.Price;

@Component
public class ItemRowMapper implements RowMapper<Item> {

    @Override
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
        Price itemPrice = new Price.PriceBuilder().dollar(rs.getInt(DBNames.DOLLAR)).cent(rs.getInt(DBNames.CENT)).build();

        Item item = new Item.ItemBuilder(new ItemType(rs.getString(DBNames.TYPE)), itemPrice).id(rs.getLong(DBNames.ID)).name(rs.getString(DBNames.NAME))
                .active(rs.getBoolean(DBNames.ACTIVE)).build();
        return item;
    }

}