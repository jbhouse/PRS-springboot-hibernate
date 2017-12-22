package domain.product;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import domain.purchaserequest.PurchaseRequestLineItem;
import domain.vendor.Vendor;

@SuppressWarnings("serial")
@Entity
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(mappedBy="product",fetch=FetchType.EAGER,orphanRemoval = true)
	@JsonIgnore
	private List<PurchaseRequestLineItem> purchaserequestlineitems;
	@ManyToOne
	@JoinColumn(name="VendorID")
	private Vendor vendor;
	@JsonProperty("Price")
	@Column(name="Price")
	private double price;
	@JsonProperty("PartNumber")
	@Column(name="PartNumber")
	private String partNumber;
	@JsonProperty("Name")
	@Column(name="Name")
    private String name;
	@JsonProperty("Unit")
	@Column(name="Unit")
    private String unit;
	@JsonProperty("PhotoPath")
	@Column(name="PhotoPath")
    private String photoPath;
	@JsonProperty("IsActive")
	@Column(name="IsActive")
    private Boolean isActive;
	
	public Product() {
		isActive = true;
	}
	
	public List<PurchaseRequestLineItem> getpurchaserequestlineitems(){
		return this.purchaserequestlineitems;
	}
	
	public void setpurchaserequestlineitems(List<PurchaseRequestLineItem> prs) {
		this.purchaserequestlineitems = prs;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String PartNumber) {
		partNumber = PartNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String Name) {
		name = Name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String Unit) {
		unit = Unit;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String PhotoPath) {
		photoPath = PhotoPath;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean IsActive) {
		isActive = IsActive;
	}

	@Override
	public String toString() {
		return "Product [id=" + id
				+ ", price=" + price + ", PartNumber=" + partNumber + ", Name=" + name + ", Unit=" + unit
				+ ", PhotoPath=" + photoPath + ", IsActive=" + isActive + "]";
	}

	
	
}
