package verifydata;

public class VerifyInt implements VerifyStrategy{
	
	/**
	 * {@inheritDoc}
	 * Verifies whether or not the String passed in parameter is an Integer
	 * @param toVerify : value to verify
	 * @return true : toVerify is an Integer, false: toVerify is not an Integer, not null
	 */
	@Override
	public boolean verifyType(String toVerify) {
		if (toVerify==null)
			return false;
		try {
			Integer.parseInt(toVerify);
			log(toVerify+" is an Integer.");
		}catch(NumberFormatException e) {
			log(toVerify+" is not an Integer.");
			return false;
		}
		return true;
	}

}
