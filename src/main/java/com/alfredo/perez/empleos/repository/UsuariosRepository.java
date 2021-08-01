package com.alfredo.perez.empleos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alfredo.perez.empleos.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

	//metodo personalizado con sql nativo
    @Query(value="select count(*) from usuarios", nativeQuery = true)
    Integer totalEntidades();
}
