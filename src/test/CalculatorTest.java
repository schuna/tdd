import calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @DisplayName("정수 다하기 정상 케이스")
    @Test
    void testAdd2IntegerNormal() {
        Calculator cal;
        cal = new Calculator();
        int result = cal.plus(1, 2);
        assertEquals(3, result);
    }
}
