export const updateState = ( previousState: any, updateValues: any ) => ({
    ...previousState,
    ...updateValues,
});