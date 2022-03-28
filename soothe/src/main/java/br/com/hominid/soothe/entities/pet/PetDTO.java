package br.com.hominid.soothe.entities.pet;

import br.com.hominid.soothe.entities.person.PersonEntity;
import br.com.hominid.soothe.entities.pet.enumeration.AnimalGroupType;
import br.com.hominid.soothe.entities.pet.enumeration.AnimalRaceType;
import br.com.hominid.soothe.entities.pet.enumeration.SpeciesType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PetDTO {

    public UUID id;
    public String name;
    public LocalDate birthDate;
    public SpeciesType species;
    public AnimalRaceType animalRace;
    public AnimalGroupType animalGroup;
    public Set<PersonEntity> overseers;

}
