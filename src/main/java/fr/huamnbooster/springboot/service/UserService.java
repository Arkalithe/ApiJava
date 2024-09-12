package fr.huamnbooster.springboot.service;

import com.fasterxml.jackson.annotation.JsonView;
import fr.huamnbooster.springboot.DTO.UserDTO;
import fr.huamnbooster.springboot.jsonview.UserJsonView;
import fr.huamnbooster.springboot.mapper.UserMapper;
import fr.huamnbooster.springboot.model.User;
import fr.huamnbooster.springboot.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @JsonView(UserJsonView.showUserSimple.class)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> findByNomContaining(String nom) {
        return userRepository.findByNomContaining(nom);
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = UserMapper.toUser(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.saveAndFlush(user);
        return UserMapper.toUserDto(savedUser);
    }

    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            user.setId(existingUser.getId());
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


    public User login(String nom, String password, Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null && user.getNom().equals(nom) && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }
}
