package com.alejandrogonzalo.ServidorRetos.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "refresh_tokens")
public class RefreshToken {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "id_usuario", nullable = false)
	private Long idUsuario;

	@Column(name = "token_hash", nullable = false)
	private String tokenHash;

	@Column(name = "expiracion", nullable = false)
	private LocalDateTime expiracion;

	@Column(name = "dispositivo")
	private String dispositivo;

	@Column(name = "creado_en", updatable = false)
	private LocalDateTime creadoEn = LocalDateTime.now();

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setTokenHash(String tokenHash) {
		this.tokenHash = tokenHash;
	}

	public void setExpiracion(LocalDateTime expiracion) {
		this.expiracion = expiracion;
	}

	public void setDispositivo(String dispositivo) {
		this.dispositivo = dispositivo;
	}

}
