import org.junit.jupiter.api.BeforeEach;
import passwordmeter.PasswordStrength;
import passwordmeter.PasswordStrengthMeter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStrengthMeterTest {

    @DisplayName("세가지 조건을 만족하는 경우 1")
    @Test
    void meetAllCriteriaThenStrongTest1() {
        assertPasswordStrengthEquals("fgtd1@AB", PasswordStrength.STRONG);
    }

    @DisplayName("세가지 조건을 만족하는 경우 2")
    @Test
    void meetAllCriteriaThenStrongTest2() {
        assertPasswordStrengthEquals("ab2D1!fg", PasswordStrength.STRONG);
    }

    @DisplayName("길이와 숫자, 두가지 조건을 만족하는 경우")
    @Test
    void meetLengthAndNumberCriteriaThenNormalTest() {
        assertPasswordStrengthEquals("ab2d1!fg", PasswordStrength.NORMAL);
    }

    @DisplayName("길이와 대문자, 두가지 조건을 만족하는 경우")
    @Test
    void meetLengthAndUpperCaseCriteriaThenNormalTest() {
        assertPasswordStrengthEquals("G!drh@jr", PasswordStrength.NORMAL);
    }

    private void assertPasswordStrengthEquals(String password, PasswordStrength expected){
        PasswordStrengthMeter passwordstrengthmeter = new PasswordStrengthMeter();
        PasswordStrength result = passwordstrengthmeter.measurePasswordStrength(password);
        assertEquals(expected, result);
    }

}
