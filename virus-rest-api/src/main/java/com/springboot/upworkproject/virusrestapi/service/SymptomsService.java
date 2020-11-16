package com.springboot.upworkproject.virusrestapi.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.springboot.upworkproject.virusrestapi.model.Symptoms;

public interface SymptomsService {
	
	List<Symptoms> getAllVirusSymptoms(long id_Virus);
	
	Symptoms getSymptomsById(long id_Virus);

	Symptoms createVirusSymptoms(long id_Virus, Symptoms symptom);
	
	String createdummy(long id_Virus, Symptoms symptom);
	
	HttpStatus updateSymptoms(Symptoms symptoms);
	
	HttpStatus deleteSymptoms(long id);
}
