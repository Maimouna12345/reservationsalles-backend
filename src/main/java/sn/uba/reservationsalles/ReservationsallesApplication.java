package sn.uba.reservationsalles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import sn.uba.reservationsalles.domain.*;
import sn.uba.reservationsalles.repository.AgenceRepository;
import sn.uba.reservationsalles.repository.RoleRepository;
import sn.uba.reservationsalles.repository.SalleRepository;
import sn.uba.reservationsalles.repository.UtilisateurRepository;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@SpringBootApplication
public class ReservationsallesApplication implements CommandLineRunner , RepositoryRestConfigurer {

   // @Autowired // 1 methode :  Injection de dependance
  //  private  SalleRepository salleRepositoryAutowored;


    // 2 methode :  Debut :  Injection de dependance
    private final AgenceRepository agenceRepository;
    private final RoleRepository roleRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final SalleRepository salleRepository;


    public ReservationsallesApplication(AgenceRepository agenceRepository, RoleRepository roleRepository, UtilisateurRepository utilisateurRepository, SalleRepository salleRepository) {
        this.agenceRepository = agenceRepository;
        this.roleRepository = roleRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.salleRepository = salleRepository;
    }
    // Fin : Injection de dependance

    public static void main(String[] args) {
        SpringApplication.run(ReservationsallesApplication.class, args);
    }


     // C'est pour exposer l'Id de l'agence, Salle, etc
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Agence.class, Salle.class, Utilisateur.class, Reservation.class);
    }

    @Override
    public void run(String... args) throws Exception {
        // Ajouter des agences dans la BD
        Agence agence1 = new Agence();
        agence1.setAdresse("Almadie");
        agence1.setNom("Almadie");
        agence1.setCodePostal("51602");

        Agence agence2 = new Agence();
        agence2.setAdresse("Plateau");
        agence2.setNom("Plateau");
        agence2.setCodePostal("12500");


        Agence agence3 = new Agence();
        agence3.setAdresse("HLM");
        agence3.setNom("HLM");
        agence3.setCodePostal("516025");

        Agence agence4 = new Agence();
        agence4.setAdresse("Port");
        agence4.setNom("Port");
        agence4.setCodePostal("12000");

        String nomAgence1=  agence1.getNom();
        String adresseAgence1=  agence1.getAdresse();

        Agence agence5 = new Agence(null,"Mbour", "Mbour 3", "15450",null);


        List<Agence> agences = List.of(agence3, agence1, agence2, agence4, agence5);

        agenceRepository.saveAll(agences);

        // Ajouter des Roles et Utilisateurs dans la BD

        Role roleAdmin = new Role(null, "ADMIN");
        Role roleUser = new Role(null, "USER");
        List<Role> roles = List.of(roleAdmin, roleUser);

        roleRepository.saveAll(roles);

        List<Role> all = roleRepository.findAll();// La methode findAll() permet de recuperer tous elements d'une entité dans la BD
        Role roleUSER = roleRepository.findById(2L).get();
        Utilisateur utilisateur1 = new Utilisateur(null,"Maimouna NDAO","mounassendao1@gmail.com", "12345",774201180, "IT", all, null,null,null   );
        Utilisateur utilisateur2 = new Utilisateur(null,"Mamadou NDIAYE","ndiamamadou@gmail.com", "12345",774016666, "IT", all, null,null,null   );
        Utilisateur utilisateur3 = new Utilisateur(null,"Virginie Lamesse","virginie.lamesse@gmail.com", "12345",775017766, "IT", List.of(roleUSER),null,null,null);
        utilisateurRepository.save(utilisateur1);
        utilisateurRepository.save(utilisateur2);
        utilisateurRepository.save(utilisateur3);

        // Ajouter des Salles dans la BD

        Salle salle1 = new Salle();
        salle1.setNom("salle 01");
        salle1.setCapacite(10);
        salle1.setAgence(agenceRepository.findById(1L).orElseGet(null));
        salle1.setUtilisateur(utilisateurRepository.findById(2L).orElseGet(null));

        Salle salle2 = new Salle();
        salle2.setNom("salle 02");
        salle2.setCapacite(10);
        salle2.setAgence(agenceRepository.findById(1L).orElseGet(null));
        salle2.setUtilisateur(utilisateurRepository.findById(1L).orElseGet(null));

        Salle salle3 = new Salle();
        salle3.setNom("salle 03");
        salle3.setCapacite(10);
        salle3.setAgence(agenceRepository.findById(2L).orElseGet(null));
        salle3.setUtilisateur(utilisateurRepository.findById(1L).orElseGet(null));

        Salle salle4 = new Salle();
        salle4.setNom("salle 04");
        salle4.setCapacite(15);
        salle4.setAgence(agenceRepository.findById(3L).orElseGet(null));
        salle4.setUtilisateur(utilisateurRepository.findById(2L).orElseGet(null));

        Salle salle5 = new Salle();
        salle5.setNom("salle 05");
        salle5.setCapacite(17);
        salle5.setAgence(agenceRepository.findById(4L).orElseGet(null));
        salle5.setUtilisateur(utilisateurRepository.findById(1L).orElseGet(null));


        salleRepository.save(salle1);
        salleRepository.save(salle2);
        salleRepository.save(salle3);
        salleRepository.save(salle4);
        salleRepository.save(salle5);

        /*

           {
          "id": 0,
          "date": "2024-07-13",
          "heureDebut": "10:00:00",
          "heureFin": "12:00:00",
          "notification":null,
          "salle": "salles/1",
          "utilisateur": "utilisateurs/1"
          }
        */







    }


}
