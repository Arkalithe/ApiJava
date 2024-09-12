package fr.huamnbooster.springboot.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import fr.huamnbooster.springboot.enumeration.Roles;
import fr.huamnbooster.springboot.jsonview.UserJsonView;
import lombok.*;

@Data
@JsonView(UserJsonView.showUserSimple.class)
public class UserDTO {
    private String nom;
    private String email;
    private String password;
    private Roles role;
}
