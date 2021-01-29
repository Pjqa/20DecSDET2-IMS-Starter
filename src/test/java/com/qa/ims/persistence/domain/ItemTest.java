package com.qa.ims.persistence.domain;

import org.junit.Test;

import static org.junit.Assert.*;
import nl.jqno.equalsverifier.EqualsVerifier;

public class ItemTest {

    @Test
    public void testConstructor1() {
        Item item = new Item("Haribos", 1.55);
        assertEquals("Haribos", item.getName());
        assertEquals(Double.valueOf(1.55), item.getPrice(), 0.0);
    }

    @Test
    public void testConstructor2() {
        Item item = new Item(1L, "Haribos", 1.55);
        assertEquals(Long.valueOf(1L), item.getIid());
        assertEquals("Haribos", item.getName());
        assertEquals(Double.valueOf(1.55), item.getPrice(), 0.0);
    }

    @Test
    public void testToString() {
        Item item = new Item(1L, "Haribos", 1.55);
        String expected = "Item [iid=1, name=Haribos, price=1.55]";
        assertEquals(expected, item.toString());
    }

    @Test
    public void testHashCode() {
        Item item = new Item(1L, "Haribos", 1.55);
        assertEquals(item.hashCode(), item.hashCode());
      
    }
    
    @Test
    public void testEquals() {
		EqualsVerifier.simple().forClass(Item.class).verify();
    }
    
}

//93.1% Coverage