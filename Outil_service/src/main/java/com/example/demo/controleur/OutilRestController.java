package com.example.demo.controleur;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Outil;
import com.example.demo.service.IOutilService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class OutilRestController {
	IOutilService outilservice;
	
	@RequestMapping(value="/outils", method=RequestMethod.GET)
	public List<Outil> findOutil (){
	   return outilservice.findAll();
	}
	@GetMapping(value="/outils/{id}")
	public Outil findOneOutilById(@PathVariable Long id){
	return outilservice.findOutil(id);
	}
	@GetMapping(value="/outils/search/source")
	public List<Outil> findOneOutilBysource(@RequestParam String source)
	{
	return outilservice.findBysource(source);
	}
	
	@DeleteMapping(value="/outils/{id}")
	public void deleteOutil(@PathVariable Long id)
	{

		outilservice.deleteOutil(id);

	}
 	
 	@PutMapping(value="/outils/outil/{id}")
	public Outil updateoutil(@PathVariable Long id, @RequestBody
			Outil o)
	{

	o.setId(id);
	return outilservice.updateOutil(o);

	}
 	
	
}
