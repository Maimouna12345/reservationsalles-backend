package sn.uba.reservationsalles.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Notifications {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;
    private String type;
    private String destinataire;
    private String message;

    @ManyToOne
    Utilisateur utilisateur;

    @ManyToOne
    Reservation reservation;

    
    
    
}
