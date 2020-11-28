package commissions.service;

import commissions.service.common.CommissionsCalculator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ComplexCalculatorTest {
    private final CommissionsCalculator complexCalculator = new ComplexCalculator();

    @Test
    void fixedCommissionOK() {
        Integer commission = complexCalculator.calculate(List.of(1000));
        Integer expected = (int) (1000 * 0.05);
        assertEquals(expected, commission);
    }

    @Test
    void generateTwoPercentOfCommissionBySaleOK() {
        Integer commission = complexCalculator.calculate(List.of(1000, 7000));
        Integer expected = (int) ((1000 + 7000 * 0.02) * 0.05);
        assertEquals(expected, commission);
    }

    @Test
    void generateThreePercentOfCommissionToTotalOK() {
        Integer commission = complexCalculator.calculate(List.of(10000, 1000));
        Integer expected = (int) (11000 * (0.05 + 0.03));
        assertEquals(expected, commission);
    }

    @Test
    void generateOnePercentOfCommissionToTotalOK() {
        Integer commission = complexCalculator.calculate(List.of(50001));
        Integer expected = (int) (50001 * (0.05 + 0.03 + 0.01));
        assertEquals(expected, commission);
    }

    @Test
    void thereAreSomeZerosButShouldGenerateOnePercentOfCommissionToTotal() {
        Integer commission = complexCalculator.calculate(List.of(0, 50001, 0, 0, 500));
        Integer expected = (int) (50501 * (0.05 + 0.03 + 0.01));
        assertEquals(expected, commission);
    }

    @Test
    void thereAreNoValues() {
        Integer commission = complexCalculator.calculate(List.of());
        Integer expected = 0;
        assertEquals(expected, commission);
    }

}
