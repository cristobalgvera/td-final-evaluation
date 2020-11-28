package commissions.service;

import commissions.service.common.CommissionsCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ComplexCalculator implements CommissionsCalculator {
    @Override
    public Integer calculate(List<Integer> sales) {
        AtomicBoolean hasOneGreaterSale = new AtomicBoolean(false);
        double fixedCommission = 0.05;

        List<Integer> updatedSales = new ArrayList<>();

        for (int i = 0; i < sales.size(); i++) {
            updatedSales.add(sales.get(i));
            if (sales.get(i) > 5000 & sales.get(i) < 10000)
                updatedSales.set(i, (int) (sales.get(i) * 0.02));
            else if (sales.get(i) >= 10000)
                hasOneGreaterSale.set(true);
        }

        Integer totalSales = updatedSales.stream().reduce(0, Integer::sum);

        if (hasOneGreaterSale.get())
            fixedCommission += 0.03;

        if (totalSales > 50000)
            fixedCommission += 0.01;

        return (int) (totalSales * fixedCommission);
    }
}
