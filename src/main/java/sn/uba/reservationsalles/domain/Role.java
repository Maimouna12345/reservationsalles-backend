package sn.uba.reservationsalles.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    @Id
    private Long id;
    private String nom;

  /*  @ManyToMany(mappedBy ="roles" )
    List<Utilisateur> utilisateurs;*/

}
