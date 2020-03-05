package verifydata;

public class VerifyBeAnAge implements VerifyStrategy{

	/**
	 * {@inheritDoc}
	 * Verifies whether or not the String passed in parameter is an Age
	 * @param toVerify : value to verify
	 * @return true : toVerify is an Age, false: toVerify is not an Age, not null
	 */
	@Override
	public boolean verifyType(String toVerify) {
		if (toVerify==null)
			return false;
		try {
			int d = Integer.parseInt(toVerify);
			if(d>= 0 && d<=120) {
				log(toVerify+" is an Age.");
				return true;
			}
		}catch(NumberFormatException e) {
			log(toVerify+" is not an Age.");

			return false;
		}
		log(toVerify+" is not an Age.");
		return false;
	}
}
