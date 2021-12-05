package passwordmeter;

public class PasswordStrengthMeter {
    public PasswordStrength measurePasswordStrength(String password) {

        int count = 0;

        if (measureLengthCriteria(password)) count++;

        if (measureNumberCriteria(password)) count++;

        if (measureUpperCaseCriteria(password)) count++;

        if (count <= 1) return PasswordStrength.WEAK;

        if (count == 2) return PasswordStrength.NORMAL;

        return PasswordStrength.STRONG;

    }

    boolean measureLengthCriteria(String password) {
        return password.length() >= 8;
    }

    boolean measureNumberCriteria(String password) {

        for (char ch : password.toCharArray()) {
            if ('0' <= ch && ch <= '9') {
                return true;
            }
        }
        return false;

    }

    boolean measureUpperCaseCriteria(String password) {

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }

}
