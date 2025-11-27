package com.alejandrogonzalo.ServidorRetos.servicio;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;

import com.alejandrogonzalo.ServidorRetos.exception.CredencialesInvalidasException;
import com.alejandrogonzalo.ServidorRetos.exception.EmailExistenteException;
import com.alejandrogonzalo.ServidorRetos.exception.NicknameExistenteException;
import com.alejandrogonzalo.ServidorRetos.modelo.LoginRequest;
import com.alejandrogonzalo.ServidorRetos.modelo.LoginResponse;
import com.alejandrogonzalo.ServidorRetos.modelo.Usuario;
import com.alejandrogonzalo.ServidorRetos.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicio {

	private UsuarioRepositorio usuarioRepositorio;
	private Argon2PasswordEncoder passwordEncoder;

	public UsuarioServicio(UsuarioRepositorio usuarioRepositorio, Argon2PasswordEncoder passwordEncoder) {
		this.usuarioRepositorio = usuarioRepositorio;
		this.passwordEncoder = passwordEncoder;
	}

	/**
	 * 
	 * @author Alejandro Soria
	 * @param usuario Es el objeto usuario que viene dado por la transformación que
	 *                hace spring boot del JSON.
	 * @return El objeto de la clase usuario que ha sido guardado en la base de
	 *         datos.
	 */
	public Usuario crearUsuario(Usuario usuario) {

		boolean existeElEmail = usuarioRepositorio.existsByEmail(usuario.getEmail());
		boolean existeNickname = usuarioRepositorio.existsByNickname(usuario.getNickname());

		if (existeElEmail) {
			throw new EmailExistenteException("El email ya esta en uso.");
		} else if (existeNickname) {
			throw new NicknameExistenteException("El nickname ya está en uso.");
		} else {
			String contrasenaHasheada = passwordEncoder.encode(usuario.getContrasena());
			usuario.setContrasena(contrasenaHasheada);
			return usuarioRepositorio.save(usuario);
		}

	}

	public LoginResponse login(LoginRequest request) {

		Usuario usuario = usuarioRepositorio.findByEmail(request.getEmail())
				.orElseThrow(CredencialesInvalidasException::new);

		boolean contrasenaCorrecta = passwordEncoder.matches(request.getContrasena(), usuario.getContrasena());

		if (!contrasenaCorrecta) {
			throw new CredencialesInvalidasException();
		}

		String token = jwtUtil.generarToken(request.getEmail());

		return new LoginResponse(token, usuario.getId(), usuario.getNickname());
	}

}
