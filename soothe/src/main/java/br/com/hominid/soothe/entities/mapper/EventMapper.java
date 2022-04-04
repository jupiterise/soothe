package br.com.hominid.soothe.entities.mapper;

import br.com.hominid.soothe.entities.EventEntity;
import br.com.hominid.soothe.entities.dto.EventDTO;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    public EventDTO toDto(EventEntity entity) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.id = entity.getId();
        eventDTO.eventMoment = entity.getEventMoment();
        eventDTO.personId = entity.getPersonId();
        eventDTO.eventType = entity.getEventType();
        eventDTO.amountType = entity.getAmountType() != null ? entity.getAmountType() : null;
        eventDTO.petEntity = entity.getPets() != null ? entity.getPets() : null;
        eventDTO.amount = entity.getAmount() != null ? entity.getAmount() : null;
        return eventDTO;
    }

    public EventEntity toEntity(EventDTO dto) {
        EventEntity entity = new EventEntity();
        entity.setId(dto.id);
        entity.setEventMoment(dto.eventMoment);
        entity.setPersonId(dto.personId);
        entity.setEventType(dto.eventType);
        entity.setAmountType(dto.amountType != null ? dto.amountType : null);
        entity.setPets(dto.petEntity != null ? dto.petEntity : null);
        entity.setAmount(dto.amount != null ? dto.amount : null);
        return entity;
    }

}
