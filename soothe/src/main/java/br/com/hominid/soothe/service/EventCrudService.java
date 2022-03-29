package br.com.hominid.soothe.service;

import br.com.hominid.soothe.entities.event.EventEntity;
import br.com.hominid.soothe.entities.event.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventCrudService implements CrudService<EventEntity> {

    @Autowired
    EventRepository repository;

    @Override
    public EventEntity getById(UUID id) {
        Optional<EventEntity> entity = repository.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new EntityNotFoundException("Entity was not found on given id: " + id);
        }
    }

    @Override
    public List<EventEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public EventEntity create(EventEntity entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public EventEntity update(EventEntity personEntity) {
        return repository.save(personEntity);
    }
}
