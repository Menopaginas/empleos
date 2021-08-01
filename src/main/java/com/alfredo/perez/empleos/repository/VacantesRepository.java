package com.alfredo.perez.empleos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alfredo.perez.empleos.model.Vacante;

public interface VacantesRepository extends JpaRepository<Vacante, Integer> {

	//List<Vacante> findByDestacadoAndEstatusOrderByIdDesc(Integer Destacado,String estatus);
	
	@Query(value="SELECT * FROM vacantes WHERE destacado= 1\r\n"
			+ "AND estatus = 'Aprobada' ORDER BY id",nativeQuery=true)
	List<Vacante> obtenerTodasDestacadas();
}
