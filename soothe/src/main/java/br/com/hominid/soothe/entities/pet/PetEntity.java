package br.com.hominid.soothe.entities.pet;

import br.com.hominid.soothe.entities.person.PersonEntity;
import br.com.hominid.soothe.entities.pet.enumeration.AnimalGroupType;
import br.com.hominid.soothe.entities.pet.enumeration.AnimalRaceType;
import br.com.hominid.soothe.entities.pet.enumeration.SpeciesType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pet")
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;
    private LocalDate birthDate;
    private SpeciesType species;
    private AnimalRaceType animalRace;
    private AnimalGroupType animalGroup;

    @JsonIgnore
    @ManyToMany(mappedBy = "pets", fetch = FetchType.LAZY)
    private Set<PersonEntity> overseers = new HashSet<>();


}
