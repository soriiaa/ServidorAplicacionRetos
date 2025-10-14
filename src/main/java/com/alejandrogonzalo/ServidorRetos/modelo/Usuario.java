package com.alejandrogonzalo.ServidorRetos.modelo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nickname;
	private String nombre;
	private String contrasena;
	@Column(name = "fecha_nacimiento")
	private LocalDate fechaNacimiento;
	private String sexo;
	@Column(name = "correo_electronico")
	private String email;
	private String telefono;

	public Long getId() {
		return id;
	}

	public String getNickname() {
		return nickname;
	}

	public String getNombre() {
		return nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefono() {
		return telefono;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
