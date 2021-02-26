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
	private Date EntryDate;
	
	public EntryQuantityPK() {
		super();
	}

	public EntryQuantityPK(long productId, long providerId, Date entryDate) {
		super();
		this.productId = productId;
		this.providerId = providerId;
		EntryDate = entryDate;
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
		return EntryDate;
	}

	public void setEntryDate(Date entryDate) {
		EntryDate = entryDate;
	}

	
	
}
