package br.com.hominid.soothe.controller;

import br.com.hominid.soothe.entities.dto.PetDTO;
import br.com.hominid.soothe.entities.PetEntity;
import br.com.hominid.soothe.entities.mapper.PetMapper;
import br.com.hominid.soothe.service.PetCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/soothe")
public class PetController {

    @Autowired
    private PetCrudService service;
    @Autowired
    private PetMapper mapper;

    @GetMapping("/pet")
    public List<PetDTO> getAll() {
        return service.getAll()
                .stream()
                .map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/pet/{id}")
    public PetDTO getById(@PathVariable String id) {
        PetEntity entity = service.getById(UUID.fromString(id));
        return mapper.toDto(entity);
    }

    @PostMapping("/pet")
    public PetDTO create(@RequestBody PetDTO pet) throws Exception {
        try {
            final PetEntity petEntity = mapper.toEntity(pet);
            return mapper.toDto(service.create(petEntity));
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e.getCause());
        }
    }

    @DeleteMapping("/pet/{id}")
    public void delete(@PathVariable String id) throws Exception {
        try {
            service.delete(UUID.fromString(id));
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e.getCause());
        }
    }

}
