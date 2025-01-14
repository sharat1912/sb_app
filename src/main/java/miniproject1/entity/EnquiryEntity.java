package miniproject1.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class EnquiryEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int enqId;
	
	private String name;
	
	private Long studentMobileNum;
	 
	public EnquiryEntity(int enqId, String name, Long studentMobileNum, String classMode, String courseName,
			String status, LocalDate createdDate, LocalDate updatedDate) {
		super();
		this.enqId = enqId;
		this.name = name;
		this.studentMobileNum = studentMobileNum;
		this.classMode = classMode;
		this.courseName = courseName;
		this.status = status;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public int getEnqId() {
		return enqId;
	}

	public void setEnqId(int enqId) {
		this.enqId = enqId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public EnquiryEntity() {
		
	}

	public Long getStudentMobileNum() {
		return studentMobileNum;
	}

	public void setStudentMobileNum(Long studentMobileNum) {
		this.studentMobileNum = studentMobileNum;
	}

	public String getClassMode() {
		return classMode;
	}

	public void setClassMode(String classMode) {
		this.classMode = classMode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	private String classMode;
	
	private String courseName;
	
	private String status;
	
	@CreationTimestamp
	private LocalDate createdDate;
	
	@UpdateTimestamp
	private LocalDate updatedDate;
		
	@ManyToOne
	@JoinColumn(name = "counsellor_id") //Many enquries belong to one counsellor
	private CounsellorEntity counsellor;

	public CounsellorEntity getCounsellor() {
		return counsellor;
	}

	public void setCounsellor(CounsellorEntity counsellor) {
		this.counsellor = counsellor;
	}
	
}
