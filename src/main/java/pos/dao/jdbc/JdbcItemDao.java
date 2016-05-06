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
import pos.model.db._Item;

@Repository
public class JdbcItemDao implements ItemDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final static String uniqueByNameAndType = "SELECT * from ITEM where ITEM.name = : name and ITEM.type = :type";

    private final static String listByType = "SELECT * from ITEM where ITEM.type = :type";

    private final static String listAll = "SELECT * from ITEM";

    private final static String insertItem = "insert into ITEM (name, type, dollar, cent, active) values "
            + " (:name, :type, :dollar, :cent, :active)";

    private final static String updateItem = "update ITEM set name = :name, type = :type, dollar = :dollar, cent = :cent "
            + " where ITEM.id = :id ";

    private final static String updateActive = "update ITEM set active = :active where ITEM.id = :id";

    @Override
    public _Item uniqueByNameAndType(String name, String type) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue(DBNames.NAME, name).addValue(DBNames.TYPE, type);
        try {
            return this.namedParameterJdbcTemplate.queryForObject(uniqueByNameAndType,
                    parameter, new BeanPropertyRowMapper<>(_Item.class));
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<_Item> listItems() {
        try {
            return this.namedParameterJdbcTemplate.query(listAll,
                    new BeanPropertyRowMapper<>(_Item.class));
        } catch (DataAccessException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<_Item> listItemsByType(String type) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue(DBNames.TYPE, type);
        try {
            return this.namedParameterJdbcTemplate.query(listByType, parameter,
                    new BeanPropertyRowMapper<>(_Item.class));
        } catch (DataAccessException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void save(_Item item) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue(DBNames.TYPE, item.getType())
                .addValue(DBNames.NAME, item.getName())
                .addValue(DBNames.DOLLAR, item.getDollar())
                .addValue(DBNames.CENT, item.getCent())
                .addValue(DBNames.ACTIVE, Boolean.TRUE);
        try {
            this.namedParameterJdbcTemplate.update(insertItem, parameter);
        } catch (DataAccessException e) {

        }
    }

    @Override
    public void update(_Item item) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue(DBNames.TYPE, item.getType())
                .addValue(DBNames.NAME, item.getName())
                .addValue(DBNames.DOLLAR, item.getDollar())
                .addValue(DBNames.CENT, item.getCent())
                .addValue(DBNames.ID, item.getId());
        try {
            this.namedParameterJdbcTemplate.update(updateItem, parameter);
        } catch (DataAccessException e) {

        }
    }

    @Override
    public void deactivateById(long id) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue(DBNames.ACTIVE, Boolean.FALSE)
                .addValue(DBNames.ID, id);
        try {
            this.namedParameterJdbcTemplate.update(updateActive, parameter);
        } catch (DataAccessException e) {

        }
    }

    @Override
    public void deactivate(_Item item) {
        this.deactivateById(item.getId());
    }
}