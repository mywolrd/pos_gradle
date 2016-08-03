package pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pos.dao.OrderDao;
import pos.model.application.Order;

@Service
public class OrderService {
    // Create
    // Modify/Append
    // Delete
    // Clear
    @Autowired
    private OrderDao orderDao;

    @Transactional(readOnly = true)
    public void uniqueById() {

    }

    @Transactional(readOnly = true)
    public void listByCustomer() {

    }

    @Transactional(readOnly = true)
    public void list() {

    }

    @Transactional
    public void save(Order order) {
        this.orderDao.save(order);
    }

    @Transactional
    public void update(Order order) {

    }

    @Transactional
    public void delete(Order order) {

    }
}