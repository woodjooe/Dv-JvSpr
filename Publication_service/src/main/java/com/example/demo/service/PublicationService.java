package com.example.demo.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.PublicationRepository;
import com.example.demo.entities.Publication;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PublicationService implements IPublicationService {
	
	PublicationRepository publicationRepository;
	
	@Override
	public Publication addPublication(Publication p) {
		publicationRepository.save(p);
		return p;
	}

	@Override
	public void deletePublication(Long id) {
		publicationRepository.deleteById(id);
		
	}

	@Override
	public Publication updatePublication(Publication p) {
		// TODO Auto-generated method stub
		return publicationRepository.saveAndFlush(p);
	}

	@Override
	public Publication findPublication(Long id) {
		Publication p = (Publication) publicationRepository.findById(id).get();
		return p;
	}

	@Override
	public List<Publication> findAll() {
		// TODO Auto-generated method stub
		return publicationRepository.findAll();
	}

	@Override
	public List<Publication> findBytype(String type) {
		// TODO Auto-generated method stub
		return publicationRepository.findBytype(type);
	}

	@Override
	public List<Publication> findByTitre(String titre) {
		// TODO Auto-generated method stub
		return publicationRepository.findByTitre(titre);
	}

	@Override
	public List<Publication> findBylien(String lien) {
		// TODO Auto-generated method stub
		return publicationRepository.findBylien(lien);
	}
	
}
