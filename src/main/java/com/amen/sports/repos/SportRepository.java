package com.amen.sports.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.amen.sports.entities.Sport;
import com.amen.sports.entities.Type;

public interface SportRepository extends JpaRepository<Sport, Long> {
	
	
	
	List<Sport> findByNomSport(String nom);
	List<Sport> findByNomSportContains(String nom);
	
	
	
	@Query("select s from Sport s where s.type = ?1")
	List<Sport> findByType (Type type);
	
	List<Sport> findByTypeIdT(Long id);
	
	List<Sport> findByOrderByNomSportAsc();
	
	

}
