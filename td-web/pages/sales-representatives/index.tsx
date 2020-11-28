import React, { FunctionComponent } from 'react';
import AppContextProvider from '../../components/utility/context/AppContext';
import SalesRepresentative from '../../components/common/SalesRepresentatives/SalesRepresentative';

const Index: FunctionComponent = () => (
    <AppContextProvider>
        <SalesRepresentative/>
    </AppContextProvider>
);

export default Index;
