import { ISalesManager } from './ISalesManager';
import { IOffice } from './IOffice';

export interface IAppContext {
    salesManagers: ISalesManager[];
    offices: IOffice[];
}