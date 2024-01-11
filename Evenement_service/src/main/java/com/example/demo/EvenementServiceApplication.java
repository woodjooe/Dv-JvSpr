package com.example.demo;

import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.EvenementRepository;
import com.example.demo.entities.Evenement;
import com.example.demo.service.EvenementService;

import lombok.AllArgsConstructor;

@SpringBootApplication
@EnableDiscoveryClient
@AllArgsConstructor
public class EvenementServiceApplication implements CommandLineRunner{
	EvenementRepository evenementRepository ;
	EvenementService evenementSevice;
	public static void main(String[] args) {
		SpringApplication.run(EvenementServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Evenement ev1 = Evenement.builder()
						.titre("even 1")
						.Date(new Date())
						.lieu("lieu du ev1")
						.build() ;
		Evenement ev2 = Evenement.builder()
				.titre("even 2")
				.Date(new Date())
				.lieu("lieu du ev2")
				.build() ;
		evenementRepository.save(ev1);
		evenementRepository.save(ev2);
		
		List <Evenement> evenements = evenementRepository.findAll();
		for (Evenement evenemet :evenements ) {
			System.out.println(evenemet.getTitre());
		}
		
		Evenement e = evenementSevice.findEvenement(1L);
		e.setTitre("new titre ev1");
		evenementSevice.updateEvenement(e);
		
	}

}
