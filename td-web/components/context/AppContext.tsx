import React, { createContext, FC, useReducer } from 'react';

interface IAppContext {
    variable: 1
}

export const AppContext = createContext<IAppContext>({
    variable: 1,
});

// const AppContextProvider: FC = ( { children } ) => {
//     const [variable, dispatchVariable] = useReducer()
//
//         return    (
//         <AppContext.Provider value={{ variable }}>
//             {children}
//         </AppContext.Provider>
//     );
// };