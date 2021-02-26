package tn.esprit.pi.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class ClaimPK implements Serializable {

	private static final long serialVersionUID = 1L;
	private long productId;
	private long userId;
	@Temporal(TemporalType.DATE)
	private Date ClaimDate;

	public ClaimPK() {
		super();
	}

	public ClaimPK(long productId, long userId, Date claimDate) {
		super();
		this.productId = productId;
		this.userId = userId;
		ClaimDate = claimDate;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Date getClaimDate() {
		return ClaimDate;
	}

	public void setClaimDate(Date claimDate) {
		ClaimDate = claimDate;
	}

}
