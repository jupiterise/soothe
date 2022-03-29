package br.com.hominid.soothe.entities.event;

import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    public EventDTO toDto(EventEntity entity) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.id = entity.getId();
        eventDTO.eventMoment = entity.getEventMoment();
        eventDTO.personEntity = entity.getPersonEntity();
        eventDTO.eventType = entity.getEventType();
        eventDTO.amountType = entity.getAmountType() != null ? entity.getAmountType() : null;
        eventDTO.petEntity = entity.getPetEntity() != null ? entity.getPetEntity() : null;
        eventDTO.amount = entity.getAmount() != null ? entity.getAmount() : null;
        return eventDTO;
    }

    public EventEntity toEntity(EventDTO dto) {
        EventEntity entity = new EventEntity();
        entity.setId(dto.id);
        entity.setEventMoment(dto.eventMoment);
        entity.setPersonEntity(dto.personEntity);
        entity.setEventType(dto.eventType);
        entity.setAmountType(dto.amountType != null ? dto.amountType : null);
        entity.setPetEntity(dto.petEntity != null ? dto.petEntity : null);
        entity.setAmount(dto.amount != null ? dto.amount : null);
        return entity;
    }

}
