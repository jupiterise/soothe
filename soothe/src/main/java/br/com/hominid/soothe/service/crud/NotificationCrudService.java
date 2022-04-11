package br.com.hominid.soothe.service.crud;

import br.com.hominid.soothe.entities.NotificationEntity;
import br.com.hominid.soothe.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NotificationCrudService implements CrudService<NotificationEntity> {

    @Autowired
    NotificationRepository repository;

    @Override
    public NotificationEntity getById(UUID id) {
        Optional<NotificationEntity> entity = repository.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new EntityNotFoundException("Entity was not found on given id: " + id);
        }
    }

    @Override
    public List<NotificationEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public NotificationEntity create(NotificationEntity entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public NotificationEntity update(NotificationEntity notificationEntity) {
        return repository.save(notificationEntity);
    }
}
