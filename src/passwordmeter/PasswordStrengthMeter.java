package passwordmeter;

public class PasswordStrengthMeter {
    public PasswordStrength measurePasswordStrength(String password) {
        PasswordStrength passwordStrength;

        int count = 0;

        if (measureLengthCriteria(password)) count++;

        if (measureNumberCriteria(password)) count++;

        if (measureUpperCaseCriteria(password)) count++;

        switch (count) {
            case 3:
                passwordStrength = PasswordStrength.STRONG;
                break;
            case 2:
                passwordStrength = PasswordStrength.NORMAL;
                break;
            default:
                passwordStrength = PasswordStrength.WEAK;
                break;

        }

        return passwordStrength;

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
