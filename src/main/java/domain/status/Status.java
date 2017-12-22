package domain.status;

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

import domain.purchaserequest.PurchaseRequest;

@SuppressWarnings("serial")
@Entity
public class Status implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(mappedBy="status",fetch=FetchType.EAGER,orphanRemoval = true)
	@JsonIgnore
	private List<PurchaseRequest> purchaserequests;
	@JsonProperty("Description")
	@Column(name="Description")
	private String description;
	@JsonProperty("UpdatedByUser")
	@Column(name="UpdatedByUser")
	private int updatedByUser;

	Status() {
		description = "";
	}
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUpdatedByUser() {
		return updatedByUser;
	}

	public void setUpdatedByUser(int UpdatedByUser) {
		updatedByUser = UpdatedByUser;
	}

	@Override
	public String toString() {
		return "Status [id=" + id + ", description=" + description
				+ ", UpdatedByUser=" + updatedByUser + "]";
	}
	
	

}
