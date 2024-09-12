package fr.huamnbooster.springboot.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.huamnbooster.springboot.enumeration.StatutReservation;
import fr.huamnbooster.springboot.jsonview.ReservationJsonView;
import fr.huamnbooster.springboot.model.Borne;
import fr.huamnbooster.springboot.model.Reservation;
import fr.huamnbooster.springboot.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        return reservationService.findReservationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    @JsonView(ReservationJsonView.showReservationSimple.class)
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation);
    }

    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        return reservationService.updateReservation(id, reservation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/borne/{id}")
    @JsonView(ReservationJsonView.showReservationSimple.class)
    public List<Reservation> findReservationsByBorne(@PathVariable Long id) {
        return reservationService.findReservationsByBorne(id);
    }

    @GetMapping("/statut")
    @JsonView(ReservationJsonView.showReservationSimple.class)
    public List<Reservation> findReservationByStatut(@RequestParam StatutReservation statut) {
        return reservationService.findReservationByStatut(statut);
    }
}
