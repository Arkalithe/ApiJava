package fr.huamnbooster.springboot.model;

import fr.huamnbooster.springboot.enumeration.Roles;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String nom;

    @Column(unique = true, nullable = false)
    @NotBlank
    @Email
    private String email;

    @Column(nullable = false)
    @NotBlank
    @Size(min = 8)
    private String password;
    
    @Column(nullable = false)
    @NotNull
    private Roles role;

    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations = new ArrayList<>();

    @Transient
    private boolean isActive;

    public boolean getIsActive() {
        LocalDateTime now = LocalDateTime.now();
        return getReservations().stream().anyMatch(r -> r.getDateHeureDebut().isAfter(now));

    }
}