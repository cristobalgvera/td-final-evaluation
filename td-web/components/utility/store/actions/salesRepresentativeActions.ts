import { ISalesRepresentative } from '../../../../pages/sales-representatives/interfaces/ISalesRepresentative';
import { ISalesRepresentativeActions } from './interfaces/ISalesRepresentativeState';

const setSalesRepresentatives = ( salesRepresentatives: ISalesRepresentative[] ): ISalesRepresentativeActions => ({
    type: 'SET_SALES_REPRESENTATIVES',
    payload: salesRepresentatives,
});

export { setSalesRepresentatives };