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

import com.example.demo.entities.Evenement;
import com.example.demo.service.IEvenementService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class EvenementRestController {
	
	IEvenementService evenementSevice;
	
	@RequestMapping(value="/evenements", method=RequestMethod.GET)
	public List<Evenement> findEvenement (){
	   return evenementSevice.findAll();
	}
	@GetMapping(value="/evenements/{id}")
	public Evenement findOneEvenementById(@PathVariable Long id){
	return evenementSevice.findEvenement(id);
	}
	
	@GetMapping(value="/evenements/search/titre")
	public List<Evenement> findOneEvenementBytitre(@RequestParam String titre)
	{
	return evenementSevice.findBytitre(titre);
	}
	
	@GetMapping(value="/evenements/search/lieu")
	public List<Evenement> findOneEvenementBylieu(@RequestParam String lieu)
	{
	return evenementSevice.findBylieu(lieu);
	}
	
	@DeleteMapping(value="/evenements/{id}")
	public void deleteEvenement(@PathVariable Long id)
	{

		evenementSevice.deleteEvenement(id);

	}
	
	@PutMapping(value="/evenements/evenement/{id}")
	public Evenement updateEvenement(@PathVariable Long id, @RequestBody
			Evenement e)
	{

	e.setId(id);
	return evenementSevice.updateEvenement(e);

	}

}
