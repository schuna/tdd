package passwordmeter;

public class PasswordStrengthMeter {
    public PasswordStrength measurePasswordStrength(String password) {

        boolean meetLengthCriteria = password.length() >= 8;

        boolean meetNumberCriteria = false;
        for (char ch : password.toCharArray()) {
            if ('0' <= ch && ch <= '9') {
                meetNumberCriteria = true;
                break;
            }
        }

        boolean meetUpperCaseCriteria = false;
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                meetUpperCaseCriteria = true;
                break;
            }
        }

        if (meetLengthCriteria && meetNumberCriteria && meetUpperCaseCriteria) {
            return PasswordStrength.STRONG;
        }
        return PasswordStrength.NORMAL;
    }
}
