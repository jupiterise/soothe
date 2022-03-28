package br.com.hominid.soothe.entities.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface PersonEntityRepository extends JpaRepository<PersonEntity, UUID> {
}
