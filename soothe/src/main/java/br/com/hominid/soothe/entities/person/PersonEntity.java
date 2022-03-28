package br.com.hominid.soothe.entities.person;

import br.com.hominid.soothe.entities.pet.PetEntity;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY )
    @JoinTable(
            name = "person_pet",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "pet_id")
    )
    private Set<PetEntity> pets = new HashSet<>();

}
