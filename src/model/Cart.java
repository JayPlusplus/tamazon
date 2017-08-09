package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cart database table.
 * 
 */
@Entity
@Table(name="cart")
@NamedQuery(name="Cart.findAll", query="SELECT c FROM Cart c")
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cartid;

	private double productprice;

	private int quantity;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="productid")
	private Product product;

	public Cart() {
	}

	public int getCartid() {
		return this.cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public double getProductprice() {
		return this.productprice;
	}

	public void setProductprice(double productprice) {
		this.productprice = productprice;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}