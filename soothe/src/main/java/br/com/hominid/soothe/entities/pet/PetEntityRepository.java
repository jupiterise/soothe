package br.com.hominid.soothe.entities.pet;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PetEntityRepository extends JpaRepository<PetEntity, UUID> {
}
