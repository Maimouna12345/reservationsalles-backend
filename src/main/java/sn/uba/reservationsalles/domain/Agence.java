package sn.uba.reservationsalles.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(nullable = false, unique = true)
    private Long id;
    private String nom;
    private String adresse;
    private String codePostal;

    @OneToMany(mappedBy = "agence")
     List<Salle> salles = new ArrayList<>();

}
