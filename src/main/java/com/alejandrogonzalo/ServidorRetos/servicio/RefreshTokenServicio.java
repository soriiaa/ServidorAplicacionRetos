package com.alejandrogonzalo.ServidorRetos.servicio;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.alejandrogonzalo.ServidorRetos.modelo.RefreshToken;
import com.alejandrogonzalo.ServidorRetos.repositorio.RefreshTokenRepositorio;

@Service
public class RefreshTokenServicio {

	private final RefreshTokenRepositorio refreshTokenRepositorio;

	public RefreshTokenServicio(RefreshTokenRepositorio refreshTokenRepositorio) {
        this.refreshTokenRepositorio = refreshTokenRepositorio;
    }

	public void guardarRefreshToken(Long usuarioId, String tokenHash, String dispositivo) {

		refreshTokenRepositorio.deleteByIdUsuario(usuarioId);
		
		RefreshToken refreshToken = new RefreshToken();
		refreshToken.setIdUsuario(usuarioId);
		refreshToken.setTokenHash(tokenHash);
		refreshToken.setExpiracion(LocalDateTime.now().plusDays(14));
		refreshToken.setDispositivo(dispositivo);

		refreshTokenRepositorio.save(refreshToken);
	}
}