package sn.uba.reservationsalles.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import sn.uba.reservationsalles.domain.Salle;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin
public interface SalleRepository extends JpaRepository<Salle, Long> {

    @Query("SELECT s FROM Salle s WHERE s.id NOT IN (" + "SELECT r.salle.id FROM Reservation r WHERE " + "(:dateHeureDebut BETWEEN r.dateHeureDebut AND r.dateHeureFin OR " + ":dateHeureFin BETWEEN r.dateHeureDebut AND r.dateHeureFin OR " + "r.dateHeureDebut BETWEEN :dateHeureDebut AND :dateHeureFin))")
    List<Salle> findAvailableSalles( @Param("dateHeureDebut") LocalDateTime dateHeureDebut, @Param("dateHeureFin") LocalDateTime dateHeureFin);


}
