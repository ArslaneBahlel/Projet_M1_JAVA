package verifydata;

import utilities.Logger;

@FunctionalInterface
public interface VerifyStrategy {

	/**
	 * Whether or not the String passed in parameter is verified
	 * @param toVerify : value to verify
	 * @return true : verified, false: not verified, not null
	 */
	public default void log(String msg) {
		Logger.log(msg);

	}
	public boolean verifyType(String toVerify);
}
