package domain.purchaserequest;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import domain.product.Product;

@SuppressWarnings("serial")
@Entity
public class PurchaseRequestLineItem implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="PurchaseRequestID")
	@JsonIgnore
	private PurchaseRequest purchaserequest;
	@ManyToOne
	@JoinColumn(name="ProductID")
	private Product product;
//	@JsonProperty("Quantity")
	@Column(name="Quantity")
    private int quantity;
//	@JsonProperty("IsActive")
	@Column(name="IsActive")
    private Boolean isActive;
//	@JsonProperty("UpdatedByUser")
	@Column(name="UpdatedByUser")
    private int updatedByUser;
//	@JsonProperty("DateCreated")
	@Column(name="DateCreated")
	private Timestamp dateCreated;
//	@JsonProperty("DateUpdated")
	@Column(name="DateUpdated")
	private Timestamp dateUpdated;

	public PurchaseRequestLineItem() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PurchaseRequest getPurchaseRequest() {
		return purchaserequest;
	}
	
	public void setPurchaseRequest(PurchaseRequest pr) {
		this.purchaserequest = pr;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int Quantity) {
		quantity = Quantity;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean IsActive) {
		isActive = IsActive;
	}

	public int getUpdatedByUser() {
		return updatedByUser;
	}

	public void setUpdatedByUser(int UpdatedByUser) {
		updatedByUser = UpdatedByUser;
	}
	
    public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Timestamp getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Timestamp dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	@Override
	public String toString() {
		return "PurchaseRequestLineItem [id=" + id + ", purchaserequest=" + purchaserequest + ", product=" + product
				+ ", Quantity=" + quantity + ", IsActive=" + isActive + ", UpdatedByUser=" + updatedByUser + "]";
	}
	
	

}
