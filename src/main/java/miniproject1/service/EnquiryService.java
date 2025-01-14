package miniproject1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import miniproject1.dto.DashboardDto;
import miniproject1.entity.EnquiryEntity;

@Service
public interface EnquiryService {
	
	
	public DashboardDto getDashboard(Integer counsellorId); //used to Dash-board based on counsellorId
	
	public boolean addEnquiry(EnquiryEntity enquiry,Integer counsellorId); //whether we can add data or not
	
	public List<EnquiryEntity> getEnquiries(EnquiryEntity enquiry,Integer counsellorId); //(drop down)this is used for filter on what basis should get data retrieved
	
	public EnquiryEntity getEnquiry(Integer enqId); //this is for edit method

}
