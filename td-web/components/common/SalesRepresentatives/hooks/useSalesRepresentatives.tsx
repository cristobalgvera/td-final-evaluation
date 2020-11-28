import { useCallback, useContext, useState } from 'react';
import { ISalesManager } from '../../../utility/context/interfaces/ISalesManager';
import { IOffice } from '../../../utility/context/interfaces/IOffice';
import axiosInstance from '../../../utility/util/axios-instance';
import { SalesRepresentativeActions } from '../../../utility/store/actions';
import { SalesRepresentativesContext } from '../context/SalesRepresentativeContext';
import { ISalesRepresentative } from '../../../../pages/sales-representatives/interfaces/ISalesRepresentative';

interface Filter {
    parentId?: ISalesManager['id'] | null;
    city?: IOffice['city'] | null;
}

interface ISalesRepresentativeDto {
    id: number;
    firstName: string;
    lastName: string;
    email: string;
    parentEmployee: Partial<ISalesRepresentativeDto>,
    office: Partial<IOffice>
}

const { setSalesRepresentatives } = SalesRepresentativeActions;

const useSalesRepresentative = () => {
    const [loading, setLoading] = useState(false);
    const { salesRepresentatives, dispatchSalesRepresentatives } = useContext(SalesRepresentativesContext);

    const _filterData = useCallback(( data: ISalesRepresentativeDto[] ): ISalesRepresentative[] =>
        data.map((
            {
                id,
                firstName,
                lastName,
                email: mail,
                parentEmployee: {
                    firstName: managerFirstName,
                    lastName: managerLastName,
                },
                office: { city: officeCity },
            },
        ) =>
            (
                {
                    id,
                    lastName,
                    mail,
                    managerFirstName,
                    managerLastName,
                    officeCity,
                    firstName,
                }
            )), []);

    const filter = useCallback(( { city, parentId }: Filter ) => {
        setLoading(true);
        let cityQuery = 'city';
        let parentIdQuery = 'parentEmployeeId';

        if (city) cityQuery += `=${city}`;
        if (parentId) parentIdQuery += `=${parentId}`;

        const query = `/employees/get-by/office?${cityQuery}&${parentIdQuery}`;

        axiosInstance.get(query)
            .then(( { data } ) => {
                dispatchSalesRepresentatives(setSalesRepresentatives(_filterData(data)));
                setLoading(false);
            })
            .catch(( { message } ) => setLoading(message));
    }, [dispatchSalesRepresentatives, _filterData]);

    return {
        data: { salesRepresentatives, loading },
        logic: { filter },
    };
};

export default useSalesRepresentative;