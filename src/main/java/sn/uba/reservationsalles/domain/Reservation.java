package sn.uba.reservationsalles.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Long id;
   // private LocalDate date;
    private LocalDateTime dateHeureDebut;
    private LocalDateTime dateHeureFin;
   // private LocalTime heureFin;

    @OneToMany(mappedBy = "reservation")
    Set<Notifications> notification = new HashSet<>();

   @ManyToOne
    Salle salle;

   @ManyToOne
    Utilisateur utilisateur;


}
