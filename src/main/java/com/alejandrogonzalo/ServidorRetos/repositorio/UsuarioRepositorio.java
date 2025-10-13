package com.alejandrogonzalo.ServidorRetos.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alejandrogonzalo.ServidorRetos.modelo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {
	
	Optional<Usuario> findByEmail(String email);

}
