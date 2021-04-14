public class Main {

    public static void main(String[] args) {
        ValidityChecker validityChecker = new ValidityChecker();
        ValidityCheck isNotNull = new isNotNull();
        ValidityCheck isRegistrationNumber = new isRegistrationNumber();
        ValidityCheck isPersonNumber = new isPersonNumber();

        validityChecker.addValidityCheck(isNotNull);
        validityChecker.addValidityCheck(isRegistrationNumber);
        validityChecker.addValidityCheck(isPersonNumber);

        String prsnr = "19820411-2380";
        String regNum = "SAS23K";

        validityChecker.checkValidity(regNum);
    }
}
