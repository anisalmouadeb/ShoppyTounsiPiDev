package tn.esprit.pi.entities;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Event implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long eventId;
	private int estimatedAmount;
	private int collectedAmount;
	private String location;
	private int numberOfVisits;
	private int numberOfparticipants;
	@Temporal(TemporalType.DATE)
	private Date eventDate;
	@ManyToMany
	private List<User> user;

	public Event() {
		super();
	}

	public Event(int estimatedAmount, int collectedAmount, String location, int numberOfVisits,
			int numberOfparticipants, Date eventDate) {
		super();
		this.estimatedAmount = estimatedAmount;
		this.collectedAmount = collectedAmount;
		this.location = location;
		this.numberOfVisits = numberOfVisits;
		this.numberOfparticipants = numberOfparticipants;
		this.eventDate = eventDate;
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public int getEstimatedAmount() {
		return estimatedAmount;
	}

	public void setEstimatedAmount(int estimatedAmount) {
		this.estimatedAmount = estimatedAmount;
	}

	public int getCollectedAmount() {
		return collectedAmount;
	}

	public void setCollectedAmount(int collectedAmount) {
		this.collectedAmount = collectedAmount;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getNumberOfVisits() {
		return numberOfVisits;
	}

	public void setNumberOfVisits(int numberOfVisits) {
		this.numberOfVisits = numberOfVisits;
	}

	public int getNumberOfparticipants() {
		return numberOfparticipants;
	}

	public void setNumberOfparticipants(int numberOfparticipants) {
		this.numberOfparticipants = numberOfparticipants;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

}
