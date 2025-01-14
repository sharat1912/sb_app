package miniproject1.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class CounsellorEntity {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int counsellorId;
	
	public CounsellorEntity(int counsellorId, String name, String pwd, String email, Long mobileNum,
			LocalDate createdDate, LocalDate updatedDate, List<EnquiryEntity> enquiries) {
		this.counsellorId = counsellorId;
		this.name = name;
		this.pwd = pwd;
		this.email = email;
		this.mobileNum = mobileNum;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.enquiries = enquiries;
	}

	private String name;
	
	
	
	private String pwd;
	
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public CounsellorEntity(int counsellorId, String name, String email, Long mobileNum, LocalDate createdDate,
			LocalDate updatedDate ,String pwd) {
		super();
		this.counsellorId = counsellorId;
		this.name = name;
		this.email = email;
		this.mobileNum = mobileNum;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.pwd =pwd;
	}

	public int getCounsellorId() {
		return counsellorId;
	}

	public List<EnquiryEntity> getEnquiries() {
		return enquiries;
	}

	public void setEnquiries(List<EnquiryEntity> enquiries) {
		this.enquiries = enquiries;
	}

	public void setCounsellorId(int counsellorId) {
		this.counsellorId = counsellorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(Long mobileNum) {
		this.mobileNum = mobileNum;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	private String email;
	
	private Long mobileNum;
	
	@CreationTimestamp
	private LocalDate createdDate;
	
    @UpdateTimestamp
	private LocalDate updatedDate;
    
    @OneToMany(mappedBy="counsellor",cascade=CascadeType.ALL)
    private List <EnquiryEntity> enquiries;
    
    public CounsellorEntity() {
    	
    }
    
	
}


















