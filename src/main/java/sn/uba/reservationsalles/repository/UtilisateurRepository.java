package sn.uba.reservationsalles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import sn.uba.reservationsalles.domain.Utilisateur;

@CrossOrigin
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findUtilisateurByEmailAndPassword(String email, String password);
}
