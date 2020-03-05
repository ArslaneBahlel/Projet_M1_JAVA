package verifydata;

public class VerifyString implements VerifyStrategy{

	/**
	 * {@inheritDoc}
	 * Verifies whether or not the String passed in parameter is a String
	 * @param toVerify : value to verify
	 * @return true : toVerify is a String, false: toVerify is not a real String, not null
	 */
	@Override
	public boolean verifyType(String toVerify) {
		
		if (toVerify==null)
			return false;
		try {
			Double.parseDouble(toVerify);
			log(toVerify+" is not a String.");
		}catch(NumberFormatException e) {
			log(toVerify+" is a String.");
			return true;
		}
		return false;
	}
}
