package br.com.hominid.soothe.controller.event;

import br.com.hominid.soothe.entities.event.EventDTO;
import br.com.hominid.soothe.entities.event.EventEntity;
import br.com.hominid.soothe.entities.event.EventMapper;
import br.com.hominid.soothe.service.EventCrudService;
import br.com.hominid.soothe.service.PetCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/soothe")
public class EventController {

    @Autowired
    private EventCrudService service;
    @Autowired
    private EventMapper mapper;

    @Autowired
    private PetCrudService petService;

    @GetMapping("/person")
    public List<EventDTO> getAll() {
        return service.getAll()
                .stream()
                .map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/person/{id}")
    public EventDTO getById(@PathVariable String id) {
        EventEntity entity = service.getById(UUID.fromString(id));
        return mapper.toDto(entity);
    }

    @PostMapping("/person")
    public EventDTO create(@RequestBody EventDTO person) throws Exception {
        try {
            final EventEntity personEntity = mapper.toEntity(person);
            return mapper.toDto(service.create(personEntity));
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e.getCause());
        }
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
