package com.alejandrogonzalo.ServidorRetos.servicio;

import org.springframework.stereotype.Service;

import com.alejandrogonzalo.ServidorRetos.exception.EmailExistenteException;
import com.alejandrogonzalo.ServidorRetos.modelo.Usuario;
import com.alejandrogonzalo.ServidorRetos.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicio {

	private UsuarioRepositorio usuarioRepositorio;

	public UsuarioServicio(UsuarioRepositorio usuarioRepositorio) {
		this.usuarioRepositorio = usuarioRepositorio;
	}

	public Usuario crearUsuario(Usuario usuario) {

		boolean existeElEmail = usuarioRepositorio.existsByEmail(usuario.getEmail());

		if (existeElEmail) {
			throw new EmailExistenteException("El email ya esta en uso.");
		} else {
			return usuarioRepositorio.save(usuario);
		}

	}
}
