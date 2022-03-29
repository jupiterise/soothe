package br.com.hominid.soothe.entities.event;

import br.com.hominid.soothe.entities.event.enumeration.AmountType;
import br.com.hominid.soothe.entities.event.enumeration.EventType;
import br.com.hominid.soothe.entities.person.PersonEntity;
import br.com.hominid.soothe.entities.pet.PetEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
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

    @Column(nullable = false)
    private PersonEntity personEntity;

    @OneToMany(mappedBy = "event",  fetch = FetchType.LAZY)
    private Set<PetEntity> petEntity;

    @Column(nullable = false)
    private EventType eventType;

    private AmountType amountType;

    private Long amount;

    @Column(nullable = false)
    private LocalDateTime eventMoment;

}
