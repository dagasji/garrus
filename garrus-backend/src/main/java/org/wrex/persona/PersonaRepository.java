package org.wrex.persona;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PersonaRepository extends CrudRepository<Persona,String>{

//	@Query("select per from Persona per where per.rut like %:param% or per.nombre like %:param%" )
//	List<Persona> findByRutLikeOrNameLike(@Param("param") String param);
	
	List<Persona> findByRunContainingOrNombreIgnoreCaseContainingOrDireccionIgnoreCaseContaining(String rut,String nombre, String Direccion);
}
