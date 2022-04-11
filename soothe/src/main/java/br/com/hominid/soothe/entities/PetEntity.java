package br.com.hominid.soothe.entities;

import br.com.hominid.soothe.entities.enumeration.AnimalGroupType;
import br.com.hominid.soothe.entities.enumeration.AnimalRaceType;
import br.com.hominid.soothe.entities.enumeration.SpeciesType;
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

    @Column(nullable = false)
    private SpeciesType species;

    private AnimalRaceType animalRace;

    @Column(nullable = false)
    private AnimalGroupType animalGroup;

    @JsonIgnore
    @ManyToMany(mappedBy = "pets", fetch = FetchType.LAZY)
    private Set<EventEntity> events = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "pets", fetch = FetchType.LAZY)
    private Set<PersonEntity> overseers = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "pets", fetch = FetchType.LAZY)
    private Set<HomeGroupEntity> homeGroups = new HashSet<>();

    @Override
    public String toString() {
        return "PetEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", species=" + species +
                ", animalRace=" + animalRace +
                ", animalGroup=" + animalGroup +
                ", events=" + events +
                ", overseers=" + overseers +
                ", homeGroups=" + homeGroups +
                '}';
    }
}
