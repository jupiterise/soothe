package br.com.hominid.soothe.entities.mapper;

import br.com.hominid.soothe.entities.NotificationEntity;
import br.com.hominid.soothe.entities.dto.NotificationDTO;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapper {

    public NotificationDTO toDto(NotificationEntity entity) {
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.id = entity.getId();
        notificationDTO.personId = entity.getPersonId();
        notificationDTO.message = entity.getMessage();
        notificationDTO.moment = entity.getMoment();
        return notificationDTO;
    }

    public NotificationEntity toEntity(NotificationDTO dto) {
        NotificationEntity entity = new NotificationEntity();
        entity.setId(dto.id);
        entity.setPersonId(dto.personId);
        entity.setMessage(dto.message);
        entity.setMoment(dto.moment);
        return entity;
    }

}
