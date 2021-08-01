package com.alfredo.perez.empleos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alfredo.perez.empleos.model.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {

}
