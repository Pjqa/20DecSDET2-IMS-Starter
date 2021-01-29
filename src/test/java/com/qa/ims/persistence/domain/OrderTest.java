package com.qa.ims.persistence.domain;

import org.junit.Test;

import static org.junit.Assert.*;
import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderTest {
	
	@Test
    public void testConstructor1() {
        Order order = new Order(1L, 1L, 1.50, null);
        assertEquals(Long.valueOf(1L), order.getOid());
        assertEquals(Long.valueOf(1L), order.getFk_customer_id());
        assertEquals(Double.valueOf(1.50), order.getOrderPrice(), 0.0);

    }
	
	@Test
    public void testConstructor2() {
        Order order = new Order(1L, 1.50, null);
        assertEquals(Long.valueOf(1L), order.getFk_customer_id());
        assertEquals(Double.valueOf(1.50), order.getOrderPrice(), 0.0);
    }
	
	@Test
    public void testConstructor3() {
        Order order = new Order(1L);
        assertEquals(Long.valueOf(1L), order.getFk_customer_id());
    }
	
    @Test
    public void testConstructor4() {
        Order order = new Order(1L, 1L);
        assertEquals(Long.valueOf(1L), order.getOid());
        assertEquals(Long.valueOf(1L), order.getFk_customer_id());
    }


    @Test
    public void testToString() {
        Order order = new Order(1L, 1L, 1.55, null);
        String expect = "Order [oid=1, fk_customer_id=1, orderPrice=1.55, orderItems=null]";
        assertEquals(expect, order.toString());
    }

    @Test
    public void testHashCode() {
        Order order = new Order(1L, 1L);
        assertEquals(order.hashCode(), order.hashCode());
    }
    
    @Test
    public void testEquals() {
		EqualsVerifier.simple().forClass(Order.class).verify();
    }
}