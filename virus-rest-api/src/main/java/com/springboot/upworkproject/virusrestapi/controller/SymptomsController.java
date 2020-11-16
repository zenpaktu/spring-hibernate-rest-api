package com.springboot.upworkproject.virusrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.upworkproject.virusrestapi.model.Symptoms;
import com.springboot.upworkproject.virusrestapi.service.SymptomsService;

@RestController
@RequestMapping("/api/service/virus/{id_Virus}/symptoms")
public class SymptomsController {
	
	@Autowired
	private SymptomsService sympSvc;
	
	/**
	* Returns a List of all Symptoms of id_Virus Virus. 
	*
	* @param	id_Virus 
	* @return	List<Virus>
	*/
	@GetMapping
	public ResponseEntity<List<Symptoms>> getAllVirusSymptoms(@PathVariable long id_Virus){
		return ResponseEntity.ok().body(this.sympSvc.getAllVirusSymptoms(id_Virus));
	}
	
	/**
	* Retrieves and returns the data of the requested symptom with the given ID as search parameter
	*
	* @param	id of Symptoms
	* @return   ResponseEntity<Symptoms>
	*/
	@GetMapping("/{id}")
	public ResponseEntity<Symptoms> getSymptomsById(@PathVariable long id){
		return ResponseEntity.ok().body(sympSvc.getSymptomsById(id));
	}
	
	/**
	* Inserts a row of symptom assigned to a virus to the database. 
	*
	* @param	id of Virus
	* @param	Symptoms Object
	* @return   ResponseEntity<Virus>
	*/
	@PostMapping
	public ResponseEntity<Symptoms> createVirusSymptoms(@PathVariable long id_Virus, @RequestBody Symptoms symptoms){
		
		return ResponseEntity.ok().body(this.sympSvc.createVirusSymptoms(id_Virus, symptoms));
	}
//	
//	@PostMapping
//	public String createVirusSymptoms(@PathVariable long id_Virus, @RequestBody Symptoms symptoms){
//		return this.sympSvc.createdummy(id_Virus, symptoms);
//	}
	
	/**
	* Updates the virus with the given Id
	*
	* @param	ID of symptom
	* @param	symptoms Object
	* @return   HttpStatus 
	*/
	@PutMapping("/{id}")
	public HttpStatus updateSymptoms(@PathVariable long id, @RequestBody Symptoms symptoms){
		symptoms.setIdSymptoms(id);
		return this.sympSvc.updateSymptoms(symptoms);
	}
	
	/**
	* Deletes the symptoms with the given Id
	*
	* @param	id of Symptom
	* @return   HttpStatus
	*/
	@DeleteMapping("/{id}")
	public HttpStatus deleteSymptoms(@PathVariable long id){
		return this.sympSvc.deleteSymptoms(id);
	}

}
