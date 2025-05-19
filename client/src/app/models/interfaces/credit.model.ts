import { StatutCredit } from '../enums/statut-credit.enum';
import { Client } from './client.model';
import { Remboursement } from './remboursement.model';
import {TypeBienImmobilier} from '../enums/type-bien.enum';

export interface Credit {
  id?: number;
  dateDemande: Date;
  statut: StatutCredit;
  dateAcception: Date | null;
  montant: number;
  dureeRemboursement: number;
  tauxInteret: number;
  client: Client;
  remboursements?: Remboursement[];
}

export interface CreditPersonnel extends Credit {
  motif: string;
}

export interface CreditImmobilier extends Credit {
  typeBien: TypeBienImmobilier;
}

export interface CreditProfessionnel extends Credit {
  motif: string;
  raisonSociale: string;
}
