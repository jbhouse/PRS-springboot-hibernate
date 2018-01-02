package domain.purchaserequest;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import domain.status.Status;
import domain.user.User;

@SuppressWarnings("serial")
@Entity
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
	@JsonIgnore
	private List<PurchaseRequestLineItem> lineItems;
	@JsonProperty("Description")
	@Column(name="Description")
	private String description;
	@JsonProperty("Justification")
	@Column(name="Justification")
    private String justification;
	@JsonProperty("DeliveryMode")
	@Column(name="DeliveryMode")
    private String deliveryMode;
	@JsonProperty("ReasonForRejection")
	@Column(name="ReasonForRejection")
    private String reasonForRejection;
	@JsonProperty("DateNeeded")
	@Column(name="DateNeeded")
	private Date dateNeeded;
	@Column(name="SubmittedDate")
	@JsonProperty("SubmittedDate")
	private Date submittedDate;
	@JsonProperty("IsActive")
	@Column(name="IsActive")
    private Boolean isActive;
    
	public PurchaseRequest() {}
	
	public void setlineItems(List<PurchaseRequestLineItem> lis) {
		this.lineItems = lis;
	}
	
	public List<PurchaseRequestLineItem> getlineItems(){
		return this.lineItems;
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
		return description;
	}

	public void setDescription(String Description) {
		description = Description;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String Justification) {
		justification = Justification;
	}

	public String getDeliveryMode() {
		return deliveryMode;
	}

	public void setDeliveryMode(String DeliveryMode) {
		deliveryMode = DeliveryMode;
	}

	public String getReasonForRejection() {
		return reasonForRejection;
	}

	public void setReasonForRejection(String ReasonForRejection) {
		reasonForRejection = ReasonForRejection;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean IsActive) {
		isActive = IsActive;
	}
	
    public Date getDateNeeded() {
		return dateNeeded;
	}

	public void setDateNeeded(String DateNeeded) {
		dateNeeded = Date.valueOf(LocalDate.parse(DateNeeded));
	}

	public Date getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate() {
		submittedDate = Date.valueOf(LocalDate.now());
	}

	@Override
	public String toString() {
		return "PurchaseRequest [id=" + id + ", user=" + user + ", status=" + status
				+ ", Description=" + description + ", Justification=" + justification + ", DeliveryMode=" + deliveryMode
				+ ", ReasonForRejection=" + reasonForRejection + ", DateNeeded=" + dateNeeded + ", SubmittedDate="
				+ submittedDate + ", IsActive=" + isActive + "]";
	}

	
	
}
