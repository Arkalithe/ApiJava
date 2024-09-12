package fr.huamnbooster.springboot.service;

import fr.huamnbooster.springboot.DTO.ReservationDTO;
import fr.huamnbooster.springboot.enumeration.StatutReservation;
import fr.huamnbooster.springboot.mapper.ReservationMapper;
import fr.huamnbooster.springboot.mapper.UserMapper;
import fr.huamnbooster.springboot.model.Borne;
import fr.huamnbooster.springboot.model.Reservation;
import fr.huamnbooster.springboot.model.User;
import fr.huamnbooster.springboot.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final BorneService borneService;

    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> findReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public List<Reservation> findReservationsByUser(User user) {
        return reservationRepository.findReservationByUser(user);
    }

    public ReservationDTO createReservation(ReservationDTO reservationDTO) {
        Reservation reservation = ReservationMapper.toReservation(reservationDTO);
        Reservation reservationUser = reservationRepository.saveAndFlush(reservation);
        return ReservationMapper.toReservationDto(reservationUser);
    }

    public List<Reservation> findReservationsByBorne(Long id) {
        Borne borne = borneService.findBorneById(id).get();
        return reservationRepository.findReservationsByBorne(borne);
    }

    public List<Reservation> findReservationByStatut(StatutReservation statut) {
        return reservationRepository.findReservationByStatut(statut);
    }

    public List<Reservation> findReservationByDateHeureDebutAfter(LocalDateTime date) {
        return reservationRepository.findReservationByDateHeureDebutAfter(date);
    }

    public List<Reservation> findReservationByDateHeureDebutBefore(LocalDateTime date) {
        return reservationRepository.findReservationByDateHeureDebutBefore(date);
    }

    public List<Reservation> findReservationByDateHeureDebutBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return reservationRepository.findReservationByDateHeureDebutBetween(startDate, endDate);
    }

    public Reservation updateReservation(Long id, Reservation reservation) {
        Reservation existingReservation = reservationRepository.findById(id).orElse(null);
        if (existingReservation != null) {
            reservation.setId(existingReservation.getId());
            return reservationRepository.save(reservation);
        } else {
            return null;
        }
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
