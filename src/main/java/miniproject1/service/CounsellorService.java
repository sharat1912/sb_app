package miniproject1.service;

import org.springframework.stereotype.Service;

import miniproject1.entity.CounsellorEntity;

@Service
public interface CounsellorService {
	
	//registration	
	public boolean saveCounsellor(CounsellorEntity counsellor);
	
	//login
	public CounsellorEntity getCounsellor(String email ,String pwd);

}
