package miniproject1.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import miniproject1.entity.CounsellorEntity;
import miniproject1.entity.EnquiryEntity;

@Repository
public interface EnquiryRepo extends JpaRepository<EnquiryEntity ,Integer> {
	
	
//@Query(value="select * from counsellorEntity where counsellor_id=:counsellorId",nativeQuery =true)
//public List<EnquiryEntity> getEnquiries(Integer CounsellorId);
	
@Query(value ="select count(*) from EnquiryEntity where counsellor_id =:id",nativeQuery =true)
public Long getEnquries(Integer id); //total enquires


@Query(value ="select count(*) from EnquiryEntity where counsellor_id =:id and status=:status",nativeQuery =true)
public Long getOpenEnquiries (@Param("id")Integer id ,@Param("status") String status); //enquires based on counsellor id and status

}
