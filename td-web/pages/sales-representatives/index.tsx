import React, { FunctionComponent } from 'react';
import AppContextProvider from '../../components/utility/context/AppContext';
import SalesRepresentative from '../../components/common/SalesRepresentatives/SalesRepresentative';
import SalesRepresentativesContextProvider
    from '../../components/common/SalesRepresentatives/context/SalesRepresentativeContext';

const Index: FunctionComponent = () => (
    <AppContextProvider>
        <SalesRepresentativesContextProvider>
            <SalesRepresentative/>
        </SalesRepresentativesContextProvider>
    </AppContextProvider>
);

export default Index;
