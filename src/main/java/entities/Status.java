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
public class Status implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(mappedBy="status",fetch=FetchType.EAGER,orphanRemoval = true)
	private List<PurchaseRequest> purchaserequests;
	private String description;
	private int UpdatedByUser;

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
		return UpdatedByUser;
	}

	public void setUpdatedByUser(int updatedByUser) {
		UpdatedByUser = updatedByUser;
	}

	@Override
	public String toString() {
		return "Status [id=" + id + ", description=" + description
				+ ", UpdatedByUser=" + UpdatedByUser + "]";
	}
	
	

}
