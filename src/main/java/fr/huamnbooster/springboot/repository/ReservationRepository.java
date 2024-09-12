package fr.huamnbooster.springboot.repository;

import fr.huamnbooster.springboot.enumeration.StatutReservation;
import fr.huamnbooster.springboot.model.Borne;
import fr.huamnbooster.springboot.model.Reservation;
import fr.huamnbooster.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findReservationByUser(User user);

    List<Reservation> findReservationsByBorne(Borne borne);

    List<Reservation> findReservationByStatut(StatutReservation statut);

    List<Reservation> findReservationByDateHeureDebutAfter(LocalDateTime date);

    List<Reservation> findReservationByDateHeureDebutBefore(LocalDateTime date);

    List<Reservation> findReservationByDateHeureDebutBetween(LocalDateTime startDate, LocalDateTime endDate);


}
