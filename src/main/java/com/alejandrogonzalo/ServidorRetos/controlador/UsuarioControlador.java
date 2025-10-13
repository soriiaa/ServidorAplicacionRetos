package com.alejandrogonzalo.ServidorRetos.controlador;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alejandrogonzalo.ServidorRetos.modelo.Usuario;
import com.alejandrogonzalo.ServidorRetos.servicio.UsuarioServicio;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioControlador {
	
	private UsuarioServicio usuarioServicio;
	
	public UsuarioControlador(UsuarioServicio usuarioServicio) {
		this.usuarioServicio = usuarioServicio;
	}
	
	@PostMapping
	public Usuario crearUsuario(@RequestBody Usuario usuario) throws Exception {
		System.out.println("Usuario Creado //////////////////////////////////////////////////////////");
		return usuarioServicio.crearUsuario(usuario);
	}

}
