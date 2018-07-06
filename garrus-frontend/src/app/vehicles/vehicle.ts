/**
 * New typescript file
 */
import { Driver } from './driver';
import { Entry } from './entry';

export class Vehicle {
  plate: string;
  gas: string;
  vehicle_type: string;
  details: string;
  year: string;
  brand: string;
  model: string;
  chofer: Driver;
  soap_date: string;
  tyres: string;
  last_maintenance: Date;
  next_inspection: Date;
  history: Entry[];
}
