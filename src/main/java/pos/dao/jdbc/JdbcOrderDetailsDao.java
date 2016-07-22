package pos.dao.jdbc;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import pos.dao.OrderDetailsDao;
import pos.model.db._OrderDetails;

@Repository
public class JdbcOrderDetailsDao extends JdbcBaseDao implements OrderDetailsDao {

    private final static String uniqueById = "SELECT * from ORDER_DETAILS where ORDER_DETAILS.id = :id";

    @Override
    public _OrderDetails uniqueById(long id) {
        SqlParameterSource parameter = new MapSqlParameterSource().addValue(DBNames.ID, id);
        try {
            return this.namedParameterJdbcTemplate.queryForObject(uniqueById, parameter, new BeanPropertyRowMapper<>(_OrderDetails.class));
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<_OrderDetails> listByOrderId(long orderId) {
        return null;
    }

    @Override
    public void save(_OrderDetails details) {

    }

    @Override
    public void update(_OrderDetails details) {

    }

    @Override
    public void delete(_OrderDetails details) {

    }

}