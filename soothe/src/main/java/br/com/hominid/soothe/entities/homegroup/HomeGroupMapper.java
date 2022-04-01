package br.com.hominid.soothe.entities.homegroup;

public class HomeGroupMapper {

    public HomeGroupDTO toDto(HomeGroupEntity entity) {
        HomeGroupDTO homeGroupDTO = new HomeGroupDTO();
        homeGroupDTO.id = entity.getId();
        homeGroupDTO.name = entity.getName();
        homeGroupDTO.pets = entity.getPets();
        homeGroupDTO.residents = entity.getResidents();
        return homeGroupDTO;
    }

    public HomeGroupEntity toEntity(HomeGroupDTO dto) {
        HomeGroupEntity entity = new HomeGroupEntity();
        entity.setId(dto.id);
        entity.setName(dto.name);
        entity.setPets(dto.pets);
        entity.setResidents(dto.residents);
        return entity;
    }

}
