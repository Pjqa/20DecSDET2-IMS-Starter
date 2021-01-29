package com.qa.ims.persistence.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DatabaseUtilities;

public class OrderDao implements IDomainDao<Order> {

	public static final Logger LOGGER = LogManager.getLogger();
	private ItemDao idao;
	private CustomerDao cdao;

	public OrderDao(ItemDao idao, CustomerDao cdao) {
		super();
		this.idao = idao;
		this.cdao = cdao;

	}

	// CREATE
	@Override
	public Order create(Order order) {
		try (Connection connection = DatabaseUtilities.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("INSERT INTO orders(fk_id) VALUES (?)");) {
			statement.setLong(1, order.getFk_customer_id());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	// READ
	public Order read(Long oid) {
		try (Connection connection = DatabaseUtilities.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE oid = ?");) {
			statement.setLong(1, oid);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Order> readAll() {
		try (Connection connection = DatabaseUtilities.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
			List<Order> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Order readLatest() {
		try (Connection connection = DatabaseUtilities.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY oid DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	// UPDATE
	@Override
	public Order update(Order order) {
		try (Connection connection = DatabaseUtilities.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE orders SET fk_id = ? WHERE oid = ?");) {
			statement.setLong(1, order.getFk_customer_id());
			statement.setLong(3, order.getOid());
			statement.executeUpdate();
			return read(order.getOid());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	// DELETE
	@Override
	public int delete(long oid) {
		try (Connection connection = DatabaseUtilities.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			return statement.executeUpdate("DELETE FROM orders WHERE oid = " + oid);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	// ADD ITEM TO ORDER
	public Order addUpdate(Long oid, Long iid) {
		try (Connection connection = DatabaseUtilities.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orderlines(fk_oid, fk_iid) VALUES(?, ?)")) {
			statement.setLong(1, oid);
			statement.setLong(2, iid);
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	// REMOVE ITEM FROM ORDER
	public Order removeUpdate(Long oid, Long iid) {
		try (Connection connection = DatabaseUtilities.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("DELETE FROM orderlines WHERE (fk_oid = ? AND fk_iid = ?")) {
			statement.setLong(1, oid);
			statement.setLong(2, iid);
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

//	  CALCULATE ORDER COST
//    public double calOrderCost(Long oid) {
//    	double totalCost = 0.0;
//			for(oid o : ) {	
//			totalCost += rs.getDouble("price");
//		}{
//       	this.update(new Order(oid, null, price));
//				return price;
//    }	
//	}	
//	
//	public double calOrderCost(List<Item> items) {
//        double totalCost = 0.0;
//        for (Item item : items) {
//            totalCost += item.getPrice();
//        }
//        return totalCost;
//    }

	public List<Item> getItemsFromOrder(Long oid) {
		List<Item> returnItems = new ArrayList<>();
		List<Long> orderItemIDs = new ArrayList<>();
		try (Connection connection = DatabaseUtilities.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("SELECT * FROM orderlines WHERE fk_oid = ?");) {
			statement.setLong(1, oid);
			try (ResultSet rs = statement.executeQuery();) {
				while (rs.next()) {
					orderItemIDs.add(rs.getLong("fk_iid"));
				}
			}
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		for (Long i : orderItemIDs) {
			returnItems.add(idao.read(i));
		}
		return returnItems;
	}

	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long oid = resultSet.getLong("oid");
		Long fk_customers_id = resultSet.getLong("fk_id");
		double orderPrice = resultSet.getDouble("price");
		List<Item> itemlist = getItemsFromOrder(oid);
		return new Order(oid, fk_customers_id, orderPrice, itemlist);
	}

}