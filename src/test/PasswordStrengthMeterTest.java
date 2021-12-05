import passwordmeter.PasswordStrength;
import passwordmeter.PasswordStrengthMeter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStrengthMeterTest{
    
    @DisplayName("세가지 조건을 만족하는 경우")
    @Test
    void testMeetAllCriteriaThenStrong() {
        PasswordStrengthMeter passwordstrengthmeter = new PasswordStrengthMeter();
        PasswordStrength result = passwordstrengthmeter.measurePasswordStrength("fgtd1@AB");
        assertEquals(PasswordStrength.STRONG, result);

        result = passwordstrengthmeter.measurePasswordStrength("ab2D1!fg");
        assertEquals(PasswordStrength.STRONG, result);
    }

}
