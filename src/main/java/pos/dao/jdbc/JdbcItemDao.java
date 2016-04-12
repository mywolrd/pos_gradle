package pos.dao.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import pos.dao.ItemDao;
import pos.model.db.Item;

@Repository
public class JdbcItemDao implements ItemDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private final static String uniqueByNameAndType = "SELECT * from ITEM where ITEM.name = : name and ITEM.type = :type";

    private final static String listByType = "SELECT * from ITEM where ITEM.type = :type";

    private final static String listAll = "SELECT * from ITEM";

    private final static String insertItem = "insert into ITEM (name, type, dollar, cent, active) values "
            + " (:name, :type, :dollar, :cent, :active)";

    private final static String updateItem = "update ITEM set name = :name, type = :type, dollar = :dollar, cent = :cent "
            + " where ITEM.id = :id ";

    private final static String updateActive = "update ITEM set active = :active where ITEM.id = :id";

    @Override
    public Item uniqueByNameAndType(String name, String type) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue(DBNames.NAME, name).addValue(DBNames.TYPE, type);
        try {
            return this.jdbcTemplate.queryForObject(uniqueByNameAndType,
                    parameter, new BeanPropertyRowMapper<>(Item.class));
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Item> listItems() {
        try {
            return this.jdbcTemplate.query(listAll,
                    new BeanPropertyRowMapper<>(Item.class));
        } catch (DataAccessException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Item> listItemsByType(String type) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue(DBNames.TYPE, type);
        try {
            return this.jdbcTemplate.query(listByType, parameter,
                    new BeanPropertyRowMapper<>(Item.class));
        } catch (DataAccessException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void save(Item item) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue(DBNames.TYPE, item.getType())
                .addValue(DBNames.NAME, item.getName())
                .addValue(DBNames.DOLLAR, item.getDollar())
                .addValue(DBNames.CENT, item.getCent())
                .addValue(DBNames.ACTIVE, Boolean.TRUE);
        try {
            this.jdbcTemplate.update(insertItem, parameter);
        } catch (DataAccessException e) {

        }
    }

    @Override
    public void update(Item item) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue(DBNames.TYPE, item.getType())
                .addValue(DBNames.NAME, item.getName())
                .addValue(DBNames.DOLLAR, item.getDollar())
                .addValue(DBNames.CENT, item.getCent())
                .addValue(DBNames.ID, item.getId());
        try {
            this.jdbcTemplate.update(updateItem, parameter);
        } catch (DataAccessException e) {

        }
    }

    @Override
    public void deactivateById(long id) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue(DBNames.ACTIVE, Boolean.FALSE)
                .addValue(DBNames.ID, id);
        try {
            this.jdbcTemplate.update(updateActive, parameter);
        } catch (DataAccessException e) {

        }
    }

    @Override
    public void deactivate(Item item) {
        this.deactivateById(item.getId());
    }
}