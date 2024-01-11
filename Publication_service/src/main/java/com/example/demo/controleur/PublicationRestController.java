package com.example.demo.controleur;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Publication;
import com.example.demo.service.IPublicationService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PublicationRestController {
 IPublicationService publicationService ;
 @RequestMapping(value="/publications", method=RequestMethod.GET)
	public List<Publication> findPublications (){
	return publicationService.findAll();
	}
 @GetMapping(value="/publications/{id}")
	public Publication findOnePublicationById(@PathVariable Long id){
	return publicationService.findPublication(id);
	}
 
 @GetMapping(value="/publications/search/type")
	public List<Publication> findOnePublicationByType(@RequestParam String type)
	{
	return publicationService.findBytype(type);
	}
 @GetMapping(value="/publications/search/titre")
	public List<Publication> findOnePublicationByTitre(@RequestParam String Titre)
	{
	return publicationService.findByTitre(Titre);
	}
 @GetMapping(value="/publications/search/Lien")
	public List<Publication> findOnePublicationByLien(@RequestParam String Lien)
	{
	return publicationService.findBylien(Lien);
	}
 	@PostMapping(value="/publications/publication")
	public Publication addPublication(@RequestBody Publication p)
	{
	return publicationService.addPublication(p);
	}
 	@DeleteMapping(value="/publications/{id}")
	public void deletePublication(@PathVariable Long id)
	{

 		publicationService.deletePublication(id);

	}
 	
 	@PutMapping(value="/publications/publication/{id}")
	public Publication updatepublication(@PathVariable Long id, @RequestBody
			Publication p)
	{

	p.setId(id);
	return publicationService.updatePublication(p);

	}
 	
	
}
