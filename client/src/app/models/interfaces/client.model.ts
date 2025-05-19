import { Credit } from './credit.model';

export interface Client {
  id?: number;
  nom: string;
  email: string;
  credits?: Credit[];
}
