package tn.esprit.pi.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class DiscountToken implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long discountTokenId;
	private int value;
	@Temporal(TemporalType.DATE)
	private Date validity;
	private boolean isUsed;
	@ManyToOne
	private User user;

	public DiscountToken(int value, Date validity, boolean isUsed) {
		super();
		this.value = value;
		this.validity = validity;
		this.isUsed = isUsed;
	}

	public DiscountToken() {
		super();
	}

	public long getDiscountTokenId() {
		return discountTokenId;
	}

	public void setDiscountTokenId(long discountTokenId) {
		this.discountTokenId = discountTokenId;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Date getValidity() {
		return validity;
	}

	public void setValidity(Date validity) {
		this.validity = validity;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
