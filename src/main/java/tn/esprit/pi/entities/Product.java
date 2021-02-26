package tn.esprit.pi.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long productId;
	private String name;
	private String description;
	private float priceV;
	private float priceA;
	private int quantity;
	private long code;
	@ManyToOne
	private Category category;
	private boolean isApproved;
	private String image;

	@OneToMany(mappedBy = "product")
	private List<Ad> ads;
	
	@OneToMany(mappedBy = "product")
	private List<EntryQuantity> entryQuantity;

	@OneToMany(mappedBy = "product")
	private List<Claim> claim;
	
	public Product(String name, String description, float priceV, float priceA, int quantity, long code,
			Category category, boolean isApproved, String image, List<Ad> ads) {
		super();
		this.name = name;
		this.description = description;
		this.priceV = priceV;
		this.priceA = priceA;
		this.quantity = quantity;
		this.code = code;
		this.category = category;
		this.isApproved = isApproved;
		this.image = image;
		this.ads = ads;
	}

	public Product() {
		super();
	}
	
	

	public List<EntryQuantity> getEntryQuantity() {
		return entryQuantity;
	}

	public void setEntryQuantity(List<EntryQuantity> entryQuantity) {
		this.entryQuantity = entryQuantity;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPriceV() {
		return priceV;
	}

	public void setPriceV(float priceV) {
		this.priceV = priceV;
	}

	public float getPriceA() {
		return priceA;
	}

	public void setPriceA(float priceA) {
		this.priceA = priceA;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Ad> getAds() {
		return ads;
	}

	public void setAds(List<Ad> ads) {
		this.ads = ads;
	}

}
