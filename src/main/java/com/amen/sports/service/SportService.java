package com.amen.sports.service;

import java.util.List;

import org.springframework.data.domain.Page;


import com.amen.sports.entities.Sport;
import com.amen.sports.entities.Type;
public interface SportService {
Sport saveSport(Sport s);
Sport updateSport(Sport s);
void deleteSport(Sport s);
void deleteSportById(Long id);
Sport getSport(Long id);
List<Sport> getAllSports();
Page<Sport> getAllSportsParPage(int page, int size);
List<Sport> findByNomSport(String nom);
List<Sport> findByNomSportContains(String nom);

List<Sport> findByType(Type type);
List<Sport> findByTypeIdT(Long id);
List<Sport> findByOrderByNomSportAsc();


List<Type> getAllTypes();
Page<Sport> getAllSportsByNomParPage(int page, int size, String nom);
Page<Sport> getAllSportsByTypeParPage(int page, int size, Long id);

}
