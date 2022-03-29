package br.com.hominid.soothe.service;

import br.com.hominid.soothe.entities.pet.PetEntity;
import br.com.hominid.soothe.entities.pet.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PetCrudService implements CrudService<PetEntity> {

    @Autowired
    PetRepository repository;

    @Override
    public PetEntity getById(UUID id) {
        Optional<PetEntity> entity = repository.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new EntityNotFoundException("Entity was not found on given id: " + id);
        }
    }

    @Override
    public List<PetEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public PetEntity create(PetEntity entity) {
        return repository.save(entity);
    }

    @Override
    public PetEntity update(PetEntity petEntity) {
        return repository.save(petEntity);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
