package tn.esprit.pi.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class EntryQuantityPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private long productId;
	private long providerId;

	@Temporal(TemporalType.DATE)
	private Date entryDate;
	
	public EntryQuantityPK() {
		super();
	}

	public EntryQuantityPK(long productId, long providerId, Date entryDate) {
		super();
		this.productId = productId;
		this.providerId = providerId;
		this.entryDate = entryDate;
	}
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entryDate == null) ? 0 : entryDate.hashCode());
	
		result = (int) (prime * result + productId);
		result = (int) (prime * result + providerId);
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
		EntryQuantityPK other = (EntryQuantityPK) obj;
		if (entryDate == null) {
			if (other.entryDate != null)
				return false;
		} else if (!entryDate.equals(other.entryDate))
			return false;
	
		if (productId != other.productId)
			return false;
		if (providerId != other.providerId)
			return false;
		return true;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getProviderId() {
		return providerId;
	}

	public void setProviderId(long providerId) {
		this.providerId = providerId;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}


	

	
	
}
