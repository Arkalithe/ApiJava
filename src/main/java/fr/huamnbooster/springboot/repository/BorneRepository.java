package fr.huamnbooster.springboot.repository;

import fr.huamnbooster.springboot.model.Borne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorneRepository extends JpaRepository<Borne, Long> {


}
