package br.com.hominid.soothe.entities.event;

import br.com.hominid.soothe.entities.event.enumeration.AmountType;
import br.com.hominid.soothe.entities.event.enumeration.EventType;
import br.com.hominid.soothe.entities.person.PersonEntity;
import br.com.hominid.soothe.entities.pet.PetEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {

    public UUID id;
    public PersonEntity personEntity;
    public Set<PetEntity> petEntity;
    public EventType eventType;
    public AmountType amountType;
    public Long amount;
    public LocalDateTime eventMoment;

}
