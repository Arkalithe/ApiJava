package fr.huamnbooster.springboot.model;

import com.fasterxml.jackson.annotation.JsonView;
import fr.huamnbooster.springboot.enumeration.StatutReservation;
import fr.huamnbooster.springboot.jsonview.ReservationJsonView;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Setter
@Getter
@EqualsAndHashCode
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull
    private User user;

    @ManyToOne
    @NotNull
    private Borne borne;

    @Column(nullable = false)
    @JsonView(ReservationJsonView.showReservationSimple.class)
    private LocalDateTime dateHeureDebut;

    @Column(nullable = false)
    @NotNull
    @JsonView(ReservationJsonView.showReservationSimple.class)
    private int duree;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @JsonView(ReservationJsonView.showReservationSimple.class)
    private StatutReservation statut;

    @Transient
    private int priorite;

    public int getPriorite() {
        long betwenHour = ChronoUnit.HOURS.between(LocalDateTime.now(), dateHeureDebut);
        if (statut == StatutReservation.ENCOURS) {
            if (betwenHour < 24) return 3;
            if (betwenHour < 48) return 2;
        }
        return 1;
    }
}

