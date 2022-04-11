package br.com.hominid.soothe.service.crud;

import br.com.hominid.soothe.entities.HomeGroupEntity;
import br.com.hominid.soothe.repository.HomeGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HomeGroupCrudService implements CrudService<HomeGroupEntity> {

    @Autowired
    HomeGroupRepository repository;

    @Override
    public HomeGroupEntity getById(UUID id) {
        Optional<HomeGroupEntity> entity = repository.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new EntityNotFoundException("Entity was not found on given id: " + id);
        }
    }

    @Override
    public List<HomeGroupEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public HomeGroupEntity create(HomeGroupEntity entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public HomeGroupEntity update(HomeGroupEntity homeGroupEntity) {
        return repository.save(homeGroupEntity);
    }
}
