package com.alejandrogonzalo.ServidorRetos.config.SecurityConfig;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {

	@Value("${JWT_SECRET}")
	private String SECRET_KEY;

	// 2 Horas de tiempo de expiración del token jwp
	// 14 días de tiempo de expiración del token refresh
	private final long ACCESS_TOKEN_EXPIRATION = 1000 * 60 * 60 * 2;
	private final long REFRESH_TOKEN_EXPIRATION = 1000 * 60 * 60 * 24 * 14;

	// En este método transformo el string de la clave en un objeto de la clase key
	// para que el jwts pueda procesarlo
	private Key getSigningKey() {
		return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
	}

	public String generarAccessToken(String email) {
		return Jwts.builder().setSubject(email) // El token es del usuario al que pertenece el email
				.setIssuedAt(new Date()) // Marca cuando se ha creado el token
				.setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_EXPIRATION))
				.signWith(getSigningKey(), SignatureAlgorithm.HS256) // Firmamos con la clave y algoritmo HS256
				.compact();
	}

}
