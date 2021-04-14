import java.util.ArrayList;
import java.util.List;

public class ValidityChecker {

    private List<ValidityCheck> validityChecks = new ArrayList<>();

    public <A> void checkValidity(A data) {
        for(ValidityCheck validityCheck : validityChecks) {
            if(validityCheck.isValid(data)) {
                System.out.println(validityCheck.getClass().getName() + ": Passed");
            } else {
                System.out.println(validityCheck.getClass().getName() + ": Did not pass");
            }
        }
    }

    public void addValidityCheck(ValidityCheck validityCheck) {
        validityChecks.add(validityCheck);
    }

    public void removeValidityCheck(ValidityCheck validityCheck) {
        validityChecks.remove(validityCheck);
    }

    public void clearValidityChecks() {
        validityChecks.clear();
    }


}
