package com.prueba.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "register_table")
public class Register {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "register_id")
	private Long registerId;
	
	@Column(name = "registro_data", nullable = false)
	private String registerData;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "file_id_fk",nullable = false)
	private File file;
	
	public Register() {
		
	}

	private Register(String registerData) {
		this.registerData = registerData;
	}
	
	public static Register createRegister(String registerData) {
		return new Register(registerData);
	}

	public Long getRegisterId() {
		return registerId;
	}

	public void setRegisterId(Long registerId) {
		this.registerId = registerId;
	}

	public String getRegisterData() {
		return registerData;
	}

	public void setRegisterData(String registerData) {
		this.registerData = registerData;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File fileId) {
		this.file = fileId;
	}
	
}
