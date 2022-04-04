package br.com.hominid.soothe.controller;

import br.com.hominid.soothe.entities.dto.HomeGroupDTO;
import br.com.hominid.soothe.entities.HomeGroupEntity;
import br.com.hominid.soothe.entities.mapper.HomeGroupMapper;
import br.com.hominid.soothe.entities.PersonEntity;
import br.com.hominid.soothe.service.HomeGroupCrudService;
import br.com.hominid.soothe.service.PersonCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/soothe")
public class HomeGroupController {

    @Autowired
    private HomeGroupCrudService service;
    @Autowired
    private HomeGroupMapper mapper;

    @Autowired
    private PersonCrudService personCrudService;

    @GetMapping("/homeGroup")
    public List<HomeGroupDTO> getAll() {
        return service.getAll()
                .stream()
                .map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/homeGroup/{id}")
    public HomeGroupDTO getById(@PathVariable String id) {
        HomeGroupEntity entity = service.getById(UUID.fromString(id));
        return mapper.toDto(entity);
    }

    @PostMapping("/homeGroup")
    public HomeGroupDTO create(@RequestBody HomeGroupDTO homeGroup) throws Exception {
        try {
            final HomeGroupEntity homeGroupEntity = mapper.toEntity(homeGroup);
            return mapper.toDto(service.create(homeGroupEntity));
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e.getCause());
        }
    }

    @PutMapping("/homeGroup/{homeGroupId}/person/{personId}")
    public HomeGroupDTO joinHomeGroupToPet(@PathVariable UUID homeGroupId, @PathVariable UUID personId) {
        HomeGroupEntity homeGroupEntity = service.getById(homeGroupId);
        PersonEntity personEntity = personCrudService.getById(personId);
        homeGroupEntity.getResidents().add(personEntity);
        return mapper.toDto(service.update(homeGroupEntity));
    }

    @DeleteMapping("/homeGroup/{id}")
    public void delete(@PathVariable String id) throws Exception {
        try {
            service.delete(UUID.fromString(id));
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e.getCause());
        }
    }

}
