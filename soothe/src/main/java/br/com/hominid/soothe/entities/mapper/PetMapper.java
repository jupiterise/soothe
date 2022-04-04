package br.com.hominid.soothe.entities.mapper;

import br.com.hominid.soothe.entities.PetEntity;
import br.com.hominid.soothe.entities.dto.PetDTO;
import org.springframework.stereotype.Component;

@Component
public class PetMapper {

    public PetDTO toDto(PetEntity entity) {
        PetDTO dto = new PetDTO();
        dto.id = entity.getId();
        dto.name = entity.getName();
        dto.animalGroup = entity.getAnimalGroup();
        dto.animalRace = entity.getAnimalRace();
        dto.birthDate = entity.getBirthDate();
        dto.overseers = entity.getOverseers();
        dto.species = entity.getSpecies();
        return dto;
    }

    public PetEntity toEntity(PetDTO dto) {
        PetEntity entity = new PetEntity();
        entity.setId(dto.id);
        entity.setName(dto.name);
        entity.setAnimalGroup(dto.animalGroup);
        entity.setBirthDate(dto.birthDate);
        entity.setOverseers(dto.overseers);
        entity.setSpecies(dto.species);
        entity.setAnimalRace(dto.animalRace);
        return entity;
    }
}
