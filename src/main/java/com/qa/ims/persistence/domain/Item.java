package com.qa.ims.persistence.domain;

public class Item {

	// variables
		private Long iid;
		private String name;
		private double value;

		// constructors	
		public Item(String name, double value) {
			this.name = name;
			this.value = value;
		}
		
		public Item(Long iid, String name, double value) {
			this.iid = iid;
			this.name = name;
			this.value = value;
		}
		
		public Long getIid() {
			return iid;
		}

		public void setIid(Long iid) {
			this.iid = iid;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getValue() {
			return value;
		}

		public void setValue(double value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Item [iid=" + iid + ", name=" + name + ", value=" + value + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((iid == null) ? 0 : iid.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			long temp;
			temp = Double.doubleToLongBits(value);
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
			Item other = (Item) obj;
			if (iid == null) {
				if (other.iid != null)
					return false;
			} else if (!iid.equals(other.iid))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
				return false;
			return true;
		}
}
