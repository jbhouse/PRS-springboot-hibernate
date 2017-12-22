package domain.user;
import java.io.Serializable;
import java.sql.Timestamp;
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

import domain.purchaserequest.PurchaseRequest;


@SuppressWarnings("serial")
@Entity
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(mappedBy="user",fetch=FetchType.EAGER,orphanRemoval = true)
	@JsonIgnore
	private List<PurchaseRequest> purchaserequests;
	@JsonProperty("UserName")
	@Column(name="UserName")
	private String userName;
	@JsonProperty("Password")
	@Column(name="Password")
	private String password;
	@JsonProperty("FirstName")
	@Column(name="FirstName")
	private String firstName;
	@JsonProperty("LastName")
	@Column(name="LastName")
	private String lastName;
	@JsonProperty("Phone")
	@Column(name="Phone")
	private String phone;
	@JsonProperty("Email")
	@Column(name="Email")
	private String email;
	@JsonProperty("IsReviewer")
	@Column(name="IsReviewer")
	private Boolean reviewer;
	@JsonProperty("IsAdmin")
	@Column(name="IsAdmin")
	private Boolean admin;
	@JsonProperty("IsActive")
	@Column(name="IsActive")
	private Boolean active;
	@JsonProperty("DateCreated")
	@Column(name="DateCreated")
	private Timestamp dateCreated;
	@JsonProperty("DateUpdated")
	@Column(name="DateUpdated")
	private Timestamp dateUpdated;
	@JsonProperty("UpdatedByUser")
	@Column(name="UpdatedByUser")
	private int updatedByUser;

	public User() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<PurchaseRequest> getPurchaserequests() {
		return purchaserequests;
	}

	public void setPurchaserequests(List<PurchaseRequest> purchaserequests) {
		this.purchaserequests = purchaserequests;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsReviewer() {
		return reviewer;
	}

	public void setIsReviewer(Boolean isReviewer) {
		this.reviewer = isReviewer;
	}

	public Boolean getIsAdmin() {
		return admin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.admin = isAdmin;
	}

	public Boolean getIsActive() {
		return active;
	}

	public void setIsActive(Boolean isActive) {
		this.active = isActive;
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

	public int getUpdatedByUser() {
		return updatedByUser;
	}

	public void setUpdatedByUser(int updatedByUser) {
		this.updatedByUser = updatedByUser;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", purchaserequests=" + purchaserequests + ", userName=" + userName + ", password="
				+ password + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", email="
				+ email + ", isReviewer=" + reviewer + ", isAdmin=" + admin + ", isActive=" + active
				+ ", dateCreated=" + dateCreated + ", dateUpdated=" + dateUpdated + ", updatedByUser=" + updatedByUser
				+ "]";
	}
	

	
}
