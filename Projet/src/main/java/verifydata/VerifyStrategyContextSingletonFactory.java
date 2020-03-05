package verifydata;

import java.util.HashMap;

public class VerifyStrategyContextSingletonFactory {

	private static HashMap<String, VerifyStrategy> verificators = new HashMap<>();

	/**
	 * Private constructor because it is a Singleton and a Factory
	 */
	private VerifyStrategyContextSingletonFactory() {}

	/**
	 * The Factory Method / Singleton Pattern
	 * @param verification : string used to tell which Verify Strategy to return 
	 * @return the suitable verification strategy
	 */
	public static VerifyStrategy getInstance(String verification) {
		if (verificators.get(verification.toLowerCase()) == null) {
			VerifyStrategy strategy = null ;
			if (verification.equalsIgnoreCase("int")) {
				strategy = new VerifyInt();
				verificators.put("int", strategy);
			}else if (verification.equalsIgnoreCase("double")) {
				strategy = new VerifyDouble();
				verificators.put("double", strategy);
			}else if (verification.equalsIgnoreCase("string")) {
				strategy = new VerifyString();
				verificators.put("string", strategy);
			}else if (verification.equalsIgnoreCase("BE_AN_AGE")) {
				strategy = new VerifyBeAnAge();
				verificators.put("be_an_age", strategy);
			}else if (verification.equalsIgnoreCase("BE_AN_EMAIL")) {
				strategy = new VerifyBeAnEmail();
				verificators.put("be_an_email", strategy);
			}else if (verification.equalsIgnoreCase("BE_AN_DAUPHINE_EMAIL")) {
				strategy = new VerifyBeAnDauphineEmail();
				verificators.put("be_an_dauphine_email", strategy);
			}
		}
		return verificators.get(verification.toLowerCase());
	}
}
