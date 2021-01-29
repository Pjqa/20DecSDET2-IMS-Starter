package com.qa.ims.controller;


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
    
    public OrderController(OrderDao orderDao, JavaUtilities javaUtilities) {
        super();
        this.orderDao = orderDao;
        this.javaUtilities = javaUtilities;
    }
    

	//CREATE 
	@Override
	public Order create() {
        LOGGER.info("Enter the customer id");
        Long fk_customer_id = javaUtilities.getLong();
        Order order = orderDao.create(new Order(fk_customer_id));
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
        //ADD AND REMOVE ITEM TO ORDER
        LOGGER.info("ADD or REMOVE an item to order");
        String action = javaUtilities.getString();
		 if ( action.equalsIgnoreCase("ADD") ) {
			    LOGGER.info("Enter the iid of the item you wanna add");
				Long iid = javaUtilities.getLong();
	        	LOGGER.info("Item added to order");
	        	return orderDao.addUpdate(oid, iid);
	        
	        } else if ( action.equalsIgnoreCase("REMOVE") ) {
	        	LOGGER.info("Enter the iid of the item you wanna remove");
				Long iid = javaUtilities.getLong();
	        	orderDao.removeUpdate(oid, iid);
	        	LOGGER.info("Item removed from order");
	        	return null;
            }
		 
		 	return null;
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