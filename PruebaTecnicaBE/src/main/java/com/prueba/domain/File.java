package com.prueba.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "file_table")
public class File {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "file_id", nullable = false)
	private Long fileId;

	@Column(name = "name_file", nullable = false)
	private String nameFile;

	@Column(name = "total_col", nullable = false)
	private int totalCol;

	@Column(name = "name_col", nullable = false)
	private String nameCol;

	@Column(name = "total_registers", nullable = false)
	private int totalRegisters;

	@OneToMany(mappedBy = "file")
	@JsonIgnore
	private List<Register> registers;

	
	public File() {
	
	}

	private File(String nameFile, int totalCol, String nameCol, int totalRegisters) {
		this.nameFile = nameFile;
		this.totalCol = totalCol;
		this.nameCol = nameCol;
		this.totalRegisters = totalRegisters;
	}
	
	public static File createFile(String nameFile, int totalCol, String nameCol, int totalRegisters) {
		return new File(nameFile, totalCol, nameCol, totalRegisters);
	}
	
	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public String getNameFile() {
		return nameFile;
	}


	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}


	public int getTotalCol() {
		return totalCol;
	}


	public void setTotalCol(int totalCol) {
		this.totalCol = totalCol;
	}


	public String getNameCol() {
		return nameCol;
	}


	public void setNameCol(String nameCol) {
		this.nameCol = nameCol;
	}


	public int getTotalRegisters() {
		return totalRegisters;
	}


	public void setTotalRegisters(int totalRegisters) {
		this.totalRegisters = totalRegisters;
	}


	public List<Register> getRegisters() {
		return registers;
	}


	public void setRegisters(List<Register> registers) {
		this.registers = registers;
	}


}
