package dataAccessLayer;

/**
 * This class resides between LoginBAL class in the businessLayer and LoginDA in
 * the DataAccess Layer
 * 
 * It takes an unencrypted password and username and encrypts the password only
 * that is passed to LoginDA The LoginDA method will only validate against an
 * encrypted password stored in the database. Therefore anybody accessing
 * database by utility etc will only see an encrypted password.
 * 
 * @author Andrew Walmsley
 *
 */
public class Encrypt {

	/**
	 * Constant to represent encryption key
	 */
	private static final int ENCRYPTION_KEY = 4;

	/**
	 * Default constructor
	 */
	public Encrypt() {

	}

	/**
	 * Method to encrypt a given string
	 * 
	 * @param original
	 * @param key
	 *            1- 10
	 * @return
	 */
	public static String encode(String original) {

		// in to represent the encryption key
		int key = ENCRYPTION_KEY;

		// char to represent characters in string
		char ch;

		// String to represent the encrypted text
		String encryptedText = "";

		// cycle through given string
		for (int loop = 0; loop < original.length(); loop++) {
			// obtain next character to be encrypted
			ch = original.charAt(loop);

			// apply the key to encrypt
			ch = (char) (ch + key);

			// append encrypted character to end of string
			encryptedText += ch;
		}
		return encryptedText;
	}

	/**
	 * Method to decrypt a given string
	 * 
	 * @param original
	 * @param key
	 *            1 - 10
	 * @return
	 */
	public static String decode(String original, int key) {

		// char to represent a character in string
		char ch;

		// String to represent the encrypted text
		String encryptedText = "";

		// cycle through the given string
		for (int loop = 0; loop < original.length(); loop++) {
			// obtain next character to be encrypted
			ch = original.charAt(loop);

			// use key to decrypt char
			ch = (char) (ch - key);

			// append decrypted character to end of string
			encryptedText += ch;
		}

		return encryptedText;

	}
}
