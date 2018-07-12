package org.wrex.vehicles;

import java.util.List;

public interface VehicleService {

	List<VehicleDTO> getAll();

	VehicleDTO load(String plate);

	void save(VehicleDTO ve);

	long countAll();

	void delete(String plate);

	void addEntry(EntryDTO entry);
	
	void deleteEntry(int entryId);
	
	List<EntryDTO> getEntries(String plate);
}
