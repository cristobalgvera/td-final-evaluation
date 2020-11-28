import React, { createContext, FC, useEffect, useState } from 'react';
import { IAppContext } from './interfaces/IAppContext';
import { ISalesManager } from './interfaces/ISalesManager';
import { IOffice } from './interfaces/IOffice';
import axiosInstance from '../util/axios-instance';

export const appContext = createContext<IAppContext>({
    salesManagers: [],
    offices: [],
});

const AppContextProvider: FC = ( { children } ) => {
    const [salesManagers, setSalesManagers] = useState<ISalesManager[]>();
    const [offices, setOffices] = useState<IOffice[]>();

    useEffect(() => {
        const getSalesManagers = async (): Promise<ISalesManager[]> => {
            try {
                const response = await axiosInstance.get(`/employees`);
                return response.data;
            } catch (error) {
                console.error(error);
            }
        };

        const getOffices = async (): Promise<IOffice[]> => {
            try {
                const response = await axiosInstance.get(`/offices`);
                return response.data;
            } catch (error) {
                console.error(error);
            }
        };

        getOffices().then(offices => setOffices(offices));
        getSalesManagers().then(salesManagers => setSalesManagers(salesManagers));
    }, []);

    return (
        <appContext.Provider value={{
            salesManagers,
            offices,
        }}>
            {children}
        </appContext.Provider>
    );
};

export default AppContextProvider;