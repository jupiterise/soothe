package br.com.hominid.soothe.entities;

import br.com.hominid.soothe.entities.enumeration.AmountType;
import br.com.hominid.soothe.entities.enumeration.EventType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity(name = "EventEntity")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "event")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name="person_id")
    @JsonIgnore
    private UUID personId;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY )
    @JoinTable(
            name = "event_pet",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "pet_id")
    )
    private Set<PetEntity> pets = new HashSet<>();

    @Column(nullable = false)
    private EventType eventType;

    private AmountType amountType;

    private Long amount;

    @Column(nullable = false)
    private LocalDateTime eventMoment;

}
