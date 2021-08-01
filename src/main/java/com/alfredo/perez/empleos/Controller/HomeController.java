package com.alfredo.perez.empleos.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.alfredo.perez.empleos.model.Perfil;
import com.alfredo.perez.empleos.model.Usuario;
import com.alfredo.perez.empleos.model.Vacante;
import com.alfredo.perez.empleos.service.IntUsuariosService;
import com.alfredo.perez.empleos.service.IntVacanteService;


@Controller
public class HomeController {

	@Autowired
	private IntUsuariosService usuariosService;
	@Autowired
	private IntVacanteService vacantesService;
	
	@GetMapping("/guardar")
	public String guardarUsuario(Usuario usuario) {
		String modificar = "{noop}"+usuario.getPassword();
		usuario.setPassword(modificar);
		System.out.println(usuario);
		usuario.setEstatus(1);
		usuario.setFechaRegistro(LocalDate.now());
		Perfil perfil=new Perfil();
		perfil.setId(3); //Rol-Usuario
		usuario.agregar(perfil);
		usuariosService.guardar(usuario);
		return "formLogin";
		}
	
	@GetMapping("/crear")
	public String crearUsuario(Usuario usuario) {
		return "formRegistro";
	}
	
	@GetMapping("/acerca")
	public String acerca() {
		return "acerca";
	}
	
	@GetMapping("/")
	public String mostrarHome(Model model) {
			List<Vacante> vacantes=vacantesService.todasDestacadas();	
			model.addAttribute("vacantes",vacantes);
		// TODO Auto-generated constructor stub
		return "home";
	}

}
