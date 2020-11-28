import React, { useContext } from 'react';
import { appContext } from '../../utility/context/AppContext';
import SalesRepresentativesContextProvider, { SalesRepresentativesContext } from './context/SalesRepresentativeContext';
import Selector from './UI/Selector/Selector';
import useSalesRepresentative from './hooks/useSalesRepresentatives';

const SalesRepresentative = () => {
    const { offices, salesManagers } = useContext(appContext);
    const { data: { loading } } = useSalesRepresentative();
    const { salesRepresentatives } = useContext(SalesRepresentativesContext);

    const salesRepresentativeHelper = () => {
        if (!loading) {
            console.log('hola', salesRepresentatives);
            return salesRepresentatives
                .map(( al ) => {
                        console.log(al);
                        return (
                            <p key={al.id}>{al.mail}</p>
                        );
                    },
                );
        } else {
            return <p>Loading...</p>;
        }
    };

    return (
        <SalesRepresentativesContextProvider>
            {(offices && salesManagers) && <Selector salesManagers={salesManagers} offices={offices}/>}
            {salesRepresentativeHelper()}
        </SalesRepresentativesContextProvider>
    );
};

export default SalesRepresentative;
