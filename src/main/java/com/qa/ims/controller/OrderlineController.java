package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderlineDao;
import com.qa.ims.persistence.domain.Orderline;
import com.qa.ims.utils.JavaUtilities;

public class OrderlineController implements ICrudController<Orderline> {

    public static final Logger LOGGER = LogManager.getLogger();

    private OrderlineDao orderlineDao;
    private JavaUtilities javaUtilities;

    public OrderlineController(OrderlineDao orderlineDao, JavaUtilities javaUtilities) {
        super();
        this.orderlineDao = orderlineDao;
        this.javaUtilities = javaUtilities;
    }

    @Override
    public List<Orderline> readAll() {
        List<Orderline> orderlines = orderlineDao.readAll();
        for (Orderline orderline : orderlines) {
            LOGGER.info(orderline);
        }
        return orderlines;
    }
    
    //CREATE
    @Override
    public Orderline create() {
        LOGGER.info("Enter item iid");
        Long fk_item_iid = javaUtilities.getLong();
        LOGGER.info("Enter order oid");
        Long fk_order_oid = javaUtilities.getLong();
        Orderline orderline = orderlineDao.create(new Orderline( fk_item_iid, fk_order_oid));
        LOGGER.info("Orderline created :)");
        return orderline;
    }

    //UPDATE
    @Override
    public Orderline update() {
        LOGGER.info("Enter the rid of the orderline you wish to update");
        Long rid = javaUtilities.getLong();
        LOGGER.info("Enter item iid");
        Long fk_item_iid = javaUtilities.getLong();
        LOGGER.info("Enter order oid");
        Long fk_order_oid = javaUtilities.getLong();
        Orderline orderline = orderlineDao.create(new Orderline(rid, fk_item_iid, fk_order_oid));
        LOGGER.info("Orderline created :)");
        return orderline;
    }
    
    //DELETE
    @Override
    public int delete() {
        LOGGER.info("Enter the rid of the orderline you wish to delete");
        Long rid = javaUtilities.getLong();
        return orderlineDao.delete(rid);
    }

}