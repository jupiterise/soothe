package br.com.hominid.soothe.entities.person;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;

@Component
public class PersonMapper {

    public PersonDTO toDto(PersonEntity entity) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.id = entity.getId();
        personDTO.name = entity.getName();
        personDTO.pets = entity.getPets() != null ? new ArrayList<>(entity.getPets()) : null;
        return personDTO;
    }

    public PersonEntity toEntity(PersonDTO dto) {
        PersonEntity entity = new PersonEntity();
        entity.setId(dto.id);
        entity.setName(dto.name);
        entity.setPets(dto.pets != null ? new HashSet<>(dto.pets) : null);
        return entity;
    }

}
