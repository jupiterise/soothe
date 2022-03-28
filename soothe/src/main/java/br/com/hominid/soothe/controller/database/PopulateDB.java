package br.com.hominid.soothe.controller.database;

import br.com.hominid.soothe.entities.person.PersonEntity;
import br.com.hominid.soothe.entities.person.PersonEntityRepository;
import br.com.hominid.soothe.entities.pet.PetEntity;
import br.com.hominid.soothe.entities.pet.PetEntityRepository;
import br.com.hominid.soothe.entities.pet.enumeration.AnimalGroupType;
import br.com.hominid.soothe.entities.pet.enumeration.AnimalRaceType;
import br.com.hominid.soothe.entities.pet.enumeration.SpeciesType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/soothe")
public class PopulateDB {

    @Autowired
    PersonEntityRepository personEntityRepository;
    @Autowired
    PetEntityRepository petEntityRepository;

    @GetMapping("/populateDB")
    private void populateDb() {
        personEntityRepository.save(new PersonEntity(UUID.randomUUID(), "Leonardo", new HashSet<>()));
        personEntityRepository.save(new PersonEntity(UUID.randomUUID(), "Jurema", new HashSet<>()));
        personEntityRepository.save(new PersonEntity(UUID.randomUUID(), "Mateus", new HashSet<>()));
        personEntityRepository.save(new PersonEntity(UUID.randomUUID(), "Julia", new HashSet<>()));
        personEntityRepository.save(new PersonEntity(UUID.randomUUID(), "Jacqueline", new HashSet<>()));
        personEntityRepository.save(new PersonEntity(UUID.randomUUID(), "Bruno", new HashSet<>()));

        petEntityRepository.save(new PetEntity(UUID.randomUUID(), "Nocturne", LocalDate.now(),
                SpeciesType.CAT, AnimalRaceType.STRAY, AnimalGroupType.MAMMAL, new HashSet<>()));
        petEntityRepository.save(new PetEntity(UUID.randomUUID(), "Zombie", LocalDate.now(),
                SpeciesType.CAT, AnimalRaceType.SIAMESE, AnimalGroupType.MAMMAL, new HashSet<>()));
        petEntityRepository.save(new PetEntity(UUID.randomUUID(), "Tina", LocalDate.now(),
                SpeciesType.DOG, AnimalRaceType.STRAY, AnimalGroupType.MAMMAL, new HashSet<>()));
        petEntityRepository.save(new PetEntity(UUID.randomUUID(), "Faísca", LocalDate.now(),
                SpeciesType.DOG, AnimalRaceType.STRAY, AnimalGroupType.MAMMAL, new HashSet<>()));
        petEntityRepository.save(new PetEntity(UUID.randomUUID(), "Fumaça", LocalDate.now(),
                SpeciesType.DOG, AnimalRaceType.PIT_BULL, AnimalGroupType.MAMMAL, new HashSet<>()));
    }
}