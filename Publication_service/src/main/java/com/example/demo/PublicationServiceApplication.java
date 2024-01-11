package com.example.demo;

import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.PublicationRepository;
import com.example.demo.entities.Publication;
import com.example.demo.service.IPublicationService;
import com.example.demo.service.PublicationService;

import lombok.AllArgsConstructor;

@SpringBootApplication
@EnableDiscoveryClient
@AllArgsConstructor
public class PublicationServiceApplication implements CommandLineRunner {
    PublicationRepository publicationRespository;
    IPublicationService  publicationService;
	public static void main(String[] args) {
		SpringApplication.run(PublicationServiceApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Publication pub1 = Publication.builder()
							.type("Media")
							.titre("pub1")
							.lien("jidhfzh")
							.Date(new Date())
							.Sourcepdf("djbhcujz")
							.build();
		Publication pub2 = Publication.builder()
				.type("Social")
				.titre("pub2")
				.lien("fkrhfhr")
				.Date(new Date())
				.Sourcepdf("jbzeef")
				.build();
		publicationRespository.save(pub1);
		publicationRespository.save(pub2);
		
		List<Publication>  publications = publicationRespository.findAll() ;
		for(Publication publication:  publications) {
			System.out.println(publication.getTitre()+" " + publication.getType());
		}
		
		Publication p = publicationService.findPublication(1L);
		p.setLien("new lien");
		publicationService.updatePublication(p);
		
		
		}
}


