package entities;
import java.io.Serializable;
import java.sql.Timestamp;
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
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(mappedBy="user",fetch=FetchType.EAGER,orphanRemoval = true)
	private List<PurchaseRequest> purchaserequests;
	private String UserName;
	private String Password;
	private String FirstName;
	private String LastName;
	private String Phone;
	private String Email;
	private Boolean IsReviewer;
	private Boolean IsAdmin;
	private Boolean IsActive;
	private Timestamp DateCreated;
	private Timestamp DateUpdated;
	private int UpdatedByUser;

	public User() {}
	
	public List<PurchaseRequest> getpurchaserequests(){
//		return this.purchaserequests;
		return null;
	}
	
	public void setpurchaserequests(List<PurchaseRequest> prs) {
		this.purchaserequests = prs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
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

	public Boolean getIsReviewer() {
		return IsReviewer;
	}

	public void setIsReviewer(Boolean isReviewer) {
		IsReviewer = isReviewer;
	}

	public Boolean getIsAdmin() {
		return IsAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		IsAdmin = isAdmin;
	}

	public Boolean getIsActive() {
		return IsActive;
	}

	public void setIsActive(Boolean isActive) {
		IsActive = isActive;
	}

	public int getUpdatedByUser() {
		return UpdatedByUser;
	}

	public void setUpdatedByUser(int updatedByUser) {
		UpdatedByUser = updatedByUser;
	}

	public Timestamp getDateUpdated() {
		return DateUpdated;
	}

	public void setDateUpdated(Timestamp dateUpdated) {
		DateUpdated = dateUpdated;
	}

	public Timestamp getDateCreated() {
		return DateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		DateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", UserName=" + UserName + ", Password="
				+ Password + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Phone=" + Phone + ", Email="
				+ Email + ", IsReviewer=" + IsReviewer + ", IsAdmin=" + IsAdmin + ", IsActive=" + IsActive
				+ ", DateCreated=" + DateCreated + ", DateUpdated=" + DateUpdated + ", UpdatedByUser=" + UpdatedByUser
				+ "]";
	}
	
}
