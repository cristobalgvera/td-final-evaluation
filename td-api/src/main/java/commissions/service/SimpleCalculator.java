package commissions.service;

import commissions.service.common.CommissionsCalculator;

import java.util.List;

public class SimpleCalculator implements CommissionsCalculator {
    @Override
    public Integer calculate(List<Integer> sales) {
        Integer totalSales = sales.stream().reduce(0, Integer::sum);

        if (totalSales > 10000) return (int) (totalSales * 0.1);

        return (int) (totalSales * 0.05);
    }
}
