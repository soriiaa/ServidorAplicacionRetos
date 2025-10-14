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
	
	/**
	 * @author Alejandro Soria
	 * @param usuario El objeto usuario que spring boot ha creado a partir del JSON de la peticion http.
	 * @return El objeto de la clase Usuario que ha sido guardado en la base de datos.
	 * @throws EmailExistenteException Devuelve un código 409 cuando el email ya existía en la base de datos.
	 */
	@PostMapping
	public Usuario crearUsuario(@RequestBody Usuario usuario) {
		return usuarioServicio.crearUsuario(usuario);
	}

}
