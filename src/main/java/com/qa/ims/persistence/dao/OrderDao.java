package com.qa.ims.persistence.dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DatabaseUtilities;

public class OrderDao implements IDomainDao<Order> {
	

	public static final Logger LOGGER = LogManager.getLogger();
	

	//CREATE
	@Override
	public Order create(Order order) {
		try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                PreparedStatement statement = connection
                        .prepareStatement("INSERT INTO orders(fk_customers_id, orderdate) VALUES (?,?)");) {
            statement.setLong(1, order.getFk_customer_id());
            statement.setDate(2, order.getOrderdate());
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
                        .prepareStatement("UPDATE orders SET fk_customer_id = ?, orderdate = ? WHERE oid = ?");) {
            statement.setLong(1, order.getFk_customer_id());
            statement.setDate(2, order.getOrderdate());
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
            return statement.executeUpdate("delete from orders where oid = " + oid);
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return 0;
    }

	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long oid = resultSet.getLong("oid");
        Long fk_customers_id = resultSet.getLong("fk_customers_id");
        Date orderdate = resultSet.getDate("orderdate");
        return new Order(oid, fk_customers_id, orderdate);
	}

}