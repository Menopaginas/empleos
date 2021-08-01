package com.alfredo.perez.empleos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.alfredo.perez.empleos.model.Categoria;
import com.alfredo.perez.empleos.repository.CategoriasRepository;

@Service
@Primary
public class CategoriaServiceJpa implements IntCategoriaService {

	@Autowired
	private CategoriasRepository repoCategorias;
		// TODO Auto-generated constructor s
	@Override
	public List<Categoria> obtenerTodas() {
		// TODO Auto-generated method stub
		return repoCategorias.findAll();
	}

	@Override
	public void guardar(Categoria categoria) {
		// TODO Auto-generated method stub
			repoCategorias.save(categoria);
	}

	@Override
	public void eliminar(Integer idCategoria) {
		// TODO Auto-generated method stub
		repoCategorias.deleteById(idCategoria);
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		// TODO Auto-generated method stub
		Optional <Categoria> optional= repoCategorias.findById(idCategoria);
		if(optional.isPresent()) {
			return optional.get();
			}
		else{
			return null;
			}
		}

	@Override
	public Page<Categoria> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return repoCategorias.findAll(page);
	}

}
