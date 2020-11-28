package commissions;

import commissions.service.ComplexCalculator;
import commissions.service.SimpleCalculator;

import java.util.ArrayList;

public class DemoConsole {
    public static void main(String[] args) {
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        ComplexCalculator complexCalculator = new ComplexCalculator();
        ArrayList<Integer> sales = getRandomSales(5, 500000);

        Integer simpleCommission = simpleCalculator.calculate(sales);
        Integer complexCommission = complexCalculator.calculate(sales);

        writeResults(sales, simpleCommission, complexCommission);
    }

    private static void writeResults(ArrayList<Integer> sales, Integer simpleCommission, Integer complexCommission) {
        StringBuilder stringBuilder = new StringBuilder("Commissions Calculator:\n\n");
        stringBuilder.append("Taking ").append(sales.size()).append(" random sales amount...\n");

        sales.forEach(sale -> stringBuilder.append("$").append(sale).append("\t"));

        stringBuilder.append("\n\nSimple algorithm commission:\t$")
                .append(simpleCommission)
                .append("\nComplex algorithm commission:\t$")
                .append(complexCommission);

        System.out.println(stringBuilder.toString());
    }

    private static ArrayList<Integer> getRandomSales(int quantity, int maxSaleAmount) {
        ArrayList<Integer> sales = new ArrayList<>();
        for (int i = 0; i < Math.abs(quantity); i++) {
            sales.add((int) (Math.random() * (20000 - 1000)) + 1000);
        }
        return sales;
    }
}
