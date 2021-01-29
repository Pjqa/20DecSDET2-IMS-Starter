package com.qa.ims.persistence.domain;

import java.util.List;

public class Order {
	
	private Long oid;
	private Long fk_customer_id;
	private double orderPrice;
	private List<Item> orderItems;

	public Order(Long oid, Long fk_customer_id, double orderPrice, List<Item> orderItems) {
		super();
		this.oid = oid;
		this.fk_customer_id = fk_customer_id;
		this.orderPrice = orderPrice;
		this.orderItems = orderItems;
	}

	public Order(Long fk_customer_id, double orderPrice, List<Item> orderItems) {
		super();
		this.fk_customer_id = fk_customer_id;
		this.orderPrice = orderPrice;
		this.orderItems = orderItems;
	}

	
	public Order(Long fk_customer_id) {
		super();
		this.fk_customer_id = fk_customer_id;
	}

	public Order(Long oid, Long fk_customer_id) {
		super();
		this.oid = oid;
		this.fk_customer_id = fk_customer_id;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public Long getFk_customer_id() {
		return fk_customer_id;
	}

	public void setFk_customer_id(Long fk_customer_id) {
		this.fk_customer_id = fk_customer_id;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public List<Item> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<Item> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fk_customer_id == null) ? 0 : fk_customer_id.hashCode());
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		result = prime * result + ((orderItems == null) ? 0 : orderItems.hashCode());
		long temp;
		temp = Double.doubleToLongBits(orderPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (fk_customer_id == null) {
			if (other.fk_customer_id != null)
				return false;
		} else if (!fk_customer_id.equals(other.fk_customer_id))
			return false;
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid))
			return false;
		if (orderItems == null) {
			if (other.orderItems != null)
				return false;
		} else if (!orderItems.equals(other.orderItems))
			return false;
		if (Double.doubleToLongBits(orderPrice) != Double.doubleToLongBits(other.orderPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", fk_customer_id=" + fk_customer_id + ", orderPrice=" + orderPrice
				+ ", orderItems=" + orderItems + "]";
	}
	
	
}

