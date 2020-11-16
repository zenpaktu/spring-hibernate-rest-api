package com.springboot.upworkproject.virusrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.upworkproject.virusrestapi.exception.DataNotFoundException;
import com.springboot.upworkproject.virusrestapi.model.Virus;
import com.springboot.upworkproject.virusrestapi.repository.VirusRepository;

@Service
@Transactional
public class VirusServiceImpl implements VirusService {
	
	@Autowired
	VirusRepository virusRep;

	@Override
	public List<Virus> getAllVirus() {
		return virusRep.findAll();
	}

	@Override
	public Virus getVirusById(long virusID) {
		Optional<Virus> queryResult = virusRep.findById(virusID);
		
		if(!queryResult.isPresent()) {
			throw new DataNotFoundException("id", String.valueOf(virusID), "Virus");
		}
		
		return queryResult.get();
	}

	@Override
	public Virus createVirus(Virus virus) {
		return virusRep.save(virus);
	}

	@Override
	public HttpStatus updateVirus(Virus virus) {
		int rowsAffected = virusRep.updateVirus(virus.getIdVirus(), virus.getName(), virus.getYearDiscovered());
		if(!(rowsAffected > 0)) {
			throw new DataNotFoundException("id", String.valueOf(virus.getIdVirus()), "Virus");
		}
		return HttpStatus.OK;
	}

	@Override
	public HttpStatus deleteVirus(long id) {
		int rowsAffected = virusRep.deleteVirus(id);
		
		if(!(rowsAffected > 0)) {
			throw new DataNotFoundException("id", String.valueOf(id), "Virus");
		}
		
		return HttpStatus.OK;
		
	}

}
