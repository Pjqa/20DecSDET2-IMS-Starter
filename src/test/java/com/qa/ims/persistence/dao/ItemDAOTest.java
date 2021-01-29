package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DatabaseUtilities;

public class ItemDAOTest {

    private final ItemDao DAO = new ItemDao();

    @Before
    public void setup() {
        DatabaseUtilities.connect();
        DatabaseUtilities.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
    }
    
    @Test
    public void testCreate() {
        final Item created = new Item(3L, "Lolly", 0.55);
        assertEquals(created, DAO.create(created));
    }

    @Test
    public void testReadAll() {
        List<Item> expected = new ArrayList<>();
        expected.add(new Item(1L, "Lolly", 0.55));
        expected.add(new Item(2L, "Haribos", 1.55));
        assertEquals(expected, DAO.readAll());
    }

    @Test
    public void testReadLatest() {
        assertEquals(new Item(2L, "Haribos", 1.55), DAO.readLatest());
    }

    @Test
    public void testRead() {
        final long iiD = 1L;
        assertEquals(new Item(iiD, "Lolly", 0.55), DAO.read(iiD));
    }

    @Test
    public void testUpdate() {
        final Item updated = new Item(1L, "Lolly", 0.55);
        assertEquals(updated, DAO.update(updated));
    }

    @Test
    public void testDelete() {
        assertEquals(1, DAO.delete(1));
    }
}

//74.9% Coverage