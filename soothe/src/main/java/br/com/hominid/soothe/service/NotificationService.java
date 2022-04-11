package br.com.hominid.soothe.service;

import br.com.hominid.soothe.entities.EventEntity;
import br.com.hominid.soothe.entities.NotificationEntity;
import br.com.hominid.soothe.entities.PetEntity;
import br.com.hominid.soothe.service.crud.NotificationCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.hominid.soothe.infra.constants.Message.FEED_NOTIFICATION_MESSAGE;

@Service
public class NotificationService extends NotificationCrudService {

    @Autowired
    PersonService service;

    public void saveNotificationFromEvent(EventEntity eventEntity) {
        NotificationEntity notificationEntity = new NotificationEntity();
        notificationEntity.setMoment(eventEntity.getEventMoment());
        notificationEntity.setPersonId(eventEntity.getPersonId());
        notificationEntity.setMessage(this.createMessageFromEvent(eventEntity));
        super.create(notificationEntity);
    }

    private String createMessageFromEvent(EventEntity entity) {
        String message = "";
        String personName = service.getById(entity.getPersonId()).getName();
        String pets = "";
        for (PetEntity pet : entity.getPets()) {
            if (pets.isEmpty()) {
                pets = pet.getName();
            } else {
                pets = pets.concat(" e " + pet.getName());
            }
        }
        switch (entity.getEventType()) {
            case FEEDING:
                final String amount = entity.getAmount().toString() + " " + entity.getAmountType().toString().toLowerCase();
                message = String.format(FEED_NOTIFICATION_MESSAGE, personName, pets, amount, "[food_type]");
                break;
            default:
                break;
        }
        return message;
    }

}
