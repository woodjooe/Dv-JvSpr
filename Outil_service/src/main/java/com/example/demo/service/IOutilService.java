package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Outil;




public interface IOutilService {
	
	public Outil addOutil(Outil o) ;
	public void deleteOutil(Long id) ;
	public Outil updateOutil(Outil o);
	public Outil findOutil(Long id) ;
	public List<Outil> findAll();
	public List<Outil> findBysource(String source);
}
