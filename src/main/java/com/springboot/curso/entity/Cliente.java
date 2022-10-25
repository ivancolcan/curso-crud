package com.springboot.curso.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	@Column(length = 50)
	private String nombre;
	
	@Column(length = 150)
	private String apellidos;
	
	@NonNull
	@Column(length = 50, unique = true)
	private String email;
	
	@Column(length = 9)
	private String telefono;
	
	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	//@CreatedDate
	//@DateTimeFormat(pattern="dd-MM-yyyy HH:mm:ss")
	//@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createAt;
	
	@PrePersist
    public void onPrePersist() {
		createAt = new Date();
        //audit("INSERT");
    }
     
    @PreUpdate
    public void onPreUpdate() {
        //audit("UPDATE");
    }
     
    @PreRemove
    public void onPreRemove() {
        //audit("DELETE");
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

}
