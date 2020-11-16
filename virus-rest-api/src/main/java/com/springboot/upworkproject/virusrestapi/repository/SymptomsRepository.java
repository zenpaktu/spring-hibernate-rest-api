package com.springboot.upworkproject.virusrestapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.upworkproject.virusrestapi.model.Symptoms;
import com.springboot.upworkproject.virusrestapi.model.Virus;

@Repository
public interface SymptomsRepository extends JpaRepository<Symptoms, Long>{
	
	public List<Symptoms> findByVirus(Virus virus);
	
	public int deleteByIdSymptoms(long idSymptoms);
}
