package com.amen.sports.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.amen.sports.entities.Sport;
import com.amen.sports.entities.Type;
import com.amen.sports.repos.SportRepository;
import com.amen.sports.repos.TypeRepository;
@Service
public class SportServiceImpl implements SportService {
@Autowired
SportRepository sportRepository;

@Autowired
TypeRepository typeRepository;

@Override
public Sport saveSport(Sport s) {
	return sportRepository.save(s);
	}
	@Override
	public Sport updateSport(Sport s) {
	return sportRepository.save(s);
	}
	@Override
	public void deleteSport(Sport s) {
	sportRepository.delete(s);
	}
	@Override
	public void deleteSportById(Long id) {
	sportRepository.deleteById(id);
	}
	@Override
	public Sport getSport(Long id) {
	return sportRepository.findById(id).get();
	}
	@Override
	public List<Sport> getAllSports() {
	return sportRepository.findAll();
	}
	@Override
	public Page<Sport> getAllSportsParPage(int page, int size) {
		return sportRepository.findAll(PageRequest.of(page, size));
	}
	@Override
	public List<Sport> findByNomSport(String nom) {
	return sportRepository.findByNomSport(nom);
	}
	@Override
	public List<Sport> findByNomSportContains(String nom) {
	return sportRepository.findByNomSportContains(nom);
	}
	/*@Override
	public List<Sport> findBynbrjoueur(String nom, int nb) {
		return sportRepository.findBynbrjoueur(nom, nb);
	}*/
	@Override
	public List<Sport> findByType(Type type) {
	return sportRepository.findByType(type);
	}
	@Override
	public List<Sport> findByTypeIdT(Long id) {
	return sportRepository.findByTypeIdT(id);
	}
	@Override
	public List<Sport> findByOrderByNomSportAsc() {
	return sportRepository.findByOrderByNomSportAsc();
	}
	/*@Override
	public List<Sport> trierSportsnombrejoueur() {
	return sportRepository.trierSportsnombrejoueur();
	}*/
	
	public List<Type> getAllTypes() {
		return typeRepository.findAll();
	}
	
	@Override
	public Page<Sport> getAllSportsByNomParPage(int page, int size, String n) {
		List<Sport> l = sportRepository.findByNomSportContains(n);
		Page<Sport> s = new PageImpl<Sport>(l, PageRequest.of(page, size), l.size());
		return s;
		/*return stagiaireRepository.findAll(PageRequest.of(page, size));*/
	}
	
	public Page<Sport> getAllSportsByTypeParPage(int page, int size, Long id) {
		List<Sport> l = sportRepository.findByTypeIdT(id);
		Page<Sport> p = new PageImpl<Sport>(l, PageRequest.of(page, size), l.size());
		return p;
	}
	}
	
	

