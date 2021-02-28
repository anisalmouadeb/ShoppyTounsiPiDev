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
public class Donation implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long donationId;
	private int amount;
	@Temporal(TemporalType.DATE)
	private Date donationDate;
	@ManyToOne
	private User user;

	public Donation(int amount, Date donationDate) {
		super();
		this.amount = amount;
		this.donationDate = donationDate;
	}

	public Donation() {
		super();
	}

	public long getDonationId() {
		return donationId;
	}

	public void setDonationId(long donationId) {
		this.donationId = donationId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(Date donationDate) {
		this.donationDate = donationDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
