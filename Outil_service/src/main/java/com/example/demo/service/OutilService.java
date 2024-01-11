package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.OutilRepository;
import com.example.demo.entities.Outil;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class OutilService implements IOutilService {
	OutilRepository outilRepository;
	@Override
	public Outil addOutil(Outil o) {
		outilRepository.save(o) ;
		return  o;
	}

	@Override
	public void deleteOutil(Long id) {
		outilRepository.deleteById(id);
		
	}

	@Override
	public Outil updateOutil(Outil o) {
		
		return outilRepository.saveAndFlush(o);
	}

	@Override
	public Outil findOutil(Long id) {
		Outil o = (Outil) outilRepository.findById(id).get();
		return o;
	}

	@Override
	public List<Outil> findAll() {
		
		return outilRepository.findAll();
	}

	@Override
	public List<Outil> findBysource(String source) {
		
		return outilRepository.findBysource(source);
	}

}
