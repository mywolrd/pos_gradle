package pos.dao;

import java.util.List;

import pos.model.db._OrderDetails;

public interface OrderDetailsDao {

    _OrderDetails uniqueById(long id);

    List<_OrderDetails> listByOrderId(long orderId);

    void save(_OrderDetails details);

    void update(_OrderDetails details);

    // is it required?
    void delete(_OrderDetails details);
}