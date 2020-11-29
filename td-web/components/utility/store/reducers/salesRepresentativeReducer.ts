import { ISalesRepresentativeReducerActions } from '../actions/interfaces/ISalesRepresentativeState';
import { ISalesRepresentative } from '../../../../pages/sales-representatives/interfaces/ISalesRepresentative';

type SalesRepresentativeReducer = ISalesRepresentativeReducerActions;
type Payload = ISalesRepresentativeReducerActions['payload'];

export const initialSalesRepresentativesStates: ISalesRepresentative[] = [];

const SalesRepresentativesReducer = ( state: ISalesRepresentative[], { type, payload }: SalesRepresentativeReducer ) => {
    switch (type) {
        case 'SET_SALES_REPRESENTATIVES':
            return setSalesRepresentative(payload);
        default:
            throw new Error('Wrong action type');
    }
};

const setSalesRepresentative = ( payload: Payload ) => {
    if (payload) {
        return [...payload];
    }
};

export default SalesRepresentativesReducer;