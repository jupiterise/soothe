package br.com.hominid.soothe.service;

import br.com.hominid.soothe.entities.EventEntity;
import br.com.hominid.soothe.service.crud.EventCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService extends EventCrudService {

    @Autowired
    private NotificationService notificationService;

    @Override
    public EventEntity create(EventEntity entity) {
        notificationService.saveNotificationFromEvent(entity);
        return super.create(entity);
    }

}
