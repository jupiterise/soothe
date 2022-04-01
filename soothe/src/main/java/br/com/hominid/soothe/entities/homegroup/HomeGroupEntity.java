package br.com.hominid.soothe.entities.homegroup;

import br.com.hominid.soothe.entities.person.PersonEntity;
import br.com.hominid.soothe.entities.pet.PetEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "event")
public class HomeGroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
    private Set<PetEntity> pets;

    @JsonIgnore
    @ManyToMany(mappedBy = "homeGroups", fetch = FetchType.LAZY)
    private Set<PersonEntity> residents;

}
