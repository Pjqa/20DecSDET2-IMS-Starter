package com.qa.ims.persistence.domain;

import java.sql.Date;

public class Order {
	
	private Long oid;
	private Long fk_customer_id;
	private Date orderdate;
	
	
	public Order( Long fk_customer_id, Date orderdate) {
		this.fk_customer_id = fk_customer_id;
		this.orderdate = orderdate;
	}
	
	public Order(Long oid, Long fk_customer_id, Date orderdate) {
		this.oid = oid;
		this.fk_customer_id = fk_customer_id;
		this.orderdate = orderdate;
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

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", fk_customer_id=" + fk_customer_id + ", orderdate=" + orderdate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fk_customer_id == null) ? 0 : fk_customer_id.hashCode());
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		result = prime * result + ((orderdate == null) ? 0 : orderdate.hashCode());
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
		if (orderdate == null) {
			if (other.orderdate != null)
				return false;
		} else if (!orderdate.equals(other.orderdate))
			return false;
		return true;
	}
	
	
}

