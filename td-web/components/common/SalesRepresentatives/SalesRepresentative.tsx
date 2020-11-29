import React, { useContext } from 'react';
import { appContext } from '../../utility/context/AppContext';
import { SalesRepresentativesContext } from './context/SalesRepresentativeContext';
import Selector from './UI/Selector/Selector';
import useSalesRepresentative from './hooks/useSalesRepresentatives';
import Table from './UI/Table/Table';

const SalesRepresentative = () => {
    const { offices, salesManagers } = useContext(appContext);
    const { data: { loading } } = useSalesRepresentative();
    const { salesRepresentatives } = useContext(SalesRepresentativesContext);

    return (
        <div className="limiter">
            <div className="container-table100">
                {(offices && salesManagers) && <Selector salesManagers={salesManagers} offices={offices}/>}
                <div className="wrap-table100">
                    <div className="table100">
                        {loading ? <p>Loading...</p> : <Table salesRepresentatives={salesRepresentatives}/>}
                    </div>
                </div>
            </div>
        </div>
    );
};

export default SalesRepresentative;
