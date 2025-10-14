package com.alejandrogonzalo.ServidorRetos.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alejandrogonzalo.ServidorRetos.modelo.Usuario;

/**
 * @author alexs
 * 
 * Esta es la clase encargada de hablar con la base de datos
 */
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
	
	public boolean existsByEmail(String email);

}
