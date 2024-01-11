package com.example.demo;

import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.OutilRepository;
import com.example.demo.entities.Outil;
import com.example.demo.service.IOutilService;

import lombok.AllArgsConstructor;

@SpringBootApplication
@EnableDiscoveryClient
@AllArgsConstructor
public class OutilServiceApplication implements CommandLineRunner{
	OutilRepository outilRepository ;
	IOutilService outilService ;
	public static void main(String[] args) {
		SpringApplication.run(OutilServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Outil out1 = Outil.builder()
						.Date(new Date())
						.source("source out 1")
						.build();
		
		outilRepository.save(out1);
		Outil out2 = Outil.builder()
				.Date(new Date())
				.source("source out 2")
				.build();

		outilRepository.save(out2);
		List <Outil> outils = outilRepository.findAll();
		for(Outil outil:  outils) {
			System.out.println(outil.getSource());
		}
		Outil o = outilService.findOutil(1L);
		o.setSource("new source");
		outilService.updateOutil(o);
		
	}

}
