package in.sai.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PalnInsuranceEntity {
    @Id
	private Integer planId;
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlanHolderName() {
		return planHolderName;
	}
	public void setPlanHolderName(String planHolderName) {
		this.planHolderName = planHolderName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String planName;
	private String planHolderName;
	private String status;
	

}
