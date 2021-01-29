package com.qa.ims.persistence.domain;

import org.junit.Test;


import static org.junit.Assert.*;
import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerTest {

	@Test
	public void testConstructor1() {
		Customer customer = new Customer("Thing", "One");
		assertEquals("Thing", customer.getFirstName());
		assertEquals("One", customer.getSurname());

	}

	@Test
	public void testConstructor2() {
		Customer customer = new Customer(1L, "Thing", "One");
		assertEquals(Long.valueOf("1"), customer.getId());
		assertEquals("Thing", customer.getFirstName());
		assertEquals("One", customer.getSurname());
	}
	
	@Test
	public void testToString() {
		Customer customer = new Customer(1L, "Thing", "One");
		String expected = "Customer [id=1, firstName=Thing, surname=One]";
		assertEquals(expected, customer.toString());
	}

	@Test
	public void testHashCode() {
		Customer customer = new Customer(1L, "Thing", "One");
		assertEquals(customer.hashCode(), customer.hashCode());
	
	}
	
	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Customer.class).verify();
	}
	
}
 // 100% COVERAGE