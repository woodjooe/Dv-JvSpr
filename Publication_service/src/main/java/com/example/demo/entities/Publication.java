package com.example.demo.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE )

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class Publication {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String type;
	@NonNull
	private String titre;
	@NonNull
	private String lien;
	@NonNull @Temporal(TemporalType.DATE)
	private Date Date;	
	@NonNull
	private String Sourcepdf;
	
	@Builder
	public Publication (String type , String titre , String lien , Date Date , String Sourcepdf) {
		this.type = type ;
		this.titre = titre ;
		this.lien = lien ; 
		this.Date = Date ;
		this.Sourcepdf = Sourcepdf;
	}
	
}
