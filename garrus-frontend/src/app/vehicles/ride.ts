import {Driver} from './driver';
import {Vehicle} from './vehicle';
export class Ride {
  id: number;
  plate: string;
  start: Date;
  end: Date;
  chofer: Driver;
  vehicle: Vehicle;
  details: string;
  distance: number;

}
