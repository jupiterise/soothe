package br.com.hominid.soothe.entities.dto;

import br.com.hominid.soothe.entities.PersonEntity;
import br.com.hominid.soothe.entities.PetEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;
import java.util.UUID;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HomeGroupDTO {

    public UUID id;
    public String name;
    public Set<PetEntity> pets;
    public Set<PersonEntity> residents;

}
