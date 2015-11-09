package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the LINEITEM database table.
 * 
 */
@Entity
@Table(name="LINEITEM", schema="Nelson")
@NamedQuery(name="Lineitem.findAll", query="SELECT l FROM Lineitem l")
public class Lineitem implements Serializable {
	private static final long serialVersionUID = 1L;

	 @Id
	 @SequenceGenerator( name = "LINEITEM_SEQ", sequenceName = "LINEITEM_SEQ", allocationSize = 1, initialValue = 1 )
	 @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "LINEITEM_SEQ" )
	private long id;

	private int quantity;
	private BigDecimal total;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	//bi-directional many-to-one association to Shopper
	@ManyToOne
	private Shopper shopper;

	public Lineitem() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quanty) {
		this.quantity = quanty;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Shopper getShopper() {
		return this.shopper;
	}

	public void setShopper(Shopper shopper) {
		this.shopper = shopper;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}