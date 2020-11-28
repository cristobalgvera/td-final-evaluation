import React, { ChangeEvent, FunctionComponent } from 'react';

interface IArrayElement {
    id: string | number;
    displayName: string | number;
}

interface OwnProps {
    array: IArrayElement[];
    value: string | number
    defaultMessage: string;

    change( target: ChangeEvent<any> ): void | null | undefined;
}

type Props = OwnProps;

const Select: FunctionComponent<Props> = ( { array, change, value, defaultMessage } ) => (
    <>
        <select value={value || '0'} onChange={change}>
            <option value={'0'}>{defaultMessage}</option>
            {array.map(( { id, displayName } ) => <option key={id} value={id}>{displayName}</option>)}
        </select>
    </>
);

export default Select;
