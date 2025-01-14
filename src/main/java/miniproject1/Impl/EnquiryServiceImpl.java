package miniproject1.Impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;


import miniproject1.dto.DashboardDto;
import miniproject1.entity.CounsellorEntity;
import miniproject1.entity.EnquiryEntity;
import miniproject1.repo.CounsellorRepo;
import miniproject1.repo.EnquiryRepo;
import miniproject1.service.EnquiryService;

@Service
public class EnquiryServiceImpl implements EnquiryService{
	
	@Autowired
	private EnquiryRepo enqRepo;
	
	@Autowired
	private CounsellorRepo counrepo;

	@Override
	public DashboardDto getDashboard(Integer counsellorId) {
	Long totalenq = enqRepo.getEnquries(counsellorId);
	Long openCount = enqRepo.getOpenEnquiries(counsellorId, "open");
	Long LostCount =enqRepo.getOpenEnquiries(counsellorId, "Lost");
	Long enrolledCount = enqRepo.getOpenEnquiries(counsellorId, "Enrolled");
	
	DashboardDto d = new DashboardDto();
	d.setTotalEnqs(totalenq);
	d.setOpenEnqs(openCount);
	d.setLostEnqs(LostCount);
	d.setEnrolleEnqs(enrolledCount);
	
		return d;
	}

	@Override
	public boolean addEnquiry(EnquiryEntity enquiry,Integer counsellorId) {
		
		CounsellorEntity counsellor = counrepo.findById(counsellorId).orElseThrow();
		enquiry.setCounsellor(counsellor); //association for foreign key
		EnquiryEntity savedEnq = enqRepo.save(enquiry);
		
		return savedEnq.getEnqId()!=0;
	}

	@Override 
	public List<EnquiryEntity> getEnquiries(EnquiryEntity enquiry, Integer counsellorId) {
		
		CounsellorEntity counsellor =counrepo.findById(counsellorId).orElseThrow();
		enquiry.setCounsellor(counsellor);
		Example<EnquiryEntity> of  = Example.of(enquiry); //dynamic query creation based on logic
		return enqRepo.findAll(of);
	}

	@Override
	public EnquiryEntity getEnquiry(Integer enqId) {
		return enqRepo.findById(enqId).orElseThrow();
	}

}
