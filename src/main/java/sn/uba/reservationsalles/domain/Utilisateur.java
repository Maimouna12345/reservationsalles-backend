package sn.uba.reservationsalles.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true )
    private Long id;
    private String nom;
    private String email;
    private String password;
    private int numTelephone;
    private String departement;

    @ManyToMany
    @JoinTable(name = "utilisateur_role",
            joinColumns = @JoinColumn(name = "utilisateur_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    List<Role> roles = new ArrayList<>();

    @OneToMany(mappedBy = "utilisateur")
    List<Salle> salles =  new ArrayList<>();

    @OneToMany(mappedBy = "utilisateur")
    Set<Notifications> notifications= new HashSet<>();

    @OneToMany(mappedBy = "utilisateur")
    List<Reservation> reservation = new ArrayList<>();


}
