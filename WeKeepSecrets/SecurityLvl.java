package weKeepSecrets;

/**
 * @author Francisco Gouveia / Martim Costa
 *
 */
public enum SecurityLvl {
	OFFICIAL(0, "official"), CONFIDENTIAL(1, "confidential"), SECRET(2, "secret"), TOP_SECRET(3, "topsecret");

	/**
	 * value - int value of the SecurityLvl 
	 * type - String associated to the SecurityLvl
	 */
	private int value;
	private String type;

	SecurityLvl(int value, String type) {
		this.value = value;
		this.type = type;
	}

	/**
	 * @return value of SecurityLvl
	 */
	public int getSecurityValue() {
		return this.value;
	}

	/**
	 * @return type of SecurityLvl
	 */
	public String getSecurityType() {
		return this.type;
	}

	/**
	 * @param sl - security type
	 * @return s1- return the SecurityLvl associated to that security type string
	 * 
	 */
	public static SecurityLvl getSecurityLvl(String sl) {
		SecurityLvl s1 = null;
		for (SecurityLvl s2 : SecurityLvl.values()) {
			if (s2.getSecurityType().equalsIgnoreCase(sl)) {
				s1 = s2;
			}

		}
		return s1;
	}

	/**
	 * @param sl -object of the type SecurityLvl
	 * @return true if the security level is bigger or equal to the one received
	 */
	public boolean isBigger(SecurityLvl s1) {
		boolean result = false;
		if (this.getSecurityValue() >= s1.getSecurityValue()) {
			result = true;
		} else {
			result = false;
		}
		return result;

	}

}
