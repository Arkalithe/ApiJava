package fr.huamnbooster.springboot.model;

import com.fasterxml.jackson.annotation.JsonView;
import fr.huamnbooster.springboot.enumeration.StatutBornes;
import fr.huamnbooster.springboot.jsonview.ReservationJsonView;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

@Entity
@Setter
@Getter
@EqualsAndHashCode
public class Borne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(ReservationJsonView.showReservationSimple.class)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    @JsonView(ReservationJsonView.showReservationSimple.class)
    private String emplacement;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutBornes statut;

    @Column(nullable = false)
    @NotNull
    @JsonView(ReservationJsonView.showReservationSimple.class)
    private double tarifsHoraires;


}

