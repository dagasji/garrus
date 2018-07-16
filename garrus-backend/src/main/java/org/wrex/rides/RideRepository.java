package org.wrex.rides;

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

	@Query("select ride from Ride ride where "
			+ "	(:plate is null or ride.plate = :plate) and "
			+ "	(:rutChofer is null or ride.rutChofer = :rutChofer)  and "
			+ "	(:dateStart is null or ride.start >= :dateStart) and "
			+ "	(:dateEnd is null or ride.end <= :dateEnd)"
			+ " order by ride.start DESC")
	List<Ride> findByOptionalParameter(@Param("plate") String plate, @Param("rutChofer") String rutChofer,
									   @Param("dateStart") Date dateStart, @Param("dateEnd") Date dateEnd);
	
}
