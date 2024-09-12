package fr.huamnbooster.springboot.repository;

import fr.huamnbooster.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByEmail(String email);

    User findByNom(String nom);

    List<User> findByNomContaining(String nom);

    User login(String nom, String password, Long id);


}
