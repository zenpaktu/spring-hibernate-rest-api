package com.springboot.upworkproject.virusrestapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.springboot.upworkproject.virusrestapi.customvalidator.ValidYearConstraint;

@Entity
@Table(name = "viruses")
public class Virus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idVirus;
	
	@NotNull
	@Size(min = 2, max = 48)
	@Column(unique=true, name = "name")
	private String name;
	
	
	@NotNull
	@ValidYearConstraint
	@Column(name = "yearDiscovered")
	private String yearDiscovered;

	public Virus(String name, String yearDiscovered) {
		super();
		this.name = name;
		this.yearDiscovered = yearDiscovered;
	}

	public Virus() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdVirus() {
		return idVirus;
	}

	public void setIdVirus(Long idVirus) {
		this.idVirus = idVirus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYearDiscovered() {
		return yearDiscovered;
	}

	public void setYearDiscovered(String dateDiscovered) {
		this.yearDiscovered = dateDiscovered;
	}
	
	@Override
	public String toString() {
		return "Virus ID:" + idVirus + "\n" + "Virus Name:" + name + "\n" + "Date Discovered:"+yearDiscovered;
	}

}
