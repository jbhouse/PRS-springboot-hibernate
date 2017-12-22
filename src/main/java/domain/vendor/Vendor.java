package domain.vendor;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import domain.product.Product;

@SuppressWarnings("serial")
@Entity
public class Vendor implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy="vendor",fetch=FetchType.EAGER,orphanRemoval = true)
    @JsonIgnore
	private List<Product> products;
    @JsonProperty("Code")
    @Column(name="Code")
    private String code;
    @JsonProperty("Name")
    @Column(name="Name")
    private String name;
    @JsonProperty("Address")
    @Column(name="Address")
    private String address;
    @JsonProperty("City")
    @Column(name="City")
    private String city;
    @JsonProperty("State")
    @Column(name="State")
    private String state;
    @JsonProperty("Zip")
    @Column(name="Zip")
    private String zip;
    @JsonProperty("Phone")
    @Column(name="Phone")
    private String phone;
    @JsonProperty("Email")
    @Column(name="Email")
    private String email;
    @JsonProperty("IsPreApproved")
    @Column(name="IsPreApproved")
    private Boolean isPreApproved;
    @JsonProperty("IsActive")
    @Column(name="IsActive")
    private Boolean isActive;
    @JsonProperty("UpDatedByUser")
    @Column(name="UpdatedByUser")
    private int upDatedByUser;

	public Vendor() {
		this.isPreApproved=false;
		this.isActive=true;
	}
	
	public List<Product> getproducts(){
		return this.products;
	}
	
	public void setproducts(List<Product> p) {
		this.products = p;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String theName) {
		name = theName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String theAddress) {
		address = theAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String theCity) {
		city = theCity;
	}

	public String getState() {
		return state;
	}

	public void setState(String theState) {
		state = theState;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String theZip) {
		zip = theZip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String thePhone) {
		phone = thePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String theEmail) {
		email = theEmail;
	}

	public Boolean getIsPreApproved() {
		return isPreApproved;
	}

	public void setIsPreApproved(Boolean IsPreApproved) {
		isPreApproved = IsPreApproved;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean IsActive) {
		isActive = IsActive;
	}

	public int getUpDatedByUser() {
		return upDatedByUser;
	}

	public void setUpDatedByUser(int UpDatedByUser) {
		upDatedByUser = UpDatedByUser;
	}

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", code=" + code + ", Name=" + name + ", Address="
				+ address + ", City=" + city + ", State=" + state + ", Zip=" + zip + ", Phone=" + phone + ", Email="
				+ email + ", IsPreApproved=" + isPreApproved + ", IsActive=" + isActive + ", UpDatedByUser="
				+ upDatedByUser + "]";
	}

	
	
}
