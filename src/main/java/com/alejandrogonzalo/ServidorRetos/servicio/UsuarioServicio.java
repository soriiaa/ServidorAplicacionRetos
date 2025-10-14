package com.alejandrogonzalo.ServidorRetos.servicio;

import org.springframework.stereotype.Service;

import com.alejandrogonzalo.ServidorRetos.exception.EmailExistenteException;
import com.alejandrogonzalo.ServidorRetos.exception.NicknameExistenteException;
import com.alejandrogonzalo.ServidorRetos.modelo.Usuario;
import com.alejandrogonzalo.ServidorRetos.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicio {

	private UsuarioRepositorio usuarioRepositorio;

	public UsuarioServicio(UsuarioRepositorio usuarioRepositorio) {
		this.usuarioRepositorio = usuarioRepositorio;
	}

	/**
	 * 
	 * @author Alejandro Soria
	 * @param usuario Es el objeto usuario que viene dado por la transformación que hace spring boot del JSON.
	 * @return El objeto de la clase usuario que ha sido guardado en la base de datos.
	 */
	public Usuario crearUsuario(Usuario usuario) {

		boolean existeElEmail = usuarioRepositorio.existsByEmail(usuario.getEmail());
		boolean existeNickname = usuarioRepositorio.existsByNickname(usuario.getNickname());

		if (existeElEmail) {
			throw new EmailExistenteException("El email ya esta en uso.");
		} else if (existeNickname) {
			throw new NicknameExistenteException("El nickname ya está en uso.");
		} else {
			return usuarioRepositorio.save(usuario);
		}

	}
}
