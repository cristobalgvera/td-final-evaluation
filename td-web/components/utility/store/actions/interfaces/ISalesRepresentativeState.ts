import { DeepPartial } from '../../../util/types';
import { SALES_REPRESENTATIVE_ACTIONS } from '../propTypes';
import { ISalesRepresentative } from '../../../../../pages/sales-representatives/interfaces/ISalesRepresentative';

export interface ISalesRepresentativeActions {
    type: keyof typeof SALES_REPRESENTATIVE_ACTIONS;
    payload?: DeepPartial<ISalesRepresentative>[];
}

export interface ISalesRepresentativeReducerActions extends ISalesRepresentativeActions {
    payload?: ISalesRepresentative[];
}