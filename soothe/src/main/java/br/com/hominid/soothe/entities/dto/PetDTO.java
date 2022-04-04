package br.com.hominid.soothe.entities.dto;

import br.com.hominid.soothe.entities.PersonEntity;
import br.com.hominid.soothe.entities.enumeration.AnimalGroupType;
import br.com.hominid.soothe.entities.enumeration.AnimalRaceType;
import br.com.hominid.soothe.entities.enumeration.SpeciesType;
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
