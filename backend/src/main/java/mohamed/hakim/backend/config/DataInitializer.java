package mohamed.hakim.backend.config;

import mohamed.hakim.backend.entities.*;
import mohamed.hakim.backend.enums.StatutCredit;
import mohamed.hakim.backend.enums.TypeBienImmobilier;
import mohamed.hakim.backend.enums.TypeRemboursement;
import mohamed.hakim.backend.repositories.ClientRepository;
import mohamed.hakim.backend.repositories.CreditRepository;
import mohamed.hakim.backend.repositories.RemboursementRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class DataInitializer implements ApplicationRunner {

    private final ClientRepository clientRepository;
    private final CreditRepository creditRepository;
    private final RemboursementRepository remboursementRepository;

    public DataInitializer(ClientRepository clientRepository,
                           CreditRepository creditRepository,
                           RemboursementRepository remboursementRepository) {
        this.clientRepository = clientRepository;
        this.creditRepository = creditRepository;
        this.remboursementRepository = remboursementRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // Sample Clients
        Client client1 = new Client();
        client1.setNom("Alice Dupont");
        client1.setEmail("alice.dupont@example.com");

        Client client2 = new Client();
        client2.setNom("Bob Martin");
        client2.setEmail("bob.martin@example.com");

        clientRepository.saveAll(Arrays.asList(client1, client2));

        // Sample Credits
        CreditPersonnel creditPersonnel = new CreditPersonnel();
        creditPersonnel.setDateDemande(LocalDate.now().minusDays(10));
        creditPersonnel.setStatut(StatutCredit.ACCEPTE);
        creditPersonnel.setDateAcception(LocalDate.now().minusDays(8));
        creditPersonnel.setMontant(15000.0);
        creditPersonnel.setDureeRemboursement(24);
        creditPersonnel.setTauxInteret(4.5);
        creditPersonnel.setMotif("Achat d'une voiture");
        creditPersonnel.setClient(client1);

        CreditImmobilier creditImmobilier = new CreditImmobilier();
        creditImmobilier.setDateDemande(LocalDate.now().minusDays(15));
        creditImmobilier.setStatut(StatutCredit.EN_COURS);
        creditImmobilier.setDateAcception(null);
        creditImmobilier.setMontant(300000.0);
        creditImmobilier.setDureeRemboursement(360);
        creditImmobilier.setTauxInteret(3.9);
        creditImmobilier.setTypeBien(TypeBienImmobilier.MAISON);
        creditImmobilier.setClient(client2);

        CreditProfessionnel creditProfessionnel = new CreditProfessionnel();
        creditProfessionnel.setDateDemande(LocalDate.now().minusDays(5));
        creditProfessionnel.setStatut(StatutCredit.REJETE);
        creditProfessionnel.setDateAcception(null);
        creditProfessionnel.setMontant(75000.0);
        creditProfessionnel.setDureeRemboursement(36);
        creditProfessionnel.setTauxInteret(5.0);
        creditProfessionnel.setMotif("Extension de l'entreprise");
        creditProfessionnel.setRaisonSociale("Tech Solutions SARL");
        creditProfessionnel.setClient(client1);

        creditRepository.saveAll(Arrays.asList(creditPersonnel, creditImmobilier, creditProfessionnel));

        // Sample Repayments
        Remboursement r1 = new Remboursement();
        r1.setDate(LocalDate.now().minusMonths(1));
        r1.setMontant(625.0);
        r1.setType(TypeRemboursement.MENSUALITE);
        r1.setCredit(creditPersonnel);

        Remboursement r2 = new Remboursement();
        r2.setDate(LocalDate.now().minusMonths(2));
        r2.setMontant(625.0);
        r2.setType(TypeRemboursement.MENSUALITE);
        r2.setCredit(creditPersonnel);

        Remboursement r3 = new Remboursement();
        r3.setDate(LocalDate.now().minusMonths(1));
        r3.setMontant(1250.0);
        r3.setType(TypeRemboursement.REMBOURSEMENT_ANTICIPE);
        r3.setCredit(creditImmobilier);

        remboursementRepository.saveAll(Arrays.asList(r1, r2, r3));

        System.out.println("Base de données initialisée avec des données de test.");
    }
}