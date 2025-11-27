package com.alejandrogonzalo.ServidorRetos.modelo;

public class LoginResponse {

	private String token;
	private Long usuarioId;
	private String nickname;

	public LoginResponse(String token, Long usuarioId, String nickname) {
		this.token = token;
		this.usuarioId = usuarioId;
		this.nickname = nickname;
	}

	public String getToken() {
		return token;
	}
	
	public Long getUsuarioId() {
		return usuarioId;
	}
	
	public String getNickname() {
		return nickname;
	}

}
