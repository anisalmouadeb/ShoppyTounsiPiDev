package tn.esprit.pi.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long userId;
	private long cin;
	private String name;
	private String address;
	private String email;
	private String numTel;
	private int age;
	private boolean isConnected;
	private boolean viewAd;
	@Enumerated(EnumType.STRING)
	private Role role;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Claim> claim;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Post> post;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Donation> donation;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<DiscountToken> discountToken;
	@ManyToMany(mappedBy = "user")
	private List<Event> event;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Orders> orders;


	public User(long cin, String name, String address, String email, String numTel, int age, boolean isConnected,
			boolean viewAd, Role role) {
		super();
		this.cin = cin;
		this.name = name;
		this.address = address;
		this.email = email;
		this.numTel = numTel;
		this.age = age;
		this.isConnected = isConnected;
		this.viewAd = viewAd;
		this.role = role;
	}

	public User() {
		super();
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getCin() {
		return cin;
	}

	public void setCin(long cin) {
		this.cin = cin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isConnected() {
		return isConnected;
	}

	public void setConnected(boolean isConnected) {
		this.isConnected = isConnected;
	}

	public boolean isViewAd() {
		return viewAd;
	}

	public void setViewAd(boolean viewAd) {
		this.viewAd = viewAd;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Claim> getClaim() {
		return claim;
	}

	public void setClaim(List<Claim> claim) {
		this.claim = claim;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	public List<Donation> getDonation() {
		return donation;
	}

	public void setDonation(List<Donation> donation) {
		this.donation = donation;
	}

	public List<DiscountToken> getDiscountToken() {
		return discountToken;
	}

	public void setDiscountToken(List<DiscountToken> discountToken) {
		this.discountToken = discountToken;
	}

	public List<Event> getEvent() {
		return event;
	}

	public void setEvent(List<Event> event) {
		this.event = event;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}



}
