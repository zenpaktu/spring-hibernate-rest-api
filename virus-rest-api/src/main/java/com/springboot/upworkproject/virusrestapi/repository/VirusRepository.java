package com.springboot.upworkproject.virusrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.upworkproject.virusrestapi.model.Virus;

@Repository
public interface VirusRepository extends JpaRepository<Virus, Long> {
	
	@Modifying
	@Query("update #{#entityName} set name = :name, year_Discovered = :yearDiscovered where id_Virus = :id")
	public int updateVirus(@Param("id") long id, @Param("name") String name, @Param("yearDiscovered") String yearDiscovered);
	
	@Modifying
	@Query("delete from #{#entityName} where id_Virus = :id")
	public int deleteVirus(@Param("id") long id);
 
}
