package com.alejandrogonzalo.ServidorRetos.modelo;

public class LoginResponse {

	private String accessToken;
	private String refreshToken;
	private Long usuarioId;
	private String nickname;

	public LoginResponse(String accessToken, String refreshToken, Long usuarioId, String nickname) {
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.usuarioId = usuarioId;
		this.nickname = nickname;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public String getNickname() {
		return nickname;
	}

}
