package br.com.hominid.soothe.service;

import br.com.hominid.soothe.entities.PersonEntity;
import br.com.hominid.soothe.repository.PersonRepository;
import br.com.hominid.soothe.service.crud.PersonCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PersonService extends PersonCrudService {

    @Autowired
    PersonRepository repository;

    public PersonEntity findPersonByEmail(String email) {
        return repository.findByEmail(email);
    }

}
