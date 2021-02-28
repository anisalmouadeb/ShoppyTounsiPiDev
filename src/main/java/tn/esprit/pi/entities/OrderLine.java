package tn.esprit.pi.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderLine implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderLinePK orderLinePK;

	@ManyToOne
	@JoinColumn(name = "productId", referencedColumnName = "productId", insertable = false, updatable = false)
	private Product product;

	@ManyToOne
	@JoinColumn(name = "orderId", referencedColumnName = "orderId", insertable = false, updatable = false)
	private Orders order;

	public int quantity;

	public OrderLinePK getOrderLinePK() {
		return orderLinePK;
	}

	public void setOrderLinePK(OrderLinePK orderLinePK) {
		this.orderLinePK = orderLinePK;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
