package com.alejandrogonzalo.ServidorRetos.modelo;

public class LoginRequest {

	private String email;
	private String contrasena;
	private String dispositivo;
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getContrasena() {
		return contrasena;
	}
	
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public String getDispositivo() {
		return dispositivo;
	}
	
	public void setDispositivo(String dispositivo) {
		this.dispositivo = dispositivo;
	}
	
}
