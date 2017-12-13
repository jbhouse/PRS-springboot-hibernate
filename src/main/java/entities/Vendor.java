package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class Vendor implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy="vendor",fetch=FetchType.EAGER,orphanRemoval = true)
	private List<Product> products;
    private String code;
    private String Name;
    private String Address;
    private String City;
    private String State;
    private String Zip;
    private String Phone;
    private String Email;
    private Boolean IsPreApproved;
    private Boolean IsActive;
    private int UpDatedByUser;

	public Vendor() {
		this.IsPreApproved=false;
		this.IsActive=true;
	}
	
//	public List<Product> getproducts(){
//		return this.products;
//		we need to return the products list. but the products list 
//	returned cant contain vendors. else infinite loop
//	}
//	
//	public void setproducts(List<Product> p) {
//		this.products = p;
//	}

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
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getZip() {
		return Zip;
	}

	public void setZip(String zip) {
		Zip = zip;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Boolean getIsPreApproved() {
		return IsPreApproved;
	}

	public void setIsPreApproved(Boolean isPreApproved) {
		IsPreApproved = isPreApproved;
	}

	public Boolean getIsActive() {
		return IsActive;
	}

	public void setIsActive(Boolean isActive) {
		IsActive = isActive;
	}

	public int getUpDatedByUser() {
		return UpDatedByUser;
	}

	public void setUpDatedByUser(int upDatedByUser) {
		UpDatedByUser = upDatedByUser;
	}

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", code=" + code + ", Name=" + Name + ", Address="
				+ Address + ", City=" + City + ", State=" + State + ", Zip=" + Zip + ", Phone=" + Phone + ", Email="
				+ Email + ", IsPreApproved=" + IsPreApproved + ", IsActive=" + IsActive + ", UpDatedByUser="
				+ UpDatedByUser + "]";
	}

	
	
}
