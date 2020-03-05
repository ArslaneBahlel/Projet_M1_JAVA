package verifydata;

import java.util.regex.Pattern;

public class VerifyBeAnDauphineEmail implements VerifyStrategy{

	private static final String DAUPHINE_MAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(dauphine.eu)|(lamsade.dauphine.fr)|(dauphine.psl.eu)";
	
	/**
	 * {@inheritDoc}
	 * Verifies whether or not the String passed in parameter is a Dauphine email
	 * @param toVerify : value to verify
	 * @return true : toVerify is a Dauphine email, false: toVerify is not an Dauphine email, not null
	 */
	@Override
	public boolean verifyType(String toVerify) {
		Pattern pat = Pattern.compile(DAUPHINE_MAIL_REGEX); 
        if (toVerify == null || !pat.matcher(toVerify).matches()) {
			log(toVerify+" is not a Dauphine Email.");
            return false; 
        }
		log(toVerify+" is a Dauphine Email.");
        return true;
	}
}
