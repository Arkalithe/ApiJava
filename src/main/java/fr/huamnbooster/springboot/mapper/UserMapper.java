package fr.huamnbooster.springboot.mapper;

import fr.huamnbooster.springboot.DTO.UserDTO;
import fr.huamnbooster.springboot.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;


public class UserMapper {

    private static PasswordEncoder passwordEncoder;

    public static UserDTO toUserDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setNom(user.getNom());
        userDTO.setEmail(user.getNom());
        String passwordEncode = passwordEncoder.encode(user.getPassword());
        userDTO.setPassword(passwordEncode);
        return userDTO;
    }

    public static User toUser(UserDTO userDTO) {
        User user = new User();
        user.setNom(userDTO.getNom());
        user.setEmail(userDTO.getNom());
        String passwordEncode = passwordEncoder.encode(userDTO.getPassword());
        user.setPassword(passwordEncode);
        return user;
    }

}
