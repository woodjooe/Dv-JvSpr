package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Outil;



public interface OutilRepository extends JpaRepository <Outil, Long>{
	
	List <Outil> findBysource(String source);

}
