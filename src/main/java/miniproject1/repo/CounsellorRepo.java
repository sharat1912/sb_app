package miniproject1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import miniproject1.entity.CounsellorEntity;

@Repository
public interface CounsellorRepo extends JpaRepository<CounsellorEntity,Integer> {
	
	

	public CounsellorEntity findByEmail(String email);

	public CounsellorEntity findByEmailAndPwd(String email, String pwd);
	

}
