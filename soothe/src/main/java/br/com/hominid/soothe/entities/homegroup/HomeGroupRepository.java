package br.com.hominid.soothe.entities.homegroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HomeGroupRepository extends JpaRepository<HomeGroupEntity, UUID> {
}
