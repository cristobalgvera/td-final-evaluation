import React, { ChangeEvent, FunctionComponent } from 'react';

interface IArrayElement {
    id: string | number;
    displayName: string | number;
    val: string | number;
}

interface OwnProps {
    array: IArrayElement[];
    value: string | number
    defaultMessage: string;

    change( val: string | number ): void | null | undefined;
}

type Props = OwnProps;

const Select: FunctionComponent<Props> = ( { array, change, value, defaultMessage } ) => {
    console.log(value);

    const setOptions = () => array.map(( { displayName, id, val } ) => (
        <div className={'select-box__value'} key={id}>
            <input
                className="select-box__input"
                type="radio"
                id={`${id}`}
                value={id}
                checked={val === value}
                readOnly={true}
            />
            <p className="select-box__input-text">{displayName}</p>
        </div>
    ));

    const setList = () => array.map(( { id, displayName, val } ) => (
        <li key={id} onClick={() => change(val)}>
            <label className="select-box__option" htmlFor={`${id}`} aria-hidden={'true'}>{displayName}</label>
        </li>
    ));

    return (
        <>
            <div className="select-box">
                <div className="select-box__current" tabIndex={1}>
                    <div className="select-box__value">
                        <input
                            className="select-box__input"
                            type="radio"
                            id="0"
                            value="0"
                            name={defaultMessage}
                            checked={value === null}
                            readOnly={true}
                        />
                        <p className="select-box__input-text">{defaultMessage}</p>
                    </div>

                    {setOptions()}
                    <img className="select-box__icon" src="http://cdn.onlinewebfonts.com/svg/img_295694.svg"
                         alt="Arrow Icon" aria-hidden="true"/>
                </div>
                <ul className="select-box__list">
                    <li>
                        <label
                            className="select-box__option"
                            htmlFor={'0'}
                            aria-hidden={'true'}
                            onClick={() => change(null)}
                        >
                            {defaultMessage}
                        </label>
                    </li>
                    {setList()}
                </ul>
            </div>
        </>
    );
};

export default Select;
