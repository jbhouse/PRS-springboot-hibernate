package entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="purchaserequest")
public class PurchaseRequest implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="UserID")
	private User user;
	@ManyToOne
	@JoinColumn(name="StatusID")
	private Status status;
	@OneToMany(mappedBy="purchaserequest",fetch=FetchType.EAGER,orphanRemoval = true)
	private List<PurchaseRequestLineItem> lineItems;
	private String Description;
    private String Justification;
    private String DeliveryMode;
    private String ReasonForRejection;
	private Date DateNeeded;
	@Column(name="SubmittedDateuser")
	private Date SubmittedDate;
    private Boolean IsActive;
    
	public PurchaseRequest() {}
	
	public void setlineItems(List<PurchaseRequestLineItem> lis) {
		this.lineItems = lis;
	}
	
	public List<PurchaseRequestLineItem> getlineItems(){
//		return this.lineItems;
		return null;
	}
		
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getJustification() {
		return Justification;
	}

	public void setJustification(String justification) {
		Justification = justification;
	}

	public String getDeliveryMode() {
		return DeliveryMode;
	}

	public void setDeliveryMode(String deliveryMode) {
		DeliveryMode = deliveryMode;
	}

	public String getReasonForRejection() {
		return ReasonForRejection;
	}

	public void setReasonForRejection(String reasonForRejection) {
		ReasonForRejection = reasonForRejection;
	}

	public Boolean getIsActive() {
		return IsActive;
	}

	public void setIsActive(Boolean isActive) {
		IsActive = isActive;
	}
	
    public Date getDateNeeded() {
		return DateNeeded;
	}

	public void setDateNeeded(String dateNeeded) {
		DateNeeded = Date.valueOf(LocalDate.parse(dateNeeded));
	}

	public Date getSubmittedDate() {
		return SubmittedDate;
	}

	public void setSubmittedDate() {
		SubmittedDate = Date.valueOf(LocalDate.now());
	}

	@Override
	public String toString() {
		return "PurchaseRequest [id=" + id + ", user=" + user + ", status=" + status
				+ ", Description=" + Description + ", Justification=" + Justification + ", DeliveryMode=" + DeliveryMode
				+ ", ReasonForRejection=" + ReasonForRejection + ", DateNeeded=" + DateNeeded + ", SubmittedDate="
				+ SubmittedDate + ", IsActive=" + IsActive + "]";
	}

	
	
}
