package fr.huamnbooster.springboot.DTO;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String nom;
    private String password;

}
