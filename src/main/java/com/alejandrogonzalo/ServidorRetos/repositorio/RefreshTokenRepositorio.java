package com.alejandrogonzalo.ServidorRetos.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alejandrogonzalo.ServidorRetos.modelo.RefreshToken;

public interface RefreshTokenRepositorio extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByIdUsuario(Long idUsuario);
    void deleteByIdUsuario(Long idUsuario);
}
