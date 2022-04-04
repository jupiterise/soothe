package br.com.hominid.soothe.repository;

import br.com.hominid.soothe.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, UUID> {

    List<PersonEntity> findByEmail(String email);

}
