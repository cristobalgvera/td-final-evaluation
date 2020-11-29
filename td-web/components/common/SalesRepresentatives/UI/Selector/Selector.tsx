import React, { FunctionComponent, useCallback, useEffect, useState } from 'react';
import { IAppContext } from '../../../../utility/context/interfaces/IAppContext';
import Select from './Input/Select';
import useSalesRepresentative from '../../hooks/useSalesRepresentatives';

import style from './Selector.module.scss';

type Props = IAppContext;

const Selector: FunctionComponent<Props> = ( { salesManagers, offices } ) => {
    const [city, setCity] = useState<string>(null);
    const [parentId, setParentId] = useState<number>(null);
    const { logic: { filter } } = useSalesRepresentative();

    useEffect(() => filter({ city, parentId }), [city, parentId]);

    const handleParentIdChange = useCallback(( value: number ) => {
        const toSet = value ? Number(value) : null
        setParentId(toSet);
    }, []);

    const handleCityChange = useCallback(( value: string ) => {
        setCity(value);
    }, []);

    return (
        <div className={style.Selector}>
            <div className={style.Divisor}>
            <Select
                defaultMessage={'Select a city'}
                value={city}
                array={offices.map(( { city, id } ) => ({
                    id: id,
                    displayName: city,
                    val: city,
                }))}
                change={handleCityChange}
            />
            <Select
                value={parentId}
                defaultMessage={'Select a sale manager'}
                array={salesManagers.map(( { id, lastName, firstName } ) => ({
                    id: id,
                    displayName: `${firstName} ${lastName}`,
                    val: id,
                }))}
                change={handleParentIdChange}
            />
            </div>
        </div>
    );
};

export default Selector;
