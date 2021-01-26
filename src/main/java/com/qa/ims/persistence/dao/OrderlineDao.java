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

import com.qa.ims.persistence.domain.Orderline;
import com.qa.ims.utils.DatabaseUtilities;

public class OrderlineDao implements IDomainDao<Orderline> {

    public static final Logger LOGGER = LogManager.getLogger();
    
    //CREATE
    @Override
    public Orderline create(Orderline orderline) {
        try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                PreparedStatement statement = connection
                        .prepareStatement("INSERT INTO orderlines(fk_item_iid, fk_order_oid) VALUES (?, ?)");) {
            statement.setString(1, orderline.getFK_item_iid());
            statement.setString(2, orderline.getFK_order_oid());
            statement.executeUpdate();
            return readLatest();
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    //READ
    public Orderline read(Long rid) {
        try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM orderlines WHERE rid = ?");) {
            statement.setLong(1, rid);
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
    public List<Orderline> readAll() {
        try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM orderlines");) {
            List<Orderline> orderlines = new ArrayList<>();
            while (resultSet.next()) {
                orderlines.add(modelFromResultSet(resultSet));
            }
            return orderlines;
        } catch (SQLException e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    public Orderline readLatest() {
        try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM orderlines ORDER BY rid DESC LIMIT 1");) {
            resultSet.next();
            return modelFromResultSet(resultSet);
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    //UPDATE
    @Override
    public Orderline update(Orderline orderline) {
        try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                PreparedStatement statement = connection
                        .prepareStatement("UPDATE orderline SET fk_item_iid = ?, fk_order_oid = ?,  WHERE rid = ?");) {
            statement.setString(1,orderline.getFK_item_iid());
            statement.setString(2, orderline.getFK_order_oid());
            statement.setLong(3, orderline.getRid());
            statement.executeUpdate();
            return read(orderline.getRid());
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    //DELETE
    @Override
    public int delete(long rid) {
        try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                Statement statement = connection.createStatement();) {
            return statement.executeUpdate("delete from orderlines where rid = " + rid);
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return 0;
    }

    @Override
    public Orderline modelFromResultSet(ResultSet resultSet) throws SQLException {
        Long rid = resultSet.getLong("rid");
        Long fk_items_iid = resultSet.getLong("fk_items_iid");
        Long fk_orders_oid = resultSet.getLong("fk_orders_oid");
        return new Orderline(rid, fk_items_iid, fk_orders_oid);
    }

}