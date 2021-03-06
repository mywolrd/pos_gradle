package pos.dao.jdbc;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import pos.dao.ItemDao;
import pos.dao.jdbc.mapper.ItemRowMapper;
import pos.model.application.Item;

@Repository
public class JdbcItemDao extends JdbcBaseDao implements ItemDao {

    private final static String uniqueByNameAndType = "SELECT * from ITEM where ITEM.name = :name and ITEM.type = :type";

    private final static String listByType = "SELECT * from ITEM where ITEM.type = :type";

    private final static String listAll = "SELECT * from ITEM";

    private final static String insertItem = "insert into ITEM (name, type, dollar, cent, active) values (:name, :type, :dollar, :cent, :active)";

    private final static String updateItem = "update ITEM set name = :name, type = :type, dollar = :dollar, cent = :cent where ITEM.id = :id ";

    private final static String updateActive = "update ITEM set active = :active where ITEM.id = :id";

    @Autowired
    private ItemRowMapper rowMapper;

    @Override
    public Item uniqueByNameAndType(String name, String type) {
        SqlParameterSource parameter = new MapSqlParameterSource().addValue(DBNames.NAME, name).addValue(DBNames.TYPE, type);
        try {
            return this.namedParameterJdbcTemplate.queryForObject(uniqueByNameAndType, parameter, rowMapper);
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Item> listItems() {
        try {
            return this.namedParameterJdbcTemplate.query(listAll, rowMapper);
        } catch (DataAccessException e) {
            return new LinkedList<>();
        }
    }

    @Override
    public List<Item> listItemsByType(String type) {
        SqlParameterSource parameter = new MapSqlParameterSource().addValue(DBNames.TYPE, type);
        try {
            return this.namedParameterJdbcTemplate.query(listByType, parameter, rowMapper);
        } catch (DataAccessException e) {
            return new LinkedList<>();
        }
    }

    @Override
    public void save(Item item) {
        SqlParameterSource parameter = new MapSqlParameterSource().addValue(DBNames.TYPE, item.getItemType().getName()).addValue(DBNames.NAME, item.getName())
                .addValue(DBNames.DOLLAR, item.getPrice().getDollar()).addValue(DBNames.CENT, item.getPrice().getCent()).addValue(DBNames.ACTIVE, Boolean.TRUE);
        try {
            this.namedParameterJdbcTemplate.update(insertItem, parameter);
        } catch (DataAccessException e) {

        }
    }

    @Override
    public void update(Item item) {
        SqlParameterSource parameter = new MapSqlParameterSource().addValue(DBNames.TYPE, item.getItemType().getName()).addValue(DBNames.NAME, item.getName())
                .addValue(DBNames.DOLLAR, item.getPrice().getDollar()).addValue(DBNames.CENT, item.getPrice().getCent()).addValue(DBNames.ACTIVE, item.isActive())
                .addValue(DBNames.ID, item.getId());
        try {
            this.namedParameterJdbcTemplate.update(updateItem, parameter);
        } catch (DataAccessException e) {

        }
    }

    @Override
    public void deactivateById(long id) {
        SqlParameterSource parameter = new MapSqlParameterSource().addValue(DBNames.ACTIVE, Boolean.FALSE).addValue(DBNames.ID, id);
        try {
            this.namedParameterJdbcTemplate.update(updateActive, parameter);
        } catch (DataAccessException e) {

        }
    }

    @Override
    public void deactivate(Item item) {
        this.deactivateById(item.getId());
    }
}