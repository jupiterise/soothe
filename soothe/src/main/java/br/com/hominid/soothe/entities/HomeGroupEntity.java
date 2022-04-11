package br.com.hominid.soothe.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "home_group")
public class HomeGroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "homeGroups", fetch = FetchType.LAZY)
    private Set<PersonEntity> residents;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "home_group_pet",
            joinColumns = @JoinColumn(name = "home_group_id"),
            inverseJoinColumns = @JoinColumn(name = "pet_id")
    )
    private Set<PetEntity> pets = new HashSet<>();

    @Override
    public String toString() {
        return "HomeGroupEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", residents=" + residents +
                ", pets=" + pets +
                '}';
    }
}
