import java.util.logging.Level;
import java.util.logging.Logger;

public class isNotNull implements ValidityCheck {
    Logger logger = Logger.getLogger(getClass().getName());

    @Override
    public <A> boolean isValid(A data) {
        if(data == null) {
            logger.log(Level.WARNING, "Data is null!");
            return false;
        } else {
            return true;
        }
    }
}
