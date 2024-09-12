package fr.huamnbooster.springboot.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import fr.huamnbooster.springboot.jsonview.ReservationJsonView;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonView(ReservationJsonView.showReservationSimple.class)
public class ReservationDTO {
    private LocalDateTime dateHeureDebut;
    private int duree;
    private String statut;
}
