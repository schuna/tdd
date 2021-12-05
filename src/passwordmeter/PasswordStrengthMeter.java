package passwordmeter;

public class PasswordStrengthMeter {
    public PasswordStrength measurePasswordStrength(String password) {
        boolean hasUpperCase = false;
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
                break;
            }
        }

        if (hasUpperCase) {
            return PasswordStrength.STRONG;
        }
        return PasswordStrength.NORMAL;
    }
}
