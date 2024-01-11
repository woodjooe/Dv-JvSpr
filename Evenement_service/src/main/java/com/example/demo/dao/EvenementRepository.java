package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Evenement;


public interface EvenementRepository  extends JpaRepository <Evenement, Long>{
	List <Evenement> findBytitre(String titre);
	List <Evenement> findByLieu(String lieu);
}
