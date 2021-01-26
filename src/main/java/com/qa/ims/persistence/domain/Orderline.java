package com.qa.ims.persistence.domain;

public class Orderline {
	
	private Long rid;
	private Long fk_order_oid;
	private Long fk_customer_id;

	public Orderline(Long fk_order_oid, Long fk_customer_id) {
		this.fk_order_oid = fk_order_oid;
		this.fk_customer_id = fk_customer_id;		
	}
	
	public Orderline(Long rid, Long fk_order_oid, Long fk_customer_id) {
		this.rid = rid;
		this.fk_order_oid = fk_order_oid;
		this.fk_customer_id = fk_customer_id;		
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public Long getFk_order_oid() {
		return fk_order_oid;
	}

	public void setFk_order_oid(Long fk_order_oid) {
		this.fk_order_oid = fk_order_oid;
	}

	public Long getFk_customer_id() {
		return fk_customer_id;
	}

	public void setFk_customer_id(Long fk_customer_id) {
		this.fk_customer_id = fk_customer_id;
	}

	@Override
	public String toString() {
		return "Orderline [rid=" + rid + ", fk_order_oid=" + fk_order_oid + ", fk_customer_id=" + fk_customer_id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fk_customer_id == null) ? 0 : fk_customer_id.hashCode());
		result = prime * result + ((fk_order_oid == null) ? 0 : fk_order_oid.hashCode());
		result = prime * result + ((rid == null) ? 0 : rid.hashCode());
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
		Orderline other = (Orderline) obj;
		if (fk_customer_id == null) {
			if (other.fk_customer_id != null)
				return false;
		} else if (!fk_customer_id.equals(other.fk_customer_id))
			return false;
		if (fk_order_oid == null) {
			if (other.fk_order_oid != null)
				return false;
		} else if (!fk_order_oid.equals(other.fk_order_oid))
			return false;
		if (rid == null) {
			if (other.rid != null)
				return false;
		} else if (!rid.equals(other.rid))
			return false;
		return true;
	}
	
	
}
