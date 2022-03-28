package br.com.hominid.soothe.entities.person;

import br.com.hominid.soothe.entities.pet.PetEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    public UUID id;
    public String name;
    public List<PetEntity> pets;

}
