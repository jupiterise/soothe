package br.com.hominid.soothe.service;

import br.com.hominid.soothe.entities.person.PersonDTO;
import br.com.hominid.soothe.entities.person.PersonEntity;
import br.com.hominid.soothe.entities.person.PersonEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    @Autowired
    PersonEntityRepository repository;

    public PersonEntity getById(UUID id) {
        Optional<PersonEntity> entity = repository.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new EntityNotFoundException("Entity was not found on given id: " + id);
        }
    }

    public List<PersonEntity> getAll() {
        return repository.findAll();
    }

    public PersonEntity create(PersonEntity entity) {
        return repository.save(entity);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public PersonEntity update(PersonEntity personEntity) {
        return repository.save(personEntity);
    }
}
