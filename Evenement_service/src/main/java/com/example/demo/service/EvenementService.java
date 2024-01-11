package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.EvenementRepository;
import com.example.demo.entities.Evenement;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class EvenementService implements IEvenementService{
	EvenementRepository evenementRepository ;
	@Override
	public Evenement addEvenement(Evenement e) {
		// TODO Auto-generated method stub
		 evenementRepository.save(e);
		return e;
	}

	@Override
	public void deleteEvenement(Long id) {
		 evenementRepository.deleteById(id);
		
	}

	@Override
	public Evenement updateEvenement(Evenement e) {
		// TODO Auto-generated method stub
		return evenementRepository.saveAndFlush(e) ;
	}

	@Override
	public Evenement findEvenement(Long id) {
		Evenement e = (Evenement) evenementRepository.findById(id).get();
		return e;
	}

	@Override
	public List<Evenement> findAll() {
		
		return evenementRepository.findAll();
	}

	@Override
	public List<Evenement> findBytitre(String titre) {
		// TODO Auto-generated method stub
		return evenementRepository.findBytitre(titre);
	}

	@Override
	public List<Evenement> findBylieu(String lieu) {
		// TODO Auto-generated method stub
		return evenementRepository.findByLieu(lieu);
	}

}
