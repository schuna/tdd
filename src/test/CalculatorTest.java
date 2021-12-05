import calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @DisplayName("정수 다하기 정상 케이스")
    @ParameterizedTest(name = "[{index}] {0} + {1} = {2}")
    @CsvSource({"1, 2, 3", "4, 5, 9"})
    void testAdd2IntegerNormal(int a, int b, int expectedSum) {
        Calculator cal;
        cal = new Calculator();
        int result = cal.plus(a, b);
        assertEquals(expectedSum, result);
    }
}
