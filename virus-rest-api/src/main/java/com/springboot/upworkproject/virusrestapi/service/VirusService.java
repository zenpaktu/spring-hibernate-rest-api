package com.springboot.upworkproject.virusrestapi.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.springboot.upworkproject.virusrestapi.model.Virus;

public interface VirusService {

	List<Virus> getAllVirus();
	
	Virus getVirusById(long virusId);
	
	Virus createVirus(Virus virus);

	HttpStatus updateVirus(Virus virus);

	HttpStatus deleteVirus(long id);
}
