package br.com.hominid.soothe.controller;

import br.com.hominid.soothe.entities.EventEntity;
import br.com.hominid.soothe.entities.PetEntity;
import br.com.hominid.soothe.entities.dto.EventDTO;
import br.com.hominid.soothe.entities.mapper.EventMapper;
import br.com.hominid.soothe.service.EventService;
import br.com.hominid.soothe.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.SpringSessionContext;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/soothe")
public class EventController {

    @Autowired
    private EventService service;
    @Autowired
    private EventMapper mapper;

    @Autowired
    private PetService petService;

    @PostMapping("/createEvent")
    public EventDTO createEvent(@RequestBody EventDTO event) throws Exception {
        try {
            final EventEntity entity = mapper.toEntity(event);
            entity.setEventMoment(LocalDateTime.now());
            Set<UUID> petIds = entity.getPets().stream().map(PetEntity::getId).collect(Collectors.toSet());
            entity.getPets().clear();
            petIds.forEach(id -> {
                entity.getPets().add(petService.getById(id));
            });
            return mapper.toDto(service.create(entity));
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e.getCause());
        }
    }

    @GetMapping("/event")
    public List<EventDTO> getAll() {
        return service.getAll()
                .stream()
                .map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/event/{id}")
    public EventDTO getById(@PathVariable String id) {
        EventEntity entity = service.getById(UUID.fromString(id));
        return mapper.toDto(entity);
    }

    @PostMapping("/event")
    public EventDTO create(@RequestBody EventDTO event) throws Exception {
        try {
            final EventEntity entity = mapper.toEntity(event);
            return mapper.toDto(service.create(entity));
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e.getCause());
        }
    }

    @DeleteMapping("/event/{id}")
    public void delete(@PathVariable String id) throws Exception {
        try {
            service.delete(UUID.fromString(id));
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e.getCause());
        }
    }

}
