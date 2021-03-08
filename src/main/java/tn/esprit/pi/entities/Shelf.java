package tn.esprit.pi.entities;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Shelf implements Serializable {

	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long ShelfId;
	private String Shelfname;
	@Column(unique=true)
	private int position;
	@Temporal(TemporalType.DATE)
	private Date dateCreation = new Date(System.currentTimeMillis());
	@Enumerated(EnumType.STRING)
	private ShelfType type;
	private String image;
	@JsonIgnore
	@OneToMany(mappedBy = "shelf")
	private List<Category> category;
	@NotNull(message = "Please specify a rating between 1 and 5 inclusive")
    @Min(value = 1, message = "Please enter a rating greater than 0")
    @Max(value = 5, message = "Please enter a rating lesser than 5")
    private int rating;
    @Column(columnDefinition = "boolean default false")
    private Boolean promo =false;
	@Column(columnDefinition = "integer default 0")
    private int reductionPercantage;
	public Shelf(String shelfname, int position, Date dateCreation, ShelfType type, String image,
			List<Category> category) {
		super();
		Shelfname = shelfname;
		this.position = position;
		this.dateCreation = dateCreation;
		this.type = type;
		this.category = category;
		this.image = image;
	}

	public Shelf() {
		super();
	}

	public long getShelfId() {
		return ShelfId;
	}

	public void setShelfId(long shelfId) {
		ShelfId = shelfId;
	}

	public String getShelfname() {
		return Shelfname;
	}

	public void setShelfname(String shelfname) {
		Shelfname = shelfname;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public ShelfType getType() {
		return type;
	}

	public void setType(ShelfType type) {
		this.type = type;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Boolean getPromo() {
		return promo;
	}

	public void setPromo(Boolean promo) {
		this.promo = promo;
	}

	public int getReduction() {
		return reductionPercantage;
	}

	public void setReduction(int reductionPercantage) {
		this.reductionPercantage = reductionPercantage;
	}
	

}
