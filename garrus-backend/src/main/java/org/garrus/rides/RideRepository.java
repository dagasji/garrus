package org.garrus.rides;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * <p>
 * Title: UserDao
 * </p>
 *
 * <p>
 * Description: Interface of a Data access object dealing with UserDao
 * persistence. It offers a set of methods which allow for saving, deleting and
 * searching user objects
 * </p>
 *
 */
public interface RideRepository extends CrudRepository<Ride, Integer> {

	/**
	 * Find rides by given parameters. dateEndAfter and dateStartBefore means the ride is active in that lapse of time: 
	 * start or end of the ride can be outside this parameters. See this date query as non exclusive. 
	 * 
	 * @param plate. Plate of the vehicle. If null all vehicles are considered;
	 * @param rutChofer Rut of the driver.  If null all vehicles are considered;
	 * @param dateEndAfter Ride end after this date. 
	 * @param dateStartBefore Ride must start before this date. 
	 * @return
	 */
	@Query("select ride from Ride ride where "
			+ "	(:plate is null or ride.plate = :plate) and "
			+ "	(:rutChofer is null or ride.rutChofer = :rutChofer)  and "
			+ "	(:dateEnd is null or ride.start <= :dateEnd) and "
			+ "	(:dateStart is null or ride.end >= :dateStart)"
			+ " order by ride.start DESC")
	List<Ride> findByOptionalParameter(@Param("plate") String plate, @Param("rutChofer") String rutChofer,
									   @Param("dateStart") Date dateEndAfter, @Param("dateEnd") Date dateStartBefore);
	
	List<Ride> findByEndBeforeOrderByStartDesc(Date end);
	
}
