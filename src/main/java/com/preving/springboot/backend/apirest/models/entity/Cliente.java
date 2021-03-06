package com.preving.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.web.bind.annotation.PutMapping;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id; //Estos decoradores sirven para decir que en la BBDD
																			 //el id es CP
	private String nombre;
	private String apellido;
	private String email;
	@Column(name = "created_at") @Temporal(TemporalType.DATE) private Date createdAt;
	
	@PrePersist
	public void prePersist() {
		createdAt = new Date();
	}	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	private static final long serialVersionUID = 1L;

}
