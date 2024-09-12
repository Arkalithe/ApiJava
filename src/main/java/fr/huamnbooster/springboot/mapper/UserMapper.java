package fr.huamnbooster.springboot.mapper;

import fr.huamnbooster.springboot.DTO.UserDTO;
import fr.huamnbooster.springboot.model.User;

public class UserMapper {


    public static UserDTO toUserDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setNom(user.getNom());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    public static User toUser(UserDTO userDTO) {
        User user = new User();
        user.setNom(userDTO.getNom());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return user;
    }

}
