package mohamed.hakim.backend.mappers;


import mohamed.hakim.backend.dtos.CreditDto;
import mohamed.hakim.backend.dtos.CreditImmobilierDto;
import mohamed.hakim.backend.dtos.CreditPersonnelDto;
import mohamed.hakim.backend.dtos.CreditProfessionnelDto;
import mohamed.hakim.backend.entities.Credit;
import mohamed.hakim.backend.entities.CreditImmobilier;
import mohamed.hakim.backend.entities.CreditPersonnel;
import mohamed.hakim.backend.entities.CreditProfessionnel;
import org.springframework.stereotype.Service;

@Service
public class CreditMapper {

    public CreditDto toCreditDto(Credit credit) {
        if (credit == null) {
            return null;
        }
        CreditDto creditDTO = new CreditDto();
        creditDTO.setId(credit.getId());
        creditDTO.setDateDemande(credit.getDateDemande());
        creditDTO.setStatut(credit.getStatut());
        creditDTO.setMontant(credit.getMontant());
        creditDTO.setDateAcception(credit.getDateAcception());
        creditDTO.setDureeRemboursement(credit.getDureeRemboursement());
        creditDTO.setTauxInteret(credit.getTauxInteret());

        return creditDTO;
    }

    public CreditImmobilierDto toCreditImmobilierDto(CreditImmobilier creditImmobilier) {
        if (creditImmobilier == null) {
            return null;
        }
        CreditImmobilierDto creditImmobilierDTO = new CreditImmobilierDto();
        creditImmobilierDTO.setId(creditImmobilier.getId());
        creditImmobilierDTO.setDateDemande(creditImmobilier.getDateDemande());
        creditImmobilierDTO.setStatut(creditImmobilier.getStatut());
        creditImmobilierDTO.setDateAcception(creditImmobilier.getDateAcception());
        creditImmobilierDTO.setMontant(creditImmobilier.getMontant());
        creditImmobilierDTO.setDureeRemboursement(creditImmobilier.getDureeRemboursement());
        creditImmobilierDTO.setTauxInteret(creditImmobilier.getTauxInteret());
        creditImmobilierDTO.setTypeBien(creditImmobilier.getTypeBien());

        return creditImmobilierDTO;
    }

    public CreditImmobilier toCreditImmobilier(CreditImmobilierDto creditImmobilierDTO) {
        if (creditImmobilierDTO == null) {
            return null;
        }
        CreditImmobilier creditImmobilier = new CreditImmobilier();
        creditImmobilier.setId(creditImmobilierDTO.getId());
        creditImmobilier.setDateDemande(creditImmobilierDTO.getDateDemande());
        creditImmobilier.setStatut(creditImmobilierDTO.getStatut());
        creditImmobilier.setDateAcception(creditImmobilierDTO.getDateAcception());
        creditImmobilier.setMontant(creditImmobilierDTO.getMontant());
        creditImmobilier.setDureeRemboursement(creditImmobilierDTO.getDureeRemboursement());
        creditImmobilier.setTauxInteret(creditImmobilierDTO.getTauxInteret());
        creditImmobilier.setTypeBien(creditImmobilierDTO.getTypeBien());

        return creditImmobilier;
    }

    public CreditProfessionnelDto toCreditProfessionnelDto(CreditProfessionnel creditProfessionnel) {
        if (creditProfessionnel == null) {
            return null;
        }
        CreditProfessionnelDto creditProfessionnelDTO = new CreditProfessionnelDto();
        creditProfessionnelDTO.setId(creditProfessionnel.getId());
        creditProfessionnelDTO.setDateDemande(creditProfessionnel.getDateDemande());
        creditProfessionnelDTO.setStatut(creditProfessionnel.getStatut());
        creditProfessionnelDTO.setDateAcception(creditProfessionnel.getDateAcception());
        creditProfessionnelDTO.setMontant(creditProfessionnel.getMontant());
        creditProfessionnelDTO.setDureeRemboursement(creditProfessionnel.getDureeRemboursement());
        creditProfessionnelDTO.setTauxInteret(creditProfessionnel.getTauxInteret());
        creditProfessionnelDTO.setMotif(creditProfessionnel.getMotif());
        creditProfessionnelDTO.setRaisonSociale(creditProfessionnel.getRaisonSociale());

        return creditProfessionnelDTO;
    }

    public CreditProfessionnel toCreditProfessionnel(CreditProfessionnelDto creditProfessionnelDTO) {
        if (creditProfessionnelDTO == null) {
            return null;
        }
        CreditProfessionnel creditProfessionnel = new CreditProfessionnel();
        creditProfessionnel.setId(creditProfessionnelDTO.getId());
        creditProfessionnel.setDateDemande(creditProfessionnelDTO.getDateDemande());
        creditProfessionnel.setStatut(creditProfessionnelDTO.getStatut());
        creditProfessionnel.setDateAcception(creditProfessionnelDTO.getDateAcception());
        creditProfessionnel.setMontant(creditProfessionnelDTO.getMontant());
        creditProfessionnel.setDureeRemboursement(creditProfessionnelDTO.getDureeRemboursement());
        creditProfessionnel.setTauxInteret(creditProfessionnelDTO.getTauxInteret());
        creditProfessionnel.setMotif(creditProfessionnelDTO.getMotif());
        creditProfessionnel.setRaisonSociale(creditProfessionnelDTO.getRaisonSociale());

        return creditProfessionnel;
    }

    public CreditPersonnelDto toCreditPersonnelDto(CreditPersonnel creditPersonnel) {
        if (creditPersonnel == null) {
            return null;
        }
        CreditPersonnelDto creditPersonnelDTO = new CreditPersonnelDto();
        creditPersonnelDTO.setId(creditPersonnel.getId());
        creditPersonnelDTO.setDateDemande(creditPersonnel.getDateDemande());
        creditPersonnelDTO.setStatut(creditPersonnel.getStatut());
        creditPersonnelDTO.setMontant(creditPersonnel.getMontant());
        creditPersonnelDTO.setDateAcception(creditPersonnel.getDateAcception());
        creditPersonnelDTO.setDureeRemboursement(creditPersonnel.getDureeRemboursement());
        creditPersonnelDTO.setTauxInteret(creditPersonnel.getTauxInteret());
        creditPersonnelDTO.setMotif(creditPersonnel.getMotif());

        return creditPersonnelDTO;
    }

    public CreditPersonnel toCreditPersonnel(CreditPersonnelDto creditPersonnelDTO) {
        if (creditPersonnelDTO == null) {
            return null;
        }
        CreditPersonnel creditPersonnel = new CreditPersonnel();
        creditPersonnel.setId(creditPersonnelDTO.getId());
        creditPersonnel.setDateDemande(creditPersonnelDTO.getDateDemande());
        creditPersonnel.setStatut(creditPersonnelDTO.getStatut());
        creditPersonnel.setMontant(creditPersonnelDTO.getMontant());
        creditPersonnel.setDateAcception(creditPersonnelDTO.getDateAcception());
        creditPersonnel.setDureeRemboursement(creditPersonnelDTO.getDureeRemboursement());
        creditPersonnel.setTauxInteret(creditPersonnelDTO.getTauxInteret());
        creditPersonnel.setMotif(creditPersonnelDTO.getMotif());

        return creditPersonnel;
    }
}
