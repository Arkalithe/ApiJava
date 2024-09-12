package fr.huamnbooster.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import fr.huamnbooster.springboot.enumeration.Roles;
import fr.huamnbooster.springboot.jsonview.UserJsonView;
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
    @JsonView(UserJsonView.showUserSimple.class)
    private String nom;

    @Column(unique = true, nullable = false)
    @NotBlank
    @Email
    @JsonView(UserJsonView.showUserSimple.class)
    private String email;

    @Column(nullable = false)
    @NotBlank
    @Size(min = 8)
    @JsonView(UserJsonView.showUserSimple.class)
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