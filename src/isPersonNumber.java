import java.util.logging.Level;
import java.util.logging.Logger;

public class isPersonNumber implements ValidityCheck{
    Logger logger = Logger.getLogger(getClass().getName());

    @Override
    public <A> boolean isValid(A data) {
        if(!isRightFormat(data)) {
            logger.log(Level.WARNING, "The data is not a valid person number!");
            return false;
        }

        String number = ((String) data).replace("-", "");
        int digitSum = 0;
        int calculatedControlDigit;
        int controlDigit = Character.digit(number.charAt(number.length() - 1), 10);

        for(int i = 2; i < number.length() - 1; i++) {
            int digit = Character.digit(number.charAt(i),10);

            if(i % 2 == 0) {
                digit *= 2;
                if(digit >= 10) {
                    int firstDigit = digit / 10;
                    int secondDigit = digit % 10;
                    digitSum += firstDigit + secondDigit;
                } else {
                    digitSum += digit;
                }
            } else if(i % 2 == 1) {
                digitSum += digit;
            }
        }

        calculatedControlDigit = (10 - (digitSum % 10)) % 10;

        if(calculatedControlDigit == controlDigit) {
            return true;
        } else {
            logger.log(Level.WARNING, "The data is not a valid person number!");
            return false;
        }
    }

    /**
     * Checks that the person number has the right format. Checks that the length of the person number is 13, with a
     * "-" at position 8. The rest of the symbols should all be digits.
     * @param data
     * @param <A>
     * @return
     */
    private <A> boolean isRightFormat(A data) {
        if (data instanceof String) {
            String s = (String) data;

            if (s.length() != 13 || s.charAt(8) != '-') {
                return false;
            }

            for (int i = 0; i < s.length(); i++) {
                if (i == 8) {
                    continue;
                }
                if (!Character.isDigit(s.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }
}
