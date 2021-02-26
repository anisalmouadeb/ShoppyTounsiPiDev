package tn.esprit.pi.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EntryQuantity implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EntryQuantityPK entryQuantityPK;

	@ManyToOne
	@JoinColumn(name = "productId", referencedColumnName = "productId", insertable = false, updatable = false)
	private Product product;

	@ManyToOne
	@JoinColumn(name = "providerId", referencedColumnName = "providerId", insertable = false, updatable = false)
	private Provider provider;

	public int quantity;

	public EntryQuantityPK getEntryQuantityPK() {
		return entryQuantityPK;
	}

	public void setEntryQuantityPK(EntryQuantityPK entryQuantityPK) {
		this.entryQuantityPK = entryQuantityPK;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
