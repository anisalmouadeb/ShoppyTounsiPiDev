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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long categoryId;
	private String name;
	@OneToMany(mappedBy = "category",cascade=CascadeType.REMOVE)
	private List<Product> product;
	@Enumerated(EnumType.STRING)
	private ShelfType type;
	@ManyToOne 
	private Shelf shelf;
	public Category(String name, List<Product> product, ShelfType type, Shelf shelf) {
		super();
		this.name = name;
		this.product = product;
		this.type = type;
		this.shelf = shelf;
	}

	public Category() {
		super();
	}
	
	

	public Shelf getShelf() {
		return shelf;
	}

	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public ShelfType getType() {
		return type;
	}

	public void setType(ShelfType type) {
		this.type = type;
	}

}
