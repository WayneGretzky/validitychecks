import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class isRegistrationNumber implements ValidityCheck {
    Logger logger = Logger.getLogger(getClass().getName());

    @Override
    public <A> boolean isValid(A data) {
        if(data instanceof String) {
            String s = (String) data;
            String firstThreeLetters = s.substring(0, 3);

            return isRightFormat(s) && isAcceptedCombinationOfLetters(firstThreeLetters);
        } else {
            logger.log(Level.WARNING, "This is not a registration number!");
            return false;
        }
    }

    /**
     * Checks whether the registration number is of right format or not. If it is, then it should be of length 6, with the
     * first three letters all in uppercase. Next two symbols should be digits, and the last symbol either a digit or a letter
     * in uppercase.
     * @param s The registration number
     * @return true or false
     */
    private boolean isRightFormat(String s) {
        Character[] notAccepted = new Character[]{'I', 'Q', 'V', 'Å', 'Ä', 'Ö'};
        List<Character> notAcceptedLetters = Arrays.asList(notAccepted);

        if(s.length() != 6) {
            logger.log(Level.WARNING, "The data is not a valid registration number!");
            return false;
        }

        for(int i = 0; i < 3; i++) {
            if(!Character.isUpperCase(s.charAt(i)) || notAcceptedLetters.contains(s.charAt(i))) {
                logger.log(Level.WARNING, "The data is not a valid registration number!");
                return false;
            }
        }

        for(int i = 4; i < 5; i++) {
            if(!Character.isDigit(s.charAt(i))) {
                logger.log(Level.WARNING, "The data is not a valid registration number!");
                return false;
            }
        }

        if(!Character.isDigit(s.charAt(5))) {
            if(!Character.isUpperCase(s.charAt(5)) || notAcceptedLetters.contains(s.charAt(5))) {
                logger.log(Level.WARNING, "The data is not a valid registration number!");
                return false;
            }
        }

        return true;
    }

    private boolean isAcceptedCombinationOfLetters(String s) {
        String[] notAccepted = new String[]{"APA", "ARG", "ASS", "BAJ", "BSS", "CUK", "DUM", "ETA", "ETT", "FAG", "FAN",
                "FEG", "FEL", "FEM", "FES", "FET", "FNL", "FUC", "FUK", "FUL", "GAM", "GAY", "GEJ", "GEY", "GHB", "GUD",
                "GYN", "HAT", "HBT", "HKH", "HOR", "HOT", "KGB", "KKK", "KUC", "KUF", "KUG", "KUK", "KYK", "LAM", "LAT",
                "LEM", "LOJ", "LSD", "LUS", "MAD", "MAO", "MEN", "MES", "MLB", "MUS", "NAZ", "NRP", "NSF", "NYP", "OND",
                "OOO", "ORM", "PLO", "PMS", "PUB", "RAP", "RAS", "ROM", "RPS", "RUS", "SEG", "SEX", "SJU", "SOS", "SPY",
                "SUG", "SUP", "SUR", "TBC", "TOA", "TOK", "TRE", "TYP", "UFO", "USA", "WAM", "WAR", "WWW", "XTC", "XTZ",
                "XXL", "XXX", "ZEX", "ZOG", "ZPY", "ZUG", "ZUP", "ZOO"};

        List<String> notAcceptedCombinations = Arrays.asList(notAccepted);

        return !notAcceptedCombinations.contains(s);
    }
}
