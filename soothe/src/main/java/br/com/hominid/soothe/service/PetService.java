package br.com.hominid.soothe.service;

import br.com.hominid.soothe.entities.pet.PetEntity;
import br.com.hominid.soothe.entities.pet.PetEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PetService {

    @Autowired
    PetEntityRepository repository;

    public PetEntity getById(UUID id) {
        Optional<PetEntity> entity = repository.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new EntityNotFoundException("Entity was not found on given id: " + id);
        }
    }

    public List<PetEntity> getAll() {
        return repository.findAll();
    }

    public PetEntity create(PetEntity entity) {
        return repository.save(entity);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
