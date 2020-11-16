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

import com.springboot.upworkproject.virusrestapi.model.Virus;
import com.springboot.upworkproject.virusrestapi.service.VirusService;

@RestController
@RequestMapping("/api/service/virus")
public class VirusController {

	@Autowired
	VirusService virusSvc;
	
	/**
	* Returns a List of all Viruses from database. 
	*
	* @return      ResponseEntity<List<Virus>>
	*/
	@GetMapping
	public ResponseEntity<List<Virus>> getAllViruses(){
		return ResponseEntity.ok().body(virusSvc.getAllVirus());
	}
	
	/**
	* Retrieves and returns the data of the requested virus with the given ID as search parameter
	*
	* @param	id
	* @return   ResponseEntity<Virus>
	*/
	@GetMapping("/{id}")
	public ResponseEntity<Virus> getVirustById(@PathVariable long id){
		return ResponseEntity.ok().body(virusSvc.getVirusById(id));
	}
	
	/**
	* Inserts a row a virus to the database. 
	*
	* @param	Virus Object
	* @return   ResponseEntity<Virus>
	*/
	@PostMapping
	public ResponseEntity<Virus> createVirus(@RequestBody Virus virus){
		return ResponseEntity.ok().body(this.virusSvc.createVirus(virus));
	}
	
	/**
	* Updates the virus with the given Id
	*
	* @param	Virus Object
	* @param	virusId
	* @return   HttpStatus 
	*/
	@PutMapping("/{id}")
	public HttpStatus updateVirus(@PathVariable long id, @RequestBody Virus virus){
		virus.setIdVirus(id);
		return this.virusSvc.updateVirus(virus);
	}
	
	/**
	* Deletes the virus with the given Id also deleting its associated symptoms
	*
	* @param	id
	* @return   HttpStatus
	*/
	@DeleteMapping("/{id}")
	public HttpStatus deleteVirus(@PathVariable long id){
		return this.virusSvc.deleteVirus(id);
	}

}
