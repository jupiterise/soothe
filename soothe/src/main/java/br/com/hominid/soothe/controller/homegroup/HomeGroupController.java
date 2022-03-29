package br.com.hominid.soothe.controller.homegroup;

import br.com.hominid.soothe.entities.homegroup.HomeGroupDTO;
import br.com.hominid.soothe.entities.homegroup.HomeGroupEntity;
import br.com.hominid.soothe.entities.homegroup.HomeGroupMapper;
import br.com.hominid.soothe.entities.pet.PetEntity;
import br.com.hominid.soothe.service.HomeGroupCrudService;
import br.com.hominid.soothe.service.PetCrudService;
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
    private PetCrudService petService;

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

    @PutMapping("/homeGroup/{homeGroupId}/pets/{petId}")
    public HomeGroupDTO joinHomeGroupToPet(@PathVariable UUID homeGroupId, @PathVariable UUID petId) {
        HomeGroupEntity homeGroupEntity = service.getById(homeGroupId);
        PetEntity petEntity = petService.getById(petId);
        homeGroupEntity.getPets().add(petEntity);
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
