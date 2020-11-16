package com.springboot.upworkproject.virusrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.upworkproject.virusrestapi.exception.DataNotFoundException;
import com.springboot.upworkproject.virusrestapi.model.Symptoms;
import com.springboot.upworkproject.virusrestapi.repository.SymptomsRepository;

@Service
@Transactional
public class SymptomsServiceImpl implements SymptomsService{
	
	@Autowired
	private SymptomsRepository sympRep;
	
	@Autowired
	VirusService virusSvc; 

	@Override
	public List<Symptoms> getAllVirusSymptoms(long id_Virus) {
		return sympRep.findByVirus(virusSvc.getVirusById(id_Virus));
	}

	@Override
	public Symptoms getSymptomsById(long idSymptoms) {
		Optional<Symptoms> queryResult = sympRep.findById(idSymptoms);
		
		if(!queryResult.isPresent()) {
			throw new DataNotFoundException("id", String.valueOf(idSymptoms), "Symptoms");
		}
		
		return queryResult.get();
	}

	@Override
	public Symptoms createVirusSymptoms(long id_Virus, Symptoms symptom) {
		symptom.setVirus(virusSvc.getVirusById(id_Virus));
//		return symptom;
		return sympRep.save(symptom);
	}

	@Override
	public HttpStatus updateSymptoms(Symptoms symptoms) {
		symptoms.setVirus(getSymptomsById(symptoms.getIdSymptoms()).getVirus());
		sympRep.save(symptoms);
		
		return HttpStatus.OK;
	}

	@Override
	public HttpStatus deleteSymptoms(long id) {
		int rowsAffected = sympRep.deleteByIdSymptoms(id);
		
		if(!(rowsAffected > 0)) {
			throw new DataNotFoundException("id", String.valueOf(id), "Symptoms");
		}
		
		return HttpStatus.OK;
	}

	@Override
	public String createdummy(long id_Virus, Symptoms symptom) {
		// TODO Auto-generated method stub
		return "test string" + symptom.toString();
	}

}
