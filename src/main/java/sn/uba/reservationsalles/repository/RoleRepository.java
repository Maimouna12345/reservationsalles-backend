package sn.uba.reservationsalles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import sn.uba.reservationsalles.domain.Role;

@CrossOrigin
public interface RoleRepository extends JpaRepository<Role, Long> {
}
