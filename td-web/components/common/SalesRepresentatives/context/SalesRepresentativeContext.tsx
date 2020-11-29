import React, { createContext, Dispatch, FC, useReducer } from 'react';
import SalesRepresentativesReducer, { initialSalesRepresentativesStates } from '../../../utility/store/reducers/salesRepresentativeReducer';
import { ISalesRepresentative } from '../../../../pages/sales-representatives/interfaces/ISalesRepresentative';

interface ISalesRepresentativesContext {
    salesRepresentatives: ISalesRepresentative[],
    dispatchSalesRepresentatives: Dispatch<any>
}

export const SalesRepresentativesContext = createContext<ISalesRepresentativesContext>({
    salesRepresentatives: initialSalesRepresentativesStates,
    dispatchSalesRepresentatives: () => {
    },
});

const SalesRepresentativesContextProvider: FC = ( { children } ) => {
    const [salesRepresentatives, dispatchSalesRepresentatives] = useReducer(SalesRepresentativesReducer, initialSalesRepresentativesStates);

    return (
        <SalesRepresentativesContext.Provider value={{
            dispatchSalesRepresentatives,
            salesRepresentatives,
        }}>
            {children}
        </SalesRepresentativesContext.Provider>
    );
};

export default SalesRepresentativesContextProvider;