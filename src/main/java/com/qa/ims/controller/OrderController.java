package com.qa.ims.controller;

import java.sql.Date;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDao;
import com.qa.ims.persistence.dao.OrderDao;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.JavaUtilities;

public class OrderController implements ICrudController<Order>  {
	
	public static final Logger LOGGER = LogManager.getLogger();

    private OrderDao orderDao;
    private JavaUtilities javaUtilities;
    
    public OrderController(OrderDao orderDao, JavaUtilities javaUtilities) {
        super();
        this.orderDao = orderDao;
        this.javaUtilities = javaUtilities;
    }
    

	//CREATE
	@Override
	public Order create() {
        LOGGER.info("Enter the customer id");
        Long id = javaUtilities.getLong();
        LOGGER.info("Enter a surname");
        Long fk_customer_id = javaUtilities.getLong();
        LOGGER.info("Enter Date Ordered on MM/DD/YYYY");
        Date orderdate = javaUtilities.getDate();
        Order order = orderDao.create(new Order(id, fk_customer_id, orderdate));
        LOGGER.info("Order created :)");
        return order;
    }
	
	  //READ
		@Override
		public List<Order> readAll() {
	        List<Order> orders = orderDao.readAll();
	        for (Order order: orders) {
	            LOGGER.info(order);
	        }
	        return orders;
	    }
		
	//UPDATE
	@Override
	public Order update() {
        LOGGER.info("Enter the oid of the order you wish to update");
        Long oid = javaUtilities.getLong();
        LOGGER.info("Enter the customer's id number");
        Long fk_customer_id = javaUtilities.getLong();
        LOGGER.info("Enter the Order Date");
        Date orderdate = javaUtilities.getDate();
        Order order = orderDao.update(new Order(oid, fk_customer_id, orderdate));
        LOGGER.info("Order Updated :)");
        return order;
    }
	
	//DELETE
	@Override
	public int delete() {
        LOGGER.info("Enter the oid of the order you wish to delete");
        Long oid = javaUtilities.getLong();
        LOGGER.info("Order Delted :)");
        return orderDao.delete(oid);
    }
}