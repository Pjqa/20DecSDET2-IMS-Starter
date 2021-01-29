package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDao;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.JavaUtilities;

public class ItemController implements ICrudController<Item>{
	
	
	public static final Logger LOGGER = LogManager.getLogger();
	 
	
	private ItemDao itemDao;
   	private JavaUtilities javaUtilities;
   	
  
   	public ItemController(ItemDao itemDao, JavaUtilities javaUtilities) {
        super();
        this.itemDao = itemDao;
        this.javaUtilities = javaUtilities;
    }
   
   	
   	// CREATE
	@Override
	public Item create() {
		LOGGER.info("Enter the name of the item");
        String name = javaUtilities.getString();
		LOGGER.info("Enter the price of the item");
        double value = javaUtilities.getDouble();
        Item item = itemDao.create(new Item(name, value));
        LOGGER.info("Item created :)");
        return item;
	}
	
	// READ
	@Override
    public List<Item> readAll() {
        List<Item> items = itemDao.readAll();
        for (Item item : items) {
            LOGGER.info(item);
        }
        return items;
    }

	// UPDATE
	@Override
	public Item update() {
        LOGGER.info("Enter the iid of the item you want to update");
        Long iid = javaUtilities.getLong();
        LOGGER.info("Enter a name");
        String name = javaUtilities.getString();
        LOGGER.info("Enter a value");
        double value = javaUtilities.getDouble();
        Item item = itemDao.update(new Item(iid, name, value));
        LOGGER.info("Item Updated :)");
        return item;
    }
	
	// DELETE
	@Override
	public int delete() {
        LOGGER.info("Enter the iid of the item you want to delete");
        Long iid = javaUtilities.getLong();
        return itemDao.delete(iid);
    }

}


