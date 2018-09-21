package org.garrus.driver.leave;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface LeaveRepository extends CrudRepository<Leave,Integer>{

	@Query("select leave from Leave leave where (leave.start <= :dateStart) and (leave.end >= :dateEnd)")
	List<Leave> findLeavesBetweenDates(@Param("dateStart") Date start, @Param("dateEnd") Date end);
	
	List<Leave> findByRutOrderByStartDesc(String rut);
}
