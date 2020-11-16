package com.springboot.upworkproject.virusrestapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "symptons")
public class Symptoms {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idSymptoms;
	
	@NotNull
	@Size(min = 2, max = 48)
	@Column(name = "symptomName")
	private String symptomName;
	
	@NotNull
	@Size(min = 4, max = 48)
	@Column(name = "description")
	private String description;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idVirus", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
    private Virus virus;

	public Symptoms() {
		// TODO Auto-generated constructor stub
	}

	public Symptoms(Long idSymptoms, String symptomName, String description, Virus virus) {
		super();
		this.idSymptoms = idSymptoms;
		this.symptomName = symptomName;
		this.description = description;
		this.virus = virus;
	}
	
	public Symptoms(String symptomName, String description) {
		super();
		this.symptomName = symptomName;
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Symptoms ID:" + idSymptoms + "\n" + "Symptom Name:" + symptomName 
				+ "\n" + "Description:"+ description;
	}

	public Long getIdSymptoms() {
		return idSymptoms;
	}

	public void setIdSymptoms(Long idSymptoms) {
		this.idSymptoms = idSymptoms;
	}

	public String getSymptomName() {
		return symptomName;
	}

	public void setSymptomName(String symptomName) {
		this.symptomName = symptomName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Virus getVirus() {
		return virus;
	}

	public void setVirus(Virus virus) {
		this.virus = virus;
	}
	
}
