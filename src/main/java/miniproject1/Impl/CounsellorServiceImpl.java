package miniproject1.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miniproject1.entity.CounsellorEntity;
import miniproject1.repo.CounsellorRepo;
import miniproject1.service.CounsellorService;


@Service
public class CounsellorServiceImpl implements CounsellorService{
	
	@Autowired
	private CounsellorRepo repo;

	@Override
	public boolean saveCounsellor(CounsellorEntity counsellor) {
		CounsellorEntity findByEmail = repo.findByEmail(counsellor.getEmail());
		if(findByEmail !=null) {
			return false; 
		} else {
	    CounsellorEntity savedCounsellor = repo.save(counsellor);
	    return savedCounsellor.getCounsellorId() != 0;
	}
	}
	
	@Override
	public CounsellorEntity getCounsellor(String email, String pwd) {
		return repo.findByEmailAndPwd(email, pwd);
		
		
	}

}
