package sn.uba.reservationsalles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import sn.uba.reservationsalles.domain.Notifications;

@CrossOrigin
public interface NotificationsRepository extends JpaRepository<Notifications, Long> {
}
