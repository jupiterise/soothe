package br.com.hominid.soothe.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity(name = "PersonEntity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, columnDefinition = "VARCHAR(45) default 'user@user.com'")
    private String email;

    @Column(nullable = false, columnDefinition = "VARCHAR(200)")
    private String password;

    @Column(nullable = false, columnDefinition = "VARCHAR(45) default 'user'")
    private String role;

    @Column(nullable = false)
    private String name;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "person_pet",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "pet_id")
    )
    private Set<PetEntity> pets = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "person_id")
    private Set<EventEntity> events = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "person_id")
    private Set<NotificationEntity> notifications = new HashSet<>();

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "person_home_group",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "home_group_id")
    )
    private Set<HomeGroupEntity> homeGroups;

    @Override
    public String toString() {
        return "PersonEntity{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", name='" + name + '\'' +
                ", pets=" + pets +
                ", events=" + events +
                ", notifications=" + notifications +
                ", homeGroups=" + homeGroups +
                '}';
    }
}
