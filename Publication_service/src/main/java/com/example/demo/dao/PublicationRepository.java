package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entities.Publication;



public interface PublicationRepository extends JpaRepository <Publication, Long> { 
	List <Publication> findBytype(String type);
	List <Publication> findByTitre(String Titre);
	List<Publication> findBylien(String lien);
	
}
