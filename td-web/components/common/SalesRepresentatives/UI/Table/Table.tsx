import React, { FunctionComponent, useEffect, useState } from 'react';
import { ISalesRepresentative } from '../../../../../pages/sales-representatives/interfaces/ISalesRepresentative';

interface OwnProps {
    salesRepresentatives: ISalesRepresentative[];
}

type Props = OwnProps;

const Table: FunctionComponent<Props> = ( { salesRepresentatives } ) => {
    const tableBody = () => (salesRepresentatives
        .map(( { id, mail, managerFirstName, managerLastName, officeCity, lastName, firstName } ) => (
            <tr key={id}>
                <td className={'column1'}>{id}</td>
                <td className={'column2'}>{firstName} {lastName}</td>
                <td className={'column3'}>{mail}</td>
                <td className={'column4'}>{officeCity}</td>
                <td className={'column5'}>{managerFirstName} {managerLastName}</td>
                <td className={'column6'}>ACTION</td>
            </tr>
        )));

    const [table, setTable] = useState(() => tableBody());

    useEffect(() => setTable(() => tableBody()), [salesRepresentatives]);

    return (
        <table style={{ zIndex: 1 }}>
            <thead>
            <tr className="table100-head">
                <th className={'column1'}>Employee number</th>
                <th className={'column2'}>Name</th>
                <th className={'column3'}>Mail</th>
                <th className={'column4'}>Office</th>
                <th className={'column5'}>Manager</th>
                <th className={'column6'}>Action</th>
            </tr>
            </thead>
            <tbody>
            {
                table.length !== 0
                    ? table
                    : <tr>
                        <th colSpan={6}>No data</th>
                    </tr>
            }
            </tbody>
        </table>
    );
};

export default Table;
