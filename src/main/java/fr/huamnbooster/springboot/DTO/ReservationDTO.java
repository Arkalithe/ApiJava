package fr.huamnbooster.springboot.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationDTO {
    private LocalDateTime dateHeureDebut;
    private int duree;
    private String statut;
}
