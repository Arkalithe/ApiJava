package fr.huamnbooster.springboot.mapper;

import fr.huamnbooster.springboot.DTO.ReservationDTO;
import fr.huamnbooster.springboot.DTO.UserDTO;
import fr.huamnbooster.springboot.enumeration.StatutReservation;
import fr.huamnbooster.springboot.model.Reservation;
import fr.huamnbooster.springboot.model.User;

public class ReservationMapper {


    public static ReservationDTO toReservationDto(Reservation reservation) {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setDuree(reservation.getDuree());
        reservationDTO.setDateHeureDebut(reservation.getDateHeureDebut());
        reservationDTO.setStatut(String.valueOf(reservation.getStatut()));
        return reservationDTO;
    }

    public static Reservation toReservation(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();
        reservation.setDuree(reservationDTO.getDuree());
        reservation.setDateHeureDebut(reservationDTO.getDateHeureDebut());
        reservation.setStatut(StatutReservation.valueOf(reservationDTO.getStatut()));
        return reservation;
    }


}
