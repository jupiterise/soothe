package br.com.hominid.soothe.entities.dto;

import br.com.hominid.soothe.entities.enumeration.AmountType;
import br.com.hominid.soothe.entities.enumeration.EventType;
import br.com.hominid.soothe.entities.PetEntity;
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
    public UUID personId;
    public Set<PetEntity> petEntity;
    public EventType eventType;
    public AmountType amountType;
    public Long amount;
    public LocalDateTime eventMoment;

}
