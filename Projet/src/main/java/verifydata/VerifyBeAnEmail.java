package verifydata;
import java.util.regex.Pattern; 

public class VerifyBeAnEmail implements VerifyStrategy{
	private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	
	/**
	 * {@inheritDoc}
	 * Verifies whether or not the String passed in parameter is an email
	 * @param toVerify : value to verify
	 * @return true : toVerify is an email, false: toVerify is not an email, not null
	 */
	@Override
	public boolean verifyType(String toVerify) {
		Pattern pat = Pattern.compile(EMAIL_REGEX); 
        if (toVerify == null || !pat.matcher(toVerify).matches()) {
			log(toVerify+" is not an Email.");
            return false; 
        }
		log(toVerify+" is an Email.");
        return true;
	}
	
}
