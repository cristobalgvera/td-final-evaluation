package commissions.service;

import commissions.service.common.CommissionsCalculator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleCalculatorTest {
    private final CommissionsCalculator simpleCalculator = new SimpleCalculator();

    @Test
    void generateLowCommissionOK() {
        Integer commission = simpleCalculator.calculate(List.of(2000, 2000, 2000));
        Integer expected = (int) (6000 * 0.05);
        assertEquals(expected, commission);
    }

    @Test
    void generateHighCommissionOK() {
        Integer commission = simpleCalculator.calculate(List.of(2000, 2000, 2000, 10000));
        Integer expected = (int) (16000 * 0.1);
        assertEquals(expected, commission);
    }

    @Test
    void thereAreSomeZeros() {
        Integer commission = simpleCalculator.calculate(List.of(0, 0, 0, 100));
        Integer expected = (int) (100 * 0.05);
        assertEquals(expected, commission);
    }

}
