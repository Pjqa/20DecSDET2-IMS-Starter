package com.qa.ims.controller;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDao;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.JavaUtilities;

public class OrderController implements ICrudController<Order>  {
	
	public static final Logger LOGGER = LogManager.getLogger();

    private OrderDao orderDao;
    private JavaUtilities javaUtilities;

	@Override
	public List<Order> readAll() {
        List<Order> orders = orderDao.readAll();
        for (Order order: orders) {
            LOGGER.info(order);
        }
        return orders;
    }


	@Override
	public Order create() {
        LOGGER.info("Enter the order oid");
        Long id = javaUtilities.getLong();
        LOGGER.info("Enter a surname");
        Long fk_customer_id = javaUtilities.getLong();
        LOGGER.info("Enter the Date you Ordered");
        Date orderdate = javaUtilities.getDate();
        Order order = orderDao.create(new Order(id, fk_customer_id, orderdate));
        LOGGER.info("Order created :)");
        return order;
    }

	@Override
	public Order update() {
        LOGGER.info("Enter the oid of the order you wish to update");
        Long oid = javaUtilities.getLong();
        LOGGER.info("Enter the customer's id number");
        Long fk_customer_id = javaUtilities.getLong();
        LOGGER.info("Enter the Order Date");
        Date orderdate = javaUtilities.getDate();
        Order order = orderDao.update(new Order(oid, fk_customer_id, orderdate));
        LOGGER.info("Order Updated");
        return order;
    }

	@Override
	public int delete() {
        LOGGER.info("Enter the oid of the order you wish to delete");
        Long id = javaUtilities.getLong();
        return orderDao.delete(oid);
    }
}