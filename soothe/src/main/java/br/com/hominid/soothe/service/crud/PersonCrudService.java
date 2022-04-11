package br.com.hominid.soothe.service.crud;

import br.com.hominid.soothe.entities.PersonEntity;
import br.com.hominid.soothe.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonCrudService implements CrudService<PersonEntity>  {

    @Autowired
    PersonRepository repository;

    @Override
    public PersonEntity getById(UUID id) {
        Optional<PersonEntity> entity = repository.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new EntityNotFoundException("Entity was not found on given id: " + id);
        }
    }

    @Override
    public List<PersonEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public PersonEntity create(PersonEntity entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public PersonEntity update(PersonEntity personEntity) {
        return repository.save(personEntity);
    }

}
