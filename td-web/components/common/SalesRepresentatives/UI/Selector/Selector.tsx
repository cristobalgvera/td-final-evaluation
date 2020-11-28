import React, { ChangeEvent, FunctionComponent, useCallback, useEffect, useState } from 'react';
import { IAppContext } from '../../../../utility/context/interfaces/IAppContext';
import Select from './Input/Select';
import useSalesRepresentative from '../../hooks/useSalesRepresentatives';

type Props = IAppContext;

const Selector: FunctionComponent<Props> = ( { salesManagers, offices } ) => {
    const [city, setCity] = useState<string>(null);
    const [parentId, setParentId] = useState<number>(null);
    const { logic: { filter } } = useSalesRepresentative();

    useEffect(() => filter({city, parentId}), [city, parentId]);

    const handleParentIdChange = useCallback(( { target: { value } }: ChangeEvent<HTMLSelectElement> ) => {
        setParentId(Number(value));
    }, []);

    const handleCityChange = useCallback(( { target: { value } }: ChangeEvent<HTMLSelectElement> ) => {
        setCity(value);
    }, []);

    return (
        <div>
            <Select
                defaultMessage={'Select a city'}
                value={city}
                array={offices.map(( { city } ) => ({
                    id: city,
                    displayName: city,
                }))}
                change={handleCityChange}
            />
            <Select
                value={parentId}
                defaultMessage={'Select a sale manager'}
                array={salesManagers.map(( { id, lastName, firstName } ) => ({
                    id,
                    displayName: `${firstName} ${lastName}`,
                }))}
                change={handleParentIdChange}
            />
        </div>
    );
};

export default Selector;
