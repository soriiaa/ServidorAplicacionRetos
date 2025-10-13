package com.alejandrogonzalo.ServidorRetos.servicio;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.alejandrogonzalo.ServidorRetos.modelo.Usuario;
import com.alejandrogonzalo.ServidorRetos.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicio {

	private UsuarioRepositorio usuarioRepositorio;
	
	public UsuarioServicio(UsuarioRepositorio usuarioRepositorio) {
		this.usuarioRepositorio = usuarioRepositorio;
	}
	
	public Usuario crearUsuario(Usuario usuario) throws Exception {
		
		Optional<Usuario> usuarioExistente = usuarioRepositorio.findByEmail(usuario.getEmail());
		
		if (usuarioExistente.isPresent()) {
			throw new Exception("El email ya esta en uso");
		} else {
			return usuarioRepositorio.save(usuario);
		}
		
	}
	
}
