import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import passwordmeter.PasswordStrength;
import passwordmeter.PasswordStrengthMeter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStrengthMeterTest {

    @DisplayName("세가지 조건을 모두 만족하는 경우")
    @ParameterizedTest(name = "[{index}] password = {0}")
    @ValueSource(strings = {"fgtd1@AB", "ab2D1!fg"})
    void meetAllCriteriaThenStrongTest(String password) {
        assertPasswordStrengthEquals(password, PasswordStrength.STRONG);
    }

    @DisplayName("두가지 조건을 모두 만족하는 경우")
    @ParameterizedTest(name = "[{index}] password = {0}")
    @ValueSource(strings = {"ab2d1!fg", "G!drh@jr", "A34g4&3"})
    void meetTwoCriteriaThenNormalTest(String password) {
        assertPasswordStrengthEquals(password, PasswordStrength.NORMAL);
    }

    @DisplayName("한개 이하를 만족하는 경우")
    @ParameterizedTest(name = "[{index}] password = {0}")
    @ValueSource(strings = {"kjid", "A@GHK", "1@34567"})
    void meetOneOrBelowCriteriaThenNormalTest(String password) {
        assertPasswordStrengthEquals(password, PasswordStrength.WEAK);
    }

    private void assertPasswordStrengthEquals(String password, PasswordStrength expected) {
        PasswordStrengthMeter passwordstrengthmeter = new PasswordStrengthMeter();
        PasswordStrength result = passwordstrengthmeter.measurePasswordStrength(password);
        assertEquals(expected, result);
    }

}
