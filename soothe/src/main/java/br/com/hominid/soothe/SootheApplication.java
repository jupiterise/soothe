package br.com.hominid.soothe;

import br.com.hominid.soothe.entities.person.PersonEntity;
import br.com.hominid.soothe.entities.person.PersonEntityRepository;
import br.com.hominid.soothe.entities.pet.PetEntity;
import br.com.hominid.soothe.entities.pet.PetEntityRepository;
import br.com.hominid.soothe.entities.pet.enumeration.AnimalGroupType;
import br.com.hominid.soothe.entities.pet.enumeration.AnimalRaceType;
import br.com.hominid.soothe.entities.pet.enumeration.SpeciesType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.UUID;

@SpringBootApplication
public class SootheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SootheApplication.class, args);
	}

}
