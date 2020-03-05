package verifydata;

public class VerifyDouble implements VerifyStrategy{

	/**
	 * {@inheritDoc}
	 * Verifies whether or not the String passed in parameter is a Double
	 * @param toVerify : value to verify
	 * @return true : toVerify is a Double, false: toVerify is not a Double, not null
	 */
	
	@Override
	public boolean verifyType(String toVerify) {
		if (toVerify==null)
			return false;
		try {
			Double.parseDouble(toVerify);
			log(toVerify+" is a Double.");
		}catch(NumberFormatException e) {
			log(toVerify+" is not a Double.");
			return false;
		}
		return true;
	}
}
