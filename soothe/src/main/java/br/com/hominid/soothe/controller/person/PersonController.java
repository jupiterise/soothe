package br.com.hominid.soothe.controller.person;

import br.com.hominid.soothe.entities.person.PersonDTO;
import br.com.hominid.soothe.entities.person.PersonEntity;
import br.com.hominid.soothe.entities.person.PersonMapper;
import br.com.hominid.soothe.entities.pet.PetEntity;
import br.com.hominid.soothe.service.PersonService;
import br.com.hominid.soothe.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/soothe")
public class PersonController {

    @Autowired
    private PersonService service;
    @Autowired
    private PersonMapper mapper;

    @Autowired
    private PetService petService;

    @GetMapping("/person")
    public List<PersonDTO> getAll() {
        return service.getAll()
                .stream()
                .map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/person/{id}")
    public PersonDTO getById(@PathVariable String id) {
        PersonEntity entity = service.getById(UUID.fromString(id));
        return mapper.toDto(entity);
    }

    @PostMapping("/person")
    public PersonDTO create(@RequestBody PersonDTO person) throws Exception {
        try {
            final PersonEntity personEntity = mapper.toEntity(person);
            return mapper.toDto(service.create(personEntity));
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e.getCause());
        }
    }

    @PutMapping("/person/{personId}/pets/{petId}")
    public PersonDTO joinPersonToPet(@PathVariable UUID personId, @PathVariable UUID petId) {
        PersonEntity personEntity = service.getById(personId);
        PetEntity petEntity = petService.getById(petId);
        personEntity.getPets().add(petEntity);
        return mapper.toDto(service.update(personEntity));
    }

    @DeleteMapping("/person/{id}")
    public void delete(@PathVariable String id) throws Exception {
        try {
            service.delete(UUID.fromString(id));
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e.getCause());
        }
    }

}
