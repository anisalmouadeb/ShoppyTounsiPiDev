package tn.esprit.pi.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class OrderLinePK implements Serializable {

	private static final long serialVersionUID = 1L;

	private long productId;
	private long orderId;

	public OrderLinePK() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + productId);
		result = (int) (prime * result + orderId);
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
		OrderLinePK other = (OrderLinePK) obj;
		if (productId != other.productId)
			return false;
		if (orderId != other.orderId)
			return false;
		return true;
	}
	
	
	
	

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

}
