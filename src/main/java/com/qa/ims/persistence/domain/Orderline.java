package com.qa.ims.persistence.domain;

public class Orderline {
	
	private Long rid;
	private Long fk_item_iid;
	private Long fk_order_oid;
	

	public Orderline(Long fk_item_iid, Long fk_order_oid) {
		this.fk_item_iid = fk_item_iid;
		this.fk_order_oid = fk_order_oid;
			
	}
	
	public Orderline(Long rid, Long fk_item_iid, Long fk_order_oid) {
		this.rid = rid;
		this.fk_item_iid = fk_item_iid;
		this.fk_order_oid = fk_order_oid;
			
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public Long getFk_item_iid() {
		return fk_item_iid;
	}

	public void setFk_item_iid(Long fk_item_iid) {
		this.fk_item_iid = fk_item_iid;
	}
	
	public Long getFk_order_oid() {
		return fk_order_oid;
	}

	public void setFk_order_oid(Long fk_order_oid) {
		this.fk_order_oid = fk_order_oid;
	}

	@Override
	public String toString() {
		return "Orderline [rid=" + rid + ", fk_item_iid=" + fk_item_iid + ", fk_order_oid=" + fk_order_oid + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fk_item_iid == null) ? 0 : fk_item_iid.hashCode());
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
		if (fk_item_iid == null) {
			if (other.fk_item_iid != null)
				return false;
		} else if (!fk_item_iid.equals(other.fk_item_iid))
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
